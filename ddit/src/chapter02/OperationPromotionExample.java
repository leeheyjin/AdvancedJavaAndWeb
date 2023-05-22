package chapter02;

public class OperationPromotionExample {
	public static void main(String[] args) {
		byte byteValue1 = 10;
		byte byteValue2 = 20;
		byte byteValue3 = (byte) (byteValue1 + byteValue2); // 더하면 int가 되므로 byte로 형변환 해야함
		int intValue1 = byteValue1 + byteValue2;
		System.out.println("intValue1: " + intValue1);

		char charValue1 = 'A';
		char charValue2 = 1;
		char charValue3 = (char) (charValue1 + charValue1); // 더하면 int가 되므로 char로 형변환 해야함
		int intValue2 = charValue1 + charValue2;
		System.out.println("유니코드: " + intValue2);
		System.out.println("출력문자: " + (char) intValue2);
		
		int intValue3 = 10;
		int intValue4 = intValue3 / 4;
		System.out.println(intValue4);
		
		int intValue5 = 10;
		int intValue6 = (int) (intValue5 / 4.0); // 정수 실수는 연산을 할 수 없으므로 (int)로 형변환 해야함
		double doubleValue1 = intValue5 / 4.0;
		System.out.println(doubleValue1);
		
		int x = 1;
		int y = 2;
		double result = (double) x / y; // 연산 자체는 정수와 정수의 연산이므로 에러발생 X. 정확한 결과를 얻고 싶으면 double로 형변환
		System.out.println(result);

		long var1 = 2l;
		float var2 = 1.8f;
		double var3 = 2.5;
		String var4 = "3.9";
		int results = (int) var1 + (int) (var2 + var3) + (int) Double.parseDouble(var4);
		System.out.println(results);
	}

	/*
	 * 예상결과* 30 66 B 2 2.5 0.5
	 */

}
