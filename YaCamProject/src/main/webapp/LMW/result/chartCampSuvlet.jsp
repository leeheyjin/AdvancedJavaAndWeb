<%@page import="kr.or.ddit.campinfo.vo.ChartCampVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%List<ChartCampVO> list = (List<ChartCampVO>)request.getAttribute("list");%>
<%
int i=0;
%>
[
<%
for(ChartCampVO vo : list){ if(i>0){out.print(",");}
%>
	{
		"name" : "<%=vo.getCamp_name() %>",
		"addr" : "<%=vo.getCamp_addr() %>",
		"amount" : "<%=vo.getAmount() %>"
	}

<%i++;} %>
]