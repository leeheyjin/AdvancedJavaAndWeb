package kr.or.ddit.member.controller;

import java.io.IOException;
import java.lang.reflect.Member;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

@WebServlet("/UpdateMember.do")
public class UpdateMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");
		String gread = request.getParameter("gread");
		String mail = request.getParameter("mail");
		System.out.println("이것은 테스트" + id  + ":" + pass + ":" + name + ":" + tel + ":" +addr  );
		MemberVO vo = new MemberVO();
		vo.setMem_id(id);
		vo.setMem_pass(pass);
		vo.setMem_name(name);
		vo.setMem_mail(mail);
		vo.setMem_tel(tel);
		vo.setMem_addr(addr);
		vo.setMem_grade(gread);
		System.out.println(vo);
		
		HttpSession sesson = request.getSession();
		IMemberService service = MemberServiceImpl.getInstance();
		int cnt = service.updateMember(vo);
		
		if(cnt>0) {
			request.setAttribute("cnt", cnt);
			vo = service.selectUserInfo(id);
			sesson.setAttribute("userinfo", vo);
		}else {
			System.out.println(cnt);
		}
		
		request.getRequestDispatcher("/LMW/mypage/updateinfoServlet.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
