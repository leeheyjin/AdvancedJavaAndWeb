<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="kr.or.ddit.member.vo.ChartVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
[
<%
List<ChartVO> list = (List<ChartVO>)request.getAttribute("list");
for(int i = 0; i<list.size(); i++){
	ChartVO vo = list.get(i);
	if(i>0) out.print(",");
%>	

	{
	"age" : <%=vo.getAge()%>,
	"count" : <%=vo.getCount()%>
	}

<%
}
%>
]