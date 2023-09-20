package kr.or.ddit.campzone.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.campinfo.service.CampInfoServiceImpl;
import kr.or.ddit.campzone.service.CampZoneServiceImpl;
import kr.or.ddit.campzone.service.ICampZoneService;
import kr.or.ddit.campzone.vo.CampzoneVo;
import kr.or.ddit.reservation.service.IReservationService;
import kr.or.ddit.reservation.service.ReservationServiceImpl;
import kr.or.ddit.reservation.vo.ReservationVo;

@WebServlet("/seleteDate.do")
public class SeleteDate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		String indate = request.getParameter("indate");
		String outdate = request.getParameter("outdate");
		String icampno = request.getParameter("icampno");
		
		IReservationService service = ReservationServiceImpl.getInstance();
		
		ReservationVo vo = new ReservationVo();
		
		vo.setRes_checkin(indate);
		vo.setRes_checkout(outdate);
		vo.setCamp_no(icampno);
		
		List<CampzoneVo> clist = service.zoneCheck(vo);
		System.out.println("이것은 캠프 ZONE 리스트 입니다."+clist);
		
		
		request.setAttribute("clist", clist);
		request.getRequestDispatcher("/ksj/ajax/selectZoneServlet.jsp").forward(request, response);
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		String indate = request.getParameter("indate");
		String outdate = request.getParameter("outdate");
		String icampno = request.getParameter("icampno");
		
		IReservationService service = ReservationServiceImpl.getInstance();
		
		ReservationVo vo = new ReservationVo();
		
		vo.setRes_checkin(indate);
		vo.setRes_checkout(outdate);
		vo.setCamp_no(icampno);
		
		List<ReservationVo> list = service.dateCheck(vo);
		System.out.println("이것은 리스트 입니다."+list);
		
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/ksj/ajax/selectDateServlet.jsp").forward(request, response);
		
	}

}
