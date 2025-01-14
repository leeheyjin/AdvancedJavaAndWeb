package kr.or.ddit.notice.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.community.dao.CommunityDaoImpl;
import kr.or.ddit.community.dao.ICommunityDao;
import kr.or.ddit.community.vo.CommunityVO;
import kr.or.ddit.community.vo.PageVO;
import kr.or.ddit.notice.service.INoticeService;
import kr.or.ddit.notice.service.NoticeServiceImpl;
import kr.or.ddit.notice.vo.NoticeVO;

@WebServlet("/noticeList.do")
public class NoticeList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//1.요청시 전송 데이터 받기 - 페이지번호, 검색시 stype, sword
		// page = 최초 실행 시 무조건 1
		int page = Integer.parseInt(request.getParameter("page"));
		
		// stype, sword 최초 실행시 값은 null
		String stype = request.getParameter("stype");
		String sword = request.getParameter("sword");
		
		//2. service 객체 얻기
		INoticeService service = NoticeServiceImpl.getInstance();
		
		//listPerPage를 호출하기 위한 준비 작업
		PageVO pvo = service.pageInfo(page, stype, sword);
		//start, end, startPage, endPage, totalPage가 pvo객체 안에 있음
		
		//3. service 메소드 - listPerPage(map)호출하기 - 결과값 받기
		Map<String, Object> map = new HashMap<>();
		map.put("start", pvo.getStart());
		map.put("end", pvo.getEnd());
	    map.put("stype", stype);
	    map.put("sword", sword);
	    
	    List<NoticeVO> list = service.listPerPage(map);
	    
	    //4. 결과값 request에 저장하기
	    request.setAttribute("list", list);
	    request.setAttribute("pvo", pvo);
	    
	    //5. view페이지로 이동
	    request.getRequestDispatcher("/view/noticelist.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
