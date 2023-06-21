package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.dao.IMemberDAO;
import kr.or.ddit.member.vo.MemberVO;

public interface IMemberService extends IMemberDAO{
	public List<MemberVO> getAllMembers();

	public MemberVO getOneMember(String mem_id);

	public int insertMember(MemberVO vo);
	
	public int updateMember(String mem_id);
	
	public int deleteMember(String mem_id);
}
