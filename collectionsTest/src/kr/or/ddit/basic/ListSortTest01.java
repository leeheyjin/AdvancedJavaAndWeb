package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListSortTest01 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("일지매");
		list.add("홍길동");
		list.add("성춘향");
		list.add("변학도");
		list.add("이순신");
		System.out.println("정렬 전: " + list);

		Collections.sort(list);
		System.out.println("오름차순 정렬 후: " + list);

		Collections.shuffle(list);
		System.out.println("섞은 후: " + list);

		// 외부 정렬 적용하기
		Collections.sort(list, new Descending());
		System.out.println("내림차순 정렬 후: " + list);
	}
}

class Descending implements Comparator<String> {

	@Override
	public int compare(String member1, String member2) {

		if (member1.compareTo(member2) > 0) {
			return -1;
		} else if (member1.compareTo(member2) < 0) {
			return 1;
		} else {
			return 0;
		}
	}

}
