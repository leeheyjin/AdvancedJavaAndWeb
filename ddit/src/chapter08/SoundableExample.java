package chapter08;

class Dog implements Soundable {

	@Override
	public String sound() {
		return "멍멍";
	}

}

class Cat implements Soundable {

	@Override
	public String sound() {
		return "야옹";
	}

}

public class SoundableExample {
	public static void main(String[] args) {
		printSound(new Dog());
		printSound(new Cat());
	}

	private static void printSound(Soundable soundable) {
		System.out.println(soundable.sound());
	}

}
