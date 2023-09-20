package kr.or.ddit.alarm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.alarm.service.AlarmServiceImpl;
import kr.or.ddit.alarm.service.IAlarmService;
import kr.or.ddit.alarm.vo.AlarmVO;
import kr.or.ddit.member.vo.MemberVO;

@WebServlet("/sendAlarm.do")
public class sendAlarm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		IAlarmService service = AlarmServiceImpl.getinstance();
		
		MemberVO vo = new MemberVO();
		vo.setMem_tel("01074423311");
		
		service.sendAlarm(vo);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
