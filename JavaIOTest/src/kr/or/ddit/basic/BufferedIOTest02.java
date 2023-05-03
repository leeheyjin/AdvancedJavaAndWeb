package kr.or.ddit.basic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedIOTest02 {
	// 문자 기반의 Buffered스트림 사용 예제(입력용)
	public static void main(String[] args) {
		try {
			FileReader fileReader = new FileReader("./src/kr/or/ddit/basic/FileTest01.java");

			// 버퍼스트림의 크기를 지정하지 않으면 기본적으로 8kb 크기로 설정된다
			BufferedReader bReader = new BufferedReader(fileReader);

			String temp = ""; // 읽어온 문자열이 저장될 변수

			// readLine(): 문자 기반의 입력을 BufferedStream에는 한 줄 단위로 읽어오는 메서드
			for (int i = 1; (temp = bReader.readLine()) != null; i++) {
				System.out.printf("%4d: %s%n", i, temp);
			}

			bReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
