package kr.or.ddit.event.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.basic.util.MyBatisSqlSessionFactory;
import kr.or.ddit.community.vo.PageVO;
import kr.or.ddit.event.vo.EventVO;
import kr.or.ddit.notice.vo.NoticeVO;

public class EventDaoImpl implements IEventDao {
	private static IEventDao dao;
	
	public static IEventDao getInstanse() {
		if(dao==null) dao = new EventDaoImpl();
		return dao;
	}
	@Override
	public List<EventVO> listPerPage(Map<String, Object> map) {
		// 1. 리턴 변수 선언
		List<EventVO> list = null;
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();

		// 2. list = mapper실행
		try {
			list = sqlSession.selectList("Event.listPerPage", map);
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
			count = sqlSession.selectOne("Event.totalCount", map);
		} finally {
			sqlSession.commit();
			sqlSession.close();
		}
		// 3. 결과 리턴
		return count;
	}
	@Override
	public EventVO selectNo(int num) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
		EventVO vo = null;
		
		try {
			vo = sqlSession.selectOne("Event.selectNo", num);
		} finally {
			sqlSession.commit();
			sqlSession.close();
		}
		return vo;
	}
	@Override
	public int insertEvent(EventVO vo) {
		int res = 0;
		SqlSession sql = MyBatisSqlSessionFactory.getSqlSession();
		
		//res = mapper 수행
		try {
//			vo.setComm_date(new java.util.Date()); // 현재 날짜 및 시간 설정
			res = sql.insert("Event.insertEvent", vo);
		} finally {
			sql.commit();
			sql.close();
		}
		
		return res;
	}
	@Override
	public int updateEvent(EventVO Vo) {
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();  // MyBatis 처리용 객체 생성
		
		int cnt = 0;
		
		try {
			cnt = session.update("Event.updateEvent", Vo);
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
	public int deleteEvent(int num) {
		int res = 0;
		SqlSession sql = MyBatisSqlSessionFactory.getSqlSession();
		try {
			res = sql.delete("Event.deleteEvent", num);
		} finally {
			sql.commit();
			sql.close();
		}
		return res;
	}

}
