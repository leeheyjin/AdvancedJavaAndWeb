package chapter08.confirm;

import java.util.Arrays;

abstract class Shape implements Comparable<Shape> {
	public abstract double area();

	public abstract double perimeter();

	public int compareTo(Shape that) {
		return Double.compare(this.area(), that.area());
	}
}

class Rectangle extends Shape {
	private double width;
	private double height;

	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public double area() {
		return width * height;
	}

	@Override
	public double perimeter() {
		return 2 * (width + height);
	}

	@Override
	public String toString() {
		return String.format("도형의 종류: 사각형, 둘레: %.2fcm, 넓이: %.2fcm²", perimeter(), area());
	}
}

class Triangle extends Shape {
	private double side;

	public Triangle(double side) {
		this.side = side;
	}

	@Override
	public double area() {
		return side / 2 * side * Math.sqrt(3) / 2;
	}

	@Override
	public double perimeter() {
		return side * 3;
	}

	@Override
	public String toString() {
		return String.format("도형의 종류: 삼각형, 둘레: %.2fcm, 넓이: %.2fcm²", perimeter(), area());

	}
}

class Circle extends Shape {
	private double radius;

	public Circle(double radius) {
		this.radius = radius;
	}

	@Override
	public double area() {
		return radius * radius * Math.PI;
	}

	@Override
	public double perimeter() {
		return 2 * radius * Math.PI;
	}

	@Override
	public String toString() {
		return String.format("도형의 종류: 원, 둘레: %.2fcm, 넓이: %.2fcm²", perimeter(), area());
	}
}

public class ShapeTest {
	public static void main(String[] args) {
		Shape[] shapes = new Shape[7];
		shapes[0] = new Circle(1.0);
		shapes[1] = new Triangle(2.0);
		shapes[2] = new Rectangle(2.0, 3.0);
		shapes[3] = new Triangle(3.0);
		shapes[4] = new Rectangle(5.0, 2.3);
		shapes[5] = new Circle(2.5);
		shapes[6] = new Circle(1.3);

		System.out.println("<도형들을 넓이 기준으로 정렬하기 전>");
		for (Shape s : shapes) {
			System.out.println(s);
		}

		Arrays.sort(shapes);
		System.out.println();
		System.out.println("<도형들을 넓이 기준으로 정렬한 후>");
		for (Shape s : shapes) {
			System.out.println(s);
		}
	}

}
