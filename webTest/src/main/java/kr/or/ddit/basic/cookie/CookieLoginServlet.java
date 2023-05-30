package kr.or.ddit.basic.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookieLoginServlet.do")
public class CookieLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id"); // input태그의 name값
		String pass = request.getParameter("pass");
		String checked = request.getParameter("rememberId");
		
		Cookie idCookie = new Cookie("id", id);
		// 체크박스의 체크 여부 검사
		if (checked != null) {
			response.addCookie(idCookie);
		} else {
			idCookie.setMaxAge(0);
			response.addCookie(idCookie);
		}
		
		// 로그인 성공 여부 검사
		if ("test".equals(id) && "1234".equals(pass)) {
			response.sendRedirect(request.getContextPath() + "/basic/cookie/cookieMain.jsp");
		} else {
			response.sendRedirect(request.getContextPath() + "/basic/cookie/cookieLogin.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
