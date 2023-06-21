package kr.or.ddit.board.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;

@WebServlet("/BoardUpdate.do")
public class BoardUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//	요청시 전송데이터를 받는다.
		//	udata - writer, subject, mail, password, content, num
		BoardVO vo = new BoardVO();
		
		try {
			BeanUtils.populate(vo, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		
		//	서비스 객체 얻기
		IBoardService service = BoardServiceImpl.getInstance();
		
		//	서비스 메소드 호출하기 - 결과값 받기 -> int
		int res = service.updateBoard(vo);
		
		//	결과값 request에 저장
		request.setAttribute("result", res);
		
		//	view 페이지로 이동
		request.getRequestDispatcher("/view/result.jsp").forward(request, response);
		
	}

}
