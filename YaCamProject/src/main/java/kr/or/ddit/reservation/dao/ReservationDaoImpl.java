package kr.or.ddit.reservation.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.basic.util.MyBatisSqlSessionFactory;
import kr.or.ddit.campzone.vo.CampzoneVo;
import kr.or.ddit.reservation.vo.ReservationVo;

public class ReservationDaoImpl implements IReservationDao{
	
	public static void main(String[] args) {
		ReservationDaoImpl impl = new ReservationDaoImpl();
//		System.out.println(impl.selectList());
		ReservationVo vo = new ReservationVo();
		vo.setRes_checkin("2023-06-15");
		vo.setRes_checkout("2023-06-19");
		vo.setCamp_no("A001");
		
//		System.out.println(impl.dateCheck(vo));
		System.out.println(impl.zoneCheck(vo));
		
	}
	
	
	private static IReservationDao dao;
	
	public static IReservationDao getInstance() {
		if(dao == null) dao = new ReservationDaoImpl();
		return dao;
		
	}

	@Override
	public List<ReservationVo> getAllReservationList() {
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		List<ReservationVo>list = null;
		
		try {
			list = session.selectList("reservation.getAllList");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		
		return list;
	}

	@Override
	public int getReservationinsert(ReservationVo vo) {
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		
		int cnt =0;
		try {
			cnt = session.insert("reservation.insert",vo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		
		return cnt;
		
	}

	@Override
	public ReservationVo selectReservation(String campno) {
		// TODO Auto-generated method stub
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		ReservationVo vo = null;
		
		try {
			vo = session.selectOne("reservation.selectReservation", campno);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		
		return vo;
	}

	@Override
	public CampzoneVo selectCampzone(CampzoneVo vo) {
		CampzoneVo cvo = null;
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		
		try {
			cvo = session.selectOne("reservation.selectCampzone", vo);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		
		return cvo;
	}

	@Override
	public List<CampzoneVo> selectList(CampzoneVo vo) {
		
		List<CampzoneVo> list = null;
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		
		try {
			list = session.selectList("campzone.selectList",vo);
			
			if (list != null) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	@Override
	public List<ReservationVo> dateCheck(ReservationVo vo) {
		
		List<ReservationVo> list = null;
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		
		try {
			list = session.selectList("reservation.dateCheck",vo);
			if (list != null) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	@Override
	public List<CampzoneVo> zoneCheck(ReservationVo vo) {
		
		List<CampzoneVo> list = null;
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		
		try {
			list = session.selectList("reservation.zoneCheck",vo);
			
			if (list != null) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	@Override
	public List<ReservationVo> selectMyReservation(String memId) {
		
		
		List<ReservationVo> list = null;
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		
		try {
			list = session.selectList("reservation.selectMyReservation",memId);
			
			if (list != null) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	@Override
	public int insertPayment(ReservationVo vo) {
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		
		int cnt =0;
		try {
			cnt = session.insert("reservation.insertPayment",vo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		
		return cnt;
	}

	@Override
	public int updateCoupon(ReservationVo vo) {
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		
		int cnt =0;
		try {
			cnt = session.insert("reservation.updateCoupon",vo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		
		return cnt;
	}

	@Override
	public int deleteReservation(String zoneNo) {
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		
		int cnt =0;
		try {
			cnt = session.insert("reservation.deleteReservation",zoneNo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		return cnt;
	}


}
