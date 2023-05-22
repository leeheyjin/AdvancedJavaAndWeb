package chapter04;

public class ForFloatCounterExample {
	public static void main(String[] args) {
		for (float x = 0.1f; x <= 1.0f; x += 0.1f) {
			System.out.println(x);
		}
	}
	/*예상결과*
	 * 0.1
	 * 0.2
	 * 0.3
	 * 0.4
	 * 0.5
	 * 0.6
	 * 0.7
	 * 0.8
	 * 0.9?
	 */
}
