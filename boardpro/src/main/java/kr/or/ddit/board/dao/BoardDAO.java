package kr.or.ddit.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.PageVO;
import kr.or.ddit.mybatis.config.MyBatisSqlSessionFactory;

public class BoardDAO implements IBoardDAO {
	private static IBoardDAO dao;

	private BoardDAO() {
	}

	public static IBoardDAO getInstance() {
		if (dao == null) {
			dao = new BoardDAO();
		}
		return dao;
	}

	@Override
	public List<BoardVO> listPerPage(Map<String, Object> map) {
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		List<BoardVO> list = null;
		try {
			list = session.selectList("board.listPerPage", map);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	@Override
	public int totalCount(Map<String, Object> map) {
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		int count = 0;
		try {
			count = session.selectOne("board.totalCount", map);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return count;
	}

	@Override
	public int writePost(BoardVO vo) {
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		int count = 0;
		try {
			count = session.insert("board.writePost", vo);
		} finally {
			session.commit();
			if (session != null) {
				session.close();
			}
		}
		return count;
	}

}
