<%@page import="kr.or.ddit.member.vo.ChartVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%List<ChartVO> list = (List<ChartVO>)request.getAttribute("list");%>
<%
int i=0;
%>
[
<%
for(ChartVO vo : list){ if(i>0){out.print(",");}
%>
	{
		"gender" : "<%=vo.getMem_gender() %>",
		"count" : "<%=vo.getCount() %>"
	
	}

<%i++;} %>
]