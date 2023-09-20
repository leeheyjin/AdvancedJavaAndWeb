package kr.or.ddit.alarm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.alarm.service.AlarmServiceImpl;
import kr.or.ddit.alarm.service.IAlarmService;

@WebServlet("/deleteAlarm.do")
public class deleteAlarm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		IAlarmService service = AlarmServiceImpl.getinstance();
		String zoneNo = request.getParameter("zoneNo");
		int cnt = service.deleteAlarm(zoneNo);
		
		request.setAttribute("cnt", cnt);
		request.getRequestDispatcher("/LMW/result/resultint.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
