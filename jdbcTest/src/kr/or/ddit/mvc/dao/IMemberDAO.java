package kr.or.ddit.mvc.dao;

import java.util.List;

import kr.or.ddit.mvc.vo.MemberVO;

/**
 * 실제 DB와 연결해서 SQL문을 수행하여 결과를 Service에 전달하는 DAO의 interface 메서드 하나가 DB와 관련된 작업1개를
 * 수행하도록 작성한다
 * 
 * @author leehyejin
 *
 */
public interface IMemberDAO {
	/**
	 * MemberVO객체에 담긴 자료를 DB에 insert하는 메서드
	 * 
	 * @param memVO DB에 insert할 자료가 저장된 MemberVO객체
	 * @return 작업 성공: 1, 작업 실패: 0
	 */
	public int insertMember(MemberVO memVO);

	/**
	 * 회원 아이디를 매개변수로 받아서 해당하는 회원의 정보를 삭제하는 메서드
	 * 
	 * @param mem_id 삭제할 회원의 아이디
	 * @return 작업 성공: 1, 작업 실패: 0
	 */
	public int deleteMember(String mem_id);

	/**
	 * MemberVO객체에 저장된 자료를 이용하여 DB에 update하는 메서드
	 * 
	 * @param memVO update할 회원 정보가 저장된 MemberVO객체
	 * @return 작업 성공: 1, 작업 실패: 0
	 */
	public int updateMember(MemberVO memVO);

	/**
	 * DB의 전체 회원 정보를 가져와서 List에 담아 반환하는 메서드
	 * 
	 * @return MemberVO객체가 저장된 List객체
	 */
	public List<MemberVO> getAllMember();

	/**
	 * 회원 아이디를 매개변수로 받아서 해당 회원 아이디의 개수를 반환하는 메서드
	 * 
	 * @param mem_id 검색할 회원 아이디
	 * @return 검색된 회원 아이디의 개수
	 */
	public int getMemberCount(String mem_id);

}
