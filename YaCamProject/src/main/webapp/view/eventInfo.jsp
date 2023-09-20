<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="kr.or.ddit.event.vo.EventVO"%>
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 서블릿에서 저장한 데이터 꺼내기
EventVO vo = (EventVO)request.getAttribute("selectNo");
MemberVO mvo = (MemberVO)session.getAttribute("userinfo");

//SimpleDateFormat 객체 생성
java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");

//날짜를 원하는 형식으로 변환하여 문자열로 저장
java.util.Date startDate = sdf.parse(vo.getEnt_start());
java.util.Date endDate = sdf.parse(vo.getEnt_end());
String formattedStartDate = sdf.format(startDate);
String formattedEndDate = sdf.format(endDate);
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>이벤트 내용</title>
    <link id="main icon" rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath()%>/Main_KKD/ICON/camping-favicon.ico">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="<%=request.getContextPath() %>/js/jquery-3.7.0.min.js"></script>
    <script src="<%=request.getContextPath() %>/js/community.js"></script>
    <script>
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
        ul {
            padding: 0px;
        }
        li {
            list-style-type: none;
            display: inline;
        }
        .centered {
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="container mt-3">
        <nav class="navbar navbar-light bg-light">
            <div class="container">
                <a class="backbtn" href="<%=request.getContextPath() %>/LHH/event/event.jsp">
                    <img src="<%=request.getContextPath() %>/imges/btn_back.png" alt="" width="30" height="24">
                </a>
                <h4 class="text-center flex-grow-1">이벤트</h4>
					<hr>
					<br>
            </div>
        </nav>
    </div>

    <div class="container mt-3">
        <div class="notice_con">
            <div class="notice_view">
                <p style="font-weight: bold;"><%=vo.getEnt_ttl() %></p>
                <div class="notice_top">
                    <ul>
                        <li><%=formattedStartDate %></li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <li>이벤트기간 : <%=formattedStartDate %>&nbsp; ~ &nbsp;<%=formattedEndDate %></li>
                    </ul>
       		 <%if("관리자".equals(mvo.getMem_grade())){%>
                    <div id="button">
                        <div class="div_button">
                            <button class="btn btn-light" id="btnUpdate" onclick="window.location.href='<%=request.getContextPath()%>/eventUpdate.do?entNo=<%=vo.getEnt_no()%>'">수정</button>
                            <input class="btn btn-light" type="button" value="삭제" onclick="window.location.href='<%=request.getContextPath()%>/eventDelete.do?num=<%=vo.getEnt_no()%>'">
                        </div>
                    </div>
          <%} %>  
                </div>
            </div>
        </div>
        <hr>
        <div class="notice_btom">
   			 <% if (vo.getEnt_file() != null && !vo.getEnt_file().isEmpty()) { %>
        <p class="centered"><img src="<%=request.getContextPath()%>/eventImageView.do?entNo=<%=vo.getEnt_no()%>" style="width: 50%;"></p>
    		 <% } %>
    	<p class="centered"><%=vo.getEnt_dtl() %></p>
</div>
    </div>
</body>
</html>
