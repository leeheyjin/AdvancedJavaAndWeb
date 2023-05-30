package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieCountServlet
 */
@WebServlet("/cookieCountServlet.do")
public class CookieCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count = 1;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		Cookie countCookie = new Cookie("count", String.valueOf(count));
		response.addCookie(countCookie);

		Cookie[] cookies = request.getCookies();

		PrintWriter writer = response.getWriter();
		writer.append("<html><head><meta charset='utf-8'><title>쿠키연습</title></head>");
		writer.append("<body>");
		if (cookies == null || cookies.length == 0) {
			System.out.println("저장된 쿠키가 없습니다.");
		} else {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("count")) {
					writer.append("<h2>어서오세요. 당신은 " + count++ + "번째 방문입니다.<h2>");
					writer.append("<a href='" + request.getContextPath() + "/cookieCountServlet.do'>카운트 증가하기</a> ");
					writer.append("<a href='" + request.getContextPath() + "/basic/cookie/cookieTest02.jsp'>시작 문서로 이동하기</a>");
					writer.append("</body></html>");
				}
			}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
