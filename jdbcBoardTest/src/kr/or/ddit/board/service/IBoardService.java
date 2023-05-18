package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.vo.BoardVO;

public interface IBoardService {
	/**
	 * BoardVO에 담긴 자료를 DB에 insert하는 메서드
	 * 
	 * @param boardVO insert할 자료가 저장된 BoardVO객체
	 * @return 작업 성공: 1, 작업 실패: 0
	 */
	public int insertBoard(BoardVO boardVO);

	/**
	 * 게시글 번호를 매개변수로 받아서 해당 게시글을 삭제하는 메서드
	 * 
	 * @param boardNo 삭제할 게시글 번호
	 * @return 작업 성공: 1, 작업 실패: 0
	 */
	public int deleteBoard(int boardNo);

	/**
	 * 수정할 정보가 저장된 BoardVO객체를 매개변수로 받아서 수정하는 메서드
	 * 
	 * @param boardVO 수정할 정보가 저장된 BoardVO객체
	 * @return 작업 성공: 1, 작업 실패: 0
	 */
	public int updateBoard(BoardVO boardVO);

	/**
	 * 게시글 번호를 매개변수로 받아서 해당 게시글 정보를 가져와 반환하는 메서드
	 * 
	 * @param boardNo 가져올 게시글 번호
	 * @return 해당 게시글 번호에 맞는 데이터가 저장된 BoardVO객체 (단, 검색자료가 없으면 null을 반환한다)
	 */
	public BoardVO getBoard(int boardNo);

	/**
	 * JDBC_BOARD테이블의 전체 레코드를 가져와서 List에 담아서 반환하는 메서드
	 * 
	 * @return BoardVO객체가 저장된 List객체
	 * 
	 */
	public List<BoardVO> getBoardAll();

	/**
	 * 게시글의 제목을 이용해 검색한 결과를 List에 담아서 반환하는 메서드
	 * 
	 * @param title 검색할 게시글 제목
	 * @return 검색된 결과가 저장된 List객체
	 */
	public List<BoardVO> getBoardSearch(String title);

	/**
	 * 게시글 번호를 매개변수로 받아서 해당 게시글의 조회수를 증가시키는 메서드
	 * 
	 * @param boardNo 조회수를 증가할 게시글 번호
	 * @return 작업 성공: 1, 작업 실패: 0
	 */
	public int setCountIncrement(int boardNo);
}
