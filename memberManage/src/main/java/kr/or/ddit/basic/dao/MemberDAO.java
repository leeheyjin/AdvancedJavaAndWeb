package kr.or.ddit.basic.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.basic.vo.MemberVO;
import kr.or.ddit.mybatis.config.MyBatisSqlSessionFactory;
import oracle.net.aso.s;

public class MemberDAO implements IMemberDAO {
	private static IMemberDAO dao;

	private MemberDAO() {
	}

	public static IMemberDAO getInstance() {
		if (dao == null) {
			dao = new MemberDAO();
		}
		return dao;
	}

	@Override
	public List<MemberVO> selectAll() {
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		List<MemberVO> list = null;
		try {
			list = session.selectList("member.selectAll");
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	@Override
	public int exists(String mem_id) {
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		int count = 0;
		try {
			count = session.selectOne("member.exists", mem_id);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return count;
	}

	@Override
	public int insertAll(MemberVO vo) {
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		int count = 0;
		try {
			count = session.insert("member.insertAll", vo);
		} finally {
			session.commit();
			if (session != null) {
				session.close();
			}
		}
		return count;
	}

	@Override
	public int updateAll(String mem_id) {
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		int count = 0;
		try {
			count = session.update("member.updateAll", mem_id);
		} finally {
			session.commit();
			if (session != null) {
				session.close();
			}
		}
		return count;
	}

	@Override
	public int deleteMember(String mem_id) {
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		int count = 0;
		try {
			count = session.delete("member.deleteOne", mem_id);
		} finally {
			session.commit();
			if (session != null) {
				session.close();
			}
		}
		return count;
	}

}
