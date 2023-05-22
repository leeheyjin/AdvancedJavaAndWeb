package chapter11;

public class StringSubstringExample {
	public static void main(String[] args) {
		String ssn = "980102-2313441";
		String firstnum = ssn.substring(0, 6);
		System.out.println(firstnum);
		
		String lastnum = ssn.substring(7);
		System.out.println(lastnum);
	}

}
