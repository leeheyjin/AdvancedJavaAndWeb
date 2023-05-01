package kr.or.ddit.basic;

public class ThreadTest11 {
	public static void main(String[] args) {
//		ThreadStopTest1 thread = new ThreadStopTest1();
//		thread.start();
//		
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		thread.stop();
//		thread.setStop(true);

		ThreadStopTest2 thread2 = new ThreadStopTest2();
		thread2.start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thread2.interrupt();

	}

}

// 스레드를 멈추게 하는 연습용 스레드
class ThreadStopTest1 extends Thread {
	private boolean stop;

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	@Override
	public void run() {
		while (!stop) {
			System.out.println("스레드 실행 중");
		}

		System.out.println("자원 정리");
		System.out.println("스레드 종료");

	}

}

// interrupted()메서드를 이용해 스레드를 멈추게 하는 연습용 스레드
class ThreadStopTest2 extends Thread {
	@Override
	public void run() {
		// 방법1: interrupt()메서드와 sleep()메서드를 이용하는 방법 - 비효율적
//		try {
//			while (true) {
//				System.out.println("작업 실행 중...");
//				Thread.sleep(1);
//			}
//		} catch (InterruptedException e) {
//
//		}

		// 방법2: interrupt()메서드가 호출되었는지 여부를 검사한다
		while (true) {
			System.out.println("스레드 실행 중");
			// 검사방법1: Thread객체의 인스턴스 메서드인 isInterrupted()메서드 이용하기
//			if (this.isInterrupted()) {
//				break;
//			}

			// 검사방법2: Thread클래스의 정적 메서드인 interrupted()메서드 이용하기
			if (Thread.interrupted()) {
				break;
			}
		}
		System.out.println("자원 정리");
		System.out.println("스레드 종료");
	}
}