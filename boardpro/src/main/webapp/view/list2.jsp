<%@page import="kr.or.ddit.board.vo.PageVO"%>
<%@page import="kr.or.ddit.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
List<BoardVO> list = (List<BoardVO>) request.getAttribute("list");
PageVO pvo = (PageVO) request.getAttribute("pvo");
%>
[
	<%
		for(int i = 0; i < list.size(); i++) {
			BoardVO bvo = list.get(i);
			if (i > 0) {
				out.print(", ");
			}
			%>
			{
				"num": "<%=bvo.getNum()%>", 
				"subject": "<%=bvo.getSubject() %>",
				"writer": "<%=bvo.getWriter() %>",
				"mail": "<%=bvo.getMail() %>",
				"hit": "<%=bvo.getHit() %>",
				"content": "<%=bvo.getContent() %>",
				"wdate": "<%=bvo.getWdate() %>"
			}
			<%
		}
	%>

]