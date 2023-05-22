package kr.or.ddit.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.vo.JdbcBoardVO;
import kr.or.ddit.util.DBUtil3;
import kr.or.ddit.util.MyBatisSQLSessionFactory;

public class JdbcBoardDaoImpl implements IJdbcBoardDao {
	private static JdbcBoardDaoImpl dao;
	private SqlSession session;

	private JdbcBoardDaoImpl() {
		
	}

	public static JdbcBoardDaoImpl getInstance() {
		if (dao == null)
			dao = new JdbcBoardDaoImpl();
		return dao;
	}

	@Override
	public int insertBoard(JdbcBoardVO boardVo) {
		try {
			session = MyBatisSQLSessionFactory.getSqlSession();
			int count = 0;
			count = session.insert("board.insert", boardVo);
			if (count > 0) {
				session.commit();
			}
			return count;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public int deleteBoard(int boardNo) {
		try {
			session = MyBatisSQLSessionFactory.getSqlSession();
			int count = 0;
			count = session.delete("board.delete", boardNo);
			if (count > 0) {
				session.commit();
			}
			return count;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public int updateBoard(JdbcBoardVO boardVo) {
		try {
			session = MyBatisSQLSessionFactory.getSqlSession();
			int count = 0;
			count = session.update("board.update", boardVo);
			if (count > 0) {
				session.commit();
			}
			return count;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public JdbcBoardVO getBoard(int boardNo) {
		JdbcBoardVO vo = null;
		try {
			session = MyBatisSQLSessionFactory.getSqlSession();
			vo = session.selectOne("board.getBoard", boardNo);
			return vo;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public List<JdbcBoardVO> getAllBoard() {
		List<JdbcBoardVO> list;
		try {
			session = MyBatisSQLSessionFactory.getSqlSession();
			list = session.selectList("board.getAllBoard");
			return list;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public List<JdbcBoardVO> getSerchBoard(String title) {
		List<JdbcBoardVO> list;
		try {
			session = MyBatisSQLSessionFactory.getSqlSession();
			list = session.selectList("board.getSearchBoard");
			return list;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public int setCountIncrement(int boardNo) {
		try {
			session = MyBatisSQLSessionFactory.getSqlSession();
			int count = 0;
			count = session.update("board.setCountIncrement", boardNo);
			if (count > 0) {
				session.commit();
			}
			return count;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}