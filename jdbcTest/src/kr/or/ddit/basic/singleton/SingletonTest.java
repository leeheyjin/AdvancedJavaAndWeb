package kr.or.ddit.basic.singleton;

public class SingletonTest {
	public static void main(String[] args) {
		MySingleton singleton1 = MySingleton.getInstance();
		MySingleton singleton2 = MySingleton.getInstance();
		
		System.out.println();
		System.out.println("singleton1: " + singleton1.toString());
		System.out.println("singleton2: " + singleton2);
		System.out.println();
		singleton1.displayTest();
	}

}
