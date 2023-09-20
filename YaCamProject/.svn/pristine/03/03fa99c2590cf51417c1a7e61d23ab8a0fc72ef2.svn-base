package kr.or.ddit.campinfo.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.campinfo.dao.CampInfoDaoImpl;
import kr.or.ddit.campinfo.dao.ICampInfoDao;
import kr.or.ddit.campinfo.vo.CampInfoVO;
import kr.or.ddit.campinfo.vo.ChartCampVO;

public class CampInfoServiceImpl implements ICampInfoService {
	
	private static ICampInfoService service;
	private ICampInfoDao dao;
	
	private CampInfoServiceImpl() {
		dao = CampInfoDaoImpl.getInstance();
	}
	
	public static ICampInfoService getInstance() {
		
		if(service == null)
			service = new CampInfoServiceImpl();
		
		return service;
	}

	@Override
	public List<CampInfoVO> getCampInfoList() {
		// TODO Auto-generated method stub
		return dao.getCampInfoList();
	}

	@Override
	public List<CampInfoVO> getSearchCamp(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.getSearchCamp(map);
	}

	@Override
	public List<ChartCampVO> chartAmount() {
		// TODO Auto-generated method stub
		return dao.chartAmount();
	}

	@Override
	public CampInfoVO selectCampName(String campNo) {
		// TODO Auto-generated method stub
		return dao.selectCampName(campNo);
	}

}
