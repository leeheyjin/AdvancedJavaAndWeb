package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookieRead.do")
public class CookieRead extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 저장된 쿠키 읽어오기
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		// 1. 전체 쿠키 정보를 Request객체를 통해 가져온다. 이떄 가져온 쿠키 정보들은 배열에 저장한다.
		Cookie[] cookies = request.getCookies();

		PrintWriter writer = response.getWriter();
		writer.append("<html><head><meta charset='utf-8'><title>쿠키연습</title></head>");
		writer.append("<body>");
		writer.append("<h2>저장된 쿠키 데이터 확인하기</h2>");
		if (cookies == null || cookies.length == 0) {
			writer.append("<h2>저장된 쿠키가 하나도 없습니다.</h2>");
		} else {
			// 2. 쿠키 배열에서 해당 쿠키 정보를 구해온다.
			for (Cookie cookie : cookies) {
				String name = cookie.getName(); // 쿠키 이름 가져오기
				String value = cookie.getValue(); // 해당 이름의 값 가져오기
				value = URLDecoder.decode(value, "utf-8");
				writer.append("쿠키 이름: " + name + "<br>");
				writer.append("쿠키값: " + value + "<hr>");
			}
		}
		writer.append("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
