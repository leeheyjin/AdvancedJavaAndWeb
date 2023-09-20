package kr.or.ddit.reservation.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import kr.or.ddit.alarm.service.AlarmServiceImpl;
import kr.or.ddit.alarm.service.IAlarmService;
import kr.or.ddit.alarm.vo.AlarmVO;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.reservation.service.IReservationService;
import kr.or.ddit.reservation.service.ReservationServiceImpl;

@WebServlet("/DeleteReservation.do")
public class DeleteReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String zoneNo = request.getParameter("zoneNo");
		IReservationService service = ReservationServiceImpl.getInstance();
		IAlarmService alarmsSrvice = AlarmServiceImpl.getinstance();
		IMemberService memberService = MemberServiceImpl.getInstance();
		
		int cnt =  service.deleteReservation(zoneNo);
		
		if(cnt>0) {
			MemberVO vo = new MemberVO();
			List<AlarmVO> list = alarmsSrvice.userAlarm(zoneNo);
			System.out.println(list);
			if(list!=null) {
				for (AlarmVO alarmVO : list) {
					vo = memberService.selectUserInfo(alarmVO.getMem_id());
					System.out.println("vo에 tel값 확인하세요" + vo);
					alarmsSrvice.sendAlarm(vo);
				}
			}else {
				System.out.println("보낼 사람이 없음");
			}
		}
		request.setAttribute("cnt", cnt);
		
		request.getRequestDispatcher("/LMW/result/resultint.jsp").forward(request, response);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
