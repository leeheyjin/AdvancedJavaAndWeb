package kr.or.ddit.blacklist.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.blacklist.service.BlackListServiceImpl;
import kr.or.ddit.blacklist.service.IBlackListService;
import kr.or.ddit.blacklist.vo.BlackListVO;

@WebServlet("/selectBlackList.do")
public class selectBlackList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		IBlackListService service = BlackListServiceImpl.getInstance();
		
		List<BlackListVO> list = service.blacklistAll();
		System.out.println(list);
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/LMW/manager/blacklist.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
