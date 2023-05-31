package kr.or.ddit.basic.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionDelete.do")
public class SessionDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Session정보 삭제하기

		// 1. Session객체를 생성하거나 현재 세션 구하기
		HttpSession session = request.getSession();
		// 2-1. removeAttribute()로 Session데이터 삭제하기
		// 형식. session.removeAttribute("키값");: 세션 자체는 삭제되지 않고 세션 데이터가 개별적으로 삭제됨
//		session.removeAttribute("testSession");
		// 2-2. invalidate()로 삭제하기
		// 형식. session.invalidate();: 세션 자체가 삭제된다.
		session.invalidate();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.append("<html><head><meta charset='utf-8'><title>세션연습</title>");
		writer.append("<h2>Session 데이터 삭제하기</h2><br><br>");
		writer.append("<a href='" + request.getContextPath() + "/basic/session/sessionTest.jsp'>시작문서로 이동하기</a>");
		writer.append("</body></html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
