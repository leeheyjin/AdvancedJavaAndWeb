package kr.or.ddit.reservation.controller;

import java.io.IOException;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.reservation.vo.ReservationVo;

@WebServlet("/Pay.do")
public class Pay extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("utf-8");
		
		
		
		int person = Integer.parseInt(request.getParameter("person"));
		int car = Integer.parseInt(request.getParameter("car")) ;
		int total = Integer.parseInt(request.getParameter("total"));
		
		ReservationVo vo = (ReservationVo)request.getSession().getAttribute("Reservationvo");
		
		ReservationVo vo2 = new ReservationVo();
		
		vo2.setMem_id(vo.getMem_id());
		vo2.setZone_no(vo.getZone_no());
		vo2.setCamp_no(vo.getCamp_no());
		vo2.setRes_checkin(vo.getRes_checkin());
		vo2.setRes_checkout(vo.getRes_checkout());
		vo2.setRes_person(person);
		vo2.setRes_car_count(car);
		vo2.setRes_price(total);
		
		request.getSession().removeAttribute("Reservationvo");
		

		System.out.println(person);
		System.out.println(car);
		System.out.println(total);
		System.out.println("체크해보자 제발"+vo2);
		
		request.getSession().setAttribute("Reservationvo", vo2); // 최종 전부 다들어있는 예약 vo
		request.setAttribute("Reser", vo);	
		
		request.getRequestDispatcher("/ksj/ajax/Reservationvo.jsp").forward(request, response);
		
		
		
		
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
