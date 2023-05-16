package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

public class PropertiesTest {
	public static void main(String[] args) {
		// 읽어올 정보를 저장할 Propertiees객체 생성
		Properties properties = new Properties();

		// 읽어올 properties파일명을 지정할 File객체 생성
		File file = new File("res/kr/or/ddit/config/dbinfo.properties");
		FileInputStream fin = null; // FileReader 사용 가능
		try {
			// 파일 내용을 읽어올 입력 스트림 객체 생성
			fin = new FileInputStream(file);
			// 입력 스트림을 이용하여 파일 내용을 읽어와 Properties객체에 저장하기
			properties.load(fin); // load(): 파일 내용을 읽어와 key값과 value값을 분류하나 후 Properties객체에 추가함
			// 읽어온 자료 출력해보기
			System.out.println("driver: " + properties.getProperty("driver"));
			System.out.println("url: " + properties.getProperty("url"));
			System.out.println("user: " + properties.getProperty("user"));
			System.out.println("password: " + properties.getProperty("password"));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fin != null) {
					fin.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
