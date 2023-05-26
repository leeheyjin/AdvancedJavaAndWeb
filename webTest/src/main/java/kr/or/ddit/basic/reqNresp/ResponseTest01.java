package kr.or.ddit.basic.reqNresp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/responseTest01.do")
public class ResponseTest01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("tel", "010-1010-1010");
		// forward방식으로 다른 문서로 이동하기
		// HttpServletRequest객체의 getRequestDispatcher()에 이동할 서블릿이나 JSP를 지정한다. 전체 URI경로 중 ContextPath이후를 지정해준다
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/forwardTest.do");
		requestDispatcher.forward(request, response); // forwarding 작업 수행 메서드(이때 request객체와 response객체를 인수값으로 입력한다.)
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
