package kr.or.ddit.basic;

import java.util.Properties;

public class PropertiesTest {
	public static void main(String[] args) {
		Properties properties = new Properties();
		properties.setProperty("name", "홍길동");
		properties.setProperty("age", "20");
		properties.setProperty("tel", "010-1111-1111");
		properties.setProperty("address", "대전시 중구 오류동");

		String name = properties.getProperty("name");
		int age = Integer.valueOf(properties.getProperty("age"));
		String tel = properties.getProperty("tel");
		String address = properties.getProperty("address");

		System.out.println("이름: " + name);
		System.out.println("나이: " + age);
		System.out.println("번호: " + tel);
		System.out.println("주소: " + address);
	}
}
