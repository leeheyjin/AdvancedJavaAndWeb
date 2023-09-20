package kr.or.ddit.campinfo.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.campinfo.vo.CampInfoVO;
import kr.or.ddit.campinfo.vo.ChartCampVO;

public interface ICampInfoService {

	//캠핑장 전체 목록 가져오기
	public List<CampInfoVO> getCampInfoList();
	
	//종류별 캠핑장 목록 가져오기
	public List<CampInfoVO> getSearchCamp(Map<String, Object> map);
	
	//캠프 판매 순위 차트
	public List<ChartCampVO> chartAmount();
	
	//내 캠프
	public CampInfoVO selectCampName(String campNo);
}
