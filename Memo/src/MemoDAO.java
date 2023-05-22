import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemoDAO {

	// 전체 select
	public List<MemoVO> getMemos() throws Exception {
		// select * from Memo;
		Class.forName("oracle.jdbc.driver.OracleDriver"); // 이건 메서드에만 해야되낭
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "pc09", "java");
		Statement statement = connection.createStatement();
		String sql = "SELECT * FROM MEMO";
		ResultSet resultSet = statement.executeQuery(sql);

		List<MemoVO> list = new ArrayList<>();
		while (resultSet.next()) {
			int memoId = resultSet.getInt("memo_id");
			String memoTitle = resultSet.getString("memo_title");
			String memoContent = resultSet.getString("memo_content");
			Date memoRegiDate = resultSet.getDate("memo_regi_date");
			Date memoModiDate = resultSet.getDate("memo_modi_date");

			list.add(new MemoVO(memoId, memoTitle, memoContent, memoRegiDate, memoModiDate));
		}
		return list;
	}

	// 하나만 select
	public MemoVO getMemo(int searchId) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver"); // 이건 메서드에만 해야되낭
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "pc09", "java");
		String sql = "SELECT * FROM MEMO WHERE MEMO_ID = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, searchId);
		ResultSet resultSet = preparedStatement.executeQuery();
		MemoVO vo = null;
		if (resultSet.next()) {
			int memoId = resultSet.getInt("memo_id");
			String memoTitle = resultSet.getString("memo_title").concat(resultSet.getString("memo_content"));
			String memoContent = resultSet.getString("memo_content");
			Date memoRegiDate = resultSet.getDate("memo_regi_date");
			Date memoModiDate = resultSet.getDate("memo_modi_date");
			vo = new MemoVO(memoId, memoTitle, memoContent, memoRegiDate, memoModiDate);
		}
		resultSet.close();
		preparedStatement.close();
		connection.close();
		return vo;
	}

	// insert
	public int insertMemo(MemoVO vo) throws Exception {
		// insert into memo (memoId, memoTitle, memoContent) values ("", "", "");
		Class.forName("oracle.jdbc.driver.OracleDriver"); // 이건 메서드에만 해야되낭
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "pc09", "java");
		String sql = "INSERT INTO MEMO (MEMO_ID, MEMO_TITLE, MEMO_CONTENT) VALUES (MEMO_SEQ.nextval, ?, ?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql); // 컬럼명을 일일이 쓰기 어려우므로 ?를 이용해 준비된 문장을 만들어
																				// 놓는다.
		preparedStatement.setString(1, vo.getMemoTitle());
		preparedStatement.setString(2, vo.getMemoContent());
		int count = preparedStatement.executeUpdate();
		preparedStatement.close();
		connection.close();
		return count;
	}

	// update
	public int updateMemo(MemoVO vo) throws Exception {
		// update memo set id where ~~~;
		Class.forName("oracle.jdbc.driver.OracleDriver"); // 이건 메서드에만 해야되낭
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "pc09", "java");
		String sql = "UPDATE MEMO SET MEMO_TITLE = ?, MEMO_CONTENT = ? MEMO_MODI_DATE = SYSDATE WHERE MEMO_ID = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, vo.getMemoTitle());
		preparedStatement.setString(2, vo.getMemoContent());
		preparedStatement.setInt(3, vo.getMemoId());

		int count = preparedStatement.executeUpdate();
		preparedStatement.close();
		connection.close();
		return count;
	}

	// delete
	public int deleteMemo(int deleteId) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver"); // 이건 메서드에만 해야되낭
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "pc09", "java");
		String sql = "DELETE FROM MEMO WHERE MEMO_ID = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, deleteId);

		int count = preparedStatement.executeUpdate();
		preparedStatement.close();
		connection.close();
		return count;
	}

}
