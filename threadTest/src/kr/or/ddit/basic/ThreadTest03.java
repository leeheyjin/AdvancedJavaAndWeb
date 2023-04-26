package kr.or.ddit.basic;

public class ThreadTest03 {
	public static void main(String[] args) {
		Thread thread = new Thread(new MyRunner());
		long startTime = System.currentTimeMillis();
		System.out.println("스레드 실행 전 현재 시간: " + startTime);
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			
		}
		long endTime = System.currentTimeMillis();
		System.out.println("스레드 실행 후 현재 시간: " + endTime);
		System.out.println("경과시간: " + (endTime - startTime));
	}

}

class MyRunner implements Runnable {

	public void run() {
		long sum = 0l;
		for (long i = 1; i <= 1000000000l; i++) {
			sum += i;
		}

		System.out.println("합계: " + sum);
	}

}