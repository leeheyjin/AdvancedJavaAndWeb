package chapter04.exercise;

import java.util.Random;
import java.util.Scanner;

public class Exercise5_이혜진 {
	public static void main(String[] args) {
		Random random = new Random();
		int randomNum = random.nextInt(100) + 1;
		Scanner scanner = new Scanner(System.in);
		int inputNum;
		do {
			int opportunity = 1;
			System.out.print("1부터 100 사이의 정수 중 하나를 선택하세요: ");
			inputNum = Integer.parseInt(scanner.nextLine());
			if (randomNum > inputNum) {
				System.out.println("더 큰 수입니다.");
				opportunity++;
			} else if (randomNum < inputNum) {
				System.out.println("더 작은 수입니다.");
				opportunity++;
			} else if (randomNum == inputNum) {
				System.out.println("정답입니다.");
				System.out.println("시도 횟수는 " + opportunity + "번 입니다.");
				System.out.println("게임을 종료합니다.");
				break;
			}
		} while (randomNum != inputNum);
		scanner.close();
	}
}
