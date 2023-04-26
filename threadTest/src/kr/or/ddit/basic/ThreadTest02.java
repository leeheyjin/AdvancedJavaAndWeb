package kr.or.ddit.basic;

public class ThreadTest02 {
	public static void main(String[] args) {
		// 멀티스레드 프로그램을 구현하는 세가지 방법 !!!
		// 1. Thread클래스를 상속받는 방법
		MyThread1 myThread1 = new MyThread1();
		myThread1.start();

		// 2. Runnable인터페이스를 구현하는 방법
		MyThread2 myThread2 = new MyThread2();
		Thread thread = new Thread(myThread2);
		thread.start();

		// 3. Runnable인터페이스를 익명 구현체로 구현해서 실행하는 방법
		Runnable runnable = new Runnable() {
			public void run() {
				for (int i = 1; i <= 200; i++) {
					System.out.print("#");
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		Thread thread2 = new Thread(runnable);
		thread2.start();

		System.out.println("main메서드 끝");
	}
}

class MyThread1 extends Thread {
	public void run() {
		for (int i = 1; i <= 200; i++) {
			System.out.print("*");
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}

class MyThread2 implements Runnable {

	public void run() {
		for (int j = 1; j <= 200; j++) {
			System.out.print("$");
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}