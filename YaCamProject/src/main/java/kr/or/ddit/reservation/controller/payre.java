package kr.or.ddit.reservation.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.reservation.service.IReservationService;
import kr.or.ddit.reservation.service.ReservationServiceImpl;
import kr.or.ddit.reservation.vo.ReservationVo;


@WebServlet("/payre.do")
public class payre extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("utf-8");
		
		ReservationVo vo = (ReservationVo)request.getSession().getAttribute("kakao");		
		System.out.println("아이디 : " + vo.getCup_no());
		System.out.println("아이디 : " + vo.getMem_id());
		System.out.println("존넘버 : " + vo.getZone_no());
		System.out.println("캠프번호 : " + vo.getCamp_no());
		System.out.println("예약일 : " + vo.getRes_date());
		System.out.println("입실일 : " + vo.getRes_checkin());
		System.out.println("퇴실일 : " + vo.getRes_checkout());
		System.out.println("인원수 : " + vo.getRes_person());
		System.out.println("차량수 : " + vo.getRes_car_count());
		System.out.println("총가격 : " + vo.getRes_price());
		IReservationService service = ReservationServiceImpl.getInstance();
		
		int Reservationvo = service.getReservationinsert(vo);
		int insertPayment = service.insertPayment(vo);
		int updateCoupon = service.updateCoupon(vo);
		System.currentTimeMillis();
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(System.currentTimeMillis());
		
		
		//if( Reservationvo > 0 && insertPayment > 0) {
			
			
			request.setAttribute("result", Reservationvo);
			request.setAttribute("today", formatter.format(date));
			request.getRequestDispatcher("/ksj/payre.jsp").forward(request, response);
		//} else {
		//}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
