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

@WebServlet("/DeleteUserInfo.do")
public class DeleteUserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		IMemberService service = MemberServiceImpl.getInstance();
		
		String id = (String)request.getParameter("id");
		System.out.println("이것은 테스트 : " + id);
		
		int cnt = service.deleteUserinfo(id);
		System.out.println(cnt);
		
		request.setAttribute("cnt", cnt);
		request.getRequestDispatcher("LMW/result/resultint.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		IMemberService service = MemberServiceImpl.getInstance();
		
		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO)session.getAttribute("userinfo");
		System.out.println("이것은 테스트 : " + vo);
		
		int cnt = service.deleteUserinfo(vo.getMem_id());
		System.out.println(cnt);
		
		request.setAttribute("cnt", cnt);
		
		request.getRequestDispatcher("LMW/mypage/updateinfoServlet.jsp").forward(request, response);
	}

}
