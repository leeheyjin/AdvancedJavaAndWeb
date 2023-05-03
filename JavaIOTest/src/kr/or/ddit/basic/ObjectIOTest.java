package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StringBufferInputStream;

// 객체를 파일에 저장하는 예제
public class ObjectIOTest {
	public static void main(String[] args) {
		Member member1 = new Member("박예린", 25, "대전");
		Member member2 = new Member("신류진", 23, "서울");
		Member member3 = new Member("한소희", 28, "부산");
		Member member4 = new Member("김유정", 23, "강릉");

		try {
			// 객체를 파일로 저장하기 위한 스트림 객체 생성
			FileOutputStream fOut = new FileOutputStream("/Users/leehyejin/Downloads/memberObj.bin");
			BufferedOutputStream bOut = new BufferedOutputStream(fOut);
			ObjectOutputStream oOut = new ObjectOutputStream(bOut);

			// 쓰기 작업
			System.out.println("객체 저장 시작");
			oOut.writeObject(member1);
			oOut.writeObject(member2);
			oOut.writeObject(member3);
			oOut.writeObject(member4);
			// 객체를 저장할 때 맨 마지막에 null값을 추가하여 저장하면 읽어올 때 EOFException을 방지할 수 있다.
			oOut.writeObject(null); 
			System.out.println("객체 저장 작업 완료");

			oOut.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 저장된 객체를 읽어와 그 내용을 화면에 출력하기
		try {
			ObjectInputStream oIn = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream("/Users/leehyejin/Downloads/memberObj.bin")));
			Object object; // 읽어온 객체가 저장될 변수
			System.out.println("객체 읽기 작업 시작\n");
			while ((object = oIn.readObject()) != null) {
				// 읽어온 객체를 원래의 객체형으로 형변환 후 사용한다
				Member readMember = (Member) object;
				System.out.println("이름: " + readMember.getName());
				System.out.println("나이: " + readMember.getAge());
				System.out.println("주소: " + readMember.getAddress());
				System.out.println();
			}
			System.out.println("객체 읽기 작업 완료");
			oIn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

class Member implements Serializable {
	private String name;
	private int age;
	private String address;

	public Member(String name, int age, String address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}