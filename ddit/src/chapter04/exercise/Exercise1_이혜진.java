package chapter04.exercise;

import java.util.Scanner;

public class Exercise1_이혜진 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("삼각형의 첫번째 변의 길이를 입력하세요: ");
		int a = Integer.parseInt(scanner.nextLine());
		System.out.print("삼각형의 두번째 변의 길이를 입력하세요: ");
		int b = Integer.parseInt(scanner.nextLine());
		System.out.print("삼각형의 세번째 변의 길이를 입력하세요: ");
		int c = Integer.parseInt(scanner.nextLine());
	
		if (a > b && a > c) {
			if (a < b + c) {
				System.out.println("삼각형이 만들어졌습니다.");
			} else {
				System.out.println("삼각형을 만들 수 없습니다.");
			}
		} else if (b > c && b > a) {
			if (b < a + c) {
				System.out.println("삼각형이 만들어졌습니다.");
			} else {
				System.out.println("삼각형을 만들 수 없습니다.");
			}
		} else if (c > a && c > b) {
			if (c < a + b) {
				System.out.println("삼각형이 만들어졌습니다.");
			} else {
				System.out.println("삼각형을 만들 수 없습니다.");
			}
		}
		scanner.close();
	}
}


