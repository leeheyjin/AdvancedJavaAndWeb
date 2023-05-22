package chapter06;

class A {
	public int field1;
	int field2;
	private int field3;
	
	public A() {
		field1 = 1;
		field2 = 1;
		field3 = 1;
		
		method1();
		method2();
		method3();
	}

	public void method1() {
		// TODO Auto-generated method stub
		
	}

	void method2() {
		// TODO Auto-generated method stub
		
	}

	private void method3() {
		// TODO Auto-generated method stub
		
	}
}

class B{
	public B() {
		A a = new A();
		a.field1 = 1;
		a.field2 = 1;
		a.field3 = 1;
		
		a.method1();
		a.method2();
		a.method3();
	}
}

public class C {
	public C() {
		A a = new A();
		a.field1 = 1;
		a.field2 = 1;
		a.field3 = 1;
		
		a.method1();
		a.method2();
		a.method3();
	}
}
