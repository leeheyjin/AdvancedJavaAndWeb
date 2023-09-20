package kr.or.ddit.alarm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.alarm.service.AlarmServiceImpl;
import kr.or.ddit.alarm.service.IAlarmService;
import kr.or.ddit.alarm.vo.AlarmVO;
import kr.or.ddit.member.vo.MemberVO;

@WebServlet("/insertAlarm.do")
public class insertAlarm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO)session.getAttribute("userinfo");
		System.out.println("이것은" + vo);
		
		String id = vo.getMem_id();
		String zone = request.getParameter("zone");
		String camp = request.getParameter("camp");
		
		AlarmVO avo = new AlarmVO();
		avo.setMem_id(id);
		avo.setZone_no(zone);
		avo.setCamp_no(camp);
		System.out.println("이것은 avo"+avo);
		
		IAlarmService service = AlarmServiceImpl.getinstance();
		int cnt = service.insertAlarm(avo);
		System.out.println("이것은" + cnt);
		request.setAttribute("cnt", cnt);
		
		request.getRequestDispatcher("/LMW/result/resultint.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
