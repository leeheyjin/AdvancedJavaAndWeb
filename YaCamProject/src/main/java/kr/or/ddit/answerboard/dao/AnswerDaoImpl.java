package kr.or.ddit.answerboard.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.answerboard.vo.AnswerVO;
import kr.or.ddit.basic.util.MyBatisSqlSessionFactory;
import kr.or.ddit.community.vo.MentVO;

public class AnswerDaoImpl implements IAnswerDao {
	private static IAnswerDao dao;
	
	public static IAnswerDao getInstance() {
		if(dao==null) dao = new AnswerDaoImpl();
		return dao;
	}
	
	@Override
	public int insertAnswer(AnswerVO vo) {
		int res = 0;
		SqlSession sql = MyBatisSqlSessionFactory.getSqlSession();
		
		//res = mapper 수행
		try {
			res = sql.insert("Answer.insertAnswer", vo);
		} finally {
			sql.commit();
			sql.close();
		}
		
		return res;
	}

	@Override
	public List<AnswerVO> listAnswer(int queNo) {
		List<AnswerVO> list = null;
		SqlSession sql = MyBatisSqlSessionFactory.getSqlSession();
		try {
			list = sql.selectList("Answer.listAnswer", queNo);
		} finally {
			sql.commit();
			sql.close();
		}
		return list;
	}

	@Override
	public int deleteAnswer(int ansNo) {
		int res = 0;
		SqlSession sql = MyBatisSqlSessionFactory.getSqlSession();
		try {
			res = sql.delete("Answer.deleteAnswer", ansNo);
		} finally {
			sql.commit();
			sql.close();
		}
		return res;
	}

	@Override
	public int updateAnswer(AnswerVO vo) {
		int res = 0;
		SqlSession sql = MyBatisSqlSessionFactory.getSqlSession();
		try {
			res = sql.update("Answer.updateAnswer", vo);
		} finally {
			sql.commit();
			sql.close();
		}
		return res;
	}

}
