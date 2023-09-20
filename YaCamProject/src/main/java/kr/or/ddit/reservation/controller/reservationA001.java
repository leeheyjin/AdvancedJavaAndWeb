package kr.or.ddit.reservation.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.campzone.vo.CampzoneVo;
import kr.or.ddit.reservation.service.IReservationService;
import kr.or.ddit.reservation.service.ReservationServiceImpl;
import kr.or.ddit.reservation.vo.ReservationVo;


@WebServlet("/reservationA001.do")
public class reservationA001 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("utf-8");
		
		String checkin = request.getParameter("in"); //체크인
		String checkout = request.getParameter("out"); //체크아웃
		String zoneno =request.getParameter("zoneno"); // 캠프존 번호 
		String campno =request.getParameter("campno"); //캠핑장 번호
		String zonetype = request.getParameter("zonetype"); // 존타입
		String price = request.getParameter("price"); //방가격
		String id = request.getParameter("id"); // 로그인한 회원아이디 
		
		ReservationVo vo = new ReservationVo();
		
		
		vo.setMem_id(id);
		vo.setZone_no(zoneno);
		vo.setCamp_no(campno);
		vo.setRes_checkin(checkin);
		vo.setRes_checkout(checkout);
		vo.setRes_price(Integer.parseInt(price));
		
		System.out.println(vo);
		System.out.println(vo.getMem_id());
		System.out.println(vo.getZone_no());
		System.out.println(vo.getCamp_no());
		System.out.println(vo.getRes_checkin());
		System.out.println(vo.getRes_checkout());
		System.out.println(vo.getRes_price());
		
		IReservationService service = ReservationServiceImpl.getInstance();
		
		CampzoneVo cvo =new CampzoneVo();
		
		cvo.setCamp_no(campno);
		cvo.setZone_no(zoneno);
		cvo.setZone_type(zonetype);
		
		List<CampzoneVo> list = service.selectList(cvo);
		
		CampzoneVo campzonevo = service.selectCampzone(cvo);
		ReservationVo Reservationvo = service.selectReservation(campno);
		System.out.println("Reservationvo" + Reservationvo);
		
		System.out.println("campzoneVo ==> " + campzonevo);
		
		request.getSession().setAttribute("Campzonevo", campzonevo);
		request.getSession().setAttribute("Reservationvo", vo);
		request.getSession().setAttribute("list", list);
		request.setAttribute("Reser", vo);
		
		
		request.getRequestDispatcher("/ksj/ajax/Reservationvo.jsp").forward(request, response);
		
		
		
	
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
