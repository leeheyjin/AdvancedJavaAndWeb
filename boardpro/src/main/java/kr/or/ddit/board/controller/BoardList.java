package kr.or.ddit.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.PageVO;

@WebServlet("/boardList.do")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		// 1. 요청시 전송 데이터 받기 - 페이지번호, 검색시 stype, sword
		int page = Integer.parseInt(request.getParameter("page")); // 최초 실행 시 무조건 1
		String stype = request.getParameter("stype"); // 최초 실행 시 값은 0
		String sword = request.getParameter("sword"); // 최초 실행 시 값은 0

		// 2. service객체 얻어서 호출하고 결과갑 받기
		IBoardService service = BoardService.getInstance();
		PageVO vo = service.pageInfo(page, stype, sword);

		// 3. 결과값 request에 저장하기

		// 4. view페이지로 이동
	}
}
