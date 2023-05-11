package kr.or.ddit.basic;

import java.sql.Statement;
import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/*
 * 문제: 사용자로부터 lprod_id값을 입력받아 입력한 값보다 lprod_id가 큰 자료들을 출력하시오
 */
public class JdbcTest02 {
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		Scanner scanner = new Scanner(System.in);
		System.out.print("첫번쨰 lprod_id값 입력 >> ");

		int num = Integer.parseInt(scanner.nextLine());

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "pc09", "java");

			String sql = "select * from lprod where lprod_id > " + num;
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				System.out.println("lprod_id: " + resultSet.getInt("lprod_id"));
				System.out.println("lprod_gu: " + resultSet.getString("lprod_gu"));
				System.out.println("lprod_nm: " + resultSet.getString("lprod_nm"));
				System.out.println();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		}
	}

}
