package chapter04.exercise;

import java.util.Scanner;

public class Exercise4_이혜진 {
	public static void main(String[] args) {
		System.out.println("가위 바위 보 게임");
		Scanner scanner = new Scanner(System.in);
		System.out.print("철수: ");
		String cheolSu = scanner.next();
		System.out.print("영희: ");
		String yeongHee = scanner.next();
		
		if (cheolSu.equals(yeongHee)) {
			System.out.println("결과: 무승부");
		} else if (cheolSu.equals("가위")) {
			if (yeongHee.equals("바위")) {
				System.out.println("결과: 영희 승리!");
			} else if (yeongHee.equals("보")) {
				System.out.println("결과: 철수 승리!");
			}
		} else if (cheolSu.equals("바위")) {
			if (yeongHee.equals("보")) {
				System.out.println("결과: 영희 승리!");
			} else if (yeongHee.equals("가위")) {
				System.out.println("결과: 철수 승리!");
			}
		} else if (cheolSu.equals("보")) {
			if (yeongHee.equals("가위")) {
				System.out.println("결과: 영희 승리!");
			} else if (yeongHee.equals("바위")) {
				System.out.println("결과: 철수 승리!");
			}
		}
		scanner.close();
	}

}
