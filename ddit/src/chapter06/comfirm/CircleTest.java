package chapter06.comfirm;

class Circle {
	private double radius;
	private double x;
	private double y;

	public double getArea() {
		return radius * radius * Math.PI;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		if (radius < 0) {
			this.radius = 0;
		} else {
			this.radius = radius;
		}
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
}

public class CircleTest {
	public static void main(String[] args) {
		Circle circle1 = new Circle();
		circle1.setRadius(3.6);
		circle1.setX(0.0);
		circle1.setY(1.5);

		System.out.println("반지름: " + circle1.getRadius());
		System.out.println("중심좌표: " + "(" + circle1.getX() + ", " + circle1.getY() + ")");
		System.out.printf("넓이: %.2f\n", circle1.getArea());
		System.out.println();
		
		Circle circle2 = new Circle();
		circle2.setRadius(-5.0); // 만약 잘못된 값이 입력되었을 경우 반지름의 값을 0으로 한다.
		circle2.setX(1.0);
		circle2.setY(2.2);

		System.out.println("반지름: " + circle2.getRadius());
		System.out.println("중심좌표: " + "(" + circle2.getX() + ", " + circle2.getY() + ")");
		System.out.printf("넓이: %.2f\n", circle2.getArea());
	}
}
