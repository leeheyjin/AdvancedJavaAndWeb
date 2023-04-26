package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListTest01 {
	public static void main(String[] args) {
		ArrayList list1 = new ArrayList<>();
		
		list1.add("aaa");
		list1.add("bbb");
		list1.add(123);
		list1.add('k');
		list1.add(false);
		list1.add(123.45);
		
		System.out.println(list1);
		System.out.println(list1.size());
		
		// 데이터 비교하기: boolean contains(비교 데이터) 리스트에 저장된 데이터 중에서 비교데이터가 있으면 true, 없으면 false를 반환
		System.out.println("ddd 존재 여부: " + list1.contains("bbb"));
		
		// indexOf(비교데이터), lastIndexOf(비교데이터) 리스트에 비교데이터가 있으면 비교데이터가 저장된 index값을 반환하고 없으면 -1을 반환한다
		// indexOf()의 검색 방향: 앞 -> 뒤, lastIndexOf()의 검색 방향: 뒤 -> 앞
		// 리스트에 비교데이터가 많으면 검색해서 첫번째로 찾은 데이터의 위치값을ㄹ 반환한다
		
		// toArray(): 리스트 안의 데이터들을 Object형 배열로 변환해서 반환한다
		// toArray(new 제네릭타입[0]): 제네릭 타입의 배열로 변환해서 반환한다
//		Object[] array = list1.toArray();
////		System.out.println(Arrays.toString(array));
//		for (Object object : array) {
//			System.out.println(object);
//		}
		
		ArrayList<String> list2 = new ArrayList<>();
		list2.add("aaa");
		list2.add("bbb");
		list2.add("ccc");
		list2.add("ddd");
		list2.add("eee");
		list2.add("fff");
		
		System.out.println("===================================");
		String[] strArr2 = list2.toArray(new String[0]);
		for (String string : strArr2) {
			System.out.println(string);
		}
		
	}

}
