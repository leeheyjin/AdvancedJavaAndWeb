package kr.or.ddit.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

// JDBC드라이버를 로딩하고 Connection객체를 생성하여 반환하는 메서드로 구성된 클래스
public class DBUtil2 {
	private static Properties properties;
	static {
		properties = new Properties();
		File file = new File("res/kr/or/ddit/config/dbinfo.properties");
		FileInputStream fin = null;

		try {
			fin = new FileInputStream(file);
			properties.load(fin);
			Class.forName(properties.getProperty("driver"));
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"),
					properties.getProperty("password"));
		} catch (SQLException e) {
			System.out.println("드라이버 연결 실패");
			return null;
		}
	}
}
