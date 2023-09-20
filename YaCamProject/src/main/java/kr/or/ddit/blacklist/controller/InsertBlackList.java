package kr.or.ddit.blacklist.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.blacklist.service.BlackListServiceImpl;
import kr.or.ddit.blacklist.service.IBlackListService;

/**
 * Servlet implementation class InsertBlackList
 */
@WebServlet("/InsertBlackList.do")
public class InsertBlackList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		System.out.println(id);
		IBlackListService service = BlackListServiceImpl.getInstance();
		
		int cnt = service.insertBlackList(id);
		
		request.setAttribute("cnt", cnt);
		
		request.getRequestDispatcher("/LMW/result/resultint.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		System.out.println(id);
		IBlackListService service = BlackListServiceImpl.getInstance();
		
		int cnt = service.deleteBlacklist(id);
		
		request.setAttribute("cnt", cnt);
		
		request.getRequestDispatcher("/LMW/result/resultint.jsp").forward(request, response);
		
	}

}
