package kr.or.ddit.prod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mybatis.config.MyBatisSqlSessionFactory;
import kr.or.ddit.prod.vo.ProdVO;

public class ProdDAO implements IProdDAO {
	private static IProdDAO dao;

	private ProdDAO() {

	}

	public static IProdDAO getInstance() {
		if (dao == null) {
			dao = new ProdDAO();
		}
		return dao;
	}

	@Override
	public List<ProdVO> selectIdName(String prod_lgu) {
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		List<ProdVO> list = null;
		try {
			list = session.selectList("prod.selectIdName", prod_lgu);
		} finally {
			session.commit();
			session.close();
		}
		return list;
	}

	@Override
	public ProdVO selectOne(String prod_id) {
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		ProdVO vo = null;
		try {
			vo = session.selectOne("prod.selectOne", prod_id);
		} finally {
			session.commit();
			session.close();
		}
		return vo;
	}

}
