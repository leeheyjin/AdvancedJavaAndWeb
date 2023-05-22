package chapter05.exercise;

import java.util.Random;

public class Exercise2 {
	public static void main(String[] args) {
		int[] array = new int[45];
		for (int i = 0; i < array.length; i++) {
			array[i] = i + 1;
		}

		for (int i = 0; i < array.length; i++) {
			int random = new Random().nextInt(45);
			int temp = array[i];
			array[i] = array[random];
			array[random] = temp;
		}

//		for (int i = 0; i < 5; i++) {
//			System.out.print(array[i] + ", ");
//		}
//		System.out.print(array[6]);
		
		for (int i = 0; i < 6; i++) {
			System.out.print((i == 0 ? "" : ", ") + array[i]);
		}
	}
}
