package kr.or.ddit.report.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.basic.util.MyBatisSqlSessionFactory;
import kr.or.ddit.blacklist.vo.BlackListVO;
import kr.or.ddit.report.vo.ReportVO;

public class ReportDaoImpl implements IReportDao {
	
	private static IReportDao dao;
	
	public static IReportDao getInstance() {
		if(dao==null) dao = new ReportDaoImpl();
		return dao;
	}

	@Override
	public int insertReport(ReportVO vo) {
		int res = 0;
		SqlSession sql = MyBatisSqlSessionFactory.getSqlSession();
		
		try {
			res = sql.insert("Report.insertReport", vo);
		} finally {
			sql.commit();
			sql.close();
		}
		
		return res;
	}

	@Override
	public int deleteReport(int num) {
		int res = 0;
		SqlSession sql = MyBatisSqlSessionFactory.getSqlSession();
		try {
			res = sql.delete("Report.deleteReport", num);
		} finally {
			sql.commit();
			sql.close();
		}
		return res;
	}

	@Override
	public int updateCount(int num) {
		int res = 0;
		SqlSession sql = MyBatisSqlSessionFactory.getSqlSession();
		try {
			res = sql.update("Report.updateCount", num);
		} finally {
			sql.commit();
			sql.close();
		}
		return res;
	}

	@Override
	public List<ReportVO> reportlistAll() {
		List<ReportVO> list = null;
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		
		try {
			list = session.selectList("Report.reportlistAll");
			System.out.println("여기는 DAO"+list);
			if(list != null) {session.commit();}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}

//	@Override
//	public int countReport(String memId) {
//		SqlSession sql = MyBatisSqlSessionFactory.getSqlSession();
//		int res = 0;
//		try {
//			res = sql.selectOne("Report.countReport", memId);
//		} finally {
//			sql.commit();
//			sql.close();
//		}
//				
//		return res;
//	}

}
