package chapter02.exercise;

public class Exercise2 {
	public static void main(String[] args) {
		double distance = 40e12;
		double velocity = 300000;
		double lightYear = velocity * 60 * 60 * 24 * 365;
		double time = distance / lightYear;

		System.out.printf("빛의 속도로 프록시마 센타우리 별까지 가는데 걸리는 시간은 %.15f광년이다", time);

	}

}
