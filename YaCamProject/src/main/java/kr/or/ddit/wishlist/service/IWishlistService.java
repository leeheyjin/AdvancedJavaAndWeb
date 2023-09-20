package kr.or.ddit.wishlist.service;

import java.util.List;

import kr.or.ddit.wishlist.vo.WishlistVo;

public interface IWishlistService {

	public int insertWishlist(WishlistVo vo);
	
	public int deleteWishlist(WishlistVo vo);
	
	public List<WishlistVo> Wishlist(String id);
}
