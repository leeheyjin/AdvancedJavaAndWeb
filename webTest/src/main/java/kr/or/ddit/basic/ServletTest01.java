package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 
 * http://localhost:80/webTest/servletTest01.do: 실행할 Url주소
 * http: 프로토콜                                            
 * localhost: 컴퓨터이름(도메인명) 또는 ip주소                        
 * 80: 포트번호                                              
 * /webTest: context path(보통 프로젝트명으로 지정된다)               
 * /servletTest01.do: 서블릿 요청 url패턴                       
 */ 

// 이 예제는 배포서술자(web.xml)을 이용해서 실행할 Servlet을 설정하는 방식의 예제이다.
public class ServletTest01 extends HttpServlet {
	// 여기서 대부분 service()나 doGet() 또는 doPost()를 재정의해서 작성한다
	
	// doGet()이나 doPost()는 service()를 통해서 호출된다.
	// doGet(): GET방식의 요청을 처리하는 메서드. 이 메서드의 매개변수로 HttpServletRequest와 HttpServletResponse객체가 자동으로 저장된다
	// HttpServletRequest: 서비스 요청에 관련된 정보 및 메서드를 관리하는 객체
	// HttpServletResponse: 서비스 응답에 관련된 정보 및 메서드를 관리하는 객체
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Set<Integer> lottoSet = new HashSet<>();
		Random random = new Random();
		
		while(lottoSet.size() < 6) {
			lottoSet.add(random.nextInt(45) + 1);
		}
		
		ArrayList<Integer> lottoList = new ArrayList<>(lottoSet);
		Collections.sort(lottoList);
		
		// 처리한 결과를 응답으로 보내준다.
		response.setCharacterEncoding("utf-8"); // 응답 문서의 인코딩 방식 지정
		response.setContentType("text/html; charset=utf-8"); // 응답 문서의 ContentType 지정
		
		// 처리한 내용을 응답으로 보내기 위해 PrintWriter객체를 생성한다
		PrintWriter writer = response.getWriter(); // 출력용 스트림 객체 생성
		// 처리한 내용을 출력한다.
		// 방법1) append()
		writer.append("<html>")
			  .append("<head>")
			  .append("<meta charset='utf-8'>")
			  .append("<title>첫번째 Servlet</title>")
			  .append("</head>")
			  .append("<body style='text-align: center;'>")
			  .append("<h2>안녕하세요 첫번째 Servlet 프로그램입니다.</h2>")
			  .append("<h3>행운의 로또번호</h3>");
		for (int num : lottoList) {
			writer.append("<em>" + num + "</em> ");
		} 
		writer.append("</body>")
			  .append("</html>");
		
		
	}

	// doPost(): POST방식의 요청을 처리하는 메섣. 이 메서드의 매개변수로 HttpServletRequest와 HttpServletResponse가 자동으로 저장된다
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
