package kr.or.ddit.campzone.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.campinfo.vo.CampInfoVO;
import kr.or.ddit.campzone.dao.CampZoneDaoImpl;
import kr.or.ddit.campzone.dao.ICampZoneDao;
import kr.or.ddit.campzone.vo.CampzoneVo;
import kr.or.ddit.reservation.vo.ReservationVo;

public class CampZoneServiceImpl implements ICampZoneService {
	private static ICampZoneService service;
	private ICampZoneDao dao;
	
	private CampZoneServiceImpl() {
		dao = CampZoneDaoImpl.getInstance();
	}
	
	public static ICampZoneService getInstance() {
		if(service == null) service = new CampZoneServiceImpl();
		
		return service;
	}
	
	@Override
	//campzone 리스트 출력
	public List<CampzoneVo> getAllList() {
		// TODO Auto-generated method stub
		return dao.getAllList();
	}

	@Override
	//campinfo 선택된거 값 가져오기
	public CampInfoVO selectCamp(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.selectCamp(map);
	}

	@Override
	//campzone 선택된거 값 가져오기
	public List<CampzoneVo> selectCampZonevo(String campno) {
		// TODO Auto-generated method stub
		return dao.selectCampZonevo(campno);
	}

	@Override
	public CampzoneVo selectMyzone(CampzoneVo campno) {
		// TODO Auto-generated method stub
		return dao.selectMyzone(campno);
	}





}
