package chapter07;

class LoginServlet extends HttpServlet {

	@Override
	public void service() {
		System.out.println("로그인합니다.");
	}
	
}

class FileDownloadServlet extends HttpServlet {
	
	@Override
	public void service() {
		System.out.println("파일을 다운로드합니다.");
	}
	
}

public class HttpServiceExample {
	public static void main(String[] args) {
		method(new LoginServlet());
		method(new FileDownloadServlet());
	}
	
	public static void method(HttpServlet servlet) {
		servlet.service();
	}
}
