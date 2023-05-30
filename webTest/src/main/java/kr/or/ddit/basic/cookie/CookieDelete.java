package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 쿠키 정보를 삭제하는 서블릿
@WebServlet("/cookieDelete.do")
public class CookieDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		
		// 저장된 쿠키 삭제하기
		// 1. 쿠키 데이터의 삭제는 쿠키의 유지시간을 0으로 설정하는 방법을 사용한다.
		//	  쿠키의 유지시간은 쿠키를 저장하는 addCookie()메서드를 호출하기 전에 해당 쿠키 객체의 setMaxAge()메서드를 사용해서 설정한다.: 
		//    cookie.setMaxAge(0);: 시간이 0이면 쿠키가 바로 삭제되고, 시간이 음수면 웹브라우저가 종료될 때 쿠키가 삭제된다.
		
		// gender쿠키 삭제하기
		Cookie[] cookies = request.getCookies();
		writer.append("<html><head><meta charset='utf-8'><title>쿠키연습</title></head>");
		writer.append("<body>");
		writer.append("<h2>저장된 쿠키 데이터 삭제하기</h2>");
		if (cookies == null || cookies.length == 0) {
			writer.append("<h2>저장된 쿠키가 하나도 없습니다.</h2>");
		} else {
			// 쿠키 배열에서 삭제할 쿠키를 찾는다.
			for (Cookie cookie : cookies) {
				String name = cookie.getName();
				if ("gender".equals(name)) {
					// 유지시간을 0으로 설정해 다시 추가한다
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				} 
			}
		}
		writer.append("<a href='" + request.getContextPath() +"/basic/cookie/cookieTest01.jsp'>시작 문서로 이동하기</a>");
		writer.append("</body></html>");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
