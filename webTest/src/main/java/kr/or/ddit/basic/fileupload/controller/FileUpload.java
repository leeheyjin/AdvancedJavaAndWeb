package kr.or.ddit.basic.fileupload.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.basic.fileupload.service.FileInfoService;
import kr.or.ddit.basic.fileupload.service.IFileInfoService;
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
		String uploadPath = "/Users/leehyejin/Project/ddit/ddit/webTest/uploadFiles";
		// 저장될 폴더가 없으면 새로 만든다.
		File file = new File(uploadPath);
		if (!file.exists()) {
			file.mkdirs();
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
			Part part2 = request.getPart("selectOne");
			fileName = extractFileName(part2);
			System.out.println(fileName);
			// 추출할 파일명이 공백("")이면 이것은 파일이 아닌 일반 파라미터라는 의미이다.
			if (!"".equals(fileName)) {
				// 한개의 파일 정보를 저장할 vo객체 생성
				FileInfoVO vo = new FileInfoVO();
				vo.setFile_writer(userName);
				vo.setOrigin_file_name(fileName);

				// 실제 저장되는 파일 이름이 중복되는 것을 방지하기 위해서 UUID클래스를 이용하여 저장할 파일명(난수+원래파일명)을 만든다.
				String saveFileName = UUID.randomUUID().toString() + fileName;
				vo.setSave_file_name(saveFileName);
				// 파일의 크기는 Part객체의 getSize()로 알 수 있고 byte단위의 값을 반환한다.
				// 파일의 크기는 kb단위로 변환해서 vo에 세팅한다
				vo.setFile_size((long) Math.ceil(part.getSize() / 1024.0));
				try {
					// upload된 파일 저장하기: part.write()
					part.write(uploadPath + File.separator + saveFileName);
					// upload된 파일 정보를 List에 추가한다.
					list.add(vo);
				} catch (Exception e) {
					// TODO: handle exception
				}
				IFileInfoService service = FileInfoService.getInstance();
				// 저장이 완료된 후 파일 목록을 보여준다.
				System.out.println(list.size());
				for (FileInfoVO fvo : list) {
					service.insert(fvo);
				}
				response.sendRedirect(request.getContextPath() + "/fileList.do");
			}
		}
	}
	
	/*
	 * Part의 구조
	 * 1. 파일이 아닌 일반 데이터인 경우
	 * --------------------dajfpoejq34u3084134ewa 	   => 각각의 파트를 구분하는 선
	 * content-disposition: form-data; name="userName" => 파라미터명(키): form태그의 name속성
	 *                                                 => 빈 줄
	 * hong											   => 파라미터값(밸류)
	 * 2. 파일일 경우
	 * --------------------dajfpoejq34u3084134ewa 								=> 각각의 파트를 구분하는 선
	 * content-disposition: form-data; name="selectOne"; filename="test1.txt"	=> 파일 정보
	 * content-type: text/plain													=> 파일의 종류
	 * 							                                                => 빈 줄
	 * abcd12345안녕하세요															=> 파일 내용
	 */
	// Part영역 안에서 fileName을 추출하는 메서드
	private String extractFileName(Part part) {
		String fileName = "";
		// Part에서 'content-disposition'의 헤더 값을 구해온다.
		String headerValue = part.getHeader("content-disposition");
		String[] items = headerValue.split(";");
		for (String item : items) {
			if (item.trim().startsWith("filename")) { // 공백 제거(trim()) 후 파일(filiename)인지 여부 검사
				fileName = item.substring(item.indexOf("=") + 2, item.length() - 1); // 파일이름 추출하기
			}
		}
		return fileName;
	}

}
