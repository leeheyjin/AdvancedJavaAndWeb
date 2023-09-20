package kr.or.ddit.coupon.service;

import java.util.List;

import kr.or.ddit.coupon.vo.CouponVO;

public interface ICouponService {
	
	/**
	 * 쿠폰생성 메소드
	 * return 값으로 0이나 1을 반환
	 */
	public int createCoupon(CouponVO vo);
	
	/**
	 * 쿠폰셀렉트 메소드
	 * return값으로 CouponVo값을 반환
	 */
	public List<CouponVO> selectCoupon(String memId);
	
	
	/**
	 * 쿠폰생성 메소드
	 * @return 값으로 쿠폰번호 16자리를 반환한다.
	 */
	public String createCouponNumber();
}
