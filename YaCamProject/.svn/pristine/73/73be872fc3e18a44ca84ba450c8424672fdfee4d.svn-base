package kr.or.ddit.campinfo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.basic.util.MyBatisSqlSessionFactory;
import kr.or.ddit.campinfo.vo.CampInfoVO;
import kr.or.ddit.campinfo.vo.ChartCampVO;

public class CampInfoDaoImpl implements ICampInfoDao {
	
	public static void main(String[] args) {
		CampInfoDaoImpl impl = new CampInfoDaoImpl();
		
//		System.out.println(impl.chartAmount());
		System.out.println(impl.selectCampName("A001"));
	}
	
	
	
	private static ICampInfoDao dao;
	
	public static ICampInfoDao getInstance() {
		if(dao == null) dao = new CampInfoDaoImpl();
		return dao;
	}

	@Override
	public List<CampInfoVO> getCampInfoList() {
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		
		List<CampInfoVO> list = null;
		
		try {
			list = session.selectList("campInfo.getCampInfoList");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		
		return list;
	}

	@Override
	public List<CampInfoVO> getSearchCamp(Map<String, Object> map) {
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		
		List<CampInfoVO> list = null;
		
		try {
			list = session.selectList("campInfo.getSearchCamp", map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		
		return list;
	}

	@Override
	public List<ChartCampVO> chartAmount() {
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		
		List<ChartCampVO> list = null;
		
		try {
			list = session.selectList("chartCamp.chartAmount");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		
		return list;
	}

	@Override
	public CampInfoVO selectCampName(String campNo) {
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		
		CampInfoVO vo = null;
		
		try {
			vo = session.selectOne("campInfo.selectCampName",campNo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		
		return vo;
	}

}
