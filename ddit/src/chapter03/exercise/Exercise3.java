package chapter03.exercise;

import java.util.Scanner;

public class Exercise3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("연도를 입력하세요: ");
		int year = Integer.parseInt(scanner.nextLine());
		String isYunyear = ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) ? year + "년은 윤년입니다"
				: year + "년은 윤년이 아닙니다.";
		System.out.println(isYunyear);
		scanner.close();
	}

}
