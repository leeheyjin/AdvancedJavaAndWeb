package chapter02.exercise;

import java.util.Scanner;

public class Exercise1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("가로의 길이는?(단위: m): ");
		double width = Double.parseDouble(scanner.nextLine());
		System.out.print("세로의 길이는?(단위: m): ");
		double height = Double.parseDouble(scanner.nextLine());

		double area = width * height;
		System.out.printf("직사각형의 널이: %f", area).println();

		double perimeter = 2 * (width + height);
		System.out.printf("직사각형의 둘레: %f", perimeter).println();
		scanner.close();

	}

}

