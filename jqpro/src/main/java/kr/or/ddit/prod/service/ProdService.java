package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.prod.dao.IProdDAO;
import kr.or.ddit.prod.dao.ProdDAO;
import kr.or.ddit.prod.vo.ProdVO;

public class ProdService implements IProdService {
	private IProdDAO dao;
	private static IProdService service;
	
	private ProdService() {
		dao = ProdDAO.getInstance();
	}
	
	public static IProdService getInstance() {
		if (service == null) {
			service = new ProdService();
		}
		return service;
	}

	@Override
	public List<ProdVO> selectIdName(String prod_lgu) {
		return dao.selectIdName(prod_lgu);
	}

	@Override
	public ProdVO selectOne(String prod_id) {
		return dao.selectOne(prod_id);
	}

}
