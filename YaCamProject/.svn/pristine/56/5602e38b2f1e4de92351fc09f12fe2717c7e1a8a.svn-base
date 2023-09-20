package kr.or.ddit.reservation.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.campzone.vo.CampzoneVo;
import kr.or.ddit.reservation.vo.ReservationVo;

public interface IReservationDao {
	public List<ReservationVo> getAllReservationList();
	
	public int getReservationinsert(ReservationVo vo);
	
	public ReservationVo selectReservation(String campno);
	
	public CampzoneVo selectCampzone(CampzoneVo vo);
	
	public List<CampzoneVo> selectList(CampzoneVo vo);
	
	public List<ReservationVo> dateCheck(ReservationVo vo);
	
	public List<CampzoneVo> zoneCheck(ReservationVo vo);
	
	public List<ReservationVo> selectMyReservation(String memId);
	
	public int insertPayment(ReservationVo vo);
	
	public int updateCoupon(ReservationVo vo);
	
	public int deleteReservation(String zoneNo);
}
