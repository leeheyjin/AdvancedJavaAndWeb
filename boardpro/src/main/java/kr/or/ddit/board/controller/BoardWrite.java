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

@WebServlet("/BoardWrite.do")
public class BoardWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//	요청시 전송데이터 받기 - fdata - writer, subject, mail, password, content
		BoardVO vo = new BoardVO();
		try {
			BeanUtils.populate(vo, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		vo.setWip(request.getRemoteAddr());
		//	service 객체 받기
		IBoardService service = BoardServiceImpl.getInstance();
		
		//	service 메소드 호출 - 결과값 얻기
		int res = service.insertBoard(vo);
		
		//	request 결과값 저장
		request.setAttribute("result", res);
		
		//	view 페이지로 이동
		request.getRequestDispatcher("/view/result.jsp").forward(request, response);
	}

}
