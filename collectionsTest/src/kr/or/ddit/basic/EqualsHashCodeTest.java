package kr.or.ddit.basic;

import java.util.HashSet;
import java.util.Objects;

public class EqualsHashCodeTest {

	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setId(1);
		p1.setName("신짱구");

		Person p2 = new Person();
		p2.setId(1);
		p2.setName("신짱구");

		Person p3 = p1;

		System.out.println(p1 == p2); // false 주소비교
		System.out.println(p1 == p3); // true

		System.out.println(p1.equals(p2));

		HashSet<Person> testSet = new HashSet<>();
		testSet.add(p1);
		testSet.add(p2);

		System.out.println("testSet의 개수: " + testSet.size());
	}

}

//Person 객체의 id값과 name 값이 모두 같으면 같은 객체로 처리도록 하기 
//			=>equals()메서드를 재정의해서 처리한다. 
class Person {
	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		// 참조값 (주소값) 이 같은지 검사
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		// 같은 유형의 클래스인지 검사
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		// 매개변수에 저장된 객체를 현재 객체 유형으로 형변환한다.
		Person that = (Person) obj;

		// 비교대상의 멤버 변수들이 같은지 여부를 검사한다.
		return this.id == that.id && Objects.equals(this.name, that.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}
}
