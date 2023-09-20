package kr.or.ddit.community.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.community.service.CommunityServiceImpl;
import kr.or.ddit.community.service.ICommunityService;
import kr.or.ddit.community.vo.MentVO;
import kr.or.ddit.member.vo.MemberVO;

@WebServlet("/replyInsert.do")
public class ReplyInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//전송되는 값 받기 - comm_no , mt_dtl, mem_id
		MentVO vo = new MentVO();
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
		
		ICommunityService service = CommunityServiceImpl.getInstance();
		
		int res = service.insertReply(vo);
		
		request.setAttribute("insert", vo);
		
		request.getRequestDispatcher("/view/communityinsert.jsp")
		.forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
