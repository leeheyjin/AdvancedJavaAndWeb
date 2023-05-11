package kr.or.ddit.basic;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCTest04 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Connection connection = null;
		Statement statement = null;
		PreparedStatement prepareStatement = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "pc09", "java");

			System.out.println("계좌번호 정보 추가하기");
			System.out.print("계좌번호 >> ");
			String bankNo = scanner.nextLine();
			System.out.print("은행이름 >> ");
			String bankName = scanner.nextLine();
			System.out.print("예금주명 >> ");
			String bankUserName = scanner.nextLine();

			String sql = "INSERT INTO BANKINFO VALUES (?, ?, ?, SYSDATE)";
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, bankNo);
			prepareStatement.setString(2, bankName);
			prepareStatement.setString(3, bankUserName);

			int count = prepareStatement.executeUpdate();
			System.out.println("반환값: " + count);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
