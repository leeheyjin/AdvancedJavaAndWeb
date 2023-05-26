package kr.or.ddit.basic.reqNresp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forwardTest.do")
public class ForwardTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userName = request.getParameter("userName");
		String tel = (String) request.getAttribute("tel"); // getAttribute의

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<meta charset='UTF-8'>");
		writer.println("<title>ForwardTest</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h2>Forward방식 결과</h2><hr>");
		writer.println("<table border=1>"
						+ "<tr>"
							+ "<td>이름</td>"
							+ "<td>" + userName + "</td>"
						+ "</tr>"
						+ "<tr>"
							+ "<td>전화</td>"
							+ "<td>" + tel + "</td>"
						+ "</tr>");
		writer.println("</table></body></html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
