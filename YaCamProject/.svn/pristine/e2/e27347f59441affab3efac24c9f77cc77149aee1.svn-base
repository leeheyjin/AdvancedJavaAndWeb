<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="kr">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>야!!!캠핑가자~</title>
	<link id="main icon" rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath()%>/Main_KKD/ICON/camping-favicon.ico">
<link rel="stylesheet" href="../../css/reset.css">
<link rel="stylesheet" href="../../css/login&membership.css">
<script  src="../../js/jquery-3.7.0.min.js"></script>
<script>
$(function(){
 	$('#lo').on('click',function(){
 		id = $('#userId').val();
 		pass = $('#userPass').val();
//  		data={
//  			"id" : id,
//  			"pass" : pass
//  		}
 			$.ajax({
 				url:"<%=request.getContextPath()%>/Login.do",
 				type:"get",
 				data: {"id":id,"pass":pass},
 				success:function(res){
 					console.log(res)
 					if(res.flag=="성공"){
 						alert("정상적으로 로그인이 되셨습니다.");
 						$(location).attr('href', '<%=request.getContextPath()%>/Main_KKD/mainpage.jsp');
 					}else{
 						alert("로그인 정보가 일치하지 않습니다.")
 					}
 				},
 				error:function(xhr){
 					alert("실패하였습니다."+xhr.status)
 				},
 				dataType:"json"
 			});
	});
})

</script>





</head>
<body>
	<div id="login">
		<!--<form name="loginform" action="<%=request.getContextPath()%>/Login.do" method="post">-->
			<div>
				<br><br><br><br><br><br><br><br><br>
				<h1 class="join">로그인</h1>
				<br> 
				<label id="login-id" for="userId">ID </label> <br>
				<input class="input_styles" type="text" id="userId" name="id" placeholder="Id"> <br> 
					<br>
				<label id="login-pass" for="userPs">Password </label> <br>
				<input class="input_styles" type="password" id="userPass" name="pass" placeholder="Password"><br> <br>
				
				<a id="id2" href="../find/idfind.jsp">아이디 찾기 </a>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a id="pass2" href="../find/passfind.jsp"> 비밀번호 찾기</a><br><br>
				 
<!-- 				<input class="input_button_sub" type="submit" value="로그인"> -->
				<button id="lo" class="input_button_sub" type="button"><div>로그인</div></button>
				<a href="../join/join.jsp"><input id="lo" class="input_button_sub" type="button">회원가입</a>
				<a href="<%=request.getContextPath()%>/Main_KKD/mainpage.jsp"><input id="lo" class="input_button_sub" type="button">돌아가기</a>
			</div>
<!-- 		</form> -->
	</div>
</body>
</html>