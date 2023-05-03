package kr.or.ddit.basic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataIOTest {
	public static void main(String[] args) {
		try {
			// 파일 출력용 스트림 객체 생성
			FileOutputStream fOut = new FileOutputStream("/Users/leehyejin/Downloads/test.dat");

			// 자료형 단위로 출력할 보조 스트림 객체 생성
			DataOutputStream dOut = new DataOutputStream(fOut);
			dOut.writeInt(2000); // 정수형으로 데이터 출력
			dOut.writeFloat(1.2345f); // 실수형으로 데이터 출력
			dOut.writeBoolean(false); // 논리형으로 데이터 출력
			dOut.writeUTF("ABCDabcd"); // 문자열로 데이터 출력
			dOut.close();

			// 출력한 자료 읽어오기
			DataInputStream dIn = new DataInputStream(new FileInputStream("/Users/leehyejin/Downloads/test.dat"));

			// DataInputStream으로 자료를 읽어올 때는 출력하는 순서와 같은 순서로 읽어야한다.
			System.out.println("정수형: " + dIn.readInt());
			System.out.println("실수형: " + dIn.readFloat());
			System.out.println("논리형: " + dIn.readBoolean());
			System.out.println("문자열형: " + dIn.readUTF());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
