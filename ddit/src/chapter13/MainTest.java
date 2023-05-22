package chapter13;

public class MainTest {
	public static void main(String[] args) {
		int n = 4;
		n = n + new MainTest().multiply(8, 2);
	}

	private int multiply(int x, int y) {
		return x * y;
	}

}
