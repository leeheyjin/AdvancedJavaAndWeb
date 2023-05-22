package chapter02;

public class PrintExample {
	public static void main(String[] args) {
		int value = 84929;
		System.out.printf("상품의 가격: %d원", value).println();
		System.out.printf("상품의 가격: %6d원", value).println();
		System.out.printf("상품의 가격: %-6d원", value).println();
		System.out.printf("상품의 가격: %06d원", value).println();
		System.out.printf("상품의 가격: %,d원", value).println();
		
		double area = 3.141592 * 10 * 10;
		System.out.printf("반지름이 %d인 원의 넓이: %10.2f", 10, area).println();
		
		String name = "홍길동";
		String job = "도적";
		System.out.printf("%6d | %-6s | %6s", 1, name, job).println();
		
	}

}
