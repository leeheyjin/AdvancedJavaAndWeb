package kr.or.ddit.basic;

import java.sql.Statement;
import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * JDBC: Java DataBase Connectivity
 * 
 * JDBC를 이용한 DB자료 처리 과정
 * 1. 드라이버 로딩: 라이브러리를 사용할 수 있게 메모리에 읽어 들이는 과정
 * 	  Class.forName("oracle.jdbc.driver.OracleDriver");: JDBC API버전 4이상에서는 getConncetion()메서드에서 자동으로 로딩해주기 때문에 생략할 수 있다. 그치만 우린 생략하지 않을 것이다. 늘 그랫듯.(;;)
 * 
 * 2. DB에 접속하기: 접속이 완료되면 Connection객체가 반환된다
 * 	  DriverManager.getConnection()메서드를 이용함
 * 
 * 3. 질의: SQL문장을 DB서버로 보내서 결과를 얻어온다.(java.sql.Statement객체(java.bean.Statement 아님 주의) 또는 PreparedStatement객체를 이용해 작업한다)
 * 
 * 4. 결과 처리: 질의 결과를 받아서 원하는 작업을 수행한다
 *    1. SQL문이 select문일 경우 select한 결과가 ResultSet객체에 저장되어 반환한다
 *    2. SQL문이 select문이 아닐 경우(insert, update, delete 등) 처리된 결과가 int값으로 반환된다. 이 int값 보통 실행에 성공한 레코드 수를 말한다. 
 * 
 * 5. 사용한 자원 반납하기: close()메서드 이용
 * 
 */
public class JdbcTest01 {
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			// 1.
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2.
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "pc09", "java");
			
			// 3.
			// 3-1. SQL문 작성
//			String sql = "select * from lprod";
			String sql = "select lprod_id, lprod_gu, lprod_nm as nm from lprod";
			// 3-2. Statement객체 생성: SQL문을 DB에 전달하고 처리한 결과를 얻어오는 객체. Connection객체를 이용해 생성한다
			statement = connection.createStatement();
			// 3-3. SQL문을 DB서버로 보내서 결과를 얻어온다. 지금은 실행할 sql문이 select문이기 떄문에 결과가 ResultSet객체에
			// 저장되어 반환된다
			resultSet = statement.executeQuery(sql);

			// 4.
			System.out.println("=== 쿼리문 처리 결과 ===");
			// resultSet.next():
			while (resultSet.next()) {
				System.out.println("LPROD_ID: " + resultSet.getInt("LPROD_ID"));
				System.out.println("LPROD_GU: " + resultSet.getString(2));
				System.out.println("LPROD_NM: " + resultSet.getString("NM"));
				System.out.println();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5.
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
