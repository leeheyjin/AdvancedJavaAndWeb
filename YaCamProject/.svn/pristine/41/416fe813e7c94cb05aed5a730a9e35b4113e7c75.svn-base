<%@page import="kr.or.ddit.reservation.vo.ReservationVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//서블릿에서 저장한 테이타 꺼내기
ReservationVo vo = (ReservationVo)request.getAttribute("Reser");
if(vo != null){//성공
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