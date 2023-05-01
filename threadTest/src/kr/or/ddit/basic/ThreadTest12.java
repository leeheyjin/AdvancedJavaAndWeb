package kr.or.ddit.basic;

import java.util.Random;

/*
 * 3개의 스레드가 각각 알파벳을 a~z까지 출력하는데 출력을 끝낸 순서대로 결과를 나타내는 프로그램을 작성하시오
 */
public class ThreadTest12 {
	public static void main(String[] args) {
		DisplayCharacter[] threadArr = { new DisplayCharacter("홍길동"), new DisplayCharacter("이순신"),
				new DisplayCharacter("엄석대") };

		for (DisplayCharacter displayCharacter : threadArr) {
			displayCharacter.start();
		}

		for (int i = 0; i < threadArr.length; i++) {
			try {
				threadArr[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println();
		System.out.println("경기 결과");
		System.out.println("순위: " + DisplayCharacter.setOrder);
	}

}

// A~Z까지 출력하는 메서드
class DisplayCharacter extends Thread {
	public static String setOrder = ""; // 출력을 끝낸 순서대로 스레드 이름이 저장될 변수
	private String name;

	public DisplayCharacter(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		Random random = new Random();
		for (char c = 'A'; c <= 'Z'; c++) {
			System.out.println(name + "의 출력문자: " + c);
			try {
				Thread.sleep(random.nextInt(400));
			} catch (InterruptedException e) {
			}
		}
		System.out.println(name + "의 출력 끝");
		DisplayCharacter.setOrder += name + " ";

	}
}