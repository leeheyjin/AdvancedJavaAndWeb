package chapter13;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Student {
	public int sno;
	public String name;

	public Student(int sno, String name) {
		super();
		this.sno = sno;
		this.name = name;
	}

	@Override
	public int hashCode() {
		return sno + name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student) {
			Student student = (Student) obj;
			return (sno == student.sno) && (name.equals(student.name));
		} else {
			return false;
		}
	}

}

public class HashMapExample {
	public static void main(String[] args) {
		Map<Student, Integer> map = new HashMap<>();
		map.put(new Student(1, "홍길동"), 95);
		map.put(new Student(1, "홍길동"), 95);

		System.out.println("총 Entry 수: " + map.size());
	}

}
