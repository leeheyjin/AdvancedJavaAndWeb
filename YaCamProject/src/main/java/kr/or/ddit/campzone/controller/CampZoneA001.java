package kr.or.ddit.campzone.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.campinfo.vo.CampInfoVO;
import kr.or.ddit.campzone.service.CampZoneServiceImpl;
import kr.or.ddit.campzone.service.ICampZoneService;
import kr.or.ddit.campzone.vo.CampzoneVo;


@WebServlet("/CampZoneA001.do")
public class CampZoneA001 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("utf-8");
		
		String campno = request.getParameter("campno");
		String campname = request.getParameter("campname");
		
		
		Map<String, Object> map = new HashMap<>();
		map.put("campname", campname);
		map.put("campno", campno);
		System.out.println("map 입니다" + map);
		
		CampInfoVO vo = new CampInfoVO();
		
		
		ICampZoneService service = CampZoneServiceImpl.getInstance(); 	
		
		List<CampzoneVo> selectcampzone = service.selectCampZonevo(campno); // 내 캠핑장 방번호 출력
		List<CampzoneVo> list = service.getAllList(); // 모든 캠핑장의 방번호 전부 출력이라 아마 안쓸듯
		CampInfoVO campinfo = service.selectCamp(map);
		vo = service.selectCamp(map);
		
		
		request.getSession().setAttribute("campinfoVo", vo);	//
		request.getSession().setAttribute("campinfomap", map);
		
		request.setAttribute("campinfoVo2", campinfo);
		request.setAttribute("campzonelist", list);
		request.setAttribute("campzoneselectlist", selectcampzone);
		
		request.getRequestDispatcher("/ksj/selectCampDate2.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
