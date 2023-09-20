package kr.or.ddit.reservation.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.campinfo.service.CampInfoServiceImpl;
import kr.or.ddit.campinfo.service.ICampInfoService;
import kr.or.ddit.campinfo.vo.CampInfoVO;
import kr.or.ddit.campzone.service.CampZoneServiceImpl;
import kr.or.ddit.campzone.service.ICampZoneService;
import kr.or.ddit.campzone.vo.CampzoneVo;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.reservation.service.IReservationService;
import kr.or.ddit.reservation.service.ReservationServiceImpl;
import kr.or.ddit.reservation.vo.ReservationVo;

@WebServlet("/SelectMyResuervation.do")
public class SelectMyResuervation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		MemberVO vo = (MemberVO) session.getAttribute("userinfo");
		ICampInfoService campinfoService = CampInfoServiceImpl.getInstance();
		ICampZoneService campzoneService = CampZoneServiceImpl.getInstance();
		IReservationService reservationService = ReservationServiceImpl.getInstance();
		String name = vo.getMem_id();
		System.out.println("과연" + name);
		
		List<ReservationVo> list = reservationService.selectMyReservation(name);
		HashMap<String, Object> map = new HashMap<>();
		
		if(list.size()!=0) {
			CampInfoVO campvo = campinfoService.selectCampName(list.get(0).getCamp_no());
			System.out.println(campvo);
			CampzoneVo zoneVo2 = new CampzoneVo();
			zoneVo2.setCamp_no(list.get(0).getCamp_no());
			zoneVo2.setZone_no(list.get(0).getZone_no());
			
			CampzoneVo zoneVo = campzoneService.selectMyzone(zoneVo2);
			System.out.println(zoneVo);
			map.put("list", list);
			map.put("campvo", campvo);
			map.put("zoneVo", zoneVo);
		}else if(list.size()==0) {
			System.out.println("값이 없음2");
			
		}else {
			System.out.println("값이 없음3");
		}
		
		
		request.setAttribute("map", map);
		request.getRequestDispatcher("/LMW/mypage/myReservationinfo.jsp").forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
