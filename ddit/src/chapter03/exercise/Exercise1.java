package chapter03.exercise;

import java.util.Scanner;

public class Exercise1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("큰 수를 입력하세요: ");
		int a = Integer.parseInt(scanner.nextLine());
		
		System.out.print("작은 수를 입력하세요: ");
		int b = Integer.parseInt(scanner.nextLine());
		
		int largerNum = ((a + b) + Math.abs(a - b)) / 2;
		int smallerNum = ((a + b) - Math.abs(a - b)) / 2;
		System.out.printf("큰 수를 작은 수로 나눈 몫은 %d이고 나머지는 %d이다.", largerNum / smallerNum, largerNum % smallerNum);
		scanner.close();
	}
}
