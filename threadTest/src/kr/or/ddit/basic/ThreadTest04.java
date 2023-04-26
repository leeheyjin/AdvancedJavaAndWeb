package kr.or.ddit.basic;

/*
 * 1~20억까지의 합계를 구하는 프로그램을 하나의 스레드가 단독으로 처리할 때와 여러개의 스레드라 협력해서 처리할 때의 경과시간을 비교해보장장
 * 
 */
public class ThreadTest04 {
	public static void main(String[] args) {
		// 단독으로 처리하는 스레드
		SumThread sumThread = new SumThread(1l, 2_000_000_000l);

		// 여럿이 협력하는 스레드
		SumThread[] sumArr = new SumThread[] { new SumThread(1l, 500_000_000l),
				new SumThread(500_000_001l, 1_000_000_000l), new SumThread(1_000_000_001l, 1_500_000_000l),
				new SumThread(1_500_000_001l, 2_000_000_000l) };

		// 단독으로 실행
		long startTime = System.currentTimeMillis();
		sumThread.start();

		try {
			sumThread.join();
		} catch (InterruptedException e) {
		}
		long endTime = System.currentTimeMillis();
		System.out.println("단독으로 처리했을 때 경과 시간: " + (endTime - startTime));
		System.out.println("======================================");

		// 여럿이 실행
		startTime = System.currentTimeMillis();
		for (SumThread sumThread2 : sumArr) {
			sumThread2.start();
		}

		for (SumThread sumThread2 : sumArr) {
			try {
				sumThread2.join();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		endTime = System.currentTimeMillis();
		System.out.println("여럿이서 처리했을 때 경과 시간: " + (endTime - startTime));
		
	}

}

// 시작값과 끝값을 주면 시작값부터 끝값까지의 합계를 구하는 스레드 클래스 만들기
class SumThread extends Thread {
	private long start;
	private long end;

	public SumThread(long start, long end) {
		super();
		this.start = start;
		this.end = end;
	}

	public void run() {
		long sum = 0l;
		for (long i = start; i <= end; i++) {
			sum += i;
		}
		System.out.println(start + "부터 " + end + "까지의 합계: " + sum);
	}

}
