package codingTest;

import java.util.Random;

public class Chapter05Exercise4 {
	public static void main(String[] args) {
		int[] frequency = new int[6];
		for (int i = 0; i < 10000; i++) {
			int diceNum = new Random().nextInt(6) + 1;
			for (int j = 0; j < 6; j++) {
				if (diceNum == j + 1) {
					frequency[j]++;
				}
			}
		}
		
		System.out.println("----------------");
		System.out.println("¸é            ºóµµ");
		System.out.println("----------------");
		for (int i = 0; i < 6; i++) {
			System.out.println((i + 1) + "           " + frequency[i]);
		}

	}

}
