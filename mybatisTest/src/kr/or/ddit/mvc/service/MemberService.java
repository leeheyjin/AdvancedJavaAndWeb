package kr.or.ddit.mvc.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.mvc.dao.IMemberDAO;
import kr.or.ddit.mvc.dao.MemberDAO;
import kr.or.ddit.mvc.vo.MemberVO;

public class MemberService implements IMemberService {
	private static MemberService service;
	private IMemberDAO dao;

	private MemberService() {
		dao = MemberDAO.getInstance();
	}

	public static MemberService getInstance() {
		if (service == null) {
			service = new MemberService();
		}
		return service;
	}

	@Override
	public int insertMember(MemberVO memVO) {
		return dao.insertMember(memVO);
	}

	@Override
	public int deleteMember(String mem_id) {
		return dao.deleteMember(mem_id);
	}

	@Override
	public int updateAllInfo(MemberVO memVO) {
		return dao.updateAllInfo(memVO);
	}

	// 쌤답
	@Override
	public int updateMember2(Map<String, String> paraMap) {
		return dao.updateMember2(paraMap);
	}

	@Override
	public List<MemberVO> getAllMember() {
		return dao.getAllMember();
	}

	@Override
	public int getMemberCount(String mem_id) {
		return dao.getMemberCount(mem_id);
	}

}
