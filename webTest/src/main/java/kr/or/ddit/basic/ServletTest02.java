package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 이 예제는 어노테이션(@WebServlet)을 이용해 Servlet을 설정하여 처리하는 예제
// 어노테이션은 Servlet버전 3.0이상부터 사용할 수 있다.
/*
 * @WebServlet의 속성들
 * 1. name: 서블릿의 이름을 설정한다.(기본값: 빈문자열(""))
 * 2. urlPatterns: 서블릿의 url패턴의 목록을 설정한다. 
 * 		ex) urlPatterns="/url1" 또는 urlPatterns={"/url1"}: 패턴이 하나일 때
 * 			urlPatterns={"/url1", "/url2", ...}: 패턴이 두 개 이상일 때
 * 3. value: urlPatterns속성과 기능이 같다.
 * 4. decription: 주석(설명글)을 설정 
 */

@WebServlet(urlPatterns = { "/servletTest02.do" }, description = "어노테이션을 이용한 서블릿 설정 연습")
public class ServletTest02 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 처리한 내용을 응답으로 보내기
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		// 출력용 스트림 객체 구하기
		PrintWriter writer = response.getWriter();
		
		// 내용 출력하기
		// 방법2) print() 또는 println()
		writer.append("<html>");
		writer.append("<head>");
		writer.append("<meta charset='utf-8'>");
		writer.append("<title>첫번째 Servlet</title>");
		writer.append("</head>");
		writer.append("<body style='text-align: center;'>");
//		writer.append("<h2>이것은 두번째 서블릿 예제입니다.<br>@WebServlet을 사용했답니다<br>하하! 하하! 하하! 하하!</h2>");
		writer.append("</body></html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	// 처리한 내용 출력하기
	
}
