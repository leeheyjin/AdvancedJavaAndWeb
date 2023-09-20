package kr.or.ddit.alarm.service;

import java.util.List;

import kr.or.ddit.alarm.dao.AlarmDAOImpl;
import kr.or.ddit.alarm.dao.IAlamDAO;
import kr.or.ddit.alarm.vo.AlarmVO;
import kr.or.ddit.member.vo.MemberVO;

public class AlarmServiceImpl implements IAlarmService{
	
	private IAlamDAO dao;
	private static IAlarmService service;
	
	public static IAlarmService getinstance() {
		return service = new AlarmServiceImpl();
	}
	
	private AlarmServiceImpl() {
		dao = AlarmDAOImpl.getinstace();
	}
	

	@Override
	public int insertAlarm(AlarmVO vo) {
		// TODO Auto-generated method stub
		return dao.insertAlarm(vo);
	}

	@Override
	public void sendAlarm(MemberVO vo) {
		dao.sendAlarm(vo);
		
	}

	@Override
	public int deleteAlarm(String memId) {
		// TODO Auto-generated method stub
		return dao.deleteAlarm(memId);
	}
	
	@Override
	public List<AlarmVO> selecrAlarm(String memId) {
		// TODO Auto-generated method stub
		return dao.selecrAlarm(memId);
	}

	@Override
	public List<AlarmVO> userAlarm(String zoneNo) {
		// TODO Auto-generated method stub
		return dao.userAlarm(zoneNo);
	}

}
