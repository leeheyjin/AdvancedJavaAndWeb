package codingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test1 {
	public static void main(String[] args) {
		int[][] lines = { { 0, 2 }, { -3, -1 }, { -2, 1 } };
		List<Integer> list = new ArrayList<>();
		List<Integer> existsList = new ArrayList<>();
		for (int i = 0; i < lines.length; i++) {
			int a = lines[i][0];
			int b = lines[i][1];
			int result = 0;
			for (int j = 0; j <= (b - a); j++) {
				result = a + j;
				if (list.contains(result)) {
					existsList.add(result);
				}
			}
		}
		System.out.println(list);
		System.out.println(existsList);
	}

}
