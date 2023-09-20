package kr.or.ddit.campzone.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.basic.util.MyBatisSqlSessionFactory;
import kr.or.ddit.campinfo.vo.CampInfoVO;
import kr.or.ddit.campzone.vo.CampzoneVo;

public class CampZoneDaoImpl implements ICampZoneDao {

	private static ICampZoneDao dao;
	
	public static ICampZoneDao getInstance() {
		if(dao == null) dao = new CampZoneDaoImpl();
		return dao;
	}
	
	@Override
	//campzone 리스트 출력
	public List<CampzoneVo> getAllList() {
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		List<CampzoneVo>list = null;
		
		try {
			list = session.selectList("campzone.getAllList", list);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		
		
		return list;
	}

	@Override
	//campinfo 선택된거 값 가져오기
	public CampInfoVO selectCamp(Map<String, Object> map) {
		CampInfoVO vo = null;
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		try {
			vo = session.selectOne("campzone.selectCampInfoVo", map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		
		
		return vo;
	}

	@Override
	//campzone 선택된거 값 가져오기
	public List<CampzoneVo> selectCampZonevo(String campno) {
		List<CampzoneVo> vo = null;
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		try {
			vo = session.selectList("campzone.selectCampZonevo", campno);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		
		
		return vo;
	}

	@Override
	public CampzoneVo selectMyzone(CampzoneVo campno) {
		CampzoneVo vo = null;
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		try {
			vo = session.selectOne("campzone.selectMyzone", campno);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		
		
		return vo;
	}

}
