package kr.or.ddit.basic;

/*
 * JavaDoc파일 만들기 예제: 프로그램과 메뉴얼을 깉아 만드는 방법
 */

/**
 * 
 * @author leehyejin
 * 
 *         <pre>
 * 파일명: JavaDocTest.java
 * 설명: JavaDoc문서 작성을 위한 연습용 Interfacer
 * 
 * 변경 이력
 * ---------------------------
 * 변경 날짜: 2023-05-15
 * 변경인: 이헤진
 * 변경 내역: 최초 생성
 * ---------------------------
 *         </pre>
 */
public interface JavaDocTest {
	/**
	 * <pre>
	 * 메서드명: methodTest
	 * 설   명: 반환 값이 없는 메서드
	 * 
	 * 
	 * @param a 첫 번째 매개변수
	 * @param b 두 번째 매개변수
	 * </pre>
	 */
	public void methodTest(int a, int b);
	
	/**
	 * 메서드명: methodAdd
	 * 설   명: 반환값이 있는 메서드
	 * 
	 * @param x 정수형 첫번째 매개변수
	 * @param y 정수형 두번째 매개변수
	 * @return 처리된 결과를 정수형으로 반환
	 */
	public int methodAdd(int x, int y);
	
	/**
	 * 메서드명: methodInput
	 * 설   명: 매개변수가 없는 메서드
	 * @return 처리된 결과를 정수형으로 반환한다
	 */
	public int methodInput();
	
}
