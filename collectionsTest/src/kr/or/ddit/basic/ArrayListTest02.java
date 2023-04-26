package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 문제
 * 5명의 이름을 입력받아 ArrayList에 저장한 후에 이 ArrayList에 저장된 이름들 중에서 김씨 성의 이름을 모두 출력하시오
 */
public class ArrayListTest02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<String> names = new ArrayList<>();
		System.out.println("------------------------");
		System.out.println("다섯명의 사람 이름을 입력하세요.");
		System.out.println("------------------------");
		for (int i = 0; i < 5; i++) {
			names.add(scanner.nextLine());
		}
		System.out.println("------------------------");

		// 쌤답
		for (int i = 0; i < names.size(); i++) {
			if (names.get(i).substring(0, 1).equals("김")) {
				System.out.println(names.get(i));
			}

			if (names.get(i).indexOf("김") == 0) {
				System.out.println(names.get(i));
			}
			
			if (names.get(i).charAt(0) == '김') {
				System.out.println(names.get(i));
			}
			
			if (names.get(i).startsWith("김")) {
				System.out.println(names.get(i));
			}
			
			if (names.get(i).contains("김")) { // "김" 글자가 그냥 존재하면 true
				System.out.println(names.get(i));
			}
		}

		// 내답
		String[] strNames = names.toArray(new String[0]);
		for (String string : strNames) {
			if (string.substring(0, 1).equals("김")) {
				System.out.println(string);
			}
		}
	}

}
