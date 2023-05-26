package kr.or.ddit.basic.reqNresp;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/responseTest02.do")
public class ResponseTest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setAttribute("tel", "010-1010-1010");

		// redirect로 이동은 response객체의 sendRedirect()메서드를 사용한다. 이때 이동할 url주소는 <u>url경로</u>를 지정해 주어야 한다.
//		response.sendRedirect(request.getContextPath() + "/redirectTest.do");
		
		// 실행하면 null 뜨는게 맞다. 암튼 맞음.. 왠지 모름
		// 데이터를 Redirect방식으로 보내려면 GET방식으로 보낼 수 있다.
		request.setCharacterEncoding("utf-8");
		String userName = request.getParameter("userName");
		String tel = "010-1111-1111";
		
		// url경로에 한글이 포함될 경우 URLEncoder객체를 이용해 인코딩해서 지정해 주어야 한다.
		userName = URLEncoder.encode(userName, "utf-8");
		response.sendRedirect(request.getContextPath() + "/redirectTest.do?userName=" + userName + "&tel="+tel);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
