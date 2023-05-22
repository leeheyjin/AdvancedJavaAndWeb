package chapter05;

public class StringEqualExample {
	public static void main(String[] args) {
		String strVal1 = "신민철";
		String strVal2 = "신민철";

		if (strVal1 == strVal2) {
			System.out.println("strVal1과 strVal2는 참조가 같음");
		} else {
			System.out.println("strVal1과 strVal2는 참조가 다름");
		}

		if (strVal1.equals(strVal2)) {
			System.out.println("strVal1과 strVal2는 문자열이 같음");
		}

		String strVal3 = new String("신민철");
		String strVal4 = new String("신민철");

		if (strVal3 == strVal4) {
			System.out.println("strVal3과 strVal4는 참조가 같음");
		} else {
			System.out.println("strVal3과 strVal4는 참조가 다름");
		}

		if (strVal1.equals(strVal2)) {
			System.out.println("strVal3과 strVal4는 문자열이 같음");

		}
	}
	/*예상결과*
	 * strVal1과 strVal2는 참조가 같음
	 * strVal1과 strVal2는 문자열이 같음
	 * strVal3과 strVal4는 참조가 다름
	 * strVal3과 strVal4는 문자열이 같음
	 */

}
