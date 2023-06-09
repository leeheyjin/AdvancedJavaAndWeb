package kr.or.ddit.board.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;

@WebServlet("/boardWrite.do")
public class BoardWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		// 요청시 전송 데이터 받기(fdata)
		BoardVO bvo = new BoardVO();
		try {
			BeanUtils.populate(bvo, request.getParameterMap());
		} catch (IllegalAccessException e) {
		} catch (InvocationTargetException e) {
		}
		bvo.setWip(request.getRemoteAddr());
		// service객체 받아서 메서드 호출
		IBoardService service = BoardService.getInstance();
		int writePost = service.writePost(bvo);

		// request결과값 저장
		request.setAttribute("result", writePost);

		// view페이지로 이동
		request.getRequestDispatcher("/view/result.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
