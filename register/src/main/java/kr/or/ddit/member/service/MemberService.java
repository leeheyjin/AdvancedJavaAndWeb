package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.dao.IMemberDAO;
import kr.or.ddit.member.dao.MemberDAO;
import kr.or.ddit.member.vo.MemberVO;

public class MemberService implements IMemberService {
	private IMemberDAO dao;
	private static IMemberService service;

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
	public List<MemberVO> getAllMembers() {
		return dao.getAllMembers();
	}

	@Override
	public MemberVO getOneMember(String mem_id) {
		return dao.getOneMember(mem_id);
	}

	@Override
	public int insertMember(MemberVO vo) {
		return dao.insertMember(vo);
	}

	@Override
	public int updateMember(String mem_id) {
		return dao.updateMember(mem_id);
	}

	@Override
	public int deleteMember(String mem_id) {
		return dao.deleteMember(mem_id);
	}

}
