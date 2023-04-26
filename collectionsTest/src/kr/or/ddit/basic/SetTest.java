package kr.or.ddit.basic;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class SetTest {
	public static void main(String[] args) {
		Set hashSet = new HashSet<>();
		hashSet.add("DD");
		hashSet.add("AA");
		hashSet.add(2);
		hashSet.add("CC");
		hashSet.add("BB");
		hashSet.add(1);
		hashSet.add(8);

		System.out.println("hashSet의 개수: " + hashSet.size());
		System.out.println("hashSet의 데이터: " + hashSet);

		boolean isAdd = hashSet.add("FF");
		System.out.println("중복되지 않을 때: " + isAdd);

		isAdd = hashSet.add("DD");
		System.out.println("중복될 때: " + isAdd);
		System.out.println("hashSet의 데이터: " + hashSet);

		// FF 데이터를 EE로 변경하기
		hashSet.remove("FF");
		hashSet.add("EE");
		System.out.println("hashSet의 데이터: " + hashSet);

//		hashSet.clear();
//		System.out.println("hashSet의 데이터: " + hashSet);
//
//		Iterator iterator = hashSet.iterator();
//		while (iterator.hasNext()) {
//			System.out.println(iterator.next());
//		}

		// 우반 학생들 중 번호를 이용하여 추첨하는 프로그램을 작성해보자. . .
		// 번호는 1번부터 26번까지 있고 추첨할 인원은 세명이다
		// 당첨자를 출력해 보시오.
//		Set<Integer> studentSet = new HashSet<>();
//		int randomNo = new Random().nextInt(26) + 1;
//		for (int i = 0; i < 3; i++) {
//			studentSet.add(randomNo);
//		}
//		System.out.println("당첨자 번호: " + studentSet.toString());
		
		 // 우리반 학생들 중 번호를 이용하여 추첨하는 프로그램을 작성해 보자.
	      // 번호는 1번부터 26번까지 있고 추첨할 인원은 3명이다.
	      // 당첨자를 출력해 보시오.
	      
	      // 난수 만들기 (23~55 사이의 난수 만들기)
	      // random.nextInt((최대값-최솟값+1)+최솟값;
	      Random random = new Random();
//	      for(int i=1; i<20; i++) {
//	         int r = random.nextInt((55-23+1)) + 23;
//	         System.out.println(r);
//	      }
	      
	      // <> 안에는 제네릭(Integer 같은 형식)
	      HashSet<Integer> testSet = new HashSet<>();
	      while(testSet.size() < 3) {      // Set의 크기가 원하는 개수가 될 때까지 반복
	         testSet.add(random.nextInt(26) + 1);   // 난수를 만들어서 Set에 추가한다.
	      }
	      System.out.println("당첨자 번호 : " + testSet);

	}

}
