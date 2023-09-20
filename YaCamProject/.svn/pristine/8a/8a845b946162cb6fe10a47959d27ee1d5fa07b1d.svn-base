package kr.or.ddit.community.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.basic.util.MyBatisSqlSessionFactory;
import kr.or.ddit.community.vo.CommunityVO;
import kr.or.ddit.community.vo.MentVO;
import kr.or.ddit.community.vo.PageVO;

public class CommunityDaoImpl implements ICommunityDao {
	
	private static ICommunityDao dao;
	
	public static ICommunityDao getInstance() {
		if(dao==null) dao = new CommunityDaoImpl();
		return dao;
	}
	
	@Override
	public List<CommunityVO> listPerPage(Map<String, Object> map) {
		// 1. 리턴 변수 선언
		List<CommunityVO> list = null;
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();

		// 2. list = mapper실행
		try {
			list = sqlSession.selectList("Community.listPerPage", map);
		} finally {
			sqlSession.commit();
			sqlSession.close();
		}
		// 3. 결과 리턴
		return list;
	}

	@Override
	public PageVO pageInfo(int page, String stype, String sword) {
		// 전체 글 갯수 구하기
	    Map<String, Object> map = new HashMap<>();
	    map.put("type", stype);
	    map.put("sword", sword);
	    
	    int count = this.totalCount(map);

	    // 전체페이지 수 구하기
	    int totalPage = (int) Math.ceil((double) count / 5);  // Updated value: 5

	    // start, end
	    int start = (page - 1) * 5 + 1;  // Updated value: 5
	    int end = start + 5 - 1;  // Updated value: 5
	    if (end > count) end = count;

	    // startPage, endPage
	    int perPage = PageVO.getPerPage();
	    int startPage = ((page - 1) / perPage * perPage) + 1;
	    int endPage = startPage + perPage - 1;
	    if (endPage > totalPage) endPage = totalPage;

	    System.out.println("start = " + start);
	    System.out.println("end = " + end);
	    System.out.println("startPage = " + startPage);
	    System.out.println("endPage = " + endPage);
	    System.out.println("totalPage = " + totalPage);

	    PageVO pvo = new PageVO();

	    pvo.setStart(start);
	    pvo.setEnd(end);
	    pvo.setStartPage(startPage);
	    pvo.setEndPage(endPage);
	    pvo.setTotalPage(totalPage);

	    return pvo;
	}

	@Override
	public int totalCount(Map<String, Object> map) {
		// 1. 리턴 변수 선언
		int count = 0;
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
		// 2. list = mapper실행
		try {
			count = sqlSession.selectOne("Community.totalCount", map);
		} finally {
			sqlSession.commit();
			sqlSession.close();
		}
		// 3. 결과 리턴
		return count;
	}

	@Override
	public CommunityVO selectNo(int num) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
		CommunityVO vo = null;
		
		try {
			vo = sqlSession.selectOne("Community.selectNo", num);
		} finally {
			sqlSession.commit();
			sqlSession.close();
		}
		return vo;
	}

	@Override
	public int insertBoard(CommunityVO vo) {
		int res = 0;
		SqlSession sql = MyBatisSqlSessionFactory.getSqlSession();
		
		//res = mapper 수행
		try {
//			vo.setComm_date(new java.util.Date()); // 현재 날짜 및 시간 설정
			res = sql.insert("Community.insertCommunity", vo);
		} finally {
			sql.commit();
			sql.close();
		}
		
		return res;
	}

	@Override
	public int deleteBoard(int num) {
		int res = 0;
		SqlSession sql = MyBatisSqlSessionFactory.getSqlSession();
		try {
			res = sql.delete("Community.deleteCommunity", num);
		} finally {
			sql.commit();
			sql.close();
		}
		return res;
	}

	@Override
	public int updateCommunity(CommunityVO vo) {
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();  // MyBatis 처리용 객체 생성
		
		int cnt = 0;
		
		try {
			cnt = session.update("Community.updateCommunity", vo);
			System.out.println(cnt);
			if(cnt > 0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			if(session!=null) session.close();
		}	
		
		return cnt;
	}

	@Override
	public int updateHit(int num) {
		int res = 0;
		SqlSession sql = MyBatisSqlSessionFactory.getSqlSession();
		try {
			res = sql.update("Community.updateHit", num);
		} finally {
			sql.commit();
			sql.close();
		}
		return res;
	}

	@Override
	public int insertReply(MentVO vo) {
		int res = 0;
		SqlSession sql = MyBatisSqlSessionFactory.getSqlSession();
		
		//res = mapper 수행
		try {
			res = sql.insert("Ment.insertMent", vo);
		} finally {
			sql.commit();
			sql.close();
		}
		
		return res;
	}

	@Override
	public List<MentVO> listReply(int commNo) {
		List<MentVO> list = null;
		SqlSession sql = MyBatisSqlSessionFactory.getSqlSession();
		try {
			list = sql.selectList("Ment.listMent", commNo);
		} finally {
			sql.commit();
			sql.close();
		}
		return list;
	}

	@Override
	public int deleteReply(int mtNo) {
		int res = 0;
		SqlSession sql = MyBatisSqlSessionFactory.getSqlSession();
		try {
			res = sql.delete("Ment.deleteMent", mtNo);
		} finally {
			sql.commit();
			sql.close();
		}
		return res;
	}

	@Override
	public int updateReply(MentVO vo) {
		int res = 0;
		SqlSession sql = MyBatisSqlSessionFactory.getSqlSession();
		try {
			res = sql.update("Ment.updateMent", vo);
		} finally {
			sql.commit();
			sql.close();
		}
		return res;
	}

	@Override
	public List<CommunityVO> listSelectBoard(String type) {
		List<CommunityVO> list = null;
		SqlSession sql = MyBatisSqlSessionFactory.getSqlSession();
		try {
			list = sql.selectList("Community.listSelectBoard" ,type);
		} finally {
			sql.commit();
			sql.close();
		}
		return list;
	}

}
