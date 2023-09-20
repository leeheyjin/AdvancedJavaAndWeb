package kr.or.ddit.questionboard.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.community.vo.PageVO;
import kr.or.ddit.questionboard.vo.QuestionVO;

public interface IQuestionDao {
	//페이지별 리스트 가져오기
	public List<QuestionVO> listPerPage(Map<String, Object> map);
	
	//페이지 정보 얻기 - 시작번호, 끝번호, 시작페이지번호, 끝페이지번호, 총페이지 갯수
	public PageVO pageInfo(int page, String stype, String sword);
	
	//전체 글 갯수 구하기
	public int totalCount(Map<String, Object> map);
	
	// comm_no를 통하여 게시글 검색
	public QuestionVO selectNo(int num);
	
	//글쓰기 - 저장
	public int insertQeustion(QuestionVO vo);
	
	//글 삭제하기
	public int deleteQuestion(int num);
	
	//글 수정하기
	public int updateQuestion(QuestionVO Vo);
}
