package kr.or.ddit.member.controller;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.vo.MemberVO;

@WebServlet("/memberAdd.do")
@MultipartConfig
public class MemberAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/view/memberAdd.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String memId = request.getParameter("mem_id");
		String memPass = request.getParameter("mem_pass");
		String memName = request.getParameter("mem_name");
		String memTel = request.getParameter("mem_tel");
		String memAddr = request.getParameter("mem_addr");

		MemberVO mvo = new MemberVO();
		mvo.setMem_id(memId);
		mvo.setMem_pass(memPass);
		mvo.setMem_name(memName);
		mvo.setMem_tel(memTel);
		mvo.setMem_addr(memAddr);

		String uploadPath = "/Users/leehyejin/Project/ddit/ddit/register/src/main/webapp/images";
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdirs();
		}

		Part part = request.getPart("mem_photo");
		if (part != null) {
			String fileName = extractFileName(part);

			if (!"".equals(fileName)) {
				try {
					part.write(uploadPath + File.separator + fileName);
					mvo.setMem_photo(fileName);
				} catch (Exception e) {
					mvo.setMem_photo(null);
				}
			}
		}

		IMemberService service = MemberService.getInstance();
		service.insertMember(mvo);
		response.sendRedirect(request.getContextPath() + "/memberList.do");
	}

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
