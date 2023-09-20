<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
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

//쿠폰발행
$(function(){ 
$('.coupon').on('click',function(){
// 	var select = $('select option:selected').val();
	var user = $(this).attr('name');
	var select = $(this).parent().find('select option:selected').val(); 
	if("쿠폰발행"!=select){
		$.ajax({
			url:"<%=request.getContextPath()%>/InsertCoupon.do",
			type:"get",
			data:{"select" :select,
				  "user" : user
				},
			success:function(res){
				alert("쿠폰이 성공적으로 발행되었습니다.")
			},
			error:function(xhr){
				alert("쿠폰발행을 실패하였습니다."+xhr.status)
			},
			dataType:"json"
		});
	}
	else{
		alert("쿠폰을 선택해주세요");
	}
});


//블랙리스트
$('.black').on('click',function(){
	if (confirm("정말 블랙리스트 설정 하시겠습니까??") == true){
		
	var id = $(this).attr('name');
		$.ajax({
			url:"<%=request.getContextPath()%>/InsertBlackList.do",
			type:"get",
			data:{"id" : id},
			success:function(res){
				alert("블랙리스트로 지정하셧습니다..")
			 	$(location).attr('href', '<%=request.getContextPath()%>/MemberList.do');
			},
			error:function(xhr){
				alert("상태 : "+xhr.status)
			},
			dataType:"json"
		})
		
	}
});


//회원수정
$('.update').on('click',function(){
		
	var id = $(this).attr('name');
		$.ajax({
			url:"<%=request.getContextPath()%>/InsertBlackList.do",
			type:"get",
			data:{"id" : id},
			success:function(res){
			},
			error:function(xhr){
				alert("상태 : "+xhr.status)
			},
			dataType:"json"
		})
		
});
	
	
//회원탈퇴
$('.delete').on('click',function(){
	var txt;
	var id = $(this).attr('name');
	var r = confirm("정말로 삭제 하시겠습니까?");
	if (r == true) {
	  $.ajax({
		 url : "<%=request.getContextPath()%>/DeleteUserInfo.do" ,
		 type : 'get',
		 data : {"id" : id},
		 success : function(res){
			 alert("탈퇴"+res.flag);
			 if(res.cnt=="성공"){
			 	$(location).attr('href', '<%=request.getContextPath()%>/MemberList.do');
			 }
		 },
		 error :function(xhr) {
			 alert(xhr.stauts)
		 },
		 dataType:'json'
	  });
	} else {
		txt = "삭제 취소"
	  	alert(txt)
	}
});

})//끝





// function insertcoupon(){

// 	alert("쿠폰을 발행했습니다.");
	
	
// }
// function ebutton(){
// 	   alert("쿠폰 생성완료!");
// 	};

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
	#img2{
		float: left;
		margin-top: 54px;
		margin-left: 30px;
	}
</style>


</head>



<%
int cnt=1;
List<MemberVO> list = (List<MemberVO>)request.getAttribute("list");
%>
<%MemberVO mvo = (MemberVO)session.getAttribute("userinfo"); %>
<body>
<div id="main_contaner">
	<div id="header">
		<br>
		<a class="navbar-brand" href="<%=request.getContextPath()%>/Main_KKD/mainpage.jsp">
            <img id="img2" src="<%=request.getContextPath()%>/imges/btn_back.png" alt="" width="30" height="24">
        </a>
	    <header id="head_box" style="font-size: xx-large;">회원 목록<br><br><hr></header>
		<nav id="nav">
		    <div id="nav_myinfo">
		    <div><br><br><br><br>
			    <a href="#" style="margin-left: 100px;"><img id="user_img" src="<%=request.getContextPath()%>/imges/user.png" alt="사람"></a>
		       </div>
		    <div id="nav_text">
		        <br><br><br><br><div>관리자</div>
		        <div><%=mvo.getMem_name() %></div>
		        <br>
		        <a class="tag" href="<%=request.getContextPath() %>/selectBlackList.do"><input type="button" value="블랙리스트 목록"></a>
				<a class="tag" href="<%=request.getContextPath() %>/LMW/manager/chart.jsp"><input type="button" value="통계보기"></a>
				<a class="tag" href="<%=request.getContextPath() %>/reportList.do"><input type="button" value="신고내역"></a>
				
		    </div>
			</div>
			
		</nav>
			<div>
				
			</div>
	</div>
		<hr>
	<div id="body">
		<table border="1">
			<tr>
				<th class = "th">아이디</th>
				<th class = "th">비밀번호</th>
				<th class = "th">이름</th>
				<th class = "th" style="width: 35px;">성별</th>
				<th class = "th">생년월일</th>
				<th class = "th">전화번호</th>
				<th class = "th">주소</th>
				<th class = "th">가입일</th>
				<th class = "th">등급</th>
				<th class = "th">이메일</th>
				<th class = "th" style="width: 65px;">탈퇴여부</th>
				<th class = "th" colspan="4" ></th>
				
			</tr>
		<%
		for(MemberVO vo : list){
			cnt++;
		%>
			<tr>
				<td>
					<%=vo.getMem_id()%><br>
				</td>
				<td>
					<%=vo.getMem_pass()%><br>
				</td>
				<td>
					<%=vo.getMem_name()%><br>
				</td>
				<td>
					<%=vo.getMem_gender()%><br>
				</td>
				<td>
					<%=vo.getMem_birth()%><br>
				</td>
				<td>
					<%=vo.getMem_tel()%><br>
				</td>
				<td>
					<%=vo.getMem_addr()%><br>
				</td>
				<td>
					<%=vo.getMem_date()%><br>
				</td>
				<td style="width: 45px;">
					<%=vo.getMem_grade()%><br>
				</td>
				<td>
					<%=vo.getMem_mail()%><br>
				</td>
				<td>
					<%=vo.getMem_delete()%>
				</td>
			
				<td>
<%-- 					<form id="all" action="<%=request.getContextPath()%>/InsertCoupon.do" onsubmit="insertcoupon()"> --%>
						<select class="select" name="select">
							<option>쿠폰발행</option>
							<option value="new">신규가입쿠폰</option>
							<option value="birth">생일쿠폰</option>
							<option value="event">이벤트 쿠폰</option>
							<option value="chllenge">첼린지 쿠폰</option>
						</select>
						<input type="hidden" value="<%=vo.getMem_id()%>" name="user">
						<input id="couponinsert" type="button" value="쿠폰발행하기" class="coupon" name="<%=vo.getMem_id()%>">
<!-- 						<input id="couponinsert" type="submit" value="쿠폰발행하기"> -->
					</form>					
				</td>
				<td>
					<input type="button" value="블랙리스트" name="<%=vo.getMem_id()%>" class="black">
				</td>
				<td>
					<form action="<%=request.getContextPath()%>/Update.do">
						<input type="submit" value="회원수정" class="update">
						<input type="hidden"  value="<%=vo.getMem_id()%>" name="userId">
					</form>
				</td>
				<td>
					<input type="button" value="회원탈퇴"  name="<%=vo.getMem_id()%>" class="delete">
				</td>
			</tr>
		
		<%}%>
		</table>
	</div>
</div>
</body>
</html>