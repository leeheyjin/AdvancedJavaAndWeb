package kr.or.ddit.member.controller;

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

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.vo.MemberVO;

@WebServlet("/images/imageView.do")
public class ImageView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String memId = request.getParameter("mem_id");
		IMemberService service = MemberService.getInstance();
		MemberVO vo = service.getOneMember(memId);

		String imageFile = vo.getMem_photo();
		if (imageFile == null) {
			imageFile = "noimage.png";
		}
		String filePath = "/Users/leehyejin/Project/ddit/ddit/register/src/main/webapp/images";
		File file = new File(filePath, imageFile);

		BufferedInputStream bIn = null;
		BufferedOutputStream bout = null;
		if (file.exists()) {
			try {
				bout = new BufferedOutputStream(response.getOutputStream());
				bIn = new BufferedInputStream(new FileInputStream(file));
				byte[] temp = new byte[1024];
				int len = 0;
				while ((len = bIn.read(temp)) > 0) {
					bout.write(temp, 0, len);
				}
				bout.flush();
			} catch (Exception e) {
				System.out.println("입출력 오류: " + e.getMessage());
			} finally {
				try {
					if (bIn != null) {
						bIn.close();
					}
					if (bout != null) {
						bout.close();
					}
				} catch (Exception e2) {
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
