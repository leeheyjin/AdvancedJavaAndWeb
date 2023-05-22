package chapter02.exercise;

import java.util.Scanner;

public class Exercise3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("원기둥 밑변의 반지름을 입력하시오.(단위: cm): ");
		double round = Double.parseDouble(scanner.nextLine());
		System.out.print("원기둥의 높이를 입력하시오.(단위: cm): ");
		double height = Double.parseDouble(scanner.nextLine());

		double area = round * round * Math.PI;
		double volume = area * height;
		System.out.printf("원기둥 밑변의 넓이는 %.14f㎠이고, 원기둥의 부피는 %.13f㎤이다.", area, volume);
		scanner.close();

	}

}
