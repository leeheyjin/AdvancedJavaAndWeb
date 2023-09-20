<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="kr.or.ddit.coupon.vo.CouponVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>야!!!캠핑가자~</title>
<link id="main icon" rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath()%>/Main_KKD/ICON/camping-favicon.ico">
<%@ include file="tmp.jsp" %>

<%--  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/reset.css"></link> --%>
<%-- <link rel="stylesheet" href="<%=request.getContextPath() %>/css/Mypage.css"></link> --%>
<%-- <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.7.0.min.js"></script> --%>

<%MemberVO mvo = (MemberVO)session.getAttribute("userinfo");%>

<style>
#main icon{
	display: block;
	margin: auto;
	cursor: zoom-in;
	background-color: hsl(0, 0%, 90%);
	transition: background-color 300ms;
}
@font-face {
	font-family: 'TheJamsil5Bold';
	src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2302_01@1.0/TheJamsil5Bold.woff2') format('woff2');
	font-weight: 700;
	font-style: normal;
}
html, body{
    min-width: 1500px;
	background-color: #f6f6f6;
	font-family: "TheJamsil5Bold";
	font-weight: 400;
	transform: rotate(0.03deg);
}
.button{
	text-align : center;
	display: inline-block;
	width: 300px;
	height: 20px;
	border-radius: 10px;
}
/* 헤더 */
#header{
	width: 60%;
	height: 220px;
	margin: 0px auto;
	position: relative;
	background-color: #f6f6f6;
	border: none;
}
hr{
	border: 3px solid #FF6529;
	margin: 0 auto;
    color: inherit;
    opacity: .25;
}
#head_box{
	width: 100%;
    height: 60px;
    text-align: center;
    line-height: 40px;
    background-color: #fff;
    font-weight: bold;
    color: #FF5918;
    font-size: 25px;
    border: none;
    border-bottom: 2px solid #ddd;
}
#nav{
	width: 100%;
	height: 110px;
	display: flex;
	flex-direction: row;
	background-color: #fff;
	border: none;
}
#nav-up {
    width: 100%;
    height: 134px;
    display: flex;
    flex-direction: row;
    background-color: #fff;
}
#nav_myinfo{
	width: 300px;
	height: 100%;
	display: flex;
	margin-left: 20px;
	border: none;
}
#nav_manu{
	margin-left: 61.5%;
	border: none;
}
#nav_report {
    width: 200px;
    margin-top: 46px;
    margin-right: -125px;
}
#report{
    font-weight: bold;
	color: #FF5918;
	font-family: "TheJamsil5Bold";
	font-weight: bold;
	transform: rotate(0.03deg);
	border: none;
    margin: 10px;
    font-size: 13px;
    width: 200px;
    margin-top: -4%;
    margin-left: 4%;
}
#nav_text{
	display: inline-block;
	width: 200px;
	height: 60px;
	margin-top: 27px;
    padding: 19px;
	padding-right: 0px;
	color: #FF5918;
	font-family: "TheJamsil5Bold";
	font-weight: bold;
	transform: rotate(0.03deg);
	border: none;
}
/* 이미지 */
#user_img {
    margin-top: 8px;
    width: 100px;
}
#clock {
    width: 50px;
    height: 50px;
    margin-top: 40px;
    margin-right: 10px;
}
/* 바디 */
#body {
	border: none;
    width: 60%;
    height: auto;
    margin: 0px auto;
}
tr {
    border: none;
}
#my {
	border-right: 1px solid #FF5918;
	border-bottom: 1px solid #FF5918;
	text-align: center;
	line-height: 50px;
	vertical-align: middle;
	color: #FF5918; 
}
td {
	background-color: #fff;
	border-bottom: 2px solid #FF5918;
	border-left: 2px solid #FF5918;
	text-align: center;
	line-height: 50px;
	vertical-align: middle;
	color: #FF5918; 
}
#nav_td {
    border-top: 2px solid #FF5918;
    border-bottom: 2px solid #FF5918;
    text-align: center;
    line-height: 20px;
    padding: 5px;
    font-weight: bold;
    font-size: 12px;
    background-color: #fff;
    color: #FF5918;
}
#nav_tdTwo {
    border-bottom: 2px solid #FF5918;
    border-left: 2px solid #FF5918;
    text-align: center;
    line-height: 20px;
    padding: 5px;
    font-size: 12px;
    background-color: #fff;
    font-weight: bold;
    color: #fd5700;
}
#table {
    border: 2px solid #FF5918;
    background-color: #fff;
    margin-top: 41px;
    margin-left: 20px;
}
.tdOne {
    font-size: 20px;
    font-weight: bold;
    background-color: #fff;
    color: #FF5918;
    border: 2px solid #FF5918;
}
table {
    border: 2px solid #FF5918;
    width: 800px;
    background-color: #fff;
    margin: 0px auto;
}
.tdTwo {
    font-size: 13px;
    font-weight: bold;
    background-color: #fff;
    border: 2px solid #FF5918;
    color: #FF5918;
	font-family: "TheJamsil5Bold";
	font-weight: bold;
	transform: rotate(0.03deg);
}
#my,#reser,#coupon,#board,#save{
	background-color: #fff;
	font-weight: bold;
	color: #FF6529;
}
.button {
	border: 2px solid #FF5918;
    text-align: center;
    display: inline-block;
    width: 400px;
    height: 40px;
    border-radius: 10px;
}
#sub{
	width: 320px;
	height: 50px;
	padding:8px;
	font-size: 14px;
	border-radius: 10px;
	border : 2px solid #FF6529;
	background: #f8f9fa;
	color: #FF6529;
	cursor: pointer;
	margin-left: 33%;
	margin-top: 3%;
}
#sub:hover{
	color: #FF6529;
	background-color: #d3d4d5;
	border-color: #FF4D07;
}
#sub div{
	font-family: "TheJamsil5Bold";
	font-weight: bold;
	transform: rotate(0.03deg);
	margin:0;
	font-size: 13px;
}
#nav_user{
	display: inline-block;
	width: 100%;
	height: 60px;
	margin-top: 40px;
	padding: 22px;
	color: #FF5918;
	font-family: "TheJamsil5Bold";
	font-weight: bold;
	transform: rotate(0.03deg);
	padding-left: 0px;
}
#img2{
	float: left;
	margin-top: 27px;
	margin-left: 30px;
}
</style>
</head>
<body>
    <div id="main_contaner">
        <div id="header">
        <a class="navbar-brand" href="<%=request.getContextPath()%>/LMW/mypage/myPage.jsp">
            <img id="img2" src="<%=request.getContextPath()%>/imges/btn_back.png" alt="" width="30" height="24">
        </a>
            <header id="head_box">보유 쿠폰</header>
            	    <hr>
	    			<br>
            <nav id="nav">
                <div id="nav_myinfo">
                    <div><a href="#"><img id="user_img" src="<%=request.getContextPath()%>/imges/user.png" alt="사람"></a></div>
                    <div id="nav_text">
                        <div id="user">&nbsp;<%=mvo.getMem_id() %>&nbsp;</div>
                        	<br>
                        <div id="user">&nbsp;<%=mvo.getMem_name() %>&nbsp;</div>
                    </div>
                <div id="nav_manu">
                    <div><a href="<%=request.getContextPath() %>/SelectAlarm.do"><img id="clock" src="<%=request.getContextPath()%>/imges/시계.png" alt="시계"></a></div>
                </div>
                <div id="nav_report">
                	<div id="report">빈자리알림</div>
                </div>
            </nav>
        </div>
        <br><br><br>
        <div id="body">
    	 <div id ="box_size">
<% List<CouponVO> list = (List<CouponVO>)request.getAttribute("list"); %>
  <%if(list != null){ %>
  <%for(CouponVO vo : list){ %> 
	<table border="1">
		<tr>
			<td id="std">
				쿠폰 번호 <br> 
				쿠폰 타입  <br>
				쿠폰사용가능 <br>
				쿠폰발행 날짜 <br>
				쿠폰사용 기한 <br>
			</td>
			<td>
			 <%=vo.getCup_no() %><br>
			 <%=vo.getCup_name() %><br>
			 <%=vo.getCup_status() %><br>
			 <%=vo.getCup_sdate() %><br>
			  <%=vo.getCup_edate() %>까지<br> 
			</td>
		</tr>
	</table>
        </div>
<%} %> 
<%}else{ %> 
	<table border="1">
		<tr>
			<td>
				<h1>보유중인 쿠폰이 없습니다.</h1>
			</td>
		</tr>
	</table>
<%} %> 
        </div>
    </div>
</body>
</html>