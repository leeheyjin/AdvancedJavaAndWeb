package kr.or.ddit.community.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.community.vo.CommunityVO;
import kr.or.ddit.community.vo.MentVO;
import kr.or.ddit.community.vo.PageVO;

public interface ICommunityDao {
	
	//페이지별 리스트 가져오기
	public List<CommunityVO> listPerPage(Map<String, Object> map);
	
	//페이지 정보 얻기 - 시작번호, 끝번호, 시작페이지번호, 끝페이지번호, 총페이지 갯수
	public PageVO pageInfo(int page, String stype, String sword);
	
	//전체 글 갯수 구하기
	public int totalCount(Map<String, Object> map);
	
	// comm_no를 통하여 게시글 검색
	public CommunityVO selectNo(int num);
	
	//글쓰기 - 저장
	public int insertBoard(CommunityVO vo);
	
	//글 삭제하기
	public int deleteBoard(int num);
	
	//글 수정하기
	public int updateCommunity(CommunityVO Vo);
	
	//조회수 증가하기
	public int updateHit(int num);
	
	//댓글 쓰기 - 저장
	public int insertReply(MentVO vo);
	
	//댓글 리스트
	public List<MentVO> listReply(int commNo);
	
	//댓글 삭제
	public int deleteReply(int mtNo);
	
	//댓글 수정
	public int updateReply(MentVO vo);
	
	//게시판 카테고리별 선택
	public List<CommunityVO> listSelectBoard(String type);
	
	
}
