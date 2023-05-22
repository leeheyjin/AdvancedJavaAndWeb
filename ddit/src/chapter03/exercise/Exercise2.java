package chapter03.exercise;

import java.util.Scanner;

public class Exercise2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("수도입니까?(수도: 1, 수도아님: 0): ");
		int isCapital = Integer.parseInt(scanner.nextLine());

		System.out.print("총 인구는?(단위: 만): ");
		int population = Integer.parseInt(scanner.nextLine());

		System.out.print("연 소득이 1억 이상인 인구는?(단위: 만): ");
		int theRich = Integer.parseInt(scanner.nextLine());

		String isMetropolice = (((isCapital == 1) && (population >= 100)) || (theRich >= 50)) ? "이 도시는 메트로폴리스입니다."
				: "이 도시는 메트로폴리스가 아닙니다.";
		System.out.println(isMetropolice);
		scanner.close();
	}

}
