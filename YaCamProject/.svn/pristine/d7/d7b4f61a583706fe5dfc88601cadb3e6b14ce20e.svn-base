package kr.or.ddit.report.service;

import java.util.List;

import kr.or.ddit.report.dao.IReportDao;
import kr.or.ddit.report.dao.ReportDaoImpl;
import kr.or.ddit.report.vo.ReportVO;

public class ReportServiceImpl implements IReportService {
	private static IReportService service;
	private IReportDao dao;
	
	private ReportServiceImpl() {
		dao = ReportDaoImpl.getInstance();
	}
	
	public static IReportService getInstance() {
		if(service==null) service = new ReportServiceImpl();
		return service;
	}
	
	@Override
	public int insertReport(ReportVO vo) {
		return dao.insertReport(vo);
	}

	@Override
	public int deleteReport(int num) {
		return dao.deleteReport(num);
	}

	@Override
	public int updateCount(int num) {
		return dao.updateCount(num);
	}

	@Override
	public List<ReportVO> reportlistAll() {
		return dao.reportlistAll();
	}

}
