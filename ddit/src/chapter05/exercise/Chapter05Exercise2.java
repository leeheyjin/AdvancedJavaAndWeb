package codingTest;

import java.util.Arrays;
import java.util.Random;

public class Chapter05Exercise2 {
	public static void main(String[] args) {
		int[] lotto = new int[6];
		for (int i = 0; i < lotto.length; i++) {
			Random random = new Random();
			lotto[i] = random.nextInt(45) + 1;
			if (i != 0 && lotto[i] == lotto[i - 1]) {
				lotto[i] = random.nextInt(45) + 1;
			}
		}

		System.out.println(Arrays.toString(lotto));

	}
}
