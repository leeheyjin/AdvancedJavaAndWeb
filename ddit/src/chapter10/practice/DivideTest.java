package chapter10.practice;

import java.util.Scanner;

public class DivideTest {
	public static void main(String[] args) {
		while (true) {
			try {
				Scanner scanner = new Scanner(System.in);
				System.out.print("어떤 수로 나누겠습니까?>> ");
				int num1 = Integer.parseInt(scanner.nextLine());
				System.out.print("어떤 수로 나누겠습니까?>> ");
				int num2 = Integer.parseInt(scanner.nextLine());
				scanner.close();
				System.out.println(num1 + "/" + num2 + " = " + num1 / num2);
				break;
			} catch (NumberFormatException e) {
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			} catch (ArithmeticException e) {
				System.out.println("0으로 나눌 수 없습니다. 다시 입력해주세요.");
			}

		}

	}

}
