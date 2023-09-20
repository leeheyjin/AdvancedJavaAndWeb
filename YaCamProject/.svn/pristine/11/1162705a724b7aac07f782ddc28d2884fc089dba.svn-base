package kr.or.ddit.campinfo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.campinfo.service.CampInfoServiceImpl;
import kr.or.ddit.campinfo.service.ICampInfoService;
import kr.or.ddit.campinfo.vo.ChartCampVO;

@WebServlet("/ChatCamp.do")
public class ChatCamp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		ICampInfoService service = CampInfoServiceImpl.getInstance();
		
		List<ChartCampVO> list = null;
		list = service.chartAmount();
		System.out.println(list);
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/LMW/result/chartCampSuvlet.jsp").forward(request, response);
	
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
