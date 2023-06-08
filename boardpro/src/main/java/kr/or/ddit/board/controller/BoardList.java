package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;
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
		PageVO pvo = service.pageInfo(page, stype, sword);

		// 3. service메서드 - listPerPage(map)호출 후 결과값 받기
		Map<String, Object> map = new HashMap<>();
		map.put("start", pvo.getStart());
		map.put("end", pvo.getEnd());
		map.put("stype", stype);
		map.put("sword", sword);

		List<BoardVO> list = service.listPerPage(map);
		// 4. 결과값 request에 저장하기
		request.setAttribute("list", list);
		request.setAttribute("pvo", pvo);

		// 5. view페이지로 이동
		request.getRequestDispatcher("/view/list.jsp").forward(request, response);
	}
}
