<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="../../js/jquery-3.7.0.min.js"></script>



<%-- <%int cnt = (int)request.getAttribute("cnt"); %> --%>
<%-- <%if(cnt>0){ %> --%>

<%-- <%}else{%> --%>

<%-- <%}%> --%>



<script>
// $(function(){ 
//  	$('#couponinsert').on('click',function(){
//  		var select = $('select option:selected').val();
//  		if("쿠폰발행"!=select){
//  			$.ajax({
//  				url:"/InsertCoupon.do",
//  				type:"get",
//  				data:"select="+select,
//  				success:function(res){
//  					alert("쿠폰이 성공적으로 발행되었습니다.")
//  				},
//  				error:function(xhr){
//  					alert("쿠폰발행을 실패하였습니다."+xhr.status)
//  				},
//  			});
//  		}
//  		else{
//  			alert("실패");
//  		}
// 	});
// });
function ebutton(){
	alert("쿠폰 생성완료!");
};

</script>

<body>
	<form id="all" action="<%=request.getContextPath()%>/InsertCoupon.do" onsubmit="ebutton()">
		<select id="select" name="select">
			<option>쿠폰발행</option>
			<option value="new">신규가입쿠폰</option>
			<option value="birth">생일쿠폰</option>
			<option value="event">이벤트 쿠폰</option>
			<option value="chllenge">첼린지 쿠폰</option>
		</select>
<!-- 		<input id="couponinsert" type="button" value="쿠폰발행하기"> -->
		<input id="couponinsert" type="submit" value="쿠폰발행하기">
	</form>
	
	
</body>
</html>