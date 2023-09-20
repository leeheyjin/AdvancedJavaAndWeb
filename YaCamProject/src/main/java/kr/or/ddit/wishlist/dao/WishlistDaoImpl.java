package kr.or.ddit.wishlist.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.basic.util.MyBatisSqlSessionFactory;
import kr.or.ddit.wishlist.vo.WishlistVo;

public class WishlistDaoImpl implements IWishlistDao {
//	public static void main(String[] args) {
//		WishlistDaoImpl impl = new WishlistDaoImpl();
//		WishlistVo vo= new WishlistVo();
//		vo.setMem_id("a001");
//		vo.setWis_status(1);
//		vo.setCamp_no("A001");
//		System.out.println(impl.deleteWishlist(vo));
//	}
		
	private static IWishlistDao dao;
	
	private WishlistDaoImpl() {}
	
	public static IWishlistDao getInstance() {
		if(dao == null) dao = new WishlistDaoImpl();
		return dao;
	}
	
	@Override
	public int insertWishlist(WishlistVo vo) {
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		int set = 0;
		
		try {
			System.out.println("인설트" + vo.getMem_id() + vo.getCamp_no() + vo.getWis_status());
			set = session.insert("wishlist.insertWishlist",vo);
			System.out.println("인설트결과"+vo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		
		return set;
	}

	@Override
	public int deleteWishlist(WishlistVo vo) {
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		int set = 0;
		try {
			System.out.println("딜리트"+vo.getCamp_no());
			System.out.println("딜리트"+vo.getMem_id());
			System.out.println("딜리트"+vo.getWis_status());
			set = session.delete("wishlist.deleteWishlist",vo);
			System.out.println("딜리트결과"+set);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		
		return set;
	}

	@Override
	public List<WishlistVo> Wishlist(String id) {
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		List<WishlistVo> list = null;
		
		try {
			list = session.selectList("wishlist.Wishlist",id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		
		return list;
	}

}
