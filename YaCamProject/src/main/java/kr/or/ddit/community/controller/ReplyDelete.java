package kr.or.ddit.community.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.community.service.CommunityServiceImpl;
import kr.or.ddit.community.service.ICommunityService;

@WebServlet("/replyDelete.do")
public class ReplyDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전송시 요청 데이터 받기 - mt_no
		int mt_no = Integer.parseInt(request.getParameter("mt_no"));

		// service객체 얻기
		ICommunityService service = CommunityServiceImpl.getInstance();

		// service메소드 호출 - 결과값 받기 - int
		int res = service.deleteReply(mt_no);

		// request에 저장
		request.setAttribute("result", res);

		// view페이지로 이동
		request.getRequestDispatcher("/view/result.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
