package kr.or.ddit.coupon.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.coupon.service.CouponServiceImpl;
import kr.or.ddit.coupon.service.ICouponService;
import kr.or.ddit.coupon.vo.CouponVO;

@WebServlet("/InsertCoupon.do")
public class InsertCoupon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String coupon = request.getParameter("select");
		String user = request.getParameter("user");
		System.out.println("테스트 : " + user);
		
//		insert into coupon values(#{cup_no},#{mem_id},#{cup_name},#{cup_type},#{cup_status},sysdate,sysdate+90)
		ICouponService service = CouponServiceImpl.getInstance();
		CouponVO vo = new CouponVO();
		String couponNumber = service.createCouponNumber();
		vo.setMem_id(user);
		vo.setCup_no(couponNumber);
		vo.setCup_status("Y");
		
		
		switch (coupon) {
		case "new":
			vo.setCup_name("신규가입 쿠폰");
			break;
		case "birth":
			vo.setCup_name("생일축하 쿠폰");
			break;
		case "event":
			vo.setCup_name("이벤트 쿠폰");
			break;
		case "chllenge":
			vo.setCup_name("첼린지 참여 쿠폰");
			break;
		default:
			System.out.println("쿠폰선택 안함");
			break;
		}
		
		int cnt = service.createCoupon(vo);
		if(cnt>0) {
			System.out.println("성공");
			request.setAttribute("cnt", cnt);
		}else {
			System.out.println("쿠폰생성 실패");
		}
//		request.getRequestDispatcher("/LMW/result/resultint.jsp").forward(request, response);
		request.getRequestDispatcher("/LMW/result/resultint.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
