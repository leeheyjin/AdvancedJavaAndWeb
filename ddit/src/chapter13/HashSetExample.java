package chapter13;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class Student8 {
	public int studentNum;
	public String name;

	public Student8(int studentNum, String name) {
		super();
		this.studentNum = studentNum;
		this.name = name;
	}

	@Override
	public int hashCode() {
		return studentNum;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student8) {
			Student8 student8 = (Student8) obj;
			return studentNum == student8.studentNum;
		} else {
			return false;
		}
	}

}

public class HashSetExample {
	public static void main(String[] args) {
		Set<Student8> set = new HashSet<>();
		set.add(new Student8(1, "홍길동"));
		set.add(new Student8(2, "신용권"));
		set.add(new Student8(1, "조민우"));

		Iterator<Student8> iterator = set.iterator();
		while (iterator.hasNext()) {
			Student8 student8 = iterator.next();
			System.out.println(student8.studentNum + ": " + student8.name);
		}
	}

}
