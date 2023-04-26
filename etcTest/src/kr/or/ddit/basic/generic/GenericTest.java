package kr.or.ddit.basic.generic;

public class GenericTest {
	public static void main(String[] args) {
		NonGeneric nonGeneric1 = new NonGeneric();
		nonGeneric1.setValue("가나다라");

		NonGeneric nonGeneric2 = new NonGeneric();
		nonGeneric2.setValue(1234);

		String stringValue = (String) nonGeneric1.getValue();
		int intValue = (int) nonGeneric2.getValue();

		MyGeneric<String> myGeneric1 = new MyGeneric();
		myGeneric1.setValue("가나다라");
		String stringVal = myGeneric1.getValue();
		
		MyGeneric<Integer> myGeneric2= new MyGeneric();
		myGeneric2.setValue(1234);
		int intVal = myGeneric2.getValue();
		
		System.out.println(stringVal);
		System.out.println(intVal);
		
		NonGeneric test = new NonGeneric();
		test.setValue("ABCDE");
		int a = (int) test.getValue();
		
		MyGeneric<String> test2 = new MyGeneric();
		test2.setValue("XYZ");
		String b = test2.getValue();
	}

}

// 제네릭을 적용한 클래스 작성
class MyGeneric<T> {
	private T value;

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

}

// 제네릭을 적용하지 않은 클래스 작성
class NonGeneric {
	private Object value;

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

}