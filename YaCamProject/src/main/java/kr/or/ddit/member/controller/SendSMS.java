package kr.or.ddit.member.controller;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.converter.json.GsonBuilderUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.service.SmsService;
import kr.or.ddit.member.vo.MemberVO;


// Servlet을 직접쓰네 나 이렇게하는거 기억안나는데 형은 어떻게 처리하시는데요?


@WebServlet("/SendSMS.do")
public class SendSMS extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 일단 무조건 true로 보낼꺼고. 귀찮으니 일단 new로할게. 무조건 니번호로 보낼거야 일단.
		// sendSms에서 던지는 에러 종류에 대한 catch가 이뤄지면 요청에 대한 result가 false로 응답.
		// 여기서 해당 내용 꺼내서 service로 넘겨주고 이름/번호 일치 확인 후 일치할 경우 방금 메소드 실행
		// 그 과정에서 content를 난수를 만들어서 그 사용자 id랑 맵핑된 뭔가에 저장시키고 나중에 저거 찾기 눌렀을때 일치하는지 확인해야됨 ㅋ
		//사랑합니다 > _ < 이거 해볼게여 이건 할수있을꺼같아서 나중에 이거 끝나고 형이 해준코드도 다까볼게요
		//근데 저기 vo 왜 저렇게 나눠놓은거에요 저사람은?
		// 네이버에서 약속된 형태로 만들때 눈에 보기 쉽게하기 위해서 ㅇㅎ 네 알겠습니다.저 프로젝트 끝나면 소주 한잔 꽂으시죠 그려~ 긴디~ 옙 사랑합
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		
		Map<String, Object> map = new HashMap<>();
		map.put("mem_name", name);
		map.put("mem_tel", tel);
		
		IMemberService service = MemberServiceImpl.getInstance();
		int set = service.idFind(map);
		System.out.println("서블릿"+set);
		String randomStr = "";
		String result = "";
		Gson gson = new Gson();
		if(set>0) {
			Random random = new Random();
			tel = tel.replaceAll("-", "");
			
			for (int i=0; i<4; i++) {
				String ran = Integer.toString(random.nextInt(10));
				randomStr += ran;
			}
			System.out.println("문자 인증번호 ="+randomStr);
			try {
			    SmsService smsService = new SmsService();
			    result = smsService.sendSms(tel, randomStr);
			    
			   
			    JsonElement element =JsonParser.parseString(result);
			    
			    JsonObject object = element.getAsJsonObject();
			    if(object.get("statusName")!=null && "success".equals(object.get("statusName").getAsString())) {
			    	System.out.println("statusName==> " + object.get("statusName").getAsString());
			    	response.getWriter().write("{\"result\":true}");
			    }else {
			    	 response.getWriter().write("{\"result\":false}");
			    }
			    
			    
			} catch (NoSuchAlgorithmException | InvalidKeyException | IOException e) {
//				e.printStackTrace();
			    response.getWriter().write("{\"result\":false}");
			}
		} else {
			System.out.println("실패 서블릿 부분 아이디 x");
			response.getWriter().write("{\"result\":false}");
		}
			
		request.setAttribute("telnum", randomStr);
		
		request.getRequestDispatcher("/pbc/find/idfind.jsp").forward(request, response);
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
