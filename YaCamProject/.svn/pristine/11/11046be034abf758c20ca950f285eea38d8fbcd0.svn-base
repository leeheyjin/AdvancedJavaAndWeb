package kr.or.ddit.reservation.service;

import java.util.List;

import kr.or.ddit.campzone.vo.CampzoneVo;
import kr.or.ddit.reservation.dao.IReservationDao;
import kr.or.ddit.reservation.dao.ReservationDaoImpl;
import kr.or.ddit.reservation.vo.ReservationVo;

public class ReservationServiceImpl implements IReservationService {
	private static IReservationService service;
	private IReservationDao dao;
	
	private ReservationServiceImpl() {
		dao = ReservationDaoImpl.getInstance();
	}
	
	public static IReservationService getInstance() {
		if(service ==null)
			service = new ReservationServiceImpl();
		return service;
	}

	@Override
	public List<ReservationVo> getAllReservationList() {
		// TODO Auto-generated method stub
		return dao.getAllReservationList();
	}

	@Override
	public int getReservationinsert(ReservationVo vo) {
		// TODO Auto-generated method stub
		return dao.getReservationinsert(vo);
	}

	@Override
	public ReservationVo selectReservation(String campno) {
		// TODO Auto-generated method stub
		return dao.selectReservation(campno);
	}

	@Override
	public CampzoneVo selectCampzone(CampzoneVo vo) {
		// TODO Auto-generated method stub
		return dao.selectCampzone(vo);
	}

	@Override
	public List<CampzoneVo> selectList(CampzoneVo vo) {
		// TODO Auto-generated method stub
		return dao.selectList(vo);
	}

	@Override
	public List<ReservationVo> dateCheck(ReservationVo vo) {
		// TODO Auto-generated method stub
		return dao.dateCheck(vo);
	}

	@Override
	public List<CampzoneVo> zoneCheck(ReservationVo vo) {
		// TODO Auto-generated method stub
		return dao.zoneCheck(vo);
	}

	@Override
	public List<ReservationVo> selectMyReservation(String memId) {
		// TODO Auto-generated method stub
		return dao.selectMyReservation(memId);
	}

	@Override
	public int insertPayment(ReservationVo vo) {
		// TODO Auto-generated method stub
		return dao.insertPayment(vo);
	}

	@Override
	public int updateCoupon(ReservationVo vo) {
		// TODO Auto-generated method stub
		return dao.updateCoupon(vo);
	}

	@Override
	public int deleteReservation(String zoneNo) {
		// TODO Auto-generated method stub
		return dao.deleteReservation(zoneNo);
	}

	
}
