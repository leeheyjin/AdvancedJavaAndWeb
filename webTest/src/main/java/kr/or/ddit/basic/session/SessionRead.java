package kr.or.ddit.basic.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.basic.vo.SampleVO;

/**
 * Servlet implementation class SessionRead
 */
@WebServlet("/sessionRead.do")
public class SessionRead extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 저장된 세션 읽어오기
		// 1. Session객체를 생성하거나 현재 세션 가져오기
		HttpSession session = request.getSession();
		
		response.setContentType("text/html; charseet=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		writer.append("<html><head><meta charset='utf-8'><title>쿠키연습</title></head>");
		writer.append("<body>");
		writer.append("<h2>Session 데이터 읽어오기</h2>");
		// 2. getAttribute("key값")로 Session 데이터를 읽어온다.
		String testSession = (String) session.getAttribute("testSession");
		writer.append("testSession의 세션값: " + testSession + "<br><br>");
		String userName = (String) session.getAttribute("userName");
		writer.append("userName의 세션값: " + userName + "<br><br>");
		int age = (int) session.getAttribute("age");
		writer.append("age의 세션값: " + age + "<br><br>");
		SampleVO vo = (SampleVO) session.getAttribute("sample");
		writer.append("SampleVO의 세션값: " + vo + "<br><br>");
		writer.append("<a href='" + request.getContextPath() + "/basic/session/sessionTest.jsp'>시작문서로 이동하기</a>");
		writer.append("</body></html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
