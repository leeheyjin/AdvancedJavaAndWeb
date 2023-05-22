package chapter02.exercise;

import java.util.Scanner;

public class Exercise4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("500원짜리 동전의 갯수: ");
		int coin500 = Integer.parseInt(scanner.nextLine());
		System.out.print("100원짜리 동전의 갯수: ");
		int coin100 = Integer.parseInt(scanner.nextLine());
		System.out.print("50원짜리 동전의 갯수: ");
		int coin50 = Integer.parseInt(scanner.nextLine());
		System.out.print("10원짜리 동전의 갯수: ");
		int coin10 = Integer.parseInt(scanner.nextLine());

		System.out.printf("저금통 안의 동전의 총 액수: %d", coin500 * 500 + coin100 * 100 + coin50 * 50 + coin10 * 10);
		scanner.close();

	}
}
