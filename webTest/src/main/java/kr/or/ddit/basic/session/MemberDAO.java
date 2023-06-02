package kr.or.ddit.basic.session;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.basic.vo.MemberVO;
import kr.or.ddit.mybatis.config.MyBatisSqlSessionFactory;

public class MemberDAO {
	private static MemberDAO dao;

	private MemberDAO() {
	}

	public static MemberDAO getInstance() {
		if (dao == null) {
			dao = new MemberDAO();
		}
		return dao;
	}

	public MemberVO getLoginMember(MemberVO vo) {
		MemberVO loginMember = null;
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		try {
			loginMember = session.selectOne("member.getLoginMember", vo);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return loginMember;
	}

}
