package chapter11;

import java.io.IOException;

public class KeyboardToStringExample {
	public static void main(String[] args) throws IOException {
		byte[] bytes = new byte[100];
		
		System.out.println("입력: ");
		int readByteNo = System.in.read(bytes);
		
		String string = new String(bytes, 0, readByteNo-1);
		System.out.println(string);
	}

}
