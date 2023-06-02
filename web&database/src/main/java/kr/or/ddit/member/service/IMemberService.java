package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.vo.AddressVO;
import kr.or.ddit.member.vo.MemberVO;

public interface IMemberService {
	public String isExists(String mem_id);

	public int insertMember(MemberVO vo);
	
	public List<AddressVO> searchAddress(String zip);

}
