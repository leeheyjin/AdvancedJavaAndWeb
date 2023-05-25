package kr.or.ddit.basic.reqNresp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestTest01
 */
@WebServlet("/requestTest01.do")
public class RequestTest01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// POST방식으로 전달되는 문자 인코딩 방식 설정하기
		request.setCharacterEncoding("utf-8");
		// 클라이언트가 보낸 데이터 받기
		// 방법1: Request객체의 getParameter(각 태그의 name속성 값)
		String userName = request.getParameter("userName");
		String job = request.getParameter("job");
		String[] hobbies = request.getParameterValues("hobby");

		response.setContentType("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<meta charset='UTF-8'>");
		writer.println("<title>RequestTest01</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<p>이름: " + userName + "<br>");
		writer.println("직업: " + job + "<br>");
		if (hobbies != null) {
			for (int i = 0; i < hobbies.length; i++) {
				writer.println("취미: " + hobbies[i] + "<br>");
			}
		} else {
			System.out.println("등록된 취미가 없습니다.");
		}
		writer.println("<br></body>");
		writer.println("</html>");
		writer.println("<hr>");
		writer.println("<h2>Request객체의 메서드 결과 출력</h2>");
		writer.println("<ul>");
		writer.println("<li>클라이언트의 ip주소: " + request.getLocalAddr() + "</li>");
		writer.println("<li>요청 메서드: " + request.getMethod() + "</li>");
		writer.println("<li>Context Path: " + request.getContextPath() + "</li>");
		writer.println("<li>프로토콜: " + request.getProtocol() + "</li>");
		writer.println("<li>URL정보: " + request.getRequestURL() + "</li>");
		writer.println("<li>URI정보: " + request.getRequestURI() + "</li>");
		writer.println("</ul>");
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(request, response);
	}

}
