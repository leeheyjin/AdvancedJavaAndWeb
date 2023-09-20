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
<% MemberVO vo = (MemberVO)request.getAttribute("userInfo"); %>
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
#head_box {
    width: 100%;
    height: 60px;
    text-align: center;
    line-height: 40px;
    background-color: #fff;
    font-weight: bold;
    color: #FF5918;
    font-size: 25px;
    padding-top: 20px;
    border-bottom: 2px solid #ddd;
}
#report {
    font-weight: bold;
	color: #FF5918;
    margin-top: 30px;
    margin-left: 10px;
    font-size: 13px;
    font-family: "TheJamsil5Bold";
	transform: rotate(0.03deg);
	border: none;
}
#title {
    font-size: 20px;
    color: #FF5918;
    background-color: #fff;
    font-weight: bold;
}
#inside {
    border: 2px solid #FF5918;
    font-size: 20px;
    color: #FF5918;
    background-color: #fff;
    font-weight: bold;
}
td {
	border: 2px solid #FF5918;
    padding: 5px;
    width: 20px;
    height: 20px;
    text-align: center;
}
/* 헤더 */
#header{
	width: 60%;
	height: 206px;
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
#body {
	border: none;
    width: 60%;
    height: 460px;
    margin: 0px auto;
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
		<br>
		<a class="navbar-brand" href="<%=request.getContextPath()%>/LMW/mypage/myPage.jsp">
            <img id="img2" src="<%=request.getContextPath()%>/imges/btn_back.png" alt="" width="30" height="24">
        </a>
	    <header id="head_box">회원 정보</header>
	    		<hr>
	    		<br>
            <nav id="nav">
                <div id="nav_myinfo">
                    <div><a href="#"><img id="user_img" src="<%=request.getContextPath()%>/imges/user.png" alt="사람"></a></div>
                    <div id="nav_text">
                        <div id="user">&nbsp;등급:&nbsp;</div>
                        <br>
                        <div id="user">&nbsp;이름:&nbsp;</div>
                    </div>
                    <div id="nav_user">
                    <div id="insert"><%=vo.getMem_grade() %></div>  
                         <br>                     
					<div id="insert"><%=vo.getMem_id() %></div>                               
                    </div>
                </div>
                <div id="nav_manu">
                    <div><a href=""<%=request.getContextPath() %>/SelectAlarm.do""><img id="clock" src="<%=request.getContextPath()%>/imges/시계.png" alt="시계"></a></div>
                </div>
                <div id="nav_report">
                	<div id="report">빈자리알림</div>
                </div>
            </nav>
        </div>
	<div id="zeroTwo"></div>
	<br>
	<div>
		<table id="body">
			<tr>
				<td id="title">아이디</td>
				<td id="inside"><%=vo.getMem_id() %></td>
			</tr>
			<tr>
				<td id="title">비밀번호</td>
				<td id="inside"><%=vo.getMem_pass() %></td>
			</tr>
			<tr>
				<td id="title">이름</td>
				<td id="inside"><%=vo.getMem_name() %></td>
			</tr>
			<tr>
				<td id="title">성별</td>
				<td id="inside"><%=vo.getMem_gender() %></td>
			</tr>
			<tr>
				<td id="title">생일</td>
				<td id="inside"><%=vo.getMem_birth() %></td>
			</tr>
			<tr>
				<td id="title">전화번호</td>
				<td id="inside"><%=vo.getMem_tel() %></td>
			</tr>
			<tr>
				<td id="title">주소</td>
				<td id="inside"><%=vo.getMem_addr() %></td>
			</tr>
			<tr>
				<td id="title">가입날짜</td>
				<td id="inside"><%=vo.getMem_date() %></td>
			</tr>
			<tr>
				<td id="title">등급</td>
				<td id="inside"><%=vo.getMem_grade() %></td>
			</tr>
			<tr>
				<td id="title">이메일</td>
				<td id="inside"><%=vo.getMem_mail() %></td>
			</tr>
		</table>
	</div>
	<div id="zeroThrid"></div>
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