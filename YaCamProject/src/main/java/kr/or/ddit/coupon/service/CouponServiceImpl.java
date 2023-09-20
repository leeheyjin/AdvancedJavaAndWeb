package kr.or.ddit.coupon.service;

import java.util.List;
import java.util.Random;

import kr.or.ddit.coupon.dao.CouponDAOImpl;
import kr.or.ddit.coupon.dao.ICouponDAO;
import kr.or.ddit.coupon.vo.CouponVO;

public class CouponServiceImpl implements ICouponService{
	
	
	private static ICouponService service;
	private ICouponDAO dao;
	
	private CouponServiceImpl() {
		dao = CouponDAOImpl.getInstance();
	}
	
	public static ICouponService getInstance() {
		return service = new CouponServiceImpl();
	}
	

	@Override
	public int createCoupon(CouponVO vo) {
		// TODO Auto-generated method stub
		return dao.createCoupon(vo);
	}

	@Override
	public List<CouponVO> selectCoupon(String memId) {
		// TODO Auto-generated method stub
		return dao.selectCoupon(memId);
	}
	
	
	//쿠폰생성
	
	int n = 4; // n자리 쿠폰번호 n만큼 생성
	char[] chs = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
			'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 
			'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

	public String createCouponNumber() {
		Random rd = new Random();
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < n; j++) {
			if(j!=0) {sb.append("-");}
			
			for (int i = 0; i < n; i++) {
				char ch = chs[rd.nextInt(chs.length)];
				sb.append(ch);
			}
		}
		return sb.toString();
	}
	
}
