package kr.or.ddit.answerboard.service;

import java.util.List;

import kr.or.ddit.answerboard.vo.AnswerVO;

public interface IAnswerService {
	
	//댓글 쓰기 - 저장
	public int insertAnswer(AnswerVO vo);
	
	//댓글 리스트
	public List<AnswerVO> listAnswer(int queNo);
	
	//댓글 삭제
	public int deleteAnswer(int ansNo);
	
	//댓글 수정
	public int updateAnswer(AnswerVO vo);
}
