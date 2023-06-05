package kr.or.ddit.basic.fileupload.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.management.RuntimeErrorException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.basic.fileupload.service.FileInfoService;
import kr.or.ddit.basic.fileupload.service.IFileInfoService;
import kr.or.ddit.basic.vo.FileInfoVO;

@WebServlet("/fileDownload.do")
public class FileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		// 파라미터로 넘어온 파일 번호를 구한다.
		int fileNo = Integer.parseInt(request.getParameter("fileno"));
		// 파일 번호를 이용해 해달 파일 정보를 db에서 가져온다.
		IFileInfoService service = FileInfoService.getInstance();
		FileInfoVO vo = service.getOne(fileNo);

		// 파일이 저장될 폴더 설정
		String uploadPath = "/Users/leehyejin/Project/ddit/ddit/webTest/uploadFiles";
		// 저장될 폴더가 없으면 새로 만든다.
		File file = new File(uploadPath);
		if (!file.exists()) {
			file.mkdirs();
		}
		response.setCharacterEncoding("utf-8");

		// 다운 받을 파일명(저장된 파일명)을 이용한 File객체 생성
		File downloadFile = new File(uploadPath, vo.getSave_file_name());
		if (downloadFile.exists()) { // 해당 파일 있을 유
			// contentType설정
			response.setContentType("application/octet-stream; charset=utf-8");
			// Response객체의 Header에 content-disposition속성을 설정한다.
			String headerKey = "content-disposition";
			// content-disposition헤더값으로 다운 받을 파일명을 원래의 파일명으로 지정해준다.
//			String headerValue = "attachment; filename=\"" + vo.getOrigin_file_name() + "\";";
			String headerValue = "attachment;" + getEncodedFileName(request, vo.getOrigin_file_name());
			response.setHeader(headerKey, headerValue);

			// 파일 입출력을 진앵한다.
			BufferedInputStream bin = null;
			BufferedOutputStream bout = null;
			try {
				// 출력용 스트림 객체 생성(클라이언트로 전송할 스트림): response객체 이용
				bout = new BufferedOutputStream(response.getOutputStream());
				// 파일 입력용 스트림 객체 생성
				bin = new BufferedInputStream(new FileInputStream(downloadFile));
				byte[] temp = new byte[1024];
				int len = 0;
				while ((len = bin.read(temp)) > 0) {
					bout.write(temp, 0, len);
				}
				bout.flush();
			} catch (IOException e) {
				e.getMessage();
			} finally {
				if (bin != null) {
					bin.close();
				}
				if (bout != null) {
					bout.close();
				}
			}
		} else { // 해당 파일 없을 무
			response.setContentType("text/html; charset=utf-8");
			response.getWriter().println("<h3>" + vo.getOrigin_file_name() + "파일이 존재하지 않습니다.</h3>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	// 다운로드할 파일명에 한글이 포함될 경우 한글이 깨지는 것을 방지하는 메서드
	private String getEncodedFileName(HttpServletRequest request, String fileName) {
		String encodedFileName = "";
		// 브라우저 종류별로 처리하기
		String userAgent = request.getHeader("user-agent");
		try {
			// IE 10버전 이하의 웹브라우저 처리
			if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {
				encodedFileName = "filename=\"" + URLEncoder.encode(fileName, "utf-8").replaceAll("\\+", "\\ ") + "\"";
			} else {
				encodedFileName = "filename*=UTF-8''" + URLEncoder.encode(fileName, "utf-8").replaceAll("\\+", "%20");
			}
		} catch (Exception e) {
			
		}
		return encodedFileName;
	}

}
