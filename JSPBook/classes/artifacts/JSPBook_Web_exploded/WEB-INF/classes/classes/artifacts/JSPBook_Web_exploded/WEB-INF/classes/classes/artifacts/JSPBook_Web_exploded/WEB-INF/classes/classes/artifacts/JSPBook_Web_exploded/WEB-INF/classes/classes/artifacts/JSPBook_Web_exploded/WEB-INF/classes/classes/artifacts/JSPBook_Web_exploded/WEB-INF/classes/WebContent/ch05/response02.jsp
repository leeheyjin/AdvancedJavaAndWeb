<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p id="p1"></p>
<script>
function gogo() {
	let today = new Date();
	console.log("today : " + today);
	
	let year = today.getFullYear();
	let month = ('0' + (today.getMonth() + 1)).slice(-2);
	let day = ('0' + today.getDate()).slice(-2);
	let dateString = year + "-" + month + "-" + day;
	console.log("dateString : " + dateString);
	
	let hours = ('0' + today.getHours()).slice(-2);
	let minutes = ('0' + today.getMinutes()).slice(-2);
	let seconds = ('0' + today.getSeconds()).slice(-2);
	let timeString = hours + ":" + minutes + ":" + seconds;
	console.log("result: " + dateString + " " + timeString);
	
	document.querySelector("#p1").innerHTML = dateString + " " + timeString;
	
}
setInterval(gogo, 1000);
</script>
</body>
</html>