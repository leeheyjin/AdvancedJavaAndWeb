package kr.or.ddit.report.dao;

import java.util.List;

import kr.or.ddit.report.vo.ReportVO;

public interface IReportDao {
	//신고하기 - 저장
	public int insertReport(ReportVO vo);
	
	//신고 삭제하기
	public int deleteReport(int num);
	
	//신고횟수 증가하기
	public int updateCount(int num);
	
	//신고내역 불러오기
	public List<ReportVO> reportlistAll();
}
