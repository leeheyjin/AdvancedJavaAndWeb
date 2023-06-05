<%@page import="org.apache.jasper.tagplugins.jstl.core.If"%>
<%@page import="kr.or.ddit.member.AddressVO"%>
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
		if (vo.getBunji() == null) {
			vo.setBunji("");
		}
		%>
		{
			"zip_code": "<%=vo.getZipcode() %>",
			"juso": "<%=vo.getSido() + " " + vo.getGugun() + " " + vo.getDong()  %>",
			"bunji": "<%=vo.getBunji() %>"
		}
		<%
	}
	%>
	
]
