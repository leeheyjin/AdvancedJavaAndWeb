package kr.or.ddit.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;
import kr.or.ddit.mybatis.config.MyBatisSqlSessionFactory;
import oracle.net.aso.s;

public class BoardDaoImpl implements IBoardDao {

	// 자기 자신의 클래스 객체 선언, 생성, 리턴
	private static BoardDaoImpl dao;

	private BoardDaoImpl() {
	}

	public static BoardDaoImpl getInstance() {
		if (dao == null)
			dao = new BoardDaoImpl();
		return dao;
	}

	@Override
	public List<BoardVO> listPerPage(Map<String, Object> map) {
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		// 1. 리턴 별수 선언
		List<BoardVO> list = null;

		// 2. list mapper 실행
		try {
			list = session.selectList("board.listPerPage", map);
		} finally {
			if (list != null)
				session.close();
		}

		// 3. 결과 리턴
		return list;
	}

	@Override
	public int totalCount(Map<String, Object> map) {
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		// 1. 리턴 변수 선언
		int count = 0;

		// 2.
		try {
			count = session.selectOne("board.totalCount", map);
		} finally {
			if (count > 0)
				session.close();
		}
		// 3. 결과 리턴

		return count;
	}

	@Override
	public int insertBoard(BoardVO vo) {
		int res = 0;
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();

		try {
			res = session.insert("board.insertBoard", vo);

			session.commit();

		} finally {
			if (session != null)
				session.close();
		}
		return res;
	}

	@Override
	public int updateBoard(BoardVO vo) {
		int res = 0;
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();

		try {
			res = session.update("board.updateBoard", vo);
			session.commit();
		} finally {
			if (session != null)
				session.close();
		}
		return res;
	}

	@Override
	public int deleteBoard(int num) {
		int res = 0;
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();

		try {
			res = session.update("board.deleteBoard", num);
			session.commit();
		} finally {
			if (session != null)
				session.close();
		}
		return res;
	}

	@Override
	public int updateHit(int num) {
		int res = 0;
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();

		try {
			res = session.update("board.updateHit", num);
			session.commit();
		} finally {
			if (session != null)
				session.close();
		}
		return res;
	}

	@Override
	public int insertReply(ReplyVO vo) {
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		int count = 0;
		try {
			count = session.insert("reply.insertReply", vo);
		} finally {
			session.commit();
			if (session != null) {
				session.close();
			}
		}
		return count;
	}

	@Override
	public int updateReply(ReplyVO vo) {
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		int count = 0;
		try {
			count = session.update("reply.updateReply", vo);
		} finally {
			session.commit();
			if (session != null) {
				session.close();
			}
		}
		return count;
	}

	@Override
	public int deleteReply(int renum) {
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		int count = 0;
		try {
			count = session.delete("reply.deleteReply", renum);
		} finally {
			session.commit();
			if (session != null) {
				session.close();
			}
		}
		return count;
	}

	@Override
	public List<ReplyVO> listReply(int bonum) {
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		List<ReplyVO> list = null;
		try {
			list = session.selectList("reply.listReply", bonum);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

}
