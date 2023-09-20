package kr.or.ddit.alarm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.alarm.service.AlarmServiceImpl;
import kr.or.ddit.alarm.service.IAlarmService;
import kr.or.ddit.alarm.vo.AlarmVO;
import kr.or.ddit.campinfo.service.CampInfoServiceImpl;
import kr.or.ddit.campinfo.service.ICampInfoService;
import kr.or.ddit.campinfo.vo.CampInfoVO;
import kr.or.ddit.member.vo.MemberVO;

@WebServlet("/SelectAlarm.do")
public class SelectAlarm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		IAlarmService service = AlarmServiceImpl.getinstance();
		ICampInfoService cservice = CampInfoServiceImpl.getInstance();
		
		
		
		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO)session.getAttribute("userinfo");
		
		List<CampInfoVO> clist = new ArrayList<>();
		List<AlarmVO> list = service.selecrAlarm(vo.getMem_id());
		HashMap<String, Object> map = new HashMap<>();
		
		for (AlarmVO vo2 : list) {
			CampInfoVO cvo = cservice.selectCampName(vo2.getCamp_no());
			clist.add(cvo);
		}
		
		map.put("list", list);
		map.put("clist", clist);
		System.out.println("이것은"+map);
		
		request.setAttribute("map", map);
		
		request.getRequestDispatcher("/LMW/mypage/myAlarm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
