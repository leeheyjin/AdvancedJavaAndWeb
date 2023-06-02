package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.dao.IMemberDAO;
import kr.or.ddit.member.dao.MemberDAO;
import kr.or.ddit.member.vo.AddressVO;
import kr.or.ddit.member.vo.MemberVO;

public class MemberService implements IMemberService {
	private IMemberDAO dao;
	private static MemberService service;
	
	private MemberService() {
		dao = MemberDAO.getInstance();
	}

	public static IMemberService getInstance() {
		if (service == null) {
			service = new MemberService();
		}
		return service;
	}
	
	@Override
	public String isExists(String mem_id) {
		return dao.isExists(mem_id);
	}

	@Override
	public int insertMember(MemberVO vo) {
		return dao.insertMember(vo);
	}

	@Override
	public List<AddressVO> searchAddress(String zip) {
		return dao.searchAddress(zip);
	}

}
