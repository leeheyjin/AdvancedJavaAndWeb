package kr.or.ddit.basic.args;

public class ArgsTest {
	// 매개변수로 받은 정수들의 합계를 구하는 메서드 만들기
	// (이 정수들의 개수는 상황에 따라 다르다.)

	// 배열을 이용한 메서드
	public int sumArr(int[] data) {
		int sum = 0;
		for (int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		return sum;
	}

	// 가변형 인수를 이용한 메서드
	public int sumArg(int... data) {
		int sum = 0;
		for (int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		return sum;
	}

	public String sumArg2(String name, int... data) {
		int sum = 0;
		for (int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		return name + "씨의 합계: " + sum;
	}

	public static void main(String[] args) {
		ArgsTest at = new ArgsTest();
//		at.test01(0, "홍록기");
//		System.out.println("----------------------");
//		at.test01(1, "알렉스");

		System.out.println(at.sumArr(new int[] { 5, 2, 3, 4, 5 }));

		System.out.println(at.sumArg(1, 3, 2, 1, 5, 1, 4, 1, 5, 234, 56, 34));

		System.out.println(at.sumArg2("홍록기", 99, 3, 1, 5, 23, 23, 2, 6, 45, 344));
	}

	public void test01(int a, String str) {
		System.out.println("a = " + a);
		System.out.println("str = " + str);
	}

	public int test02(int a, int b, int c) {
		return a + b + c;
	}
}
