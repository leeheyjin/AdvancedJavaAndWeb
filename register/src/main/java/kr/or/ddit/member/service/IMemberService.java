package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.vo.MemberVO;

public interface IMemberService {
	public List<MemberVO> getAllMembers();

	public String getOneMember(String mem_id);

	public int insertMember(MemberVO vo);

}
