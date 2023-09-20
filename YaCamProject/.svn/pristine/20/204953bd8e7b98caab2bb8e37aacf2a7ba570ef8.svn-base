package kr.or.ddit.community.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.community.dao.CommunityDaoImpl;
import kr.or.ddit.community.dao.ICommunityDao;
import kr.or.ddit.community.vo.CommunityVO;
import kr.or.ddit.community.vo.MentVO;
import kr.or.ddit.community.vo.PageVO;

public class CommunityServiceImpl implements ICommunityService {
	private static ICommunityService service;
	private ICommunityDao dao;
	
	private CommunityServiceImpl() {
		dao = CommunityDaoImpl.getInstance();
	}
		public static ICommunityService getInstance() {
		if(service == null) service = new CommunityServiceImpl();
		return service;
	}
	
	@Override
	public List<CommunityVO> listPerPage(Map<String, Object> map) {
		return dao.listPerPage(map);
	}

	@Override
	public PageVO pageInfo(int page, String stype, String sword) {
		return dao.pageInfo(page, stype, sword);
	}

	@Override
	public int totalCount(Map<String, Object> map) {
		return dao.totalCount(map);
	}

	@Override
	public CommunityVO selectNo(int num) {
		return dao.selectNo(num);
	}

	@Override
	public int insertBoard(CommunityVO vo) {
		return dao.insertBoard(vo);
	}

	@Override
	public int deleteBoard(int num) {
		return dao.deleteBoard(num);
	}

	@Override
	public int updateCommunity(CommunityVO Vo) {
		return dao.updateCommunity(Vo);
	}

	@Override
	public int updateHit(int num) {
		return dao.updateHit(num);
	}

	@Override
	public int insertReply(MentVO vo) {
		return dao.insertReply(vo);
	}

	@Override
	public List<MentVO> listReply(int commNo) {
		return dao.listReply(commNo);
	}
	@Override
	public int deleteReply(int mtNo) {
		return dao.deleteReply(mtNo);
	}
	@Override
	public int updateReply(MentVO vo) {
		return dao.updateReply(vo);
	}
	@Override
	public List<CommunityVO> listSelectBoard(String type) {
		return dao.listSelectBoard(type);
	}

}
