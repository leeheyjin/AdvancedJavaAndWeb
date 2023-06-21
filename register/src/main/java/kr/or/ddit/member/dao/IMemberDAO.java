package kr.or.ddit.member.dao;

import java.util.List;

import kr.or.ddit.member.vo.MemberVO;

public interface IMemberDAO {
	public List<MemberVO> getAllMembers();

	public MemberVO getOneMember(String mem_id);

	public int insertMember(MemberVO vo);
	
	public int updateMember(String mem_id);
	
	public int deleteMember(String mem_id);
}
