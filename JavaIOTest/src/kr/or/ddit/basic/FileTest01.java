package kr.or.ddit.basic;

import java.io.File;

public class FileTest01 {
	public static void main(String[] args) {
		File file = new File("/Users/leehyejin/Downloads/test.txt"); // 구분문자로 '/' 사용
		System.out.println("파일명: " + file.getName());
		System.out.println("파일여부: " + file.isFile());
		System.out.println("디렉토리(폴더) 여부: " + file.isDirectory());
		System.out.println();
		File folder = new File("/Users/leehyejin/Downloads"); // 구분문자로 '/' 사용
		System.out.println("폴더명: " + folder.getName());
		System.out.println("파일여부: " + folder.isFile());
		System.out.println("디렉토리(폴더) 여부: " + folder.isDirectory());
		System.out.println();
		File file2 = new File(folder, "test.txt");
		System.out.println("파일명: " + file2.getName());
		System.out.println("파일여부: " + file2.isFile());
		System.out.println("디렉토리(폴더) 여부: " + file2.isDirectory());
		System.out.println();
		File file3 = new File("/Users/leehyejin/Downloads", "test.txt");
		System.out.println("파일명: " + file3.getName());
		System.out.println("파일여부: " + file3.isFile());
		System.out.println("디렉토리(폴더) 여부: " + file3.isDirectory());
		System.out.println();
		File file4 = new File("/Users/leehyejin/Downloads/연습용");
		
		
	}

}
