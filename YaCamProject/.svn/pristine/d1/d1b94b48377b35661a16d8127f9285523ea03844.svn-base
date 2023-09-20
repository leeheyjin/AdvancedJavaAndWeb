package kr.or.ddit.member.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.vo.ChartVO;
import kr.or.ddit.member.vo.MemberVO;

public class MemberServiceImpl implements IMemberService {
	private static IMemberService service;
	private IMemberDao dao;
	
	private MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
	}
	
	public static IMemberService getInstance() {
		if(service == null) service = new MemberServiceImpl();
		return service;
	}

	@Override
	public int insertMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return dao.insertMember(vo);
	}

	@Override
	public MemberVO selectmemberlogin(MemberVO vo) {
		// TODO Auto-generated method stub
		return dao.selectmemberlogin(vo);
	}

	@Override
	public int selectMemid(String memId) {
		// TODO Auto-generated method stub
		return dao.selectMemid(memId);
	}

	@Override
	public int idFind(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.idFind(map);
	}

	@Override
	public MemberVO selectUserInfo(String memId) {
		// TODO Auto-generated method stub
		return dao.selectUserInfo(memId);
	}

	@Override
	public String idFindMail(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.idFindMail(map);
	}

	@Override
	public String idFindMailPw(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.idFindMailPw(map);
	}

	@Override
	public int updateMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return dao.updateMember(vo);
	}

	@Override
	public int deleteUserinfo(String memId) {
		// TODO Auto-generated method stub
		return dao.deleteUserinfo(memId);
	}

	@Override
	public List<MemberVO> memberList() {
		// TODO Auto-generated method stub
		return dao.memberList();
	}

	@Override
	public List<ChartVO> chartAge() {
		// TODO Auto-generated method stub
		return dao.chartAge();
	}

	@Override
	public List<ChartVO> chartGender() {
		// TODO Auto-generated method stub
		return dao.chartGender();
	}

	@Override
	public int countReport(String memId) {
		// TODO Auto-generated method stub
		return dao.countReport(memId);
	}

	
}
