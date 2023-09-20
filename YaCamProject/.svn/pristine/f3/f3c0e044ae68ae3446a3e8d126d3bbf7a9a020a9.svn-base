package kr.or.ddit.coupon.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.coupon.service.CouponServiceImpl;
import kr.or.ddit.coupon.service.ICouponService;
import kr.or.ddit.coupon.vo.CouponVO;
import kr.or.ddit.member.vo.MemberVO;

@WebServlet("/SelectCoupon.do")
public class SelectCoupon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		// 1. Session객체를 생성하거나 현재 세션 가져오기
		HttpSession session = request.getSession();
		
		MemberVO userinfo = (MemberVO)session.getAttribute("userinfo");
		System.out.println("테스트"+userinfo);
		
		ICouponService service = CouponServiceImpl.getInstance();
		List<CouponVO> list = null;
		list = service.selectCoupon(userinfo.getMem_id());
		System.out.println(list);
		
		//값 저장
		request.setAttribute("list", list);	
		
		request.getRequestDispatcher("/LMW/mypage/myCouponBox.jsp").forward(request, response);
//		response.sendRedirect(request.getContextPath()+"/LMW/mypage/myCouponBox.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
