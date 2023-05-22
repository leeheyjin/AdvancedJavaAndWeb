 package codingTest;

public class Exercise {
	public static void main(String[] args) {
		// 1
		int numOfApples = 123;
		int sizeOfBuckets = 10;
		int numOfBucket = numOfApples % sizeOfBuckets > 0 ? numOfApples / sizeOfBuckets + 1
				: numOfApples / sizeOfBuckets;

		System.out.println("필요한 바구니의 수: " + numOfBucket);

		// 2
		int num = -2;
		System.out.println(num > 0 ? "양수" : (num == 0 ? "0" : "음수"));

		// 3
		int num1 = 456;
		System.out.println(num1 - num1 % 100);

		// 4
		int num2 = 777;
		System.out.println(num2 - num2 % 10 + 1);

		// 5
		int num3 = 19;
		System.out.println((num3 / 10 + 1) * 10 - num3);

		// 6
		char ch = '1';
		boolean b = ((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122) || (ch >= 48 && ch <= 57)) ? true : false;
		System.out.println(b);

		// 7
		char ch1 = 'A';
		char lowerCase = (ch1 >= 65 && ch1 <= 90) ? (char) (ch1 + 32) : ch1;
		System.out.println("ch: " + ch1);
		System.out.println("ch to lowerCase: " + lowerCase);

	}

}
