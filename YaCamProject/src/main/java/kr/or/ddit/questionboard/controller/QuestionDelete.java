package kr.or.ddit.questionboard.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.notice.service.INoticeService;
import kr.or.ddit.notice.service.NoticeServiceImpl;
import kr.or.ddit.questionboard.service.IQuestionService;
import kr.or.ddit.questionboard.service.QuestionServiceImpl;

@WebServlet("/questionDelete.do")
public class QuestionDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청시 전송데이터 받기 - num
		int num = Integer.parseInt(request.getParameter("num"));
				
		try {
			//service객체 
			IQuestionService service = QuestionServiceImpl.getInstance();
			int res = service.deleteQuestion(num);

			if(res > 0) {
				response.sendRedirect(request.getContextPath() + "/LHH/question/question.jsp");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
