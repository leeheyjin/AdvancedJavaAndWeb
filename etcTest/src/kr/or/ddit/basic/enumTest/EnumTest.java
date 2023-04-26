package kr.or.ddit.basic.enumTest;

public class EnumTest {
	public static void main(String[] args) {
//		System.out.println("RED: " + ConstTest.RED);
//		System.out.println("THREE: " + ConstTest.THREE);
//		
//		if (ConstTest.RED == ConstTest.TWO) {
//			System.out.println("....");
//		} else {
//			System.out.println("####");
//		}

		Color myColor = Color.valueOf("GREEN");
//		Color myColor = Color.GREEN; // 위 문장과 의미가 같음
		System.out.println("myColor: " + myColor.name());

		Count myCount = Count.ONE;
		System.out.println("myCount: " + myCount.name());

		System.out.println("myColor.ordinal(): " + myColor.ordinal());
		System.out.println("myCount.ordinal(): " + myCount.ordinal());

		if (myColor == Color.BLUE) {
			System.out.println("..");
		} else {
			System.out.println("---^--@");
		}

		switch (myCount) {
		case ONE:
			System.out.println("ONE입니다.");
			break;

		case TWO:
			System.out.println("TWO입니다.");
			break;

		case THREE:
			System.out.println("THREE입니다.");
			break;
		}

		System.out.println("===================================");

		Season ss = Season.valueOf("봄");
		System.out.println("name: " + ss.name());
		System.out.println("ordinal: " + ss.ordinal());
		System.out.println("span: " + ss.span);
		System.out.println("temp: " + ss.temp);
		System.out.println("===================================");

		for (Season season : Season.values()) {
			System.out
					.println(season + " == " + season.name() + " -> " + season.getSpan() + ", 평균기온: " + season.getTemp());
		}

	}

	public enum Color {
		RED, GREEN, BLUE // 0, 1, 2번째
	}

	public enum Count {
		ONE, TWO, THREE
	}

	public enum Season {
		봄("3월부터 5월까지", 13), 여름("6월부터 8월까지", 25), 가을("9월부터 11월까지", 15), 겨울("12월부터 2월까지", 1);

		// 값들이 저장될 변수 선언
		private String span;
		private int temp;

		// 생성자
		private Season(String span, int temp) {
			this.span = span;
			this.temp = temp;
		}

		public String getSpan() {
			return span;
		}

		public int getTemp() {
			return temp;
		}
	}

}

enum TestEnum {

}
