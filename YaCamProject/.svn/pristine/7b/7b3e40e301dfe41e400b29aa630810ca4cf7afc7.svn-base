package kr.or.ddit.answerboard.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.answerboard.service.AnswerServiceImpl;
import kr.or.ddit.answerboard.service.IAnswerService;
import kr.or.ddit.answerboard.vo.AnswerVO;

@WebServlet("/answerUpdate.do")
public class AnswerUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//전송시 요청데이터 받기 - reply객체 -> mt_dtl, mt_no
		AnswerVO vo = new AnswerVO();
		try {
			BeanUtils.populate(vo, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		//serivce 객체 얻기
		IAnswerService service = AnswerServiceImpl.getInstance();
		
		//service 메소드 호출 - 결과값받기 int
		int res = service.updateAnswer(vo);
		
		//request에 저장
		request.setAttribute("result", res);
		
		//view페이지 이동
		request.getRequestDispatcher("/view/result.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
