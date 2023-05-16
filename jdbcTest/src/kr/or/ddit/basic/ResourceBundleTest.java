package kr.or.ddit.basic;

import java.util.ResourceBundle;

/*
 * ResourceBundle객체: 파일의 확장자가 properties인 파일의 내용을 읽어와서 key값과 value값을 구분해서 정보를 갖고 있는 객체
 */
public class ResourceBundleTest {
	public static void main(String[] args) {
		// ResourceBundle객체를 이용하여 properties파일 읽어오기
		// ResourceBundle객체 생성하기: 객체를 생성할 때 읽어올 properties파일의 정보를 지정해준다. 이 파일의 정보를 지정할 때 '패키지명.파일명'까지만 지정하고 확장자는 제외한다
		ResourceBundle bundle = ResourceBundle.getBundle("kr.or.ddit.config.dbinfo");
		// 읽어올 내용 출력하기
		System.out.println("driver: " + bundle.getString("driver"));
		System.out.println("url: " + bundle.getString("url"));
		System.out.println("user: " + bundle.getString("user"));
		System.out.println("password: " + bundle.getString("password"));
	}

}
