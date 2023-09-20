<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="../../css/reset.css">
<link rel="stylesheet" href="../../css/login&membership.css">

<script
  src="https://code.jquery.com/jquery-3.7.0.min.js"
  integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g="
  crossorigin="anonymous"></script>

</head>
<body>

<script>
$(function(){
	
	
	
	$("#btn_mail_send").on('click', function(){
		 // 입력 필드가 비어 있는지 확인합니다.
	    if ($('#name').val() == '' || $('#mail').val() == '' || $('#id').val()=='' ) {
	      alert('모든 필드를 입력해주세요');
	      return; // 요청 중단
	    }
		console.log('mail send')
		
		mailData = {
			name : $('#name').val(),
			mail : $('#mail').val(),
			id : $('#id').val()
		}
		
		$.ajax({
			url : '<%= request.getContextPath()%>/MailSendPw.do',
			data : mailData,
			type : 'get',
			success :function(res){
				console.log(res);
				if(res.flag=="이메일 발송 완료")
					alert("전송 완료");
				else
					alert("전송 실패")
			},
			error : function(xhr){
				alert("실패: " + xhr.status);
			},
			dataType : 'json'
		})
	})
})

</script>



<div id="idfind">
		<form name="loginform" method="post">
			<div>
				<h1 class="join">비밀번호 찾기</h1><br> 
				<label for="userId">이름 </label> <br> 
				<input class="input_style" type="text" id="name" name="name" placeholder="이름을 입력하세요" required> <br><br> 
				
				<label for="userId">아이디 </label> <br> 
				<input class="input_style" type="text" id="id" name="id" placeholder="아이디를 입력하세요" required> <br><br> 
				
<!-- 				<label for="userPs">휴대폰 번호 </label> <br>  -->
<!-- 				<input class="find" type="text" id="tel" name="tel" placeholder="ex) 010-1234-5678"> -->
<!-- 				<input class="input_button_sub3" type="button" value="전송"> -->
<!-- 				<br> <br> -->
				
				<label for="userPs">이메일 </label> <br> 
				<input class="find" type="text" id="mail" name="mail" placeholder="ex) abc@naver.com" required>
				<input id="btn_mail_send" class="input_button_sub3" type="button" value="전송">
				<br> <br>
				
<!-- 				<h1 class="join"></h1> -->
<!-- 				<label for="userId">인증번호 </label> <br>  -->
<!-- 				<input class="find" type="text" id="telnum" name="telnum" placeholder="인증번호를 입력하세요"> -->
<!-- 				<input class="input_button_sub3" type="button" value="확인"> -->
<!-- 				<br><br><br>  -->
				
				
				
				
					
			</div>
		</form>
	</div>
	
</body>
</html>