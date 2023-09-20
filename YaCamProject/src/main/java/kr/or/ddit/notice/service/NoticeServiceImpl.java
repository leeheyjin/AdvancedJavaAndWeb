package kr.or.ddit.notice.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.community.vo.MentVO;
import kr.or.ddit.community.vo.PageVO;
import kr.or.ddit.notice.dao.INoticeDao;
import kr.or.ddit.notice.dao.NoticeDaoImpl;
import kr.or.ddit.notice.vo.NoticeVO;

public class NoticeServiceImpl implements INoticeService, INoticeDao {
	private static INoticeService service;
	private INoticeDao dao;
	
	private NoticeServiceImpl() {
		dao = NoticeDaoImpl.getInstance();
	}
	
	public static INoticeService getInstance() {
		if(service==null) service = new NoticeServiceImpl();
		return service;
	}

	@Override
	public List<NoticeVO> listPerPage(Map<String, Object> map) {
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
	public int insertNotice(NoticeVO vo) {
		return dao.insertNotice(vo);
	}

	@Override
	public NoticeVO selectNo(int num) {
		return dao.selectNo(num);
	}

	@Override
	public int updateNotice(NoticeVO Vo) {
		return dao.updateNotice(Vo);
	}

	@Override
	public int deleteNotice(int num) {
		return dao.deleteNotice(num);
	}

	@Override
	public int updateHit(int num) {
		return dao.updateHit(num);
	}

}
