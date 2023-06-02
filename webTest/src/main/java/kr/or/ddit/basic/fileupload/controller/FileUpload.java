package kr.or.ddit.basic.fileupload.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.basic.vo.FileInfoVO;

/*
 * 서블릿 버전 3.0이상에서는 파일 업로드를 하려면 @MultipartConfig 어노테이션을 설정해야 한다.
 * @MultipartConfig에서 설정할 변수
 * 1. location: 업로드한 파일이 임시적으로 저장될 경로(기본값: "" -> 시스템의 임시 파일 저장 위치)
 * 2. fileSizeThreshold: 여기에 지정한 값보다 큰 파일이 전송되면 location에 지정한 임시 디렉토리에 저장해놓고 처리한다.
 *    (단위: byte, 기본값: 0 -> 무조건 임시 디렉토리를 사용한다)
 * 3. maxFileSize: 한 파일의 최대 크기(단위: byte, 기본값: -1 -> 무제한)
 * 4. maxRequestSize: 서버로 전송되는 request데이터 전체의 최대 크기(모든 파일 크기 + form의 데이터)를 지정
 *    (단위: byte, 기본값: -1 -> 무제한) 
 */
@WebServlet("/fileUpload.do")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 10, 
		maxFileSize = 1024 * 30 * 1024, 
		maxRequestSize = 1024 * 1024 * 100
)
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/basic/fileupload/fileUpload.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 업로드된 파일이 저장될 폴더 설정
		String uploadPath = "/webTest/uploadFiles";
		// 저장될 폴더가 없으면 새로 만든다.
		File file = new File(uploadPath);
		if (!file.exists()) {
			file.mkdir();
		}
		// 파일이 아닌 일반 데이터는 getParameter()메서드나 getParameterValues()메서드를 이용한다.
		String userName = request.getParameter("userName");
		System.out.println(userName);
		// 수신 받은 파일 데이터 처리하기
		String fileName = "";
		// upload한 파일 목록이 저장될 List 생성
		List<FileInfoVO> list = new ArrayList<>();
		/*
		 * 서블릿 3.0이상에서 새롭게 추가된 upload관련 메서드
		 * 1. request.getParts(): 전체 Part객체를 Collection객체에 담아서 반환함
		 * 2. request.getPart("이름"): 지정된 이름(form태그 내 입력요소의 name속성)을 갖는 개별 Part객체를 반환함
		 */
		for (Part part : request.getParts()) {
			
		}
	}

}
