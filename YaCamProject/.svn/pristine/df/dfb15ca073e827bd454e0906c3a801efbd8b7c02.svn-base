package kr.or.ddit.notice.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.community.vo.PageVO;
import kr.or.ddit.notice.vo.NoticeVO;

public interface INoticeService {
	//페이지별 리스트 가져오기
	public List<NoticeVO> listPerPage(Map<String, Object> map);
	
	//페이지 정보 얻기 - 시작번호, 끝번호, 시작페이지번호, 끝페이지번호, 총페이지 갯수
	public PageVO pageInfo(int page, String stype, String sword);
	
	//전체 글 갯수 구하기
	public int totalCount(Map<String, Object> map);
	
	// comm_no를 통하여 게시글 검색
	public NoticeVO selectNo(int num);
	
	//글쓰기 - 저장
	public int insertNotice(NoticeVO vo);
	
	//글 수정하기
	public int updateNotice(NoticeVO Vo);
	
	//글 삭제하기
	public int deleteNotice(int num);
	
	//조회수 증가하기
	public int updateHit(int num);
}
