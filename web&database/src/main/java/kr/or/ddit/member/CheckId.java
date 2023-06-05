package kr.or.ddit.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/checkId.do")
public class CheckId extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 요청 시 전송데이터(id) 받기
		String id = request.getParameter("id");
		// service객체 얻기
		IMemberService service = MemberService.getInstance();
		// isExists메서드 호출
		String selectResult = service.isExists(id);
		request.setAttribute("isExists", selectResult);
		request.getRequestDispatcher("/0601/CheckId.jsp").forward(request, response);
	}

}
