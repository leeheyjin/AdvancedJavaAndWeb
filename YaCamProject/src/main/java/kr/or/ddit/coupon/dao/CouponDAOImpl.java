package kr.or.ddit.coupon.dao;

import java.util.List;


import org.apache.ibatis.session.SqlSession;
import kr.or.ddit.basic.util.MyBatisSqlSessionFactory;
import kr.or.ddit.coupon.vo.CouponVO;

public class CouponDAOImpl implements ICouponDAO {
	
	
// 오류확인
//	public static void main(String[] args) {
//		CouponDAOImpl impl = new CouponDAOImpl();
//		
//		CouponVO vo = new CouponVO();
//		
//		vo.setCup_no("asd44");
//		vo.setMem_id("lmw");
//		vo.setCup_name("신규가입");
//		vo.setCup_type("이게머임");
//		vo.setCup_status("Y");
//		
//		System.out.println(impl.createCoupon(vo));
//		
//		System.out.println(impl.selectCoupon("lmw"));
//	}
//	
	private static ICouponDAO dao;
	
	private CouponDAOImpl() {
	}
	
	public static ICouponDAO getInstance() {
		return dao=new CouponDAOImpl();
	}
	
	
	
	@Override
	public int createCoupon(CouponVO vo) {
		int count = 0;
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		
		try {
			count = session.insert("coupon.createCoupon", vo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		
		return count;
	}


	@Override
	public List<CouponVO> selectCoupon(String memId) {
		List<CouponVO> list = null;
		SqlSession session =  MyBatisSqlSessionFactory.getSqlSession();
		
		try {
			list = session.selectList("coupon.selectCoupon",memId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
				
		
		return list;
	}
	
	
}
