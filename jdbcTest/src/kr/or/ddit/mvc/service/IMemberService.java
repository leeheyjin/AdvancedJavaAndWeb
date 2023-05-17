package kr.or.ddit.mvc.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.mvc.vo.MemberVO;

/**
 * Service객체는 DAO에 만들어진 메서드를 원하는 작업에 맞게 호출하여 실행하고 그 결과를 받아와서 Conetroller에 보내주는
 * 역할 보통 메서드의 구조가 DAO와 같다
 * 
 * @author leehyejin
 *
 */
public interface IMemberService {
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
	 * @param memId 삭제할 회원의 아이디
	 * @return 작업 성공: 1, 작업 실패: 0
	 */
	public int deleteMember(String memId);

	/**
	 * MemberVO객체에 저장된 자료를 이용하여 DB에 update하는 메서드
	 * 
	 * @param memVO update할 회원 정보가 저장된 MemberVO객체
	 * @return 작업 성공: 1, 작업 실패: 0
	 */
	public int updateAllInfo(MemberVO memVO);

	/**
	 * MemberVO객체에 저장된 자료 중 일부를 DB에 update하는 메서드
	 * 
	 * @param memId       수정할 회원의 아이디
	 * @param updateField 수정될 테이블의 컬럼
	 * @param updateData  수정될 데이터
	 * @return 작업 성공: 1, 작업 실패: 0
	 */
	public int updateOneInfo(String memId, String updateField, String updateData);

	// 쌤답
	/**
	 * 원하는 항목만 수정할 수 있는 데이터를 Map으로 받아서 수정하는 메서드 
	 * key: memId(회원 아이디), field(수정할 컬럼명),
	 * data(수정할 데이터)
	 * 
	 * @param paraMap 수정할 정보가 저장된 Map객체
	 * @return 작업 성공: 1, 작업 실패: 0
	 */
	public int updateMember2(Map<String, String> paraMap);

	/**
	 * DB의 전체 회원 정보를 가져와서 List에 담아 반환하는 메서드
	 * 
	 * @return MemberVO객체가 저장된 List객체
	 */
	public List<MemberVO> getAllMember();

	/**
	 * 회원 아이디를 매개변수로 받아서 해당 회원 아이디의 개수를 반환하는 메서드
	 * 
	 * @param memId 검색할 회원 아이디
	 * @return 검색된 회원 아이디의 개수
	 */
	public int getMemberCount(String memId);

}
