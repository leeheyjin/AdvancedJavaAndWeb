package kr.or.ddit.basic;

import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * 문제: lprod_id값을 2개 입력 받아서 두 값중 작은값부터 큰값사이의 자료들을 출력하시오
 */
public class JdbcTest03 {
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		Scanner scanner = new Scanner(System.in);
		System.out.print("첫번쨰 lprod_id값 입력 >> ");
		int num1 = Integer.parseInt(scanner.nextLine());
		System.out.print("두번쨰 lprod_id값 입력 >> ");
		int num2 = Integer.parseInt(scanner.nextLine());

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "pc09", "java");

			String sql = "SELECT * FROM LPROD WHERE LPROD_ID BETWEEN " + num1 + "AND " + num2;
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				System.out.println("LPROD_ID: " + resultSet.getInt(1));
				System.out.println("LPROD_GU: " + resultSet.getString(2));
				System.out.println("LPROD_NM: " + resultSet.getString(3));
				System.out.println();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
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
