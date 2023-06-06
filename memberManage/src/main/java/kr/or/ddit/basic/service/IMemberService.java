package kr.or.ddit.basic.service;

import java.util.List;

import kr.or.ddit.basic.vo.MemberVO;

public interface IMemberService {
	public List<MemberVO> selectAll();

	public int insertAll(MemberVO vo);

	public int exists(String mem_id);

	public int updateAll(String mem_id);

	public int deleteMember(String mem_id);

}
