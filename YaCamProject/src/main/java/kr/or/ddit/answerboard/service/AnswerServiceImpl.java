package kr.or.ddit.answerboard.service;

import java.util.List;

import kr.or.ddit.answerboard.dao.AnswerDaoImpl;
import kr.or.ddit.answerboard.dao.IAnswerDao;
import kr.or.ddit.answerboard.vo.AnswerVO;

public class AnswerServiceImpl implements IAnswerService {
	private static IAnswerService service;
	private IAnswerDao dao;
	
	private AnswerServiceImpl() {
		dao = AnswerDaoImpl.getInstance();
	}
	
	public static IAnswerService getInstance() {
		if(service==null) service = new AnswerServiceImpl();
		return service;
	}

	@Override
	public int insertAnswer(AnswerVO vo) {
		return dao.insertAnswer(vo);
	}

	@Override
	public List<AnswerVO> listAnswer(int queNo) {
		return dao.listAnswer(queNo);
	}

	@Override
	public int deleteAnswer(int ansNo) {
		return dao.deleteAnswer(ansNo);
	}

	@Override
	public int updateAnswer(AnswerVO vo) {
		return dao.updateAnswer(vo);
	}

}
