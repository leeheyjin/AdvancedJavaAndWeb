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
import kr.or.ddit.member.vo.MemberVO;

@WebServlet("/answerInsert.do")
public class AnswerInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//전송되는 값 받기 - que_no , ans_dtl, mem_id
		AnswerVO vo = new AnswerVO();
		//세션에서 로그인된 사용자의 정보를 가져옴
		MemberVO loginUser = (MemberVO)request.getSession().getAttribute("userinfo");
		//vo에 저장
		if (loginUser != null) {
		    vo.setMem_id(loginUser.getMem_id());
		}
		try {
			BeanUtils.populate(vo, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		IAnswerService service = AnswerServiceImpl.getInstance();
		
		int res = service.insertAnswer(vo);
		
		request.setAttribute("insert", vo);
		
		request.getRequestDispatcher("/view/answerinsert.jsp")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
