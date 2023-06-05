package kr.or.ddit.member;

import java.util.List;

public interface IMemberDAO {
	public String isExists(String mem_id);
	
	public int insertMember(MemberVO vo);
	
	public List<AddressVO> searchAddress(String zip);

}
