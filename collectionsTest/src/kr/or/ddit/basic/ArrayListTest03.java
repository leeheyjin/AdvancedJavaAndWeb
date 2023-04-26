package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 문제: 5명의 별명을 입력받아 ArrayList에 저장하고 저장된 별명들 중에 별명의 길이가 제일 긴 별명을 출력하시오
 * (단, 각 별명의 길이는 모두 다르게 입력한다.)
 */
public class ArrayListTest03 {
	public static void main(String[] args) {
		List<String> nicknames = new ArrayList<>();
		System.out.println("별명 다섯개를 입력하세요");
		for (int i = 0; i < 5; i++) {
			nicknames.add(new Scanner(System.in).nextLine());
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nicknames.size(); i++) {
			if (nicknames.get(i).length() > max) {
				max = nicknames.get(i).length();
			}
			
			if (max == nicknames.get(i).length()) {
				System.out.println("결과: " + nicknames.get(i));
			}
		}
	}

}
