package chapter07.confirm;

class Shape {
	public double area() {
		return 0.0;
	}

	public double perimeter() {
		return 0.0;
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
		return "도형의 종류: 사각형, 둘레: " + perimeter() + "cm, 넓이: " + area() + "cm²";
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
		return "도형의 종류: 삼각, 둘레: " + perimeter() + "cm, 넓이: " + area() + "cm²";

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
		return "도형의 종류: 원, 둘레: " + perimeter() + "cm, 넓이: " + area() + "cm²";
	}
}

public class ShapeTest {
	public static void main(String[] args) {
		Shape[] shapes = new Shape[3];
		shapes[0] = new Circle(1.0);
		shapes[1] = new Triangle(2.0);
		shapes[2] = new Rectangle(2.0, 3.0);
		for (Shape shape : shapes) {
			System.out.println(shape);
		}
	}

}
