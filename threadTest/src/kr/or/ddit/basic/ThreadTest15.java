package kr.or.ddit.basic;

public class ThreadTest15 {
	public static void main(String[] args) {
		ShareObject sObject = new ShareObject();

		TestThread thread1 = new TestThread("test1", sObject);
		TestThread thread2 = new TestThread("test2", sObject);
		
		thread1.start();
		thread2.start();
		
		
	}

}

class ShareObject {
	private int sum = 0;

	public void add() {
		synchronized (this) {			
			int n = sum;
			n += 10;
			sum = n;

			System.out.println(Thread.currentThread().getName() + " 합계: " + sum);
		}
	}
}

// test용 스레드
class TestThread extends Thread {
	private ShareObject sObject;

	public TestThread(String name, ShareObject sObject) {
		super(name);
		this.sObject = sObject;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			sObject.add();
		}
	}

}