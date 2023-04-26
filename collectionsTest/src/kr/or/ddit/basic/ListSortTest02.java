package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListSortTest02 {
	public static void main(String[] args) {
		List<Member> members = new ArrayList<>();
		members.add(new Member(1, "홍길동", "010-9191-9191"));
		members.add(new Member(5, "이순신", "010-1919-1919"));
		members.add(new Member(4, "성춘향", "010-8282-8282"));
		members.add(new Member(2, "강감찬", "010-2828-2828"));
		members.add(new Member(9, "일지매", "010-7373-7373"));
		members.add(new Member(6, "변학도", "010-3737-3837"));

		System.out.println("정렬 전");
		printList(members);
		System.out.println("=============================================");

		Collections.sort(members);

		System.out.println("회원 이름 기준 오름차순 정렬 후");
		printList(members);
		System.out.println("=============================================");

		Collections.shuffle(members);
		System.out.println("셔플 후");
		printList(members);
		System.out.println("=============================================");

		// Member의 회원번호(num) 값의 내림차순으로 정렬하는 외부정렬기준 클래스를 작성하여 정렬하시오.
		// Comparator인터페이스를 구현한 SortNumDesc클래스를 생성한다.
		System.out.println("회원 번호 기준 내림차순 정렬 후");
		Collections.sort(members, new SortNumDesc());
		printList(members);
		System.out.println("=============================================");
	}

	private static void printList(List<Member> members) {
		for (Member member : members) {
			System.out.println(member);
		}
	}

}

class SortNumDesc implements Comparator<Member> {

	@Override
	public int compare(Member member1, Member member2) {
		// 내답
		Integer member1No = member1.getNum();
		Integer member2No = member2.getNum();
		return member1No.compareTo(member2No) * -1;
		
		// 쌤답1
//		return Integer.valueOf(member1.getNum()).compareTo(Integer.valueOf(member2.getNum())) * -1;
		// 쌤답2
//		return new Integer(member1.getNum()).compareTo(member2.getNum());
		// 쌤답3
//		return Integer.compare(member1.getNum(), member2.getNum()) * -1;
	}

}

// Member클래스의 회원이름을 기준으로 오름차순 정렬이 되로록 내부 정렬 기준을 추가하기
class Member implements Comparable<Member> {
	private int num;
	private String name;
	private String tel;

	public Member(int num, String name, String tel) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", tel=" + tel + "]";
	}

	// 회원이름의 오름차순 정렬 지정하기
	@Override
	public int compareTo(Member member) {
		return this.getName().compareTo(member.getName());
	}

}