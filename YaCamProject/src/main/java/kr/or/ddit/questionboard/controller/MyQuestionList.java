package kr.or.ddit.questionboard.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.community.vo.PageVO;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.questionboard.service.IQuestionService;
import kr.or.ddit.questionboard.service.QuestionServiceImpl;
import kr.or.ddit.questionboard.vo.QuestionVO;


@WebServlet("/MyQuestionList.do")
public class MyQuestionList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//1.요청시 전송 데이터 받기 - 페이지번호, 검색시 stype, sword
//		 page = 최초 실행 시 무조건 1
		int page = Integer.parseInt(request.getParameter("page"));
		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO)session.getAttribute("userinfo");
		
		// stype, sword 최초 실행시 값은 null
		String stype = request.getParameter("stype");
		String sword = request.getParameter("sword");
		
		//2. service 객체 얻기
		IQuestionService service = QuestionServiceImpl.getInstance();
		
		//listPerPage를 호출하기 위한 준비 작업
		PageVO pvo = service.pageInfo(page, stype, sword);
		//start, end, startPage, endPage, totalPage가 pvo객체 안에 있음
		System.out.println("이것은 pvo입니다" + pvo);
		
		//3. service 메소드 - listPerPage(map)호출하기 - 결과값 받기
		Map<String, Object> map = new HashMap<>();
		map.put("start", pvo.getStart());
		map.put("end", pvo.getEnd());
	    map.put("stype", stype);
	    map.put("sword", sword);
	    System.out.println("에스타입 :" + stype);
	    System.out.println("에스word :" + sword);
	    
	    List<QuestionVO> list = service.listPerPage(map);
	    System.out.println("이것은 list입니다" + list);
	    List<QuestionVO> mylist = new ArrayList<>();
	    
	    
		for (QuestionVO myvo : list) {
			if (vo.getMem_id().equals(myvo.getMem_id())) {
				mylist.add(myvo);
			}
		}
	    
	    
	    //4. 결과값 request에 저장하기
	    request.setAttribute("list", mylist);
	    request.setAttribute("pvo", pvo);
	    
	    //5. view페이지로 이동
	    request.getRequestDispatcher("/view/questionlist.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
