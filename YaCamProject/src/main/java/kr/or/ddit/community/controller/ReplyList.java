package kr.or.ddit.community.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.community.service.CommunityServiceImpl;
import kr.or.ddit.community.service.ICommunityService;
import kr.or.ddit.community.vo.MentVO;

@WebServlet("/replyList.do")
public class ReplyList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//전송 데이터 받기 - bonum
		int commNo = Integer.parseInt(request.getParameter("commNo"));
		
		System.out.println("reply bonum ="  + commNo );
		//service 객체 얻기
		ICommunityService service = CommunityServiceImpl.getInstance();
				
		//service메소드 호출 - 결과값 받기
		List<MentVO> list = service.listReply(commNo);
				
		//request에 결과값 저장
		request.setAttribute("list", list);
				
		//view페이지로 이동
		request.getRequestDispatcher("/view/replyList.jsp")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
