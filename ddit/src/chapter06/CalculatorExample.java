package chapter06;

class Calculator {
	void powerOn() {
		System.out.println("전원을 켭니다.");
	}

	int plus(int x, int y) {
		return x + y;
	}

	double divide(int x, int y) {
		return (double) x / y;
	}

	void powerOff() {
		System.out.println("전원을 끕니다.");
	}
}

public class CalculatorExample {
	public static void main(String[] args) {
		Calculator c = new Calculator();
		c.powerOn();
		int result1 = c.plus(4, 5);
		System.out.println("result1: " + result1);

		byte x = 10;
		byte y = 4;
		double result2 = c.divide(x, y);
		System.out.println("result2: " + result2);
		
		c.powerOff();
	}
}
