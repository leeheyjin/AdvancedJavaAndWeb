<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//서블릿에서 저장한 테이타 꺼내기
String res = (String)request.getAttribute("send");
System.out.println("jsp"+res);

if(res !=null){//성공
%>
	
	{
		"flag" : "이메일 발송 완료"
	}
	
	
<%
}else{
%>

	{
		"flag" : "이메일 발송 실패"
	}

<%
}
%>