package kr.or.ddit.event.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.community.vo.PageVO;
import kr.or.ddit.event.vo.EventVO;

public interface IEventService {
	//페이지별 리스트 가져오기
	public List<EventVO> listPerPage(Map<String, Object> map);
		
	//페이지 정보 얻기 - 시작번호, 끝번호, 시작페이지번호, 끝페이지번호, 총페이지 갯수
	public PageVO pageInfo(int page, String stype, String sword);
		
	//전체 글 갯수 구하기
	public int totalCount(Map<String, Object> map);
	
	// emt_no를 통하여 게시글 검색
	public EventVO selectNo(int num);
	
	//글쓰기 - 저장
	public int insertEvent(EventVO vo);
	
	//글 수정하기
	public int updateEvent(EventVO Vo);
	
	//글 삭제하기
	public int deleteEvent(int num);
}
