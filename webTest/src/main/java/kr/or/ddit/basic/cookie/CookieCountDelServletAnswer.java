package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookieCountDelServletAnswer.do")
public class CookieCountDelServletAnswer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();

		// 쿠키 삭제하기
		Cookie[] cookies = request.getCookies();
		writer.append("<html><head><meta charset='utf-8'><title>쿠키연습</title></head>");
		writer.append("<body>");
		writer.append("<h2>Count가 초기화 되었습니다.</h2>");
		if (cookies == null || cookies.length == 0) {
			writer.append("<h2>저장된 쿠키가 하나도 없습니다.</h2>");
		} else {
			// 쿠키 배열에서 삭제할 쿠키를 찾는다.
			for (Cookie cookie : cookies) {
				String name = cookie.getName();
				if ("count".equals(name)) {
					// 유지시간을 0으로 설정해 다시 추가한다
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
		}
		writer.append("<a href='" + request.getContextPath() + "/basic/cookie/cookieTest02.jsp'>시작 문서로 이동하기</a>");
		writer.append("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
