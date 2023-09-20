package kr.or.ddit.report.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.report.service.IReportService;
import kr.or.ddit.report.service.ReportServiceImpl;
import kr.or.ddit.report.vo.ReportVO;

@WebServlet("/reportInsert.do")
public class ReportInsert extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        // 전송시 데이터 받기
        String repReason = request.getParameter("optradio");
        String ansDtl = request.getParameter("text");
        String memId = request.getParameter("mem_id");
        int commNo = Integer.parseInt(request.getParameter("comm_no"));

        // vo에 저장
        ReportVO vo = new ReportVO();
        vo.setComm_no(commNo);
        vo.setRep_reason(repReason);
        vo.setRep_dtl(ansDtl);
        vo.setMem_id(memId);

        System.out.println("들고온 commNo값 : " + commNo);
        System.out.println("Reportvo객체에 담겨있는 값 : " + "COMM_NO:" + vo.getComm_no() + ", " 
                + "REP_REASON:" + vo.getRep_reason() + ", " + "MEM_ID:" + vo.getMem_id() + ", "
                +  "REP_DTL" + vo.getRep_dtl() + ", " +  "REP_ACTION:" +vo.getRep_action());

        // member Service 객체 가져오기
        IMemberService memService = MemberServiceImpl.getInstance();

        int count = memService.countReport(memId);
        System.out.println("memberVo에 count 값 : " + count);

        IReportService service = ReportServiceImpl.getInstance();

        int res = service.insertReport(vo);
        request.setAttribute("result", vo);
//        request.getRequestDispatcher("/view/result.jsp").forward(request, response);

        String closeScript = "<script>window.close();</script>";
        response.getWriter().write(closeScript);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
