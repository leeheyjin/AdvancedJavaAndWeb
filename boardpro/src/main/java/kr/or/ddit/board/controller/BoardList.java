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

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.PageVO;

@WebServlet("/BoardList.do")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//	1.	요청시 전송데이터 받기	-	페이지 번호, 검색시 stype, sword
		int page = Integer.parseInt(request.getParameter("page"));
		//	page -- 최초 실행시 무조건 1
		
		String stype = request.getParameter("stype");
		String sword = request.getParameter("sword");
		//	stype, sword는 최초 실행시 값은 null
		
		
		//	2.	service객체 얻기
		IBoardService service = BoardServiceImpl.getInstance();
		
		
		//	listPerPage를 호출하기 위한 준비 작업
		PageVO pvo = service.pageInfo(page, stype, sword);
		
		//	3.	service메소드 호출하기 - listPerPage 호출하기
		Map<String, Object> map = new HashMap<>();
		map.put("start", pvo.getStart());
		map.put("end", pvo.getEnd());
		map.put("stype", stype);
		map.put("sword", sword);
		
		List<BoardVO> list = service.listPerPage(map);
		
		//	4.	결과값 request에 저장하기
		request.setAttribute("list", list);
		request.setAttribute("pvo", pvo);
		
		//	5.	view페이지로 이동
		request.getRequestDispatcher("/view/list.jsp").forward(request, response);
		
	}

}
