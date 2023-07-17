<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-3.6.0.js"></script>
</head>
<body>
	<form action="fileUpload04_process.jsp" method="post"
		enctype="multipart/form-data">
		<p>
			이름: <input type="text" name="name" required>
		</p>
		<p>
			제목: <input type="text" name="subject" required>
		</p>
		<p>
			파일: <input type="file" id="uploadFile" name="fileName" multiple>
		</p>
		<p id="pImg"></p>
		<input type="submit" value="파일올리기">
	</form>
	<script type="text/javascript">
		$(function() {
			$("#uploadFile").on("change", handleImgFileSelect);
		});

		// e: onchange 이벤트 객체
		function handleImgFileSelect(e) {
			// e.target: <input type="file">
			let	files = e.target.files;
			// multiple일때처럼 이미지가 여러개 있을 수 잇음. 이미지들을 각각 분리해서 배열로 만듦
			let fileArr = Array.prototype.slice.call(files);
			// 파일 타입의 배열 반복. f: 배열 안에 들어있는 각각의 이미지 파일 객체 하나
			fileArr.forEach(function(f) { // == for(ProductVO vo:list)
				// 이미지 파일이 아닌 경우 이미지 미리보기 실패 처리(MIME타입으로 체킹)
				if (!f.type.match("image.*")) {
					alert("이미지 파일만 가능합니다.")
					return false; // 함수 종료
				}
				// 이미지 객체 읽어오기: 자바스크립트의 reader객체
				let reader = new FileReader();
				// e: reader가 이미지 파일을 읽는 이벤트
				reader.onload = function(e) {
					// e.target == f(이미지 객체)
					let imgHtml = `<img src="\${e.target.result}" style="width: 100px;" />`; // reader가 이미지를 다 읽은 결과(result)
					$("#pImg").html(imgHtml);
				};
				reader.readAsDataURL(f);	 // 이미지 파일 객체(f)의 binary를 읽어옴
			});
		}
	</script>
</body>
</html>