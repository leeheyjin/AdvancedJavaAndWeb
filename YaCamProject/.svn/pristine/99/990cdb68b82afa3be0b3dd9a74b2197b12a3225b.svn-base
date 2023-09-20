<%@page import="kr.or.ddit.campinfo.vo.CampInfoVO"%>
<%@page import="java.util.HashMap"%>
<%@page import="kr.or.ddit.alarm.vo.AlarmVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>야!!!캠핑가자~</title>
<link id="main icon" rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath()%>/Main_KKD/ICON/camping-favicon.ico">
<%@include file="tmp.jsp" %>
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
    margin-top: 4%;
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
    margin-top: 55px;
    margin-right: 10px;
}
#photo {
    width: 50%;
    height: 270px;
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
	line-height: 40px;
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
    width: 100%;
    background-color: #fff;
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
#photo {
    width: 50%;
    height: 300px;
}
#muzi{
border: 1px solid ;
margin: 0px auto;
text-align: center;
width: 100%;
height: 500px;
line-height: 500px;
}
#body{
margin-top: 100px;
}
.deleteAlarm{
	text-align: center;
	display : inline;
	position: absolute;
}

#cancel_box{
text-align: center;
}
#cancel{
	width: 320px;
	height: 50px;
	padding:8px;
	font-size: 14px;
	border-radius: 10px;
	border : 2px solid #FF6529;
	background: #f8f9fa;
	color: #FF6529;
	cursor: pointer;
}
#cancel:hover{
	color: #FF6529;
	background-color: #d3d4d5;
	border-color: #FF4D07;
}
#cancel div{
	font-family: "TheJamsil5Bold";
	font-weight: bold;
	transform: rotate(0.03deg);
	margin:0;
	font-size: 13px;
}
.deleteAlarm {
    text-align: center;
    display: inline;
    position: absolute;
    top: 246px;
    right: 385px;
    border: 2px solid #FF5918;
    background-color: #fff;
    font-weight: bold;
    cursor: pointer;
    color: #FF5918;
}

</style>

<script>
$(function(){

	//알림 선택
	$('.deleteAlarm').on('click',function(){
		var zoneNo = $(this).attr('id');
		if(confirm("정말 알림을 취소 하시겠습니까?")){
			$.ajax({
				url : "<%=request.getContextPath()%>/deleteAlarm.do",
				data : {"zoneNo" : zoneNo},
				type : "post",
				success : function(res){
					alert("취소가 완료 되었습니다.")
				 	$(location).attr('href','<%=request.getContextPath()%>/SelectAlarm.do');
				},
				error : function(xhr){
					
				},
				dataType : "json"
			})
		}
	})
	//알림 선택

})

</script>


</head>
<body>
<% MemberVO vo = (MemberVO)session.getAttribute("userinfo"); %>
<% HashMap map = (HashMap)request.getAttribute("map"); %>
<% List<CampInfoVO> clist = (List<CampInfoVO>)map.get("clist"); %>
<% List<AlarmVO> alist = (List<AlarmVO>)map.get("list"); %>

<div id="main_contaner">
	<div id="headerTwo">
		<a class="navbar-brand" href="<%=request.getContextPath()%>/LMW/mypage/myPage.jsp">
            <img id="img2" src="<%=request.getContextPath()%>/imges/btn_back.png" alt="" width="30" height="24">
        </a>
	    <header id="head_box">빈자리 알림</header>
	    			<hr>
	    			<br>
	    <nav id="nav-up">
	        <div id="nav_myinfo">
	            <div><a href="#"><img id="user_img" src="<%=request.getContextPath()%>/imges/user.png" alt="사람"></a></div>
	    		<br>
		   		<div>
				    <table id="table">
				    	<tr>
					    	<td id="nav_td">아이디</td>
					    	<td id="nav_tdTwo"><%=vo.getMem_id() %></td>
				    	</tr>
				    	<tr>
					    	<td id="nav_td">회원등급</td>
					    	<td id="nav_tdTwo"><%=vo.getMem_grade()%></td>
				    	</tr>
				    </table>
		   		</div>
			</div>
			<div id="nav_manu">
			    <div><a href="#"><img id="clock" src="<%=request.getContextPath()%>/imges/시계.png" alt="시계"></a></div>
			</div>
			<div id="nav_report">
				<div id="report">빈자리알림</div>
			</div>
	    </nav>
	</div>
	<div id="body">
		<hr>
		<%for(int i=0; i<clist.size(); i++){ %>
		<table>
				<tr>
					<td id="photo" rowspan="8" style="background-image: url('<%=request.getContextPath() %><%= clist.get(i).getCamp_poto()%>'); background-size: cover; background-repeat: no-repeat; background-position: center;"></td>
					<td>캠핑장 이름</td>
					<td><%= clist.get(i).getCamp_name()%></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><%= clist.get(i).getCamp_addr()%></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><%= clist.get(i).getCamp_tel()%></td>
				</tr>
				<tr>
					<td>가격</td>
					<td><%= clist.get(i).getCamp_info()%></td>
				</tr>
				<tr>
					<td>캠프 동반 가능 종류</td>
					<td><%= clist.get(i).getCamp_facility_info()%></td>
				</tr>
				<tr>
					<td>유의 사항</td>
					<td><%= clist.get(i).getCamp_policy()%></td>
				</tr>
				<tr>
					<td>이용시간</td>
					<td><%= clist.get(i).getCamp_instructions()%></td>
				</tr>
				<tr>
					<td>빈자리 알림 예약 호수</td>
					<td><%= alist.get(i).getZone_no()%> &nbsp;&nbsp;
					 <input type="button" value="빈자리 알림 취소하기" class="deleteAlarm" id="<%= alist.get(i).getZone_no()%>"></td>
				</tr>
		</table>
		<hr>
		<%} %>
	</div>
</div>
</body>
</html>