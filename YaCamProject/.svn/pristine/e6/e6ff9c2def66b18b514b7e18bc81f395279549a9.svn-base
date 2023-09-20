package kr.or.ddit.alarm.dao;

import java.util.HashMap;
import java.util.List;

import javax.annotation.processing.SupportedSourceVersion;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONObject;

import kr.or.ddit.alarm.vo.AlarmVO;
import kr.or.ddit.basic.util.MyBatisSqlSessionFactory;
import kr.or.ddit.member.vo.MemberVO;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
public class AlarmDAOImpl implements IAlamDAO{
	
	
	public static void main(String[] args) {
//		String api_key = "NCS5JIVVVCSSLUVI"; // Api 키
//	    String api_secret = "V8GAHTNRIRV3V8FMOQTFU6QLXYLERNLH"; // Api secret
//	    Message coolsms = new Message(api_key, api_secret);
//	    // 4 params(to, from, type, text) are mandatory. must be filled
//	    HashMap<String, String> params = new HashMap<String, String>();
//	    params.put("to", "01074423311"); 	// 수신 번호 (받는사람 번호)
//	    params.put("from", "01074423311");	// 발신번호  (보내는 사람 번호)
//	    params.put("type", "SMS");
//	    params.put("text", "어서 예약하세요");
//	    params.put("app_version", "test app 1.2"); // application name and version
//	    try {
//	    	//메세지 전송
//	    	JSONObject obj = (JSONObject) coolsms.send(params);
//	      	//보내진 이후에 해야할 행위들 작성
//	    	System.out.println(obj.toString());s
//	    } catch (CoolsmsException e) {
//	    	System.out.println(e.getMessage());
//	    	System.out.println(e.getCode());
//	    }
		
		AlarmDAOImpl impl = new AlarmDAOImpl();
		AlarmVO vo = new AlarmVO();
//		vo.setMem_id("asd");
//		vo.setZone_no("1");
//		vo.setCamp_no("A001");
//		System.out.println(impl.insertAlarm(vo));
//		System.out.println(impl.deleteAlarm("1"));
//		System.out.println(impl.selecrAlarm("asd"));
//		impl.sendAlarm(null);
	}

	private static IAlamDAO dao;
	
	public static IAlamDAO getinstace() {
		return dao=new AlarmDAOImpl();
	};
	
	private AlarmDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	@Override
	public int insertAlarm(AlarmVO vo) {
		int cnt = 0;
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		
		try {
			cnt = session.insert("alarm.insertAlarm",vo);
			
			if(cnt>0)session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return cnt;
	}

	@Override
	public void sendAlarm(MemberVO vo) {
		System.out.println(vo);
		String api_key = "NCS5JIVVVCSSLUVI"; // Api 키
	    String api_secret = "V8GAHTNRIRV3V8FMOQTFU6QLXYLERNLH"; // Api secret
	    Message coolsms = new Message(api_key, api_secret);
	    // 4 params(to, from, type, text) are mandatory. must be filled
	    HashMap<String, String> params = new HashMap<String, String>();
	    params.put("to", vo.getMem_tel()); 	// 수신 번호 (받는사람 번호)
	    params.put("from", "01074423311");	// 발신번호  (보내는 사람 번호)
	    params.put("type", "SMS");
	    params.put("text", "신청하신 빈자리 알람 발송(-야캠-) : 자리가 나왔습니다 서둘러 예약하세요!!");
	    params.put("app_version", "test app 1.2"); // application name and version
	    try {
	    	//메세지 전송
	    	JSONObject obj = (JSONObject) coolsms.send(params);
	      	//보내진 이후에 해야할 행위들 작성
	    	System.out.println(obj.toString());
	    } catch (CoolsmsException e) {
	    	System.out.println(e.getMessage());
	    	System.out.println(e.getCode());
	    }
	}

	@Override
	public int deleteAlarm(String memId) {
		int cnt = 0;
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		
		try {
			cnt = session.delete("alarm.deleteAlarm",memId);
			
			if(cnt>0)session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return cnt;
	}

	@Override
	public List<AlarmVO> selecrAlarm(String memId) {
		List<AlarmVO> list = null;
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		
		try {
			list = session.selectList("alarm.selecrAlarm",memId);
			
			
			if (session != null) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return list;
	}

	@Override
	public List<AlarmVO> userAlarm(String zoneNo) {
		List<AlarmVO> list = null;
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		
		try {
			list = session.selectList("alarm.userAlarm",zoneNo);
			
			
			if (session != null) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return list;
	}
}