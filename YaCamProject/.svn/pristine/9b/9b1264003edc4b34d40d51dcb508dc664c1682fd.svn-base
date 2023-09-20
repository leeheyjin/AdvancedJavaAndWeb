package kr.or.ddit.alarm.dao;

import java.util.List;

import kr.or.ddit.alarm.vo.AlarmVO;
import kr.or.ddit.member.vo.MemberVO;

public interface IAlamDAO {
	
	//알람 예약
	public int insertAlarm(AlarmVO vo);
	
	//알람 발송
	public void sendAlarm(MemberVO vo);
	
	//알람 삭제
	public int deleteAlarm(String memId);
	
	//알람 조회
	public List<AlarmVO> selecrAlarm(String memId);
	
	public List<AlarmVO>userAlarm(String zoneNo);
}
