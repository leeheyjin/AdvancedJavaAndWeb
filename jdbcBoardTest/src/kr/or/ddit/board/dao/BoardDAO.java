package kr.or.ddit.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.board.util.DBUtil;
import kr.or.ddit.board.vo.BoardVO;

public class BoardDAO implements IBoardDAO {
	private static BoardDAO dao;

	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	private BoardDAO() {

	}

	public static BoardDAO getInstance() {
		if (dao == null) {
			dao = new BoardDAO();
		}
		return dao;
	}

	@Override
	public int insertBoard(BoardVO boardVO) {
		int count = 0;
		try {
			connection = DBUtil.getConnection();
			String sql = "INSERT INTO JDBC_BOARD VALUES (BOARD_SEQ.NEXTVAL, ?, ?, SYSDATE, 0, ?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, boardVO.getBoardTitle());
			preparedStatement.setString(2, boardVO.getBoardWriter());
			preparedStatement.setString(3, boardVO.getBoardContent());

			count = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e2) {
			}
		}
		return count;
	}

	@Override
	public int deleteBoard(int boardNo) {
		int count = 0;
		try {
			connection = DBUtil.getConnection();
			String sql = "DELETE FROM JDBC_BOARD WHERE BOARD_NO = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, boardNo);

			count = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e2) {
			}
		}
		return count;
	}

	@Override
	public int updateBoard(BoardVO boardVO) {
		int count = 0;
		try {
			connection = DBUtil.getConnection();
			String sql = "UPDATE JDBC_BOARD SET BOARD_TITLE = ?, BOARD_CONTENT = ? WHERE BORAD_NO = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, boardVO.getBoardTitle());
			preparedStatement.setString(2, boardVO.getBoardContent());
			preparedStatement.setInt(3, boardVO.getBoardNo());

			count = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e2) {
			}
		}
		return count;
	}

	@Override
	public BoardVO getBoard(int boardNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardVO> getBoardAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardVO> getBoardSearch(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int setCountIncrement(int boardNo) {
		
		return 0;
	}

}
