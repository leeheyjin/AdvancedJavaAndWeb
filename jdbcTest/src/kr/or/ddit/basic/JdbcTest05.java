package kr.or.ddit.basic;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/*
 * LPROD 테이블에 새로운 데이터 추가하기 
 * 
 * lprod_gu 와 lprod_nm 값은 직접 입력받아 처리하고,
 * lprod_id 는 현재의 lprod_id 중에서 제일 큰 값보다 1 만큼 크게 한다.
 * 
 * 입력받은 lprod_gu가 이미 등록되어 있으면 다시 입력 받아서 처리한다. 
 * 
 */
public class JdbcTest05 {
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		PreparedStatement prepareStatement;

		Scanner scanner = new Scanner(System.in);

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "pc09", "java");

			String sql = "INSERT INTO LPROD VALUES ((SELECT MAX(LPROD_ID) FROM LPROD) + 1, ?, ?)";
			prepareStatement = connection.prepareStatement(sql);

			String lprodGu = scanner.nextLine();
			if (exists(lprodGu) == true) { // 만약 lprodGu값이 존재하면 추가하지 않음

			}
			String lprodNm = scanner.nextLine();

			prepareStatement.setString(1, lprodGu); // lprod_gu
			prepareStatement.setString(2, lprodNm); // lprod_nm

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static boolean exists(String lprodGu) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "pc09", "java");

			String sql = "SELECT COUNT(*) FROM LPROD WHERE LPROD_GU = " + lprodGu;
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
