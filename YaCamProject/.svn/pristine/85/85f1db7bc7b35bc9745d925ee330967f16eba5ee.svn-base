<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="kr.or.ddit.notice.vo.NoticeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 서블릿에서 저장한 데이터 꺼내기
NoticeVO vo = (NoticeVO)request.getAttribute("selectNo");
MemberVO mvo = (MemberVO)session.getAttribute("userinfo");
//SimpleDateFormat 객체 생성
java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");

//날짜를 원하는 형식으로 변환하여 문자열로 저장
String formattedDate = vo.getNoti_date();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>공지사항 내용</title>
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
    min-height: 1500px;
	background-color: #f6f6f6;
	font-family: "TheJamsil5Bold";
	font-weight: 400;
	transform: rotate(0.03deg);
}
.container, .container-lg, .container-md, .container-sm, .container-xl, .container-xxl {
    max-width: 60%;
}
.bg-primary {
    --bs-bg-opacity: 1;
    background-color: #FF6529 !important;
}
.text-white {
    --bs-text-opacity: 1;
    color: #fff !important;
}
.text-center {
    text-align: center!important;
}
#imges{
	margin-left: 4%;
}
.p-2 {
    padding: 0.5rem!important;
}
.h5, h5 {
    font-size: 20px;
}
h3{
    margin-top: -25px;
    margin-bottom: 0.5rem;
    font-weight: 500;
    line-height: 1.2;
}
.btn-secondary {
    --bs-btn-color: #FF5918 !important;
    --bs-btn-bg: #fff !important;
    --bs-btn-border-color: #fff !important;
    --bs-btn-hover-color: #FF5918 !important;
    --bs-btn-hover-bg: #DDD !important;
    --bs-btn-hover-border-color: #fff !important;
    --bs-btn-focus-shadow-rgb: 49,132,253 !important;
    --bs-btn-active-color: #fff !important;
    --bs-btn-active-bg: #fff !important;
    --bs-btn-active-border-color: #fff !important;
    --bs-btn-active-shadow: inset 0 3px 5px rgba(0, 0, 0, 0.125) !important;
    --bs-btn-disabled-color: #fff !important;
    --bs-btn-disabled-bg: #fff !important;
    --bs-btn-disabled-border-color: #fff !important;
}
#send{
	margin-left: 500px;
}
.form-select {
    display: block;
    width: 100%;
    padding: 0.375rem 2.25rem 0.375rem 0.75rem;
    -moz-padding-start: calc(0.75rem - 3px);
    font-size: 1rem;
    font-weight: 400;
    line-height: 1.5;
    color: #212529;
    background-color: #fff;
    background-image: url(data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 16 16'%3e%3cpath fill='none' stroke='%23343a40' stroke-linecap='round' stroke-linejoin='round' stroke-width='2' d='m2 5 6 6 6-6'/%3e%3c/svg%3e);
    background-repeat: no-repeat;
    background-position: right 0.75rem center;
    background-size: 16px 12px;
    border: 1px solid #FF6529;
    border-radius: 0.375rem;
    transition: border-color .15s ease-in-out,box-shadow .15s ease-in-out;
    -webkit-appearance: none;
    -moz-appearance: none;
    appearance: none;
}
#subject,#content,#file{
	border: 1px solid #FF6529;
}
hr{
	border: 3px solid #FF6529;
	margin: 0 auto;
    color: inherit;
    opacity: .25;
}
.navbar-brand {
    padding-top: var(--bs-navbar-brand-padding-y);
    padding-bottom: var(--bs-navbar-brand-padding-y);
    margin-right: var(--bs-navbar-brand-margin-end);
    font-size: var(--bs-navbar-brand-font-size);
    color: var(--bs-navbar-brand-color);
    text-decoration: none;
    white-space: nowrap;
    align-items: center;
	justify-content: space-between;
	display: flex;
	flex-wrap: inherit;
	height: 0px;
}

  #datesel {
  	width: 300px;
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
  #send {
    margin-left: 595px;
}
</style>

</head>
<body>
	<div class="container mt-3">
    <nav class="navbar navbar-light bg-light">
        <div class="container">
          <a class="backbtn" href="<%=request.getContextPath() %>/LHH/notice/notice.jsp">
            <img src="<%=request.getContextPath() %>/imges/btn_back.png" alt="" width="30" height="24">
          </a>
          <h4 class="text-center flex-grow-1">공지사항</h4>
        </div>
      </nav>
      </div>

      <div class="container mt-3">
       <div class="notice_con">
        <div class="notice_view">
          <p style="font-weight: bold;"><%=vo.getNoti_ttl() %></p>
          <div class="notice_top">
            <ul>
              <li><%=formattedDate %></li>&nbsp;&nbsp;&nbsp;&nbsp;
              <li>조회수 : <%=vo.getNoti_hit() %></li>
            </ul>
             <div id="button">
        <%if("관리자".equals(mvo.getMem_grade())){%>
    <div class="div_button">
        <button class="btn btn-light" id="btnUpdate" onclick="window.location.href='<%=request.getContextPath()%>/noticeUpdate.do?notiNo=<%=vo.getNoti_no()%>'">수정</button>
		<input class="btn btn-light" type="button" value="삭제" onclick="window.location.href='<%=request.getContextPath()%>/noticeDelete.do?num=<%=vo.getNoti_no()%>'">
    </div>
            <%} %>
</div>
          </div>
        </div>
      </div>
      <hr>
      <div class="notice_btom">
      <% if(vo.getNoti_file() != null && !vo.getNoti_file().isEmpty()) { %>
        <p class="centered"><img src="<%=request.getContextPath()%>/noticeImageView.do?notiNo=<%=vo.getNoti_no()%>" style="width: 50%;"></p>
      <% } %>
        <p class="centered"><%=vo.getNoti_dtl() %></p>
      </div>
    </div>
   

</body>
</html>