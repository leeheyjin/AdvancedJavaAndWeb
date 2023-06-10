package kr.or.ddit.member.dao;

import java.util.List;

import kr.or.ddit.member.vo.MemberVO;

public interface IMemberDAO {
	public List<MemberVO> getAllMembers();

	public String getOneMember(String mem_id);

	public int insertMember(MemberVO vo);

}
