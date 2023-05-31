package kr.or.ddit.buyer.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.buyer.vo.BuyerVO;
import kr.or.ddit.mybatis.config.MyBatisSqlSessionFactory;

public class BuyerDAO implements IBuyerDAO {
	private static IBuyerDAO dao;
	private SqlSession session;

	private BuyerDAO() {
		
	}

	public static IBuyerDAO getInstance() {
		if (dao == null) {
			dao = new BuyerDAO();
		}
		return dao;
	}

	@Override
	public List<BuyerVO> selectIdName() {
		session = MyBatisSqlSessionFactory.getSqlSession();
		List<BuyerVO> list = null;
		try {
			list = session.selectList("buyer.selectIdName");
		} finally {
			session.commit();
			session.close();
		}
		return list;
	}

	@Override
	public BuyerVO selectOne(String buyer_id) {
		session = MyBatisSqlSessionFactory.getSqlSession();
		BuyerVO buyer = null;
		try {
			buyer = session.selectOne("buyer.selectOne", buyer_id);
		} finally {
			session.commit();
			session.close();
		}
		return buyer;
	}

}
