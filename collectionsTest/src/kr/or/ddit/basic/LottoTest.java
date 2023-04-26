package kr.or.ddit.basic;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class LottoTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		while (true) {
			System.out.println("==========================");
			System.out.println("       Lotto 프로그램       ");
			System.out.println("--------------------------");
			System.out.println("1. Lotto 구입");
			System.out.println("2. 프로그램 종료");
			System.out.println("==========================");
			System.out.print("메뉴 선택: ");
			int menu = Integer.parseInt(scanner.nextLine());
			if (menu == 1) {
				System.out.println("Lotto 구입 시작");
				System.out.println("(1000원에 로또번호 하나입니다.)");
				System.out.print("금액 입력: ");
				int money = Integer.parseInt(scanner.nextLine());

				if (money >= 1000 && money <= 100000) {
					System.out.println("행운의 로또번호는 아래와 같습니다.");
					for (int i = 0; i < money / 1000; i++) {
						Set<Integer> lottoSet = new HashSet<>();
						for (int j = 0; j < 6; j++) {
							lottoSet.add(random.nextInt(45) + 1);
						}
						System.out.println("로또번호" + i + ": " + lottoSet);
					}
					System.out.println("받은 금액은 " + money + "원이고 거스름돈은 " + money % 1000 + "원입니다.");
				} else if (money < 1000) {
					System.out.println("입력 금액이 너무 적습니다. 로또번호 구입 실패!");
					continue;
				} else {
					System.out.println("입력 금액이 너무 많습니다. 로또번호 구입 실패!");
				}

			} else if (menu == 2) {
				System.out.println("감사합니다.");
				break;
			}
		}
	}

}
