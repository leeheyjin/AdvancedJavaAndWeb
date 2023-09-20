package kr.or.ddit.answerboard.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.answerboard.service.AnswerServiceImpl;
import kr.or.ddit.answerboard.service.IAnswerService;
import kr.or.ddit.answerboard.vo.AnswerVO;

@WebServlet("/answerList.do")
public class AnswerList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//전송 데이터 받기 - que_no
		int queNo = Integer.parseInt(request.getParameter("queNo"));
		
		System.out.println("reply que_no ="  + queNo );
		//service 객체 얻기
		IAnswerService service = AnswerServiceImpl.getInstance();
				
		//service메소드 호출 - 결과값 받기
		List<AnswerVO> list = service.listAnswer(queNo);
				
		//request에 결과값 저장
		request.setAttribute("list", list);
				
		//view페이지로 이동
		request.getRequestDispatcher("/view/answerList.jsp")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
