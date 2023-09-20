<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//서블릿에서 저장한 테이타 꺼내기
int res = (Integer)request.getAttribute("result");

if(res >0){//성공
%>
	
	{
		"flag" : "성공"
	}
	
	
<%
}else{
%>

	{
		"flag" : "실패"
	}

<%
}
%>