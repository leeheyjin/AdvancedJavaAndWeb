package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("name", "홍길동");
		map.put("addr", "대전");
		map.put("tel", "010-0101-0101");

		System.out.println("map: " + map);

		System.out.println("이름: " + map.get("name"));
		System.out.println("별명: " + map.get("alias"));

//		String removeTel = map.remove("tel");
//		System.out.println("삭제 후 map: " + map);
//		System.out.println("삭제된 밸류값: " + removeTel);

		System.out.println("Iterator 이용");
		Set<String> keySet = map.keySet();
		Iterator<String> iterator = keySet.iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			String value = map.get(key);
			System.out.println(key + " - " + value);
		}

		System.out.println();

		System.out.println("향상된 for문 이용");
		for (String string : keySet) {
			System.out.println(string + " - " + map.get(string));
		}

		System.out.println("values() 이용");
		for (String values : keySet) {
			System.out.print(values + ", ");
		}
		System.out.println();
		System.out.println();

		// 키값은 번호(int)로 하고 밸류값은 멤버의 인스턴스로 하는 맵객체 생성하기
		Map<Integer, Member> memberMap = new HashMap<>();
		memberMap.put(1, new Member(1, "홍길동", "010-9191-9191"));
		memberMap.put(2, new Member(2, "일지매", "010-1919-1919"));
		memberMap.put(3, new Member(3, "이순신", "010-2222-2222"));
		System.out.println("memberMap의 개수: " + memberMap.size());
		System.out.println("memberMap: " + memberMap);
	}

}
