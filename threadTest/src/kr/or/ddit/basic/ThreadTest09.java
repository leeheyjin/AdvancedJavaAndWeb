package kr.or.ddit.basic;


// 스레드의 상태값 저장해보기
public class ThreadTest09 {
	public static void main(String[] args) {
		PrintStateThread pThread = new PrintStateThread(new TargetThread());
		pThread.start();

	}

}

// 스레드의 상태값의 검사 대상이 되는 스레드
class TargetThread extends Thread {
	@Override
	public void run() {
		long sum = 0;
		for (long i = 1; i <= 1_000_000_000l; i++) {
			sum += i;
		}

		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sum = 0;
		for (long i = 1; i <= 1_000_000_000l; i++) {
			sum += i;
		}
	}
}

// TargetThread의 상태값을 구해서 출력하는 스레드
class PrintStateThread extends Thread {
	private TargetThread target; //

	public PrintStateThread(TargetThread target) {
		super();
		this.target = target;
	}

	@Override
	public void run() {
		while (true) {
			// getState(): 스레드의 상태값 구하기
			Thread.State state = target.getState();
			System.out.println("TargetThread의 상태값: " + state);

			if (state == Thread.State.NEW) { // TargetThread가 NEW상태라면
				target.start();
			}

			if (state == Thread.State.TERMINATED) { // TargetThread가 종료상태이면
				break;
			}

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}