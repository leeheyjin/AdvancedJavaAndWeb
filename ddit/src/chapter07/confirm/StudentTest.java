package chapter07.confirm;

class Human {
	private String name;
	private int age;

	public Human(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "이름: " + name + ", 나이: " + age;
	}

}

class Student extends Human {
	private String major;

	public Student(String name, int age, String major) {
		super(name, age);
		this.major = major;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String toString() {
		return super.toString() + ", 전공: " + major;
	}

}

public class StudentTest {
	public static void main(String[] args) {
		Human man = new Human("Steve", 30);
		System.out.println(man);

		Student student = new Student("Parker", 23, "Physics");
		System.out.println(student);

		student.setName("Peter");
		student.setAge(19);
		student.setMajor("Computer Science");
		System.out.print("이름: " + student.getName() + ", ");
		System.out.print("나이: " + student.getAge() + ", ");
		System.out.print("전공: " + student.getMajor());
	}
}
