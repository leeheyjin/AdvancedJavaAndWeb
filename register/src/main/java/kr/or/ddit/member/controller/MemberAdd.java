package kr.or.ddit.member.controller;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

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

		String uploadPath = "./src/uploadFiles";
		File file = new File(uploadPath);
		if (!file.exists()) {
			file.mkdirs();
		}
		String originFileName = request.getParameter("mem_photo");
		String saveFileName = UUID.randomUUID().toString() + originFileName;
		

	}

}
