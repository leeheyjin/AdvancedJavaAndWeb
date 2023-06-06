package kr.or.ddit.basic.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.basic.service.IMemberService;
import kr.or.ddit.basic.service.MemberService;
import kr.or.ddit.basic.vo.MemberVO;

@WebServlet("/memberList.do")
public class MemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IMemberService service = MemberService.getInstance();
		List<MemberVO> selectAll = service.selectAll();
		request.setAttribute("selectAll", selectAll);
		request.getRequestDispatcher("/jsp/memberList.jsp").forward(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
