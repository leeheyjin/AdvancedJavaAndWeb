package kr.or.ddit.basic;

import java.util.Arrays;
import java.util.Random;

public class ThreadTest13Answer {
	public static void main(String[] args) {
		HorseAns[] horses = new HorseAns[10];
		for (int i = 0; i < 10; i++) {
			horses[i] = new HorseAns((i + 1) + "번 말");
		}

		GameStatePrint gameStatePrint = new GameStatePrint(horses);
		// 말들 경주 시작
		for (HorseAns horseAns : horses) {
			horseAns.start();
		}

		gameStatePrint.start(); // 말들의 경주 상태 출력 스레드 시작

		for (HorseAns horseAns : horses) {
			try {
				horseAns.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			gameStatePrint.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("경기 끝");
		System.out.println("경기 결과: ");
		Arrays.sort(horses);
		for (HorseAns horseAns : horses) {
			System.out.println(horseAns);
		}
	}

}

class HorseAns extends Thread implements Comparable<HorseAns> {
	public static int currentRank = 0; // 말들의 등수를 결정할 변수

	private String horseName; // 말이름
	private int location; // 현재 위치
	private int rank; // 등수

	// 말이 달리는 것을 스레드로 처리한다
	@Override
	public void run() {
		Random random = new Random();
		for (int i = 1; i <= 50; i++) {
			this.location = i; // 말의 현재 위치를 구한다
			try {
				Thread.sleep(random.nextInt(500));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} // for문이 끝나면 한 마리의 경기가 끝난 것
			// 한 마리의 말이 경주가 끝나면 등수를 구해서 저장한다
		currentRank++;
		this.rank = currentRank;

	}

	// 말 이름 초기화 생성자
	public HorseAns(String horseName) {
		this.horseName = horseName;
	}

	public String getHorseName() {
		return horseName;
	}

	public void setHorseName(String horseName) {
		this.horseName = horseName;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return rank + "등 경주마 " + horseName;

	}

	// 등수를 오름차순으로 처리할 내부 정렬 기준
	@Override
	public int compareTo(HorseAns that) {
		return Integer.compare(this.rank, that.rank);
	}

}

// 경기 중에 말들의 현재 위치를 나타내는 스레드
class GameStatePrint extends Thread {
	private HorseAns[] horses;

	public GameStatePrint(HorseAns[] horses) {
		this.horses = horses;
	}

	@Override
	public void run() {
		while (true) {
			if (HorseAns.currentRank == horses.length) {
				break;
			}

			for (int i = 1; i <= 10; i++) {
				System.out.println();
			}

			for (int i = 0; i < horses.length; i++) {
				System.out.println(horses[i].getHorseName());

				for (int j = 1; j <= 50; j++) {
					// 말의 현재 위치를 찾아서 '>'문자로 나타낸다.
					if (horses[i].getLocation() == j) {
						System.out.println(">");
					} else {
						System.out.print("-");
					}
				}
				System.out.println();
			}

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}