package chapter13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCProgramming {

	public static void main(String[] args) throws Exception {
//		1. 오라클 드라이버 로딩(등록)
		Class.forName("oracle.jdbc.driver.OracleDriver");
//		2. DB 정보(ip, oracle service id, id, password)를 이용해 접속
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "pc09", "java");
//		3. 접속된 DB에 쿼리를 전송할 워크시트 생성
		Statement statement = connection.createStatement();
//		4. 쿼리 작성하기
		String sql = "SELECT MEM_ID, MEM_NAME, MEM_HP, MEM_MAIL FROM MEMBER";
//		5. 작성된 쿼리를 디비 서버에 전송
		ResultSet resultSet = statement.executeQuery(sql); // executeQuery는 select문, executeUpdate()가 insert, update,
															// delete문을 받음.
//		6. 전송된 결과를 받아서 처리
		while (resultSet.next()) {
			String memId = resultSet.getString("MEM_ID");
			String memName = resultSet.getString("MEM_NAME");
			String memHP = resultSet.getString("MEM_HP");
			String memMail = resultSet.getString("MEM_MAIL");
			System.out.printf("%s\t%s\t%s\t%s", memId, memName, memHP, memMail).println();
		}
//		7. 접속 종료
		resultSet.close();
		statement.close();
		connection.close();
	}

}
