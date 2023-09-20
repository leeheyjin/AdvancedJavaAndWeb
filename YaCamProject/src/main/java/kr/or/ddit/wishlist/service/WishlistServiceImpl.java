package kr.or.ddit.wishlist.service;

import java.util.List;

import kr.or.ddit.wishlist.dao.IWishlistDao;
import kr.or.ddit.wishlist.dao.WishlistDaoImpl;
import kr.or.ddit.wishlist.vo.WishlistVo;

public class WishlistServiceImpl implements IWishlistService {
	private static IWishlistService service;
	private IWishlistDao dao;
	
	private WishlistServiceImpl() {
		dao = WishlistDaoImpl.getInstance();
	}
	
	public static IWishlistService getInstance() {
		if(service == null) service = new WishlistServiceImpl();
		return service;
	}
	
	@Override
	public int insertWishlist(WishlistVo vo) {
		// TODO Auto-generated method stub
		return dao.insertWishlist(vo);
	}

	@Override
	public int deleteWishlist(WishlistVo vo) {
		// TODO Auto-generated method stub
		return dao.deleteWishlist(vo);
	}

	@Override
	public List<WishlistVo> Wishlist(String id) {
		// TODO Auto-generated method stub
		return dao.Wishlist(id);
	}

}
