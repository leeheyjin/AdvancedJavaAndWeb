package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.PageVO;

public interface IBoardService {
	// 글을 리스트로 가져오기
	// 페이지별 리스트 가져오기
	public List<BoardVO> listPerPage(Map<String, Object> map);

	// 전체 글개수
	public int totalCount(Map<String, Object> map);
	//	조회수 증가하기 
	//	글쓰기(저장하기)
	//	글 수정하기 
	//	페이지 정보 얻기 - 시작번호, 끝번호, 시작페이지번호, 끝페이지번호, 홈페이지 개수
	public PageVO pageInfo(int page, String stype, String sword);
	
	//	댓글쓰기 
	//	댓글 수정 
	//	댓글 삭제 
	//	댓글 리스트 
}
