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
<script>
$(function(){
<% MemberVO vo = (MemberVO)request.getAttribute("userInfo"); %>
	
	$('#sub').on('click',function(){
		
		 id=$('#id').val();
		 pass=$('#pass').val();
		 name=$('#name').val();
	   	 tel=$('#tel').val();
		 addr=$('#addr').val();
		 mail=$('#mail').val();
		 gread='<%=vo.getMem_grade()%>'
		console.log(id,pass,name,tel,addr,mail,gread)
		fdata={
			"id":id,
			"pass":pass,
			"name":name,
			"tel":tel,
			"addr":addr,
			"mail":mail,
			"gread":gread
		};
		console.log(fdata)
		$.ajax({
			url : "<%=request.getContextPath()%>/UpdateMember.do",
			data : fdata,
			type : "post",
			success : function(res){
				if(res.cnt=="성공"){
				alert("수정이 완료되었습니다.");
				$(location).attr('href', '<%=request.getContextPath()%>/LMW/mypage/myPage.jsp');	
				}else(
				alert("다시 시도하세욧!.")
						)
			},
			error : function(xhr){
				alert(xhr.status);
			},
			dataType:'json'
		});
	})
})

</script>
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
    height: 460px;
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
	border-bottom: 1px solid #FF5918;
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

#zeroTwo {
    width: 60%;
    height: 81px;
    margin: 0px auto;
    background-color: #f6f6f6;
}
</style>
</head>
<body>
<div id="zero"></div>
<div id="main_contaner">
	<div id="headerTwo">
			<br>
		<a class="navbar-brand" href="<%=request.getContextPath()%>/LMW/mypage/myPage.jsp">
            <img id="img2" src="<%=request.getContextPath()%>/imges/btn_back.png" alt="" width="30" height="24">
        </a>
	    <header id="head_box">회원 정보 수정</header>
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
	<div id="zeroTwo"></div>
	<div id="body">
<%-- 	<form action="<%=request.getContextPath() %>/UpdateMember.do"> --%>
		<table id="tableTwo" border="1">
			<tr>
				<td class="tdOne">아이디</td>
				<td class="tdTwo"><%=vo.getMem_id() %><input type="hidden" value="<%=vo.getMem_id() %>" name="id" id="id"></td>
			</tr>
			<tr>
				<td class="tdOne">비밀번호</td>
				<td class="tdTwo"><input type="text" value="<%=vo.getMem_pass() %>" id="pass" name="pass"></td>
			</tr>
			<tr>
				<td class="tdOne">이름</td>
				<td class="tdTwo"><input type="text" value="<%=vo.getMem_name() %>" id="name" name="name"></td>
			</tr>
			<tr>
				<td class="tdOne">전화번호</td>
				<td class="tdTwo"><input type="text" value="<%=vo.getMem_tel()%>" id="tel" name="tel"></td>
			</tr>
			<tr>
				<td class="tdOne">주소</td>
				<td class="tdTwo"><input type="text" value="<%=vo.getMem_addr()%>" id="addr" name="addr"></td>
			</tr>
			<tr>
				<td class="tdOne">이메일</td>
				<td class="tdTwo"><input type="text" value="<%=vo.getMem_mail()%>" id="mail" name="mail"></td>
			</tr>
		</table>
<!-- 		<input type="submit" id="sub" value="정보 수정"> -->
		<input type="button" id="sub" value="정보 수정">
	<!-- 	</form> -->
	</div>
	<br><br>
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
</div>
</body>
</html>