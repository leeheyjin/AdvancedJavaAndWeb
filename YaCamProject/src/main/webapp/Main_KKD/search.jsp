<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>야!!!캠핑가자~</title>
<link id="main icon" rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath()%>/Main_KKD/ICON/camping-favicon.ico">
<link rel="stylesheet" href="../css/reset.css"></link>
<link rel="stylesheet" href="../css/search.css"></link>
 
<script src="../js/jquery-3.7.0.min.js"></script>
 <script src="https://code.jquery.com/jquery-latest.min.js"></script>
	
<script type="text/javascript">
	<%MemberVO vo = (MemberVO)session.getAttribute("userinfo"); %>
</script>
</head>
<body>
    <div id="header">
        <div id="top">
            <div id="top_logo">
                <a href="./mainpage.jsp"><img id="logoimg" src="./ICON/야!!!캠핑가자~ 로고(배경X).png"></a>
        	</div>
        </div>
            	<%if(vo == null){ %>	           
            	<a id="login" class="right" href="<%=request.getContextPath()%>/pbc/login/sign.jsp"><button id="button" type="button"><div>로그인</div></button></a>
            	<%}else{%>
            	<a id="mypage" class="right" href="<%=request.getContextPath()%>/LMW/mypage/myPage.jsp"><button id="button-my" type="button"><div>마이페이지</div></button></a>
            	<%}if(vo != null){%>
            	<a id="logout" class="right" href="<%=request.getContextPath()%>/Main_KKD/mainpage.jsp"><button id="button-out" type="button"><div>로그아웃</div></button></a>
            	<%} %>
    </div>
	<div id="midle">
		<div id="searchNav">
			<div id="head2">검색</div>
		</div>
		<hr><br><br><br><br><br><br><br>
		<form action="<%=request.getContextPath() %>/search.do" id="searchTop" method="get">
		<br><br>
		<input id="search" name="search" type="text" placeholder="캠핑장명을 입력하세요." autocomplete="off">
		<button type="button" id="submit">검색</button>
				<p id="searchGude">(검색어 예시: 베스트필드 글램핑장, 제이하우스 펜션.....등등)</p>		
		</form>
	</div>
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