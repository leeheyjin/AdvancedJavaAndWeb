package kr.or.ddit.campzone.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.campinfo.vo.CampInfoVO;
import kr.or.ddit.campzone.vo.CampzoneVo;
import kr.or.ddit.reservation.vo.ReservationVo;

public interface ICampZoneDao {
	//campzone 리스트 출력
	public List<CampzoneVo> getAllList();
	
	//campinfo 선택된거 값 가져오기
	public CampInfoVO selectCamp(Map<String, Object> map);
	
	//campzone 선택된거 값 가져오기
	public List<CampzoneVo> selectCampZonevo(String campno);
	
	//방호수 정보
	public CampzoneVo selectMyzone(CampzoneVo campno);
	
	
}
