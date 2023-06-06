package kr.or.ddit.basic.dao;

import java.util.List;

import kr.or.ddit.basic.vo.MemberVO;

public interface IMemberDAO {
	public List<MemberVO> selectAll();
	
	public int exists(String mem_id);
	
	public int insertAll(MemberVO vo);
	
	public int updateAll(String mem_id);
	
	public int deleteMember(String mem_id);

}
