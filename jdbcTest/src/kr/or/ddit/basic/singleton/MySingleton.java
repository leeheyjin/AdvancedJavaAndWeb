package kr.or.ddit.basic.singleton;

/* 싱글톤 클래스 정의 방법
 * 1. 자신 class의 참조값이 저장될 변수를 private static으로 선언한다
 * 2. 모든 생성자의 접근 제한자를 private으로 한다 그래야 외부에서 new를 사용하지 못함
 * 3. 자신 class의 인스턴스를 생성하고 반환하는 메서드를 public static으로 생성한다 주로 이 메서드의 이름은 getInstance로 한다
 */
public class MySingleton {
	// 1.
	private static MySingleton singleton;

	// 2.
	private MySingleton() {
		System.out.println("싱글톤 객체의 생성자입니다");
	}

	// 3.
	public static MySingleton getInstance() {
		if (singleton == null) {
			singleton = new MySingleton();
		}
		return singleton;
	}

	// 기타 이 클래스가 처리할 내용을 작성함
	public void displayTest() {
		System.out.println("이 내용은 싱글톤 클래스의 처리 내용입니다");
	}

}
