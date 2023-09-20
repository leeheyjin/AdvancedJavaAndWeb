package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;

/**
 * Servlet implementation class MailSend
 */
@WebServlet("/MailSend.do")
public class MailSend extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		
		
		//메일정보
		String host = "smtp.naver.com";
		final String username = "pqc101";
		final String password = "cjfcks12!@";
		int port=465;
		
		
		//저장해서 이값으로 쿼리문 아이디 가져옴
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		
		Map<String, Object> map = new HashMap<>();
		map.put("mem_name", name);
		map.put("mem_mail", mail);
		
		IMemberService service = MemberServiceImpl.getInstance();
		String id = service.idFindMail(map);
		System.out.println("서블릿 결과 id ?" + id);
		
		if(id != null) {
			
		
		//메일 내용
		String recipient = mail;
		String subject = "야 캠핑가자 아이디찾기";
		String body = name+"님의 아이디는 "+id + "입니다.";
		
		
		
		Properties props = System.getProperties();
		
		 props.put("mail.smtp.host", host);
	        props.put("mail.smtp.port", port);
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.ssl.enable", "true");
	        props.put("mail.smtp.ssl.trust", host);
	          
	        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
	            String un=username;
	            String pw=password;
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(un, pw);
	            }
	        });
	        session.setDebug(true); //for debug
	          
	        Message mimeMessage = new MimeMessage(session);
	        try {
				
			
	        mimeMessage.setFrom(new InternetAddress("pqc101@naver.com"));
	        mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
	        mimeMessage.setSubject(subject);
	        mimeMessage.setText(body);
	        Transport.send(mimeMessage);
	        
	        
	        } catch (Exception e) {
				e.printStackTrace();
			} 
		}else {
			id = null;
		}
	        
	        
	        request.setAttribute("send", id);
	        
	        request.getRequestDispatcher("/pbc/find.jsp").forward(request, response);
	        
		}
		
		
	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
