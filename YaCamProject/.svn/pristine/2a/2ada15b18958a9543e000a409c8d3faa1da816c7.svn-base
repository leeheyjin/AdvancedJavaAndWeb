<%@page import="kr.or.ddit.report.vo.ReportVO"%>
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="tmp.jsp" %>

<script>
$(function(){
$('.noblack').on('click',function(){
	if (confirm("정말 블랙리스트를 해지 하시겠습니까??") == true){
		var id = $(this).attr('name');
			$.ajax({
				url:"<%=request.getContextPath()%>/InsertBlackList.do",
			type:"post",
			data:{"id" : id},
			success:function(res){
				alert("블랙리스가 해지되었습니다.")
			 	$(location).attr('href', '<%=request.getContextPath()%>/MemberList.do');
			},
			error:function(xhr){
				alert("상태 : "+xhr.status)
			},
			dataType:"json"
		})
		
	}
})
	
})

</script>

<style>
	@font-face {
    font-family: 'TheJamsil5Bold';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2302_01@1.0/TheJamsil5Bold.woff2') format('woff2');
    font-weight: 700;
    font-style: normal;
	}
	
	table{
		border: 2px solid black;
	}
	tbody{
		border: 0px;
	}
	tr{
		border: 0px;
	}
	td{
		text-align: center;
		align-items: center;
		vertical-align: middle;
		padding: 3px;
		border: 2px solid black;
	}
	
	th{
		text-align: center;
		vertical-align: middle;
		padding: 3px;
		border: 2px solid black; 
	}
	
	#main icon{
	display: block;
    margin: auto;
    cursor: zoom-in;
    background-color: hsl(0, 0%, 90%);
    transition: background-color 300ms;
	}
	
	body{
	background-color: #f6f6f6;
	font-family: "TheJamsil5Bold";
	font-weight: 400;
	transform: rotate(0.03deg);
	margin:0;
	position: relative;	
	
	}
	
	hr {
    border: 2px solid #E44000;
    margin: 0 auto;
    color: inherit;
    opacity: .25;
	}
	
	
	
	#head_box{
		height: 30px;
	    float: none;
	    padding-top: 50px;
	    border: 0px;
	}
	#body{
		margin-top: 30px;
		border: 2px solid black;
	}
	#header, #nav_text, #nav_myinfo, #nav{
		border: 0px;
	}
	#nav_myinfo{
		width: 600px;
	}
	.tag{
		padding: 3px;	
	}
	.th{
		background: #f8cfbf;
	}
	#nav_myinfo{
		padding-top: 65px;
		padding-left: 100px;
	}
	
</style>


<%List<ReportVO> list = (List<ReportVO>)request.getAttribute("list"); %>
<%MemberVO mvo = (MemberVO)session.getAttribute("userinfo"); %>
</head>
<body>
<div id="main_contaner">
	<div id="header">
	    <header id="head_box" style="font-size: xx-large;">신고내역<br><br><hr></header>
   		<nav id="nav">
        <div id="nav_myinfo">
	        <div>
	    	    <a href="#"><img id="user_img" src="<%=request.getContextPath()%>/imges/user.png" alt="사람"></a>
	        </div>
		    <div id="nav_text">
		        <div>관리자</div>
		        <div><%=mvo.getMem_name() %></div>
		    </div>
		</div>
		
	    </nav>
	</div>
		<hr>
	<div id="body">
		<table border="1">
				<tr>
					<th class = "th">신고번호</th>
					<th class = "th">분류</th>
					<th class = "th">신고내용</th>
					<th class = "th">조치여부</th>
					<th class = "th">게시글번호</th>
					<th class = "th">회원아이디</th>
				</tr>
			<%for(ReportVO vo: list){ %>
				<tr>
					<td><%=vo.getRep_no()%></td>
					<td><%=vo.getRep_reason()%></td>
					<td><%=vo.getRep_dtl()%></td>
					<td><%=vo.getRep_action()%></td>
					<td><%=vo.getComm_no()%></td>
					<td><%=vo.getMem_id()%></td>
				</tr>
			<%} %>
		</table>
	</div>
</div>
</body>
</html>