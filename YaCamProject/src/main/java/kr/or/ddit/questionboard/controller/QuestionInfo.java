package kr.or.ddit.questionboard.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.notice.service.INoticeService;
import kr.or.ddit.notice.service.NoticeServiceImpl;
import kr.or.ddit.notice.vo.NoticeVO;
import kr.or.ddit.questionboard.service.IQuestionService;
import kr.or.ddit.questionboard.service.QuestionServiceImpl;
import kr.or.ddit.questionboard.vo.QuestionVO;

@WebServlet("/questionInfo.do")
public class QuestionInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer queNo = Integer.parseInt(request.getParameter("num"));
		
		//service 객체 얻기
		IQuestionService service = QuestionServiceImpl.getInstance();
		
		//service메소드 호출하기 - 결과값 받기
		QuestionVO vo = service.selectNo(queNo);
		
		//결과값 request에 저장
		request.setAttribute("selectNo", vo);
		
		//view페이지로 이동 - json데이터형식의 문자열 데이터생성
		request.getRequestDispatcher("/view/questionInfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
