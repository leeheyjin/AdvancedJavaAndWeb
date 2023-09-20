<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원가입</title>
<link id="main icon" rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath()%>/Main_KKD/ICON/camping-favicon.ico">
<link rel="stylesheet" href="../../css/reset.css">
<link rel="stylesheet" href="../../css/login&membership.css">

<script src="<%=request.getContextPath() %>/js/jquery-3.7.0.min.js"></script>

<script>

$(function(){
	
	//회원가입 버튼 누르면
	$("#save").on('click', function(){
		idvalue = $('#id').val();
		pwvalue = $('#pass').val();
		namevalue = $('#name').val();
		telvalue = $('#tel').val();
		addvalue = $('#addr').val();
		mailvalue = $('#mail').val();
		gendervalue = $('input[name="gender"]:checked').val();
		birvalue = $('#bir').val();
		gradevalue = $('#grade').val();
		
		console.log(pwvalue, gendervalue,birvalue,"아리가또",idvalue)
		
		fdata = {
			"id"     : idvalue,
			"pw"     : pwvalue,
			"name"   : namevalue,
			"tel"    : telvalue,
			"addr"   : addvalue,
			"mail"   : mailvalue,
			"gender" : gendervalue,
			"bir"   : birvalue,
			"grade"  : gradevalue,
		}
		console.log(fdata)
		 
		$.ajax({
			 url: '<%= request.getContextPath()%>/join.do',
			 data : fdata,
			 type : 'post',
			 success : function(res){
				 if(res.flag  == "성공"){
					 	alert("회원가입 완료")
						vpage = "<%=request.getContextPath()%>/pbc/login/sign.jsp"
						location.href=vpage;
					 } else{
						alert(res.flag) 
					 }
			 },
			 error : function(xhr){
				 alert("상태 : " + xhr.status);
				 alert("상태 : " + xhr.status);
			 },
			 dataType : 'json'
		})
		  console.log(fdata)
	}); // 회원가입버튼 끝
	
	
	 //비밀번호 확인
	 $('#pass2').on('keyup', function(){
		pw1 = $('#pass').val();
		pw2 = $('#pass2').val(); 
		 
	 	if(pw1 == pw2){
			 $('#spid').html("비밀번호가 일치").css('color','green')
			 
	 	}else{
			 $('#spid').html("비밀번호 불일치").css('color','red')
	 	}
	 });//비밀번호 확인끝
	 
	  $('#checkid').on('click', function(){
		  //입력한 id를 가져온다
		  var idvalue = $('#id').val();
		  $.ajax({
			  url : "<%=request.getContextPath()%>/CheckId.do",
			  data : {"id" : idvalue},
			  type : 'get',
			 
			  success : function(res){
				  alert(res.flag);
			  },
			  error : function(xhr){
				  alert("상태 : " + xhr.status);
			  },
			  dataType : 'json'
		  })
		  
	  }); // 아이디 확인
	 
	  
     	
     		
     	
    
     		
}) //function끝

</script>

</head>
<body>
	<div id="mem">
		<form>
			<div>
				<legend class="join">JOIN</legend>
				<br>
				<br> <label>아이디 </label><br>
				<input required class="input_style_sub" type="text" id="id" name="id"  placeholder="아이디를 입력하세요."> 
				<button id="checkid" type="button"><div>중복확인</div></button> <br>
				<div id="id_check"></div>
				

				<br> <label>비밀번호 </label><br>
					<div class="pw_position">
						<input required class="input_style" type="password" id="pass" name="pass" placeholder="비밀번호를 입력하세요">
					</div> <br> <label for="userPs2">비밀번호확인 </label><br>
					<div></div>
					<div class="pw_position">
						<input required class="input_style" type="password" id="pass2" name="pass2"
							placeholder="비밀번호를 입력하세요"><span id="spid"></span> <br>
					</div>
					<br> <label>이름</label><br>
					<input required class="input_styles" type="text" id="name" name="name" 	placeholder="홍길동"><br>
						
					<br> <label>이메일 주소</label><br>
					<input required	class="input_styles" type="email" id="mail" name="mail" placeholder="dditddit23@co.kr"><br>
						
					<br> <label>전화번호 </label><br>
					<input required class="input_styles" type="tel" id="tel" name="tel" placeholder="01012345678"><br>
						
					<br>	
					<label id="m" ><input type="radio"  name="gender" value="M" checked="checked">남</label>
					<label id="w"><input type="radio"  name="gender" value="W">여</label>
					<br>	
						
						
					<br> <label>생년월일</label><br> <input required class="input_style" type="date" id="bir" name="bir"><br> <br>

						<label>주소</label><br> <input required	class="input_style" type="text" id="addr" name="addr"><br>
						
						<input type="hidden" id="grade" name="grade" value="회원">	
						<input type="hidden" id="date" name="date">
						
					<br> <br> <button class="input_button_sub1" id="save" type="button"><div>회원가입</div></button> <br>
					<br> <button onclick="location.href='<%=request.getContextPath()%>/pbc/login/sign.jsp'" class="input_button_sub2" type="reset"><div>취소</div></button>
			</div>
		</form>
	</div>
</body>
</html>