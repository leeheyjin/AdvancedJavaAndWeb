<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%	//스크립틀릿
	request.setCharacterEncoding("UTF-8");
	
	//쿠키 쿠키 뉴~ 쿠키. 네임 밸류
	//요청 파라미터 정보를 쿠키에 넣음
	Enumeration en = request.getParameterNames();
	Cookie[] cookies = new Cookie[6];
	int cnt = 0;
	//파라미터 개수만큼 반복
	while(en.hasMoreElements()){
		String paramName = (String)en.nextElement();
		/*
		paramName : cartId
		paramName : name
		paramName : shippingDate
		paramName : country
		paramName : zipCode
		paramName : addressName
		*/
		out.print("<p>paramName : " + paramName + "</p>");
		
		cookies[cnt] = new Cookie("shipping_"+paramName,
				URLEncoder.encode(request.getParameter(paramName),"UTF-8"));
		cookies[cnt].setMaxAge(24 * 60 * 60);
		//리스폰스 애드 쿠키
		response.addCookie(cookies[cnt]);
		cnt++;
	}
	out.print("<p>------------------------------</p>");
	response.sendRedirect("orderConfirmation.jsp");
%>
<a href="/ch14/cookie02.jsp">[테스트]쿠키 생성 확인</a>