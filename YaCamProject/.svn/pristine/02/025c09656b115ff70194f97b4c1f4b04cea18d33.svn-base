<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="../../css/reset.css">
<link rel="stylesheet" href="../../css/login&membership.css">

<!--  <script src="<%=request.getContextPath() %>/../js/jquery-3.7.0.min.js"></script> -->
<script
  src="https://code.jquery.com/jquery-3.7.0.min.js"
  integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g="
  crossorigin="anonymous"></script>

</head>
<body>

<script>
$(function(){
	
	
	
	
	//핸드폰 번호 전송버튼
function requestCert(e) {
	console.log('requestCert clicked')
	const reqData = {
			name : $('#name').val(),
			tel: $('#tel').val()
			}
	
	$.ajax({
		url : '<%= request.getContextPath()%>/SendSMS.do',
		data : reqData, 
		type : 'get',
		success :function(res){
			console.log(res);
			if(res.flag==true)
				alert("전송 완료");
			else
				alert("전송 실패")
		},
		error : function(xhr){
			alert("실패: " + xhr.status);
		},
		dataType : 'json'
	})
	
	
}
// 전송 버튼 누를시 
$('#btn_req_cert').on('click', requestCert)

	
	
	//메일 보내기 버튼 누를시
	$('#btn_mail_send').on('click',function(){
		 // 입력 필드가 비어 있는지 확인합니다.
	    if ($('#name').val() == '' || $('#mail').val() == '' ) {
	      alert('모든 필드를 입력해주세요');
	      return; // 요청 중단
	    }
		 
		console.log('mail send')
		mailData ={
			name : $('#name').val(),
			mail : $('#mail').val()
		}
		$.ajax({
			url : '<%= request.getContextPath()%>/MailSend.do',
			data : mailData,
			type : 'get',
			success :function(res){
				console.log(res+"마지막");
				if(res.flag == "이메일 발송 완료")
					alert("전송 완료");
				else
					alert("전송 실패")
			},
			error : function(xhr){
				alert("실패: " + xhr.status);
			},
			dataType : 'json'
		})
	})  // 메일 보내기 버튼 끝
	
}) //functio 끝


// $("#check").on('click', function() {
<%-- 	<% --%>
// 	int telnum=(Integer) request.getAttribute("telnum");
<%--   	%> --%>
//     var num = $("#telnum").val();
<%--     var telnum = <%= telnum %>; // JSP 변수 가져오기 --%>
//     if (telnum == num) {
//       alert("맞습니다");
//     } else {
//       alert("틀립니다");
//     }
//   });



</script>



<div id="idfind">
		<form name="loginform" method="post">
			<div>
				<br><br><br><br><br><br><br><br><br>
				<h1 class="join">아이디 찾기</h1><br> 
				<label for="userId">이름 </label> <br> 
				<input class="input_style" type="text" id="name" name="name" placeholder="이름을 입력하세요"> <br><br> 
				
<!-- 				<label for="userPs">휴대폰 번호 </label> <br>  -->
<!-- 				<input class="find" type="text" id="tel" name="tel" placeholder="ex) 010-1234-5678"> -->
<!-- 				<input id="btn_req_cert" class="input_button_sub3" type="button" value="전송"> -->
<!-- 				<br> <br> -->
				
<!-- 				<h1 class="join"></h1> -->
<!-- 				<label for="userId">인증번호 </label> <br>  -->
<!-- 				<input class="find" type="text" id="telnum" name="telnum" placeholder="인증번호를 입력하세요"> -->
<!-- 				<input id="check" class="input_button_sub3" type="button" value="확인"> -->
<!-- 				<br><br><br>  -->
				
				
				<label for="userPs">이메일 </label> <br> 
				<input class="find" type="text" id="mail" name="mail" placeholder="ex) abc@naver.com">
				<button id="btn_mail_send" class="input_button_sub3" type="button"><div>전송</div></button>
				<br> <br>
				
				
				
				
				
					
			</div>
		</form>
	</div>
	
</body>
</html>