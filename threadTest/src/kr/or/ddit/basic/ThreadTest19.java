package kr.or.ddit.basic;

public class ThreadTest19 {
	public static void main(String[] args) {
		DataBox dataBox = new DataBox();
		DataInThread in = new DataInThread(dataBox);
		DataOutThread out = new DataOutThread(dataBox);

		in.start();
		out.start();

	}

}

// 데이터를 공통으로 사용하는 클래스
class DataBox {
	private String data;

	// data변수의 값이 null이면 data변수에 문자열이 채워질 때까지 기다리고(wait()) data변수에 값이 있으면 해당 문자열을
	// 반환한다
	// data값을 반환한 후에는 data변수의 값을 null로 만든다
	public synchronized String getData() {
		if (data == null) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// data변수에 값이 있을 때
		String temp = data; // 원래 data를 temp로 대피
		System.out.println("스레드가 읽은 데이터: " + temp);
		data = null;
		notify(); // 데이터를 채울 스레드를 깨움
		return temp;
	}

	// data변수에 값이 있으면 data변수의 값이 null이 될 때까지 기다린다(wait())
	// data변수의 값이 null이 되면 새로운 값을 data변수에 저장한다.
	public synchronized void setData(String data) {
		if (this.data != null) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// data변수의 값이 null일 때 처리
		this.data = data;
		System.out.println("스레드에서 새로 저장한 데이터: " + data);

		notify();
	}
}

// 데이터를 넣어주는 스레드
class DataInThread extends Thread {
	private DataBox dataBox;

	public DataInThread(DataBox dataBox) {
		super();
		this.dataBox = dataBox;
	}

	@Override
	public void run() {
		String[] testArr = new String[] { "서울", "대전", "광주", "대구" };
		for (int i = 0; i < testArr.length; i++) {
			dataBox.setData(testArr[i]);
		}
	}

}

// 데이터를 꺼내서 사용하느 스레드
class DataOutThread extends Thread {
	private DataBox dataBox;

	public DataOutThread(DataBox dataBox) {
		super();
		this.dataBox = dataBox;
	}

	@Override
	public void run() {
		for (int i = 0; i < 4; i++) {
			String data = dataBox.getData();
		}
	}

}