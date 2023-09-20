package kr.or.ddit.member.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.basic.util.MyBatisSqlSessionFactory;
import kr.or.ddit.member.vo.ChartVO;
import kr.or.ddit.member.vo.MemberVO;

public class MemberDaoImpl implements IMemberDao {
	public static void main(String[] args) {
		MemberDaoImpl impl = new MemberDaoImpl();
//		MemberVO vo = new MemberVO();
//		vo.setMem_id("ksj2");
//		vo.setMem_pass("123");
//		vo.setMem_name("김승종");
//		vo.setMem_mail("ksj@ddit.co.kr");
//		vo.setMem_gender("m");
//		vo.setMem_birth("1993,01,01");
//		vo.setMem_tel("00-1111-1111");
//		vo.setMem_addr("대덕");
//		vo.setMem_grade("관리자");
		
//		System.out.println(impl.insertMember(vo));
//		System.out.println(impl.selectmemberlogin(vo));
//		System.out.println(impl.selectMemid("lmw"));
//		System.out.println(impl.selectUserInfo("asd"));
//		System.out.println(impl.memberList());
		System.out.println(impl.chartAge());
		System.out.println(impl.chartGender());
	}
	
	private static IMemberDao dao;
	
	private MemberDaoImpl() {}
	
	public static IMemberDao getInstance() {
		if(dao == null) dao = new MemberDaoImpl();
		return dao;
	}

	@Override
	public int insertMember(MemberVO vo) {
		int cnt = 0;
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		try {
			cnt = session.insert("member.insertMember",vo);
			if (cnt>0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) session.close();
		}
		return cnt;
	}

	@Override
	public MemberVO selectmemberlogin(MemberVO loginIdPass) {
		MemberVO vo = null;
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		try {
			vo = session.selectOne("member.selectmemberlogin",loginIdPass);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) session.close();
		}
		return vo;
	}

	@Override
	public int selectMemid(String memId) {
		int cnt = 0;
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		try {
			cnt = session.selectOne("member.selectMemid",memId);
			if (cnt>0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) session.close();
		}
		return cnt;
	}
	
	@Override
	public int idFind(Map<String, Object> map) {
		int cnt = 0;
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		System.out.println("ifFind"+map);
		try {
			cnt = session.selectOne("member.idfind",map);
			if (cnt>0) {
				session.commit();
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) session.close();
		}
		return cnt;
	}

	@Override
	public MemberVO selectUserInfo(String memId) {
		MemberVO vo = null;
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		try {
			vo = session.selectOne("member.selectUserInfo",memId);
			if (vo!=null) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) session.close();
		}
		return vo;
	}

	@Override
	public String idFindMail(Map<String, Object> map) {
		String id = "";
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		System.out.println("DAO 아이디 메일"+map);
		try {
			id = session.selectOne("member.idfindmail",map);
			if (id!=null) {
				session.commit();
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) session.close();
		}
		return id;
	
	}
	
	@Override
	public String idFindMailPw(Map<String, Object> map) {
		String pw ="";
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		System.out.println("DAO 비밀번호 메일"+map);
		System.out.println("DAO 비밀번호 pw"+pw);
		try {
			pw = session.selectOne("member.idfindmailpw",map);
			if (pw!=null) {
				session.commit();
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) session.close();
		}
		return pw;
	
	}

	@Override
	public int updateMember(MemberVO vo) {
		int cnt = 0;
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		try {
			cnt = session.update("member.updateMember",vo);
			if (cnt>0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) session.close();
		}
		return cnt;
	}

	@Override
	public int deleteUserinfo(String memId) {
		int cnt = 0;
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		try {
			cnt = session.update("member.deleteUserinfo",memId);
			if (cnt>0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) session.close();
		}
		return cnt;
	}

	@Override
	public List<MemberVO> memberList() {
		List<MemberVO> list = null;
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		try {
			list = session.selectList("member.memberList");
			if (list!=null) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) session.close();
		}
		return list;
	}
	
	//차트
	@Override
	public List<ChartVO> chartAge() {
		List<ChartVO> list = null;
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		try {
			list = session.selectList("chartVO.chartAge");
			if (list!=null) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) session.close();
		}
		return list;
	}

	@Override
	public List<ChartVO> chartGender() {
		List<ChartVO> list = null;
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		try {
			list = session.selectList("chartVO.chartGender");
			if (list!=null) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) session.close();
		}
		return list;
	}

	@Override
	public int countReport(String memId) {
	    int res = 0;
	    SqlSession sql = MyBatisSqlSessionFactory.getSqlSession();
	    try {
	        res = sql.update("member.countReport", memId);
	    } finally {
	        sql.commit();
	        sql.close();
	    }
	    return res;
	}
	
	
}
