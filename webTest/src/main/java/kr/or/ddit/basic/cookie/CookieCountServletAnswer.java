package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookieCountServletAnswer.do")
public class CookieCountServletAnswer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		PrintWriter writer = response.getWriter(); // name=count인 쿠카가 있는지 검사
		Cookie[] cookies = request.getCookies();
		int count = 0;
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				// count라는 쿠키가 있늦지 검사한다.
				if ("count".equals(cookie.getName())) {
					String value = cookie.getValue();
					count = Integer.parseInt(value);
				}
			}
		}
		count++;

		// 증가된 카운트값을 갖는 Cookie객체 생성
		Cookie countCookie = new Cookie("count", String.valueOf(count));
		response.addCookie(countCookie);
		writer.append("<html><head><meta charset='utf-8'><title>쿠키연습</title></head>");
		writer.append("<body>");
		writer.append("<h2>어서오세요. 당신은 " + count + "번째 방문입니다.</h2>");
		writer.append("<a href='" + request.getContextPath() + "/cookieCountServletAnswer.do'>카운트 증가하기</a> ");
		writer.append("<a href='" + request.getContextPath() + "/basic/cookie/cookieTest02.jsp'>시작 문서로 이동하기</a>");
		writer.append("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
