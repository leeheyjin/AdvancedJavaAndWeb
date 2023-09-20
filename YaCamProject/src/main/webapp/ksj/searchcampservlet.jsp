<%@page import="kr.or.ddit.wishlist.vo.WishlistVo"%>
<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@page import="kr.or.ddit.campinfo.vo.CampInfoVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
	//서블릿에서 보낸 자료 받기
	
	List<CampInfoVO> searchCamp = (List<CampInfoVO>) request.getAttribute("searchCamp");
	List<WishlistVo> wishlist = (List<WishlistVo>) request.getAttribute("wishlist");
	if(searchCamp != null){
%>
[
<% for (int i = 0; i < searchCamp.size(); i++) {
     CampInfoVO vo = searchCamp.get(i);
	System.out.println("searchCamp==> " + vo);
     String wishCheck = "";
     for(int j = 0; j<wishlist.size(); j++){
    	 if(vo.getCamp_no().equals( wishlist.get(j).getCamp_no())){
    		wishCheck = "checked"; 
    	 }
     }
     
%>
    {
        "campNo": "<%=vo.getCamp_no() %>",
        "campName": "<%=vo.getCamp_name() %>",
        "campAddr": "<%=vo.getCamp_addr() %>",
        "campInfo": "<%=vo.getCamp_info() %>",
        "campPhoto": "<%=request.getContextPath() + vo.getCamp_poto() %>",
        "wishlist" : "<%=wishCheck %>"
    }
   <% if (i < searchCamp.size() - 1) { %>,<% } %>
<% } %>
]
	
<%
	}else{
%>
	{"searchCamp" : "조건에 맞는 캠핑장이 없습니다"}
<%
	}
%>