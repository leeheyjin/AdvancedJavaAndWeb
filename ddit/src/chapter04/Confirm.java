package chapter04;
import java.util.Random;
import java.util.Scanner;

public class Confirm {
	public static void main(String[] args) {
		// 2
		System.out.println("No.2: ");
		int sum = 0;
		for (int i = 0; i <= 100; i++) {
			if (i % 3 == 0) {
				sum += i;
			}
		}
		System.out.println(sum);

		// 3
		System.out.println("No.3: ");
		while (true) {
			Random random = new Random();
			int i = random.nextInt(6) + 1;
			int j = random.nextInt(6) + 1;
			if (i + j == 5) {
				break;
			}
			System.out.println(i + ", " + j);
		}

		// 4
		System.out.println("No.4: ");
		for (int x = 0; x <= 10; x++) {
			for (int y = 0; y <= 10; y++) {
				if ((4 * x + 5 * y) == 60) {
					System.out.println("(" + x + ", " + y + ")");
				}

			}
		}

		// 5
		System.out.println("No.5: ");
		for (int i = 0; i <= 3; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		// 6
		System.out.println("No.6: ");
		for (int i = 0; i < 4; i++) {
			for (int j = 4; j > i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		


		// 7
		System.out.print("No. 7: ");
		boolean run = true;
		int balance = 0;
		Scanner scanner = new Scanner(System.in);

		while (run) {
			System.out.println("-------------------------------------");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");

			System.out.println("-------------------------------------");
			System.out.print("선택>");
			int choice = Integer.parseInt(scanner.nextLine());
			switch (choice) {
			case 1:
				System.out.print("예금액 > ");
				int money = Integer.parseInt(scanner.nextLine());
				balance += money;
				continue;
			case 2:
				System.out.print("출금액 > ");
				money = Integer.parseInt(scanner.nextLine());
				balance -= money;
				continue;
			case 3:
				System.out.print("잔고 > ");
				System.out.println(balance);
				continue;
			case 4:
				System.out.println();
				System.out.println("프로그램 종료");
				run = false;
				break;
			}
		}
		scanner.close();
	}

}
