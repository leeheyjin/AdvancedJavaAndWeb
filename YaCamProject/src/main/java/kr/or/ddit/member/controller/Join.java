package kr.or.ddit.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;


@WebServlet("/join.do")
public class Join extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pw");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String birth = request.getParameter("bir");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");
		String grade = request.getParameter("grade");
		String mail = request.getParameter("mail");
		
		
		
		MemberVO vo = new MemberVO();
		
		vo.setMem_id(id);
		vo.setMem_pass(pass);
		vo.setMem_name(name);
		vo.setMem_mail(mail);
		vo.setMem_gender(gender);
		vo.setMem_birth(birth);
		vo.setMem_tel(tel);
		vo.setMem_addr(addr);
		vo.setMem_grade(grade);
		
//		insert into member values(#{mem_id},#{mem_pass},#{mem_name},
//		#{mem_mail},#{mem_gender},#{mem_birth},#{mem_tel},#{mem_addr},
//		sysdate,#{mem_grade})
		
		IMemberService service = MemberServiceImpl.getInstance();
		
		int set = service.insertMember(vo);
		
		request.setAttribute("result", set);
		System.out.println("서블릿 체크"+set);
		
		request.getRequestDispatcher("/pbc/result.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
