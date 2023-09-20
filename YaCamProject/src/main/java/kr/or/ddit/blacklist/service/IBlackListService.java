package kr.or.ddit.blacklist.service;

import java.util.List;

import kr.or.ddit.blacklist.vo.BlackListVO;

public interface IBlackListService {
	
	//블랙리스트 저장
	public int insertBlackList(String memId);
	
	//블릭리스트 전체 출력
	public List<BlackListVO> blacklistAll();
	
	//블랙리스트 삭제
	public int deleteBlacklist(String memId);
	
}
