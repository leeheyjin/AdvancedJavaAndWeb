package kr.or.ddit.basic;

import java.util.Stack;

public class StackTest {
	public static void main(String[] args) {
		Browser browser = new Browser();
		
		browser.goUrl("1. 네이버");
		browser.history();
		browser.goUrl("2. 구글");
		browser.history();
		browser.goUrl("3. 다음");
		browser.history();
		browser.goBack();
		browser.history();
		browser.goBack();
		browser.history();
		browser.goForward();
		browser.history();
		browser.goUrl("4. 네이트");
		browser.history();

	}

}

// stack을 이용한 웹브라우저의 앞으로 가기, 뒤로 가기 기능 구현
class Browser {
	private Stack<String> back;
	private Stack<String> forward;
	private String currentUrl;

	public Browser() {
		back = new Stack<>();
		forward = new Stack<>();
		currentUrl = "";
	}

	// 사이트를 방문하는 메서드. 매개변수에는 방문할 url주소가 저장되어 있다.
	public void goUrl(String url) {
		System.out.println(url.substring(3) + " 사이트에 접속합니다");
		if (currentUrl != null && !"".equals(currentUrl)) { // 현재 페이지가 있으면
			back.push(currentUrl); // 현재 페이지를 back 스택에 추가한다.
		}
		currentUrl = url; // 현재페이지를 변경한다
		forward.clear();
	}

	// 뒤로 가기
	public void goBack() {
		// isEmpty(): 컬렉션이 비어있으면 true, 아니면 false
		if (!back.isEmpty()) { // 이전 페이지가 비어 있지 않으면 = 이전 페이지가 있으면
			forward.push(currentUrl); // 현재 페이지를 forward에 저장
			currentUrl = back.pop(); // back 스택에서 1개의 요소를 꺼내와 현재 페이지로 설정한다.

		}
	}

	public void goForward() {
		if (!forward.isEmpty()) {
			back.push(currentUrl);
			currentUrl = forward.pop();
		}
	}
	
	// 방문 기록 확인하기
	public void history() {
		System.out.println();
		System.out.println("==========================");
		System.out.println("       방  문  기  록       ");
		System.out.println("==========================");
		System.out.println("이전 페이지 - " + back);
		System.out.println("현재 페이지 - " + currentUrl);
		System.out.println("다음 페이지 - " + forward);
		System.out.println("==========================");
	}
}
