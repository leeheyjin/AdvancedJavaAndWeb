package kr.or.ddit.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;

@WebServlet("/BoardHitUpdate.do")
public class BoardHitUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//	요청시 num 받기
		int num = Integer.parseInt(request.getParameter("num"));
		
		//	서비스 얻기
		IBoardService service = BoardServiceImpl.getInstance();
		
		//	서비스 메소드 호출
		int res = service.updateHit(num);
		
		//	결과값 request에 저장
		request.setAttribute("result", res);
		
		//	view 페에지로 이동
		request.getRequestDispatcher("/view/result.jsp").forward(request, response);
	}

}
