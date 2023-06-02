package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.vo.AddressVO;

@WebServlet("/zipSearch.do")
public class ZipSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String dong = request.getParameter("dong");
		IMemberService service = MemberService.getInstance();
		List<AddressVO> list = service.searchAddress(dong);
		request.setAttribute("searchDong", list);
		request.getRequestDispatcher("/0601/zipSearch.jsp").forward(request, response);
	}

}
