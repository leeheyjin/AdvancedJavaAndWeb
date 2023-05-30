package kr.or.ddit.buyer.service;

import java.util.List;

import kr.or.ddit.buyer.dao.BuyerDAO;
import kr.or.ddit.buyer.vo.BuyerVO;

public class BuyerService implements IBuyerService {
	private BuyerDAO dao;
	private static BuyerService service;

	private BuyerService() {
		dao = BuyerDAO.getInstance();
	}

	public static BuyerService getInstance() {
		if (service == null) {
			service = new BuyerService();
		}
		return service;
	}

	@Override
	public List<BuyerVO> selectIdName() {
		return dao.selectIdName();
	}

	@Override
	public BuyerVO selectOne(String buyerId) {
		return dao.selectOne(buyerId);
	}

}
