package codingTest;

import java.util.Random;
import java.util.Scanner;

public class Chapter05Exercise3 {
	public static void main(String[] args) {
		System.out.print("가위 바위 보를 입력하세요: ");

		Scanner scanner = new Scanner(System.in);
		String gamer = scanner.nextLine();
		System.out.println("게이머: " + gamer);
		
		String[] ai = { "가위", "바위", "보" };
		String aiPick = ai[new Random().nextInt(3)];
		System.out.print("인공지능 컴퓨터: " + aiPick);

		if(gamer.equals(aiPick)) {
			System.out.println("결과: 무승부" );
		} else if (gamer.equals("가위")) {
			if (aiPick.equals("바위")) {
				System.out.println("인공지능 승리!");
			} else if (aiPick.equals("보")) {
				System.out.println("게이머 승리!");
			}
		} else if (gamer.equals("바위")) {
			if (aiPick.equals("보")) {
				System.out.println("인공지능 승리!");
			} else if (aiPick.equals("가위")) {
				System.out.println("게이머 승리!");
			}
		} else if (gamer.equals("보")) {
			if (aiPick.equals("가위")) {
				System.out.println("인공지능 승리!");
			} else if (aiPick.equals("바위")) {
				System.out.println("게이머 승리!");
			}
		}
		scanner.close();
	}

}
