package chapter04.exercise;

import java.util.Scanner;

public class Exercise3_이혜진 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("점수를 입력하세요.");
		System.out.print("프로그래밍 기초: ");
		int programming = Integer.parseInt(scanner.nextLine());
		System.out.print("데이터베이스: ");
		int database = Integer.parseInt(scanner.nextLine());
		System.out.print("화면 구현: ");
		int uiux = Integer.parseInt(scanner.nextLine());
		System.out.print("애플리케이션 구현: ");
		int application = Integer.parseInt(scanner.nextLine());
		System.out.print("머신러닝: ");
		int machineLearning = Integer.parseInt(scanner.nextLine());

		int total = programming + database + uiux + application + machineLearning;
		System.out.println("총점: " + total);
		double average = (double) (total) / 5;
		System.out.printf("평균: %.2f", average).println();

		char grade;
		if (average >= 90) {
			grade = 'A';
		} else if (average >= 80 && average < 90) {
			grade = 'B';
		} else if (average >= 70 && average < 80) {
			grade = 'C';
		} else if (average >= 60 && average < 70) {
			grade = 'D';
		} else {
			grade = 'F';
		}
		System.out.println("학점: " + grade);
		scanner.close();
	}

}
