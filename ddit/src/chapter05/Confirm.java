package chapter05;

import java.util.Scanner;

public class Confirm {
	public static void main(String[] args) {
		// 4
		int max = 0;
		int[] array = { 1, 5, 3, 8, 2 };
		for (int i = 0; i < array.length; i++) {
			if (max < array[i]) {
				max = array[i];
			}
		}
		System.out.println("max: " + max);

		// 5
		int[][] arrays = { { 87 }, { 83, 92, 96 }, { 78, 83, 93, 87, 88 } };
		int sum = 0;
		double avg = 0.0;
		int count = 0;
		for (int i = 0; i < arrays.length; i++) {
			for (int j = 0; j < arrays[i].length; j++) {
				sum += arrays[i][j];
				count++;
			}
			avg = (double) sum / count;
		}
		System.out.println("sum: " + sum);
		System.out.println("avg: " + avg);

		// 6
		boolean run = true;
		int studentNum = 0;
		int[] scores = null;
		Scanner scanner = new Scanner(System.in);

		while (run) {
			System.out.println("--------------------------------------------------");
			System.out.println("1. 학생수 | 2. 점수입력 | 3. 점수리스트 | 4. 분석 | 5. 종료");
			System.out.println("--------------------------------------------------");
			System.out.print("선택> ");

			int selectNo = Integer.parseInt(scanner.nextLine());

			if (selectNo == 1) {
				System.out.print("학생 수> ");
				studentNum = Integer.parseInt(scanner.nextLine());
				scores = new int[studentNum];
			} else if (selectNo == 2) {
				for (int i = 0; i < scores.length; i++) {
					System.out.print("scores[" + i + "]> ");
					scores[i] = Integer.parseInt(scanner.nextLine());
				}
			} else if (selectNo == 3) {
				for (int i = 0; i < scores.length; i++) {
					System.out.println("scores[" + i + "]> " + scores[i]);
				}
			} else if (selectNo == 4) {
				int max1 = 0;
				int sum1 = 0;
				for (int i = 0; i < scores.length; i++) {
					if (max1 < scores[i]) {
						max1 = scores[i];
					}
					sum1 += scores[i];
				}
				double avg1 = (double) sum1 / scores.length;

				System.out.println("최고 점수: " + max1);
				System.out.println("평균 점수: " + avg1);
			} else if (selectNo == 5) {
				run = false;
			}
		}
		System.out.println("프로그램 종료");
		scanner.close();
	}

}
