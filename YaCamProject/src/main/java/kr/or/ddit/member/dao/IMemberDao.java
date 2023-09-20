package kr.or.ddit.member.dao;


import java.util.List;
import java.util.Map;

import kr.or.ddit.member.vo.ChartVO;
import kr.or.ddit.member.vo.MemberVO;


public interface IMemberDao {
	
	//회원가입
	public int insertMember(MemberVO vo);
	
	//로그인
	public MemberVO selectmemberlogin(MemberVO vo);
	
	//아이디 중복체크
	public int selectMemid(String memId);
	
	//아이디찾기
	public int idFind(Map<String, Object> map);
	
	public String idFindMail(Map<String, Object> map);
	
	public String idFindMailPw(Map<String, Object> map);
	//유저정보
	public MemberVO selectUserInfo(String memId);
	
	//유저업데이트
	public int updateMember(MemberVO vo);
	
	//유저삭제
	public int deleteUserinfo(String memId);
	
	//관리자 회원목록
	public List<MemberVO> memberList();
	
	//회원 나이별 통계
	public List<ChartVO> chartAge();
	
	//회원 성별 통계
	public List<ChartVO> chartGender();
	
	//회원별 신고횟수 카운트
	public int countReport(String memId);
}
