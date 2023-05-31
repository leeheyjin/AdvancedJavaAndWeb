package kr.or.ddit.buyer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.buyer.service.BuyerService;
import kr.or.ddit.buyer.service.IBuyerService;
import kr.or.ddit.buyer.vo.BuyerVO;

@WebServlet("/buyerIdName.do")
public class BuyerIdName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BuyerIdName() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 전송시 데이터를 받는다
		
		// service객체를 얻는다
		IBuyerService service = BuyerService.getInstance();
		
		// service 메소드 호출 - 수행결과를 얻는다
		List<BuyerVO> list = service.selectIdName();
		
		// request객체로 결과를 저장한다.
		// View 페이지로 이동하여 수행결과로 응답데이터 생성 - json 배열
		request.setAttribute("allBuyer", list);
		
		// 컨트롤러에서 view로 데이터를 공유하면서(엄연히 말하면 request 객체를 공유하는것) 페이지 이동 ==> forward / redirect 방식 중 선택
		request.getRequestDispatcher("/0526/idName.jsp").forward(request, response);
	}

}
