package kr.or.ddit.event.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.event.service.EventServiceImpl;
import kr.or.ddit.event.service.IEventService;
import kr.or.ddit.event.vo.EventVO;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.notice.service.INoticeService;
import kr.or.ddit.notice.service.NoticeServiceImpl;
import kr.or.ddit.notice.vo.NoticeVO;

@WebServlet("/eventUpdate.do")
@MultipartConfig
public class EventUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

        try {
            int entNo = Integer.parseInt(request.getParameter("entNo"));

            IEventService service = EventServiceImpl.getInstance();
            EventVO vo = service.selectNo(entNo);

            request.setAttribute("entVo", vo);
            request.getRequestDispatcher("/LHH/event/EventUpdate.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            // EntNo가 올바르지 않은 형식이면 적절한 예외 처리를 수행한다.
            // 예를 들어, 에러 페이지로 이동하거나 다른 처리를 수행할 수 있다.
            response.sendError(HttpServletResponse.SC_BAD_REQUEST,"Invalid entNo parameter");
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        // POST방식으로 요청할 때는 수정한 회원 정보를 받아서 프로필 사진을 저장하고
        // DB의 회원 정보를 수정한다.

        // 사용자가 업로드한 파일이 저장될 서버쪽의 폴더 경로 설정
        String uploadPath = "d:/d_other/community/uploadFiles";

        // 저장될 폴더가 없으면 폴더를 만들어 준다.
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        // 회원 정보를 받는다.
        String entType = request.getParameter("type");
        String entTtl = request.getParameter("ttl");
        String entDtl = request.getParameter("dtl");
        int entNo = Integer.parseInt(request.getParameter("ent_no"));
        String startDate = request.getParameter("start");
        String endDate = request.getParameter("end");

        // 받아온 회원 정보를 VO에 저장한다.
        EventVO vo = new EventVO();
        vo.setEnt_type(entType);
        vo.setEnt_ttl(entTtl);
        vo.setEnt_dtl(entDtl);
        vo.setEnt_no(entNo);
        vo.setEnt_start(startDate);
        vo.setEnt_end(endDate);
        
        System.out.println("vo값 들어갔는지 확인 : " + vo.getEnt_type() + vo.getEnt_ttl() + vo.getEnt_dtl() +
        		vo.getEnt_start() + vo.getEnt_end());
        
        // form의 file입력요소의 name값은 Part객체의 이름역할을 한다.
        // 이 이름을 이용하여 Part객체를 구한다.
        Part part = request.getPart("file");

        if (part != null) {
            String fileName = extractFilename(part);

            if (!"".equals(fileName)) {
                try {
                    part.write(uploadPath + File.separator + fileName);

                    vo.setEnt_file(fileName);  // DB에 저장할 파일명을 VO객체에 저장
                } catch (Exception e) {
                    vo.setEnt_file(null);  // 프로필 사진 저장 오류 처리
                }
            }
        }

        // 회원 정보를 DB에 update한다.
        IEventService service = EventServiceImpl.getInstance();
        service.updateEvent(vo);

        // 작업이 완료되면 List 페이지로 이동
//        response.sendRedirect(request.getContextPath() + "/LHH/board.jsp");
        response.sendRedirect(request.getContextPath() + "/eventInfo.do?num=" + vo.getEnt_no());
    }

    // Part 구조 안에서 파일명을 찾는 메서드
    private String extractFilename(Part part) {
        String fileName = "";

        String contentDisposition = part.getHeader("content-disposition");
        String[] items = contentDisposition.split(";");
        for (String item : items) {
            if (item.trim().startsWith("filename")) {
                // filename="test1.txt"
                fileName = item.substring(item.indexOf("=") + 2, item.length() - 1);
            }
        }

        return fileName;
    }
}
