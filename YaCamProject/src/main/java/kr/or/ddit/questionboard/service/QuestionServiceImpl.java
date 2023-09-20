package kr.or.ddit.questionboard.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.community.service.ICommunityService;
import kr.or.ddit.community.vo.PageVO;
import kr.or.ddit.questionboard.dao.IQuestionDao;
import kr.or.ddit.questionboard.dao.QuestionDaoImpl;
import kr.or.ddit.questionboard.vo.QuestionVO;

public class QuestionServiceImpl implements IQuestionService {
	private static IQuestionService service;
	private IQuestionDao dao;
	
	private QuestionServiceImpl() {
		dao = QuestionDaoImpl.getInstance();
	}
	
	public static IQuestionService getInstance() {
		if(service == null) service = new QuestionServiceImpl();
		return service;
	}
	@Override
	public List<QuestionVO> listPerPage(Map<String, Object> map) {
		return dao.listPerPage(map);
	}

	@Override
	public PageVO pageInfo(int page, String stype, String sword) {
		return dao.pageInfo(page, stype, sword);
	}

	@Override
	public int totalCount(Map<String, Object> map) {
		return dao.totalCount(map);
	}

	@Override
	public QuestionVO selectNo(int num) {
		return dao.selectNo(num);
	}

	@Override
	public int insertQeustion(QuestionVO vo) {
		return dao.insertQeustion(vo);
	}

	@Override
	public int deleteQuestion(int num) {
		return dao.deleteQuestion(num);
	}

	@Override
	public int updateQuestion(QuestionVO Vo) {
		return dao.updateQuestion(Vo);
	}

}
