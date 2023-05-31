package kr.or.ddit.lprod.service;

import java.util.List;

import kr.or.ddit.lprod.dao.ILprodDAO;
import kr.or.ddit.lprod.dao.LprodDao;
import kr.or.ddit.lprod.vo.LprodVO;

public class LprodService implements ILprodService {
	private ILprodDAO dao;
	private static ILprodService service;

	private LprodService() {
		dao = LprodDao.getInstance();
	}

	public static ILprodService getInstance() {
		if (service == null) {
			service = new LprodService();
		}
		return service;
	}

	@Override
	public List<LprodVO> selectAll() {
		return dao.selectAll();
	}

}
