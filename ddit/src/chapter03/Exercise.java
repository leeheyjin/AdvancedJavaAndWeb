package chapter03;

import java.util.Scanner;

public class Exercise {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// ***************************************************
		System.out.println("Prob 9");
		System.out.print("첫 번째 수: ");
		double num1 = Double.parseDouble(scanner.nextLine());
		System.out.print("두 번째 수: ");
		double num2 = Double.parseDouble(scanner.nextLine());
		System.out.println("---------------------------");
		if (num2 == 0 || num2 == 0.0) {
			System.out.println("결과: 무한대");
		} else {
			System.out.printf("결과: %.2f", num1 / num2);
		}

		// ***************************************************
		System.out.println("Prob 10");
		int var1 = 10;
		int var2 = 3;
		int var3 = 14;
		double var4 = var1 * var1 * Double.parseDouble(var2 + "." + var3);
		System.out.println("원의 넓이: " + var4);

		// ***************************************************
		System.out.println("Prob 11");
		System.out.print("아이디: ");
		String name = scanner.nextLine();

		System.out.print("패스워드: ");
		Integer password = Integer.parseInt(scanner.nextLine());

		if (name.equals("java")) {
			if (password == 12345) {
				System.out.println("로그인 성공");
			} else {
				System.out.print("로그인 실패: 패스워드 틀림");
			}
		} else {
			System.out.println("로그인 실패: 아이디 존재하지 않음.");
		}

		scanner.close();
	}

}
