package kr.or.ddit.blacklist.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.basic.util.MyBatisSqlSessionFactory;
import kr.or.ddit.blacklist.vo.BlackListVO;

public class BlackListDAOImpl implements IBlackListDAO{
	private static IBlackListDAO dao;
	
	public static IBlackListDAO getInstance() {
		return dao = new BlackListDAOImpl();
	}
	
	private BlackListDAOImpl() {}

	@Override
	public int insertBlackList(String memId) {
		int cnt = 0;
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		
		try {
			cnt = session.insert("black.insertBlackList",memId);
			if(cnt>0) {session.commit();}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public List<BlackListVO> blacklistAll() {
		List<BlackListVO> list = null;
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		
		try {
			list = session.selectList("black.blacklistAll");
			System.out.println("여기는 DAO"+list);
			if(list != null) {session.commit();}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}

	@Override
	public int deleteBlacklist(String memId) {
		int cnt = 0;
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		
		try {
			cnt = session.delete("black.deleteBlacklist",memId);
			if(cnt>0) {session.commit();}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return cnt;
	}
}
