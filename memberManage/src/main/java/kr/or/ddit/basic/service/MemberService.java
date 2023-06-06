package kr.or.ddit.basic.service;

import java.util.List;

import kr.or.ddit.basic.dao.IMemberDAO;
import kr.or.ddit.basic.dao.MemberDAO;
import kr.or.ddit.basic.vo.MemberVO;

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
	public List<MemberVO> selectAll() {
		return dao.selectAll();
	}

	@Override
	public int insertAll(MemberVO vo) {
		return dao.insertAll(vo);
	}

	@Override
	public int exists(String mem_id) {
		return dao.exists(mem_id);
	}

	@Override
	public int updateAll(String mem_id) {
		return dao.updateAll(mem_id);
	}

	@Override
	public int deleteMember(String mem_id) {
		return dao.deleteMember(mem_id);
	}

}
