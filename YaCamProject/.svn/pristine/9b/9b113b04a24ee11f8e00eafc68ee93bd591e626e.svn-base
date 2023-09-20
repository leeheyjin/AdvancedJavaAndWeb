package kr.or.ddit.questionboard.controller;

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

import kr.or.ddit.notice.service.INoticeService;
import kr.or.ddit.notice.service.NoticeServiceImpl;
import kr.or.ddit.notice.vo.NoticeVO;
import kr.or.ddit.questionboard.service.IQuestionService;
import kr.or.ddit.questionboard.service.QuestionServiceImpl;
import kr.or.ddit.questionboard.vo.QuestionVO;

@WebServlet("/questionImageView.do")
public class QuestionImageView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("utf-8");
		
		//파라미터로 넘어온 게시판no를 받는다.
		int queNo = Integer.parseInt(request.getParameter("queNo"));
		
		IQuestionService service = QuestionServiceImpl.getInstance();
		QuestionVO vo = service.selectNo(queNo);
		
		String imageFile = vo.getQue_file();
		if(imageFile==null) imageFile = "noimage.png";
		
		//이미지가 저장된 폴더 설정
		String filepath = "d:/d_other/community/uploadFiles";
		File file = new File(filepath, imageFile);
		
		BufferedInputStream bin = null;
		BufferedOutputStream bout = null;
		if(file.exists()) {
			try {
				//출력용 스트림
				bout = new BufferedOutputStream(response.getOutputStream());
				
				//파일 입력용 스트림
				bin = new BufferedInputStream(new FileInputStream(file));
				
				byte[] temp = new byte[1024];
				int len = 0;
				
				while( (len = bin.read(temp)) >0 ) {
					bout.write(temp, 0, len);
				}
				bout.flush();
				
			} catch (Exception e) {
				System.out.println("입출력 오류 : " + e.getMessage());
			} finally {
				if(bin!=null) try { bin.close(); }catch(IOException e) {}
				if(bout!=null) try { bout.close(); }catch(IOException e) {}
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
