package kr.or.ddit.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

@WebServlet("/Login.do")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String userId = request.getParameter("id");
		String userPass = request.getParameter("pass");
		MemberVO vo = new MemberVO();
		vo.setMem_id(userId);
		vo.setMem_pass(userPass);
		System.out.println(vo);
		
		// 1. Session객체를 생성하거나 현재 세션 가져오기
		HttpSession session = request.getSession();
		
		MemberVO userinfo = null;
		IMemberService service = MemberServiceImpl.getInstance();
		userinfo = service.selectmemberlogin(vo);
		System.out.println("테스트");
		System.out.println("테스트" + userinfo);
		//세션 저장
		if(userinfo != null && userinfo.getMem_delete().equals("N")) {//로그인 성공
			//리퀘스트 저장
			request.setAttribute("vo", userinfo);
			//세션 저장
			session.setAttribute("userinfo", userinfo);
			
//			response.sendRedirect(request.getContextPath() 
//									+ "/Main_KKD/mainpage.jsp");
		}
		request.getRequestDispatcher("/pbc/login/servletsign.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


}
