package codingTest;

public class Chapter05Exercise1 {
	public static void main(String[] args) {
		int[] arrays = { 38, 94, 16, 3, 76, 94, 82, 47, 59, 8 };
		int max = 0;
		for (int i : arrays) {
			if (max < i) {
				max = i;
			}
		}
		System.out.println("max: " + max);

		int min = max;
		for (int i : arrays) {
			if (min > i) {
				min = i;
			}
		}
		System.out.println("min: " + min);
	}

}
