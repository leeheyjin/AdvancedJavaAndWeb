package kr.or.ddit.blacklist.service;

import java.util.List;

import kr.or.ddit.blacklist.dao.BlackListDAOImpl;
import kr.or.ddit.blacklist.dao.IBlackListDAO;
import kr.or.ddit.blacklist.vo.BlackListVO;

public class BlackListServiceImpl implements IBlackListService{
	private IBlackListDAO dao;
	
	private static IBlackListService service;
	
	public static IBlackListService getInstance() {
		return service = new BlackListServiceImpl();
	}
	public BlackListServiceImpl() {
		dao= BlackListDAOImpl.getInstance();
		
	}
	@Override
	public int insertBlackList(String memId) {
		// TODO Auto-generated method stub
		return dao.insertBlackList(memId);
	}
	@Override
	public List<BlackListVO> blacklistAll() {
		// TODO Auto-generated method stub
		return dao.blacklistAll();
	}
	@Override
	public int deleteBlacklist(String memId) {
		// TODO Auto-generated method stub
		return dao.deleteBlacklist(memId);
	}
	
	
	
	
}
