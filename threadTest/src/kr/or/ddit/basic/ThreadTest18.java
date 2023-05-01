package kr.or.ddit.basic;

// wait() notify() 메서드를 이용해서 두 스레드가 번갈아 한번씩 실행되는 예제
public class ThreadTest18 {
	public static void main(String[] args) {
		WorkObject workObject = new WorkObject();
		ThreadA threadA = new ThreadA(workObject);
		ThreadB threadB = new ThreadB(workObject);

		threadA.start();
		threadB.start();
	}

}

// 공통으로 사용할 객체
class WorkObject {
	public synchronized void methodA() {
		System.out.println("methodA()에서 실행 중");
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized void methodB() {
		System.out.println("methodB()에서 처리하는 중");
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

// WorkObject의 methodA()만 호출하는 스레드
class ThreadA extends Thread {
	private WorkObject workObject;

	public ThreadA(WorkObject workObject) {
		this.workObject = workObject;
	}

	@Override
	public void run() {
		for (int i = 0; i <= 10; i++) {
			workObject.methodA();
		}
		synchronized (workObject) {
			workObject.notify();
		}
	}

}

// WorkObject의 methodB()만 호출하는 스레드
class ThreadB extends Thread {
	private WorkObject workObject;

	public ThreadB(WorkObject workObject) {
		this.workObject = workObject;
	}

	@Override
	public void run() {
		for (int i = 0; i <= 10; i++) {
			workObject.methodB();
		}
		synchronized (workObject) {
			workObject.notify();
		}
	}

}