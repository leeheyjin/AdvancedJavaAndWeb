package kr.or.ddit.basic.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.basic.vo.SampleVO;

@WebServlet("/sessionAdd.do")
public class SessionAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Session 정보를 저장하는 방법
		// 1. Session객체를 생성하거나 현재의 Session가져오기
		// 형식1. request.getSession(); 또는 request.getSession(true);: 현재 세션이 존재하면 현재 세션을
		// 반환하고, 존재하지 않으면 새로운 세션을 생성한다(보통)
		// 형식2. request.getSession(false);: 현재 세션이 존재하면현재 세션을 반환하고 존재하지 않으면 새로운 세션을 생성하지
		// 않고 null을 반환한다.
		HttpSession session = request.getSession();

		// 2. setAttribute()메서드로 Session값을 저장한다
		// 형식. session.setAttribute("key값", 저장할 데이터값);
		session.setAttribute("testSession", "연습용 세션 데이터입니다.");
		session.setAttribute("userName", "홍길동");
		session.setAttribute("age", 26); // Cookie랑 다르게 숫자값 데이터로 저장 가능
		SampleVO vo = new SampleVO();
		vo.setName("이순신");
		vo.setNum(1);
		session.setAttribute("sample", vo);

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.append("<html><head><meta charset='utf-8'><title>쿠키연습</title></head>");
		writer.append("<body>");
		writer.append("<h2>Session 데이터 저장하기</h2>");
		writer.append("<a href='" + request.getContextPath() + "/basic/session/sessionTest.jsp'>시작문서로 이동하기</a>");
		writer.append("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
