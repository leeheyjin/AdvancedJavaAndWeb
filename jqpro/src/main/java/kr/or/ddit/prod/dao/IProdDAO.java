package kr.or.ddit.prod.dao;

import java.util.List;

import kr.or.ddit.prod.vo.ProdVO;

public interface IProdDAO {
	public List<ProdVO> selectIdName(String prod_lgu);

	public ProdVO selectOne(String prod_id);

}
