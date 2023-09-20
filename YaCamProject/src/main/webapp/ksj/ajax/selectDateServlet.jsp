<%@page import="kr.or.ddit.campzone.vo.CampzoneVo"%>
<%@page import="kr.or.ddit.reservation.vo.ReservationVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%List<ReservationVo> list = (List<ReservationVo>)request.getAttribute("list");%>
<%int n = 0;%>
[
<%
for(ReservationVo vo : list){
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