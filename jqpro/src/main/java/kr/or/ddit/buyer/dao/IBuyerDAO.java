package kr.or.ddit.buyer.dao;

import java.util.List;

import kr.or.ddit.buyer.vo.BuyerVO;

public interface IBuyerDAO {
	public List<BuyerVO> selectIdName();

	public BuyerVO selectOne(String buyer_id);
}
