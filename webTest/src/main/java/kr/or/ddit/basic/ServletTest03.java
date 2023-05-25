package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Servlet의 동작 과정
 * 
 * 1. 사용자(클라이언트) url을 클릭하면 http요청을 sevlet container로 전송한다(요청)
 * 2. 컨테이너는 web.xml에 정의된 urlPattern을 확인하여 어느 서블릿을 통해 처리해야할지(실행할 서블릿)를 검색한다
 *    (이 때 서블릿이 로딩이 안 된 경우에는 로딩 작업을 한다. 처음 로딩시에는 init()메서드를 호출한다. Servlet버전 3.0이상에서는 어노테이션(@WebServlet)으로 설정할 수 있다.)
 * 3. Servlet Container는 개별 요청을 처리할 스레드를 생성하여 해당 서블릿객체의 service()메서드 호출한다
 *    (이 때 HttpServletRequest객체와 HttpServletResponse객체를 생성하여 파라미터로 넘겨준다)
 * 4. service()메서드는 전송방식(GET, POST 등 method속성값)을 체크하여 적절한 메서드를 호출한다
 *    (doGet(), doPost(), doPut(), doDelete() 등)
 * 5. 요청 및 응답 처리가 완료되면 HttpServletRequest객체와 HttpServletResponse객체는 자동으로 소멸된다
 * 6. 컨테이너로부터 서블릿이 제거되는 경우에는 destroy()메서드가 호출된다.
 * 
 */

@WebServlet("/servletTest03.do") // urlmapping
public class ServletTest03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		System.out.println(this.getServletName() + " 서블릿에서 init()메서드 호출");
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service() 메서드 시작");
		// GET방식과 POST방식에 맞는 메서드 호출하기
		// 방법1: 부모 클래스인 HttpServlet의 service()메서드로 위임하기
		super.service(request, response);
		// 방법2: 
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()메서드 시작");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter writer = response.getWriter();
		writer.println("<html><head><meta charset='utf-8'></head>");
		writer.println("<body><h1 style='color: blue;'>doGet()메서드를 처리한 결과입니다.</h1></body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()메서드 시작");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter writer = response.getWriter();
		writer.println("<html><head><meta charset='utf-8'></head>");
		writer.println("<body><h1 style='color: blue;'>doPost()메서드를 처리한 결과입니다.</h1></body></html>");
	}
	
	@Override
	public void destroy() {
		System.out.println(this.getServletName() + " 서블릿에서 destroy()메서드 호출");
	}

}
