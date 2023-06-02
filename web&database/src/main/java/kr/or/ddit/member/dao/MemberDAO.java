package kr.or.ddit.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.member.vo.AddressVO;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.mybatis.config.MyBatisSqlSessionFactory;

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
	public String isExists(String mem_id) {
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		String selectId = null;
		try {
			selectId = session.selectOne("member.isExists", mem_id);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return selectId;
	}

	@Override
	public int insertMember(MemberVO vo) {
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		MemberVO insertVo = null;
		int count = 0;
		try {
			count = session.insert("member.insertMember", insertVo);
		} finally {
			session.commit();
			if (session != null) {
				session.close();
			}
		}
		return count;
	}

	@Override
	public List<AddressVO> searchAddress(String zip) {
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		List<AddressVO> list = null;
		try {
			list = session.selectList("member.searchZip", zip);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

}
