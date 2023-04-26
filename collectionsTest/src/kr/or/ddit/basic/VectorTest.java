package kr.or.ddit.basic;

import java.util.Collections;
import java.util.Vector;

public class VectorTest {
	public static void main(String[] args) {
		// 객체 생성
		Vector v1 = new Vector();
		System.out.println("처음 크기: " + v1.size());

		// 데이터 추가하기1: boolean add(추가할 데이터) 추가를 성공하면 true를, 실패하면 false를 반환
		v1.add("aaa");
		v1.add(100);
		v1.add(123);
		v1.add(true);
		v1.add('c');
		System.out.println("현재 크기: " + v1.size());
		System.out.println("v1 => " + v1);

		// 데이터 추가하기2: void addElement(추가할 데이터) add 이전에 존재하던 요소 추가 메서드. 이전 버전의 프로그램과의
		// 호환성을 위해 남아있는 메서드
		v1.addElement("cccc");
		System.out.println("v1 => " + v1);

		// 데이터 추가하기3: void add(index, 데이터) index번째에 데이터를 끼워넣는다.
		v1.add(4, "cvc");
		System.out.println("v1 => " + v1);

		// 데이터 꺼내오기: Object get(index) index번째 데이터를 꺼내서 반환한다.
		System.out.println("0번째 데이터: " + v1.get(0));
		int iTemp = (int) v1.get(2);
		System.out.println(iTemp);

		// 데이터 수정하기: Object set(index, 새로운 데이터) index번째 데이터를 '새로운데이터'로 변경해 원래 데이터를 반환한다
		String sTemp = (String) v1.set(0, "zzzzzz");
		System.out.println("변경 전 데이터: " + sTemp);
		System.out.println("v1 => " + v1);

		// 데이터 삭제하기1: Object remove(index) index번째 데이터를 삭제한다. 삭제된 데이터를 반환함
		sTemp = (String) v1.remove(0);
		System.out.println("삭제된 데이터: " + sTemp);
		System.out.println("v1 => " + v1);

		// 데이터 삭제하기2: boolean remove(삭제할 데이터) 삭제할 데이터를 찾아서 삭제한다 만약 해당 데이터가 여러개일 경우 첫번째만
		// 삭제된다. 삭제 성공하면 true, 삭제 실패면 false 반환
		v1.remove("cccc");
		System.out.println("v1 => " + v1);
		v1.remove(new Integer(123));
		v1.remove(Integer.valueOf(123)); // 윗줄과 같은 내용
		System.out.println("v1 => " + v1);

		v1.remove(new Character('c'));
		v1.remove(Character.valueOf('c'));
		System.out.println("v1 => " + v1);

		// 전체 데이터 삭제하기: clear();
		v1.clear();
		System.out.println(v1);

		Vector<Integer> v2 = new Vector<>();
		Vector<String> v3 = new Vector<>();
		v3.add("1");

		String stemp2 = v3.get(0);
		System.out.println(stemp2);

		Vector<Vector> vector = new Vector<>(); // 2차원 배열
		Vector<Vector<Vector>> vectors = new Vector<>(); // 3차원 배열

		v3.clear();

		v3.add("AAA");
		v3.add("BBB");
		v3.add("CCC");
		v3.add("DDD");
		v3.add("EEE");
		v3.add("FFF");

		Vector<String> v4 = new Vector<>();
		v4.add("BBB");
		v4.add("EEE");

		System.out.println("v3 => " + v3);
		System.out.println("v4 => " + v4);

		// 데이터 삭제하기3: boolean removeAll(Collections) 데이터 중에서 Collection객체가 가지고 있는 모든
		// 데이터를 삭제한다. 삭제 성공하면 true, 아니면 false를 반환한다. 
		v3.removeAll(v4); // v4가 뭘 가지고 있는지와 관계없이 v3에서만 v4와 동일한 데이터가 지워진다
		System.out.println("v3 => " + v3);
		System.out.println("v4 => " + v4);
		
		v3.clear();
		v3.add("AAA");
		v3.add("BBB");
		v3.add("CCC");
		v3.add("DDD");
		v3.add("EEE");
		v3.add("FFF");
		
		// 벡터의 데이터들을 순서대로 모두 가져와 사용하기 -> 이 때는 for문을 사용하면 된다
		for (String v : v3) {
			System.out.println(v);
		}

		v3.toArray();
	}

}
