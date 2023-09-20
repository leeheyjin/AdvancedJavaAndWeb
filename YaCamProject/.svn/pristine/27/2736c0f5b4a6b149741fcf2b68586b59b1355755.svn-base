<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
<%MemberVO vo = (MemberVO)request.getAttribute("vo");%>

<%if(vo==null ||  vo.getMem_delete().equals("Y")){%>
	{
		"flag" : "다시시도" 
	}
<%}else{%>
	{
		"flag" : "성공" 
	}
<%}%>