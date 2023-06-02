<%@page import="kr.or.ddit.member.vo.AddressVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
List<AddressVO> list = (List<AddressVO>) request.getAttribute("searchDong");
%>
[
	<%
	for (int i = 0; i < list.size(); i++) {
		AddressVO vo = list.get(i);
		if (i > 0) {
			out.print(", ");
		}
		%>
		{
			"zip_code": "<%=vo.getZipcode() %>",
			"sido": "<%=vo.getSido() %>",
			"gugun": "<%=vo.getGugun() %>",
			"dong": "<%=vo.getGugun() %>",
			"bunji": "<%=vo.getBunji() %>"
		}
		<%
	}
	%>
	
]
