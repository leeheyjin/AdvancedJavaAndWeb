package chapter04;

import java.util.Random;

public class SwitchNoBreakCaseExample {
	public static void main(String[] args) {
		Random random = new Random();
		int time = random.nextInt(4) + 8;
		System.out.println("[현재 시각: " + time + "시]");
		switch (time) {
		case 8:
			System.out.println("출근합니다.");
		case 9:
			System.out.println("회의를 합니다.");
		case 10:
			System.out.println("업무를 봅니다.");
		default:
			System.out.println("외근을 나갑니다.");

		}
	}
	/*예상결과*
	 * 현재시각 8시
	 * 출근합니다.
	 * 회의를 합니다.
	 * 업무를 봅니다.
	 * 외근을 나갑니다.
	 * 
	 * 현재시각 9시
	 * 회의를 합니다.
	 * 업무를 봅니다.
	 * 외근을 나갑니다.
	 * 
	 * 현재시각 10시
	 * 업무를 봅니다.
	 * 외근을 나갑니다.
	 * 
	 * 기타 다른 숫자:
	 * 현재시각 n시
	 * 외근을 나갑니다.
	 */
}
