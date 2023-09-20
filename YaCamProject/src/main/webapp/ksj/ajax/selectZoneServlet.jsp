<%@page import="kr.or.ddit.campzone.vo.CampzoneVo"%>
<%@page import="kr.or.ddit.reservation.vo.ReservationVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%List<CampzoneVo> clist = (List<CampzoneVo>)request.getAttribute("clist");%>
<%int n = 0;%>
[
<%
for(CampzoneVo vo : clist){
if(n>0){ 
	out.print(",");
}
%>


	{
		"zone_no" : "<%=vo.getZone_no() %>",
		"camp_no" : "<%=vo.getCamp_no() %>"
	}


<%n++;}%>	
]