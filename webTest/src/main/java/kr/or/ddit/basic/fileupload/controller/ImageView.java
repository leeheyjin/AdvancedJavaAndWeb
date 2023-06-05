package kr.or.ddit.basic.fileupload.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.basic.fileupload.service.FileInfoService;
import kr.or.ddit.basic.fileupload.service.IFileInfoService;
import kr.or.ddit.basic.vo.FileInfoVO;

@WebServlet("/images/imageView.do")
public class ImageView extends HttpServlet {
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
		String imagePath = uploadPath + File.separator + vo.getSave_file_name();
		File imageFile = new File(imagePath);
		if (imageFile.exists()) {
			// 파일 입출력을 진앵한다.
			BufferedInputStream bin = null;
			BufferedOutputStream bout = null;
			try {
				// 출력용 스트림 객체 생성(클라이언트로 전송할 스트림): response객체 이용
				bout = new BufferedOutputStream(response.getOutputStream());
				// 파일 입력용 스트림 객체 생성
				bin = new BufferedInputStream(new FileInputStream(imageFile));
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
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
