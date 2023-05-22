package kr.or.ddit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

// JDBC드라이버를 로딩하고 Connection객체를 생성하여 반환하는 메서드로 구성된 클래스
public class DBUtil {
	static final Logger LOGGER = Logger.getLogger(DBUtil.class);
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			LOGGER.info("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			LOGGER.error("드라이버 로딩 실패", e);
		}
	}

	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "pc09", "java");
			LOGGER.info("드라이버 연결 성공");
		} catch (SQLException e) {
			LOGGER.error("드라이버 연결 실패", e);
			return null;
		}
		return connection;
	}
}
