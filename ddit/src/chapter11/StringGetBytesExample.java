package chapter11;

public class StringGetBytesExample {
	public static void main(String[] args) {
		String string = "안녕하세요";
		
		byte[] bytes1 = string.getBytes();
		System.out.println("bytes1.length: " + bytes1.length);
		String str1 = new String(bytes1);
		System.out.println("bytes1 -> String: " + str1);

		try {
			byte[] bytes2 = string.getBytes("EUC-KR");
			System.out.println("bytes2.length: " + bytes2.length);
			String string2 = new String(bytes2, "EUC-KR");
			System.out.println("bytes2 -> String: " + string2);

			byte[] bytes3 = string.getBytes("UTF-8");
			System.out.println("bytes3.length: " + bytes3.length);
			String string3 = new String(bytes3, "UTF-8");
			System.out.println("bytes3 -> String: " + string3);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
