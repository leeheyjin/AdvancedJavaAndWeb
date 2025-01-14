<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<title>야!!!캠핑가자~</title>
	<link id="main icon" rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath()%>/Main_KKD/ICON/camping-favicon.ico">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<!-- <link href="../css/board.css" rel="stylesheet"> -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<script src="../js/jquery-3.7.0.min.js"></script>
	<script src="../js/jquery.serializejson.min.js"></script>
	<script src="../js/community.js"></script>
	<%MemberVO vo = (MemberVO)session.getAttribute("userinfo"); %>
	<%-- <%=vo.getMem_id() %> --%>

<script>
	mypath = '<%= request.getContextPath()%>';
	currentPage = 1;
	
	$(document).ready(function() {
		  // HTML에서 Review Board 클릭 이벤트 처리
		  $("#reviewBoard").click(function() {
		    // Review Board 요소의 값을 가져오기
		    var Clickvalue = $("#reviewBoard").attr("data-value");

		    // 가져온 값 사용하기
		    console.log("Review Board 값: " + Clickvalue);
		  });
		});
	
	$(function () {
		listPageServer(1);
		
		//전체게시판 클릭이벤트
		$('#totalBoard').on('click', function() {
			listPageServer(1);
		})
		
		//후기게시판 클릭이벤트
		$('#reviewBoard').on('click', function() {
			listSelectServer(1);
		})
		
		//자유게시판 클릭이벤트
		$('#freeBoard').on('click', function() {
			freeBoardList(1);
		})
		
		//환경보호챌린지 클릭이벤트
		$('#bohoBoard').on('click', function() {
			bohoBoardList(1);
		})
		
		// 검색이벤트 - 엔터
		$('#sword').on('keypress', function(key) {
		    if(key.keyCode == '13') {
		    	listPageServer(1);
		   }
		})
		
		//검색이벤트 - 버튼클릭
		$('#search').on('click', function(){
			//stype - mem_id, comm_ttl, comm_dtl
			//sword - 입력한 값
			listPageServer(1);
		})
		
		//페이지번호 클릭이벤트
        $(document).on('click', '.pageno', function () {
            currentPage = parseInt($(this).text().trim());
            listPageServer(currentPage);
          })
          
        //다음버튼 이벤트 - delegate
        $(document).on('click', '#next', function () {
            currentPage = parseInt($('.pageno').last().text()) + 1;
            listPageServer(currentPage);
          })

        //이전버튼 이벤트
        $(document).on('click', '#prev', function () {
            currentPage = parseInt($('.pageno').first().text()) - 1;
            listPageServer(currentPage);
          })
          
		//리뷰페이지번호 클릭이벤트
        $(document).on('click', '.pagenoReview', function () {
            currentPage = parseInt($(this).text().trim());
            listSelectServer(currentPage);
          })
          
        //리뷰다음버튼 이벤트 - delegate
        $(document).on('click', '#nextReview', function () {
            currentPage = parseInt($('.pagenoReview').last().text()) + 1;
            listSelectServer(currentPage);
          })

        //리뷰이전버튼 이벤트
        $(document).on('click', '#prevReview', function () {
            currentPage = parseInt($('.pagenoReview').first().text()) - 1;
            listSelectServer(currentPage);
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
    min-width: 800px;
    min-height: 500px;
    text-align: center;
    font-family: "TheJamsil5Bold";
}
.nav {
    --bs-nav-link-padding-x: 1rem;
    --bs-nav-link-padding-y: 0.5rem;
    --bs-nav-link-font-weight: ;
	--bs-nav-link-color: #FF6529;
    --bs-nav-link-hover-color: #000;
    --bs-nav-link-disabled-color: #6c757d;
    display: flex;
    flex-wrap: wrap;
    padding-left: 0;
    margin-bottom: 0;
    list-style: none;
}
.navbar {
    --bs-navbar-padding-x: 0;
    --bs-navbar-padding-y: 0.5rem;
    --bs-navbar-color: rgba(0, 0, 0, 0.55);
    --bs-navbar-hover-color: rgba(0, 0, 0, 0.7);
    --bs-navbar-disabled-color: rgba(0, 0, 0, 0.3);
    --bs-navbar-active-color: rgba(0, 0, 0, 0.9);
    --bs-navbar-brand-padding-y: 0.3125rem;
    --bs-navbar-brand-margin-end: 1rem;
    --bs-navbar-brand-font-size: 1.25rem;
    --bs-navbar-brand-color: rgba(0, 0, 0, 0.9);
    --bs-navbar-brand-hover-color: rgba(0, 0, 0, 0.9);
    --bs-navbar-nav-link-padding-x: 0.5rem;
    --bs-navbar-toggler-padding-y: 0.25rem;
    --bs-navbar-toggler-padding-x: 0.75rem;
    --bs-navbar-toggler-font-size: 1.25rem;
    --bs-navbar-toggler-icon-bg: url(data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 30 30'%3e%3cpath stroke='rgba%280, 0, 0, 0.55%29' stroke-linecap='round' stroke-miterlimit='10' stroke-width='2' d='M4 7h22M4 15h22M4 23h22'/%3e%3c/svg%3e);
    --bs-navbar-toggler-border-color: rgba(0, 0, 0, 0.1);
    --bs-navbar-toggler-border-radius: 0.375rem;
    --bs-navbar-toggler-focus-width: 0.25rem;
    --bs-navbar-toggler-transition: box-shadow 0.15s ease-in-out;
    position: relative;
    display: flex;
    flex-wrap: wrap;
    align-items: center;
    justify-content: space-between;
    padding: var(--bs-navbar-padding-y) var(--bs-navbar-padding-x);
    font-size: 13px;
}
hr{
	border: 2px solid #F54500;
}
.pagination {
    --bs-pagination-padding-x: 0.75rem;
    --bs-pagination-padding-y: 0.375rem;
    --bs-pagination-font-size: 13px;
    --bs-pagination-color: #FF6529;
    --bs-pagination-bg: #fff;
    --bs-pagination-border-width: 1px;
    --bs-pagination-border-color: #dee2e6;
    --bs-pagination-border-radius: 0.375rem;
    --bs-pagination-hover-color: #FF6529;
    --bs-pagination-hover-bg: #e9ecef;
    --bs-pagination-hover-border-color: #dee2e6;
    --bs-pagination-focus-color: #FF6529;
    --bs-pagination-focus-bg: #e9ecef;
    --bs-pagination-focus-box-shadow: 0 0 0 0.25rem rgba(13, 110, 253, 0.25);
    --bs-pagination-active-color: #fff;
    --bs-pagination-active-bg: #FF6529;
    --bs-pagination-active-border-color: #FF6529;
    --bs-pagination-disabled-color: #6c757d;
    --bs-pagination-disabled-bg: #fff;
    --bs-pagination-disabled-border-color: #dee2e6;
    display: flex;
    padding-left: 0;
    list-style: none;
}
.nav-pills {
    --bs-nav-pills-border-radius: 0.375rem;
    --bs-nav-pills-link-active-color: #fff;
    --bs-nav-pills-link-active-bg: #FF6529;
}
.navbar>.container, .navbar>.container-lg, .navbar>.container-md, .navbar>.container-sm, .navbar>.container-xl, .navbar>.container-xxl {
    display: flex;
    flex-wrap: inherit;
    align-items: center;
    justify-content: space-between;
    color: #000;
    font-weight: bold;
    height: 10%;
}
h4 {
	text-align: center;
	font-size: 20px;
}
#result{
font-size: 13px;
}
.btn btn-dark {
	margin-left: auto; /* 왼쪽 여백을 자동으로 설정하여 오른쪽으로 보냅니다 */
}
#stype{
	margin-right: 2%;
	border: 1px solid #ced4da;
	border-radius: 0.375rem;
}
#search {
	display: flex;
}

.container-fluid {
	max-width: 380px; /* Adjust the width as needed */
	text-align: center;
}
.btn-dark {
    --bs-btn-color: #fff;
    --bs-btn-bg: #FF6529;
    --bs-btn-border-color: #FF5918;
    --bs-btn-hover-color: #fff;
    --bs-btn-hover-bg: #FF713A;
    --bs-btn-hover-border-color: #FF6529;
    --bs-btn-focus-shadow-rgb: 66,70,73;
    --bs-btn-active-color: #fff;
    --bs-btn-active-bg: #FF713A;
    --bs-btn-active-border-color: #FF5918;
    --bs-btn-active-shadow: inset 0 3px 5px rgba(0, 0, 0, 0.125);
    --bs-btn-disabled-color: #fff;
    --bs-btn-disabled-bg: #FF6529;
    --bs-btn-disabled-border-color: #FF5918;
}
.btn-light {
	--bs-btn-color: #FF6529;
	--bs-btn-bg: #f8f9fa;
	--bs-btn-border-color: #f8f9fa;
	--bs-btn-hover-color: #FF6529;
	--bs-btn-hover-bg: #d3d4d5;
	--bs-btn-hover-border-color: #c6c7c8;
	--bs-btn-focus-shadow-rgb: 211,212,213;
	--bs-btn-active-color: #FF6529;
	--bs-btn-active-bg: #c6c7c8;
	--bs-btn-active-border-color: #babbbc;
	--bs-btn-active-shadow: inset 0 3px 5px rgba(0, 0, 0, 0.125);
	--bs-btn-disabled-color: #FF6529;
	--bs-btn-disabled-bg: #f8f9fa;
	--bs-btn-disabled-border-color: #f8f9fa;
}
</style>
</head>
<body>
  <div class="container mt-3">
<nav class="navbar navbar-light bg-light">
        <div class="container">
          <a class="navbar-brand" href="<%=request.getContextPath()%>/Main_KKD/mainpage.jsp">
            <img id="navImg" src="../imges/btn_back.png" alt="" width="30" height="24">
          </a>
          <h4 class="text-center flex-grow-1">게시판</h4>
        </div>
      </nav>
      <hr>
      <br>
    <ul class="nav nav-pills nav-justified">
      <li class="nav-item">
        <a class="nav-link" href="#" id="totalBoard" name="totalBoard" data-value="전체게시판">전체게시판</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#" id="reviewBoard" name="reviewBoard" data-value="후기게시판">후기게시판</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#" id="freeBoard" name="freeBoard" data-value="자유게시판">자유게시판</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#" id="bohoBoard" name="bohoBoard" data-value="환경보호챌린지">환경보호 챌린지</a>
      </li>
    </ul><br>
    <div id="result"></div>
    <%if(vo!=null) { %>
    <button type="button" class="btn btn-light" style="float: right;" onclick="location.href='${mypath}/YaCamProject/LHH/BoardInsert.jsp'">글쓰기</button>
    <%} %>
    <div id="pageList"></div>
  </div>
 
  <nav class="navbar navbar-light">
    <div id="search" class="container-fluid">

      <form class="d-flex" onsubmit="return false">
        <select id="stype">
          <option value="">전체</option>
          <option value="comm_ttl">제목</option>
          <option value="mem_id">작성자</option>
          <option value="comm_dtl">내용</option>
        </select>
        <input class="form-control me-2" type="text" id="sword" placeholder="검색" aria-label="Search">
        <button class="btn btn-light" type="button" id="search">Search</button>
      </form>
      
    </div>
  </nav>

</body>
</html>