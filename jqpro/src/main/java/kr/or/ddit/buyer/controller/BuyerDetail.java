package kr.or.ddit.buyer.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.buyer.service.BuyerService;
import kr.or.ddit.buyer.vo.BuyerVO;

@WebServlet("/buyerDetail.do")
public class BuyerDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 전송시 데이터 받기
		String buyerId = request.getParameter("id");
		// service객체 얻기
		BuyerService service = BuyerService.getInstance();
		// service메소드 호출하기 - 결과값 받기
		BuyerVO vo = service.selectOne(buyerId);
		// 결과값을 request에 저장하기
		request.setAttribute("selectOne", vo);
		// view 페이지로 이동 - json데이터 생성
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
