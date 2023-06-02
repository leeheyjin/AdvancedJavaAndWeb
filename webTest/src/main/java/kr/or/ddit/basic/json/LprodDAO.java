package kr.or.ddit.basic.json;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.basic.vo.LprodVO;
import kr.or.ddit.mybatis.config.MyBatisSqlSessionFactory;

public class LprodDAO implements ILprodDAO {
	private static ILprodDAO dao;

	private LprodDAO() {
		
	}
	
	public static ILprodDAO getInstance() {
		if (dao == null) {
			dao = new LprodDAO();
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
			if (session != null) {				
				session.close();
			}
		}
		return list;
	}

}
