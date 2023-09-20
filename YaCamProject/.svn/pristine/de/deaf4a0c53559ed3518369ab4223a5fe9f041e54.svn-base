package kr.or.ddit.event.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.community.vo.PageVO;
import kr.or.ddit.event.dao.EventDaoImpl;
import kr.or.ddit.event.dao.IEventDao;
import kr.or.ddit.event.vo.EventVO;

public class EventServiceImpl implements IEventService {
	private static IEventService service;
	private IEventDao dao;
	
	private EventServiceImpl() {
		dao = EventDaoImpl.getInstanse();
	}
	
	public static IEventService getInstance() {
		if(service==null) service = new EventServiceImpl();
		return service;
	}
	@Override
	public List<EventVO> listPerPage(Map<String, Object> map) {
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
	public EventVO selectNo(int num) {
		return dao.selectNo(num);
	}

	@Override
	public int insertEvent(EventVO vo) {
		return dao.insertEvent(vo);
	}

	@Override
	public int updateEvent(EventVO Vo) {
		return dao.updateEvent(Vo);
	}

	@Override
	public int deleteEvent(int num) {
		return dao.deleteEvent(num);
	}

}
