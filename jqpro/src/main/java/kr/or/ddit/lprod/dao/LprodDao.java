package kr.or.ddit.lprod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.lprod.vo.LprodVO;
import kr.or.ddit.mybatis.config.MyBatisSqlSessionFactory;

public class LprodDao implements ILprodDAO {
	private static ILprodDAO dao;
	
	private LprodDao() {
		
	}
	
	public static ILprodDAO getInstance() {
		if (dao == null) {
			dao = new LprodDao();
		}
		return dao;
	}

	@Override
	public List<LprodVO> selectAll() {
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		List<LprodVO> list = null;
		try {
			list = session.selectList("lprod.selectAll");
		} finally {
			session.commit();
			session.close();
		}
		return list;
	}

}
