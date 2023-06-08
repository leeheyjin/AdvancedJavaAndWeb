package kr.or.ddit.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDAO;
import kr.or.ddit.board.dao.IBoardDAO;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.PageVO;

public class BoardService implements IBoardService {
	private static IBoardService service;
	private IBoardDAO dao;

	private BoardService() {
		dao = BoardDAO.getInstance();
	}

	public static IBoardService getInstance() {
		if (service == null) {
			service = new BoardService();
		}
		return service;
	}

	@Override
	public List<BoardVO> listPerPage(Map<String, Object> map) {
		return dao.listPerPage(map);
	}

	@Override
	public int totalCount(Map<String, Object> map) {
		return dao.totalCount(map);
	}

	@Override
	public PageVO pageInfo(int page, String stype, String sword) { // db작업이 아니기 대문에 dao에 정의하지 않음
		// 전체 글 개수 구하기
		Map<String, Object> map = new HashMap<>();
		map.put("stype", stype);
		map.put("sword", sword);
		int count = this.totalCount(map);

		// 전체 페이지수 구하기
		int perList = PageVO.getPerList();
		int totalPage = (int) Math.ceil((double) count / perList);

		// 현재 페이지에 글번호 정의
		int start = (page - 1) * perList + 1; // 7페이지 첫 글 번호 19
		int end = start + perList - 1; // 7페이지 마지막 글 번호 21
		if (end > count) {
			end = count;
		}
		// startPage, endPage
		int perPage = PageVO.getPerPage();
		int startPage = ((page - 1) / perPage * perPage) + 1;
		int endPage = startPage + perPage - 1;
		if(endPage > totalPage) {
			endPage = totalPage;
		}
		
		System.out.println("start: " +  start);
		System.out.println("end: " +  end);
		System.out.println("startPage: " +  startPage);
		System.out.println("endPage: " +  endPage);
		System.out.println("totalPage: " +  totalPage);
		
		PageVO vo = new PageVO();
		vo.setStart(start);
		vo.setEnd(end);
		vo.setStartPage(startPage);
		vo.setEndPage(endPage);
		vo.setTotalPage(totalPage);

		return vo; 
	}

}
