<%@page import="kr.or.ddit.campzone.vo.CampzoneVo"%>
<%@page import="kr.or.ddit.campinfo.vo.CampInfoVO"%>
<%@page import="java.util.HashMap"%>
<%@page import="kr.or.ddit.reservation.vo.ReservationVo"%>
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
/* 풋터 */
#footer{
	background-color: #fff;
	display: flex;
	flex-direction: row;
}
#customerOne{
	height: 150px;
	margin-left: 30%;
}
#customerTwo{
	height: 150px;
	margin-left: 300px;
}
#mainContent{	
	display: flex;
	flex-direction: row;
	font-weight: bold;
	color: gray;
}
#center{
	font-size: 2px;
	font-weight: bold;
	color: black;
}
#content{
	font-size: 1px;
	margin-top: 5px;
	color: gray;
}
/* 빈 공간 */
#zero{
	width: 100%;
	height: 35px;
	background-color: #fff;
	
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
#photo{
	width : 100%;
	height: 300px;
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
</style>

<script>
$(function(){
	$('#cancel').on('click',function(){
		var zoneNo = $(this).attr('name');
		$.ajax({
			url : "<%=request.getContextPath()%>/DeleteReservation.do",
			data : {"zoneNo" : zoneNo},
			type : "post",
			success : function(res){
				alert("성공")
				$(location).attr('href', '<%=request.getContextPath()%>/LMW/mypage/myPage.jsp');
			},
			error : function(xhr){
				alert(xhr.status)
			},
			dataType : "json"
		})
	})
})

</script>


</head>
<body>
<% MemberVO vo = (MemberVO)session.getAttribute("userinfo"); %>
<% HashMap map = (HashMap)request.getAttribute("map"); %>
<% List<ReservationVo> list = (List<ReservationVo>)map.get("list"); %>
<% CampInfoVO campinfoVo = (CampInfoVO)map.get("campvo"); %>
<% CampzoneVo campZonVo= (CampzoneVo)map.get("zoneVo"); %>

<%if(map.size()==0){ %>
<div id="main_contaner">
	<div id="headerTwo">
				<br>
		<a class="navbar-brand" href="<%=request.getContextPath()%>/LMW/mypage/myPage.jsp">
            <img id="img2" src="<%=request.getContextPath()%>/imges/btn_back.png" alt="" width="30" height="24">
        </a>
	    <header id="head_box">상세 예약조회</header>
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
		<div id="muzi">예약중인 방이 없습니다.</div>
	</div>
</div>
	
<% }else{ %>

<div id="main_contaner">
	<div id="headerTwo">
		<a class="navbar-brand" href="<%=request.getContextPath()%>/LMW/mypage/myPage.jsp">
            <img id="img2" src="<%=request.getContextPath()%>/imges/btn_back.png" alt="" width="30" height="24">
        </a>
	    <header id="head_box">상세 예약조회</header>
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
		<table>
				<tr>
					<td colspan="2"><img id="photo" src="<%=request.getContextPath()%><%=campinfoVo.getCamp_poto()%>"></td>
				</tr>
				<tr>
					<td>캠핑장 이름</td>
					<td><%=campinfoVo.getCamp_name()%></td>
				</tr>
				<tr>
					<td>캠핑 종류</td>
					<td><%=campZonVo.getZone_type()%></td>
				</tr>
				<tr>
					<td>구역 호수번호</td>
					<td><%=campZonVo.getZone_no()%></td>
				</tr>
				<tr>
					<td>캠핑장 주소</td>
					<td><%=campinfoVo.getCamp_addr() %></td>
				</tr>
				<tr>
					<td>캠핑장 전화번호</td>
					<td><%=campinfoVo.getCamp_tel() %></td>
				</tr>
				<tr>
					<td>환불 안내</td>
					<td><%=campinfoVo.getCamp_refund() %></td>
				</tr>
				<tr>
					<td>예약 인원</td>
					<td><%=list.get(0).getRes_person() %></td>
				</tr>
				<tr>
					<td>캠프 수용정보</td>
					<td><%=campinfoVo.getCamp_facility_info() %></td>
				</tr>
				<tr>
					<td>입,퇴실 시간</td>
					<td><%=campinfoVo.getCamp_instructions() %></td>
				</tr>
				<tr>
					<td>결제금액</td>
					<td><%=list.get(0).getRes_price()%></td>
				</tr>
				<tr id="cancel_box">
					<td colspan="2"><button type="button" id="cancel" type="button" name="<%=campZonVo.getZone_no()%>"><div>예약 취소</div></button></td>
				</tr>
		</table>
	</div>
</div>
<%} %>
<br><br><br>
<div id="footer">
	<div id="customerOne">
		<br>
		<h3 id="center">고객센터</h3>
			<br>	
		<h6 id="content">010-8602-4217</h6>
			<br>
		<h6 id="content">kkd9612@naver.com</h6>
			<br>
		<h6 id="content">평일: 09:00 ~ 18:00 (점심시간 12:50 ~ 13:50)</h6>
			<br>
	</div>
	<div id="customerTwo">
		<br>
		<h3 id="center">대덕인재개발원 402호 4조</h3>	
			<br>
		<div id="mainContent">야!!캠<div id="content">핑가자~</div></div>
			<br>
		<h6 id="content">주소: 대전광역시 중구 계룡로 945 4층</h6>
			<br>
		<h6 id="content">팀장: 임민우 | 팀원: 김승종 | 팀원: 이현학 | 팀원: 박병철 | 팀원: 권기덕</h6>
	</div>
</div>
<div id="zero"></div>
</body>
</html>