<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="true"%>
<!DOCTYPE html>
<html lang="kr">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script type="text/javascript" src="../js/jquery-3.7.0.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="../js/board.js"></script>
<script type="text/javascript" src="../js/jquery.serializejson.min.js"></script>
<style type="text/css">
body * {
	box-sizing: border-box;
}

.card-body {
	display: flex;
	flex-direction: column;
}

.p1p2 {
	display: flex;
	flex-direction: row;
}

.p1 {
	flex: 30%;
}

.p2 {
	flex: 70%;
	text-align: right;
}

p {
	padding: 5px;
}

input[name=reply] {
	height: 55px;
	vertical-align: top;
}

.pagination {
	justify-content: center;
}

nav a {
	display: none; /* 존재하지 않음 */
	/* visibility: hidden; 존재하나 보이지 않음 */
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="javascript:void(0)">Logo</a>
			<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="mynavbar">
				<ul class="navbar-nav me-auto">
					<li class="nav-item"><a class="nav-link"
						href="javascript:void(0)">Link</a></li>
					<li class="nav-item"><a class="nav-link"
						href="javascript:void(0)">Link</a></li>
					<li class="nav-item"><a class="nav-link"
						href="javascript:void(0)">Link</a></li>
				</ul>
				<form class="d-flex">
					<select class="form-select" id="stype">
						<option value="">전체</option>
						<option value="writer">작성자</option>
						<option value="subject">제목</option>
						<option value="content">내용</option>
					</select> 
					<input class="form-control me-2" type="text" id="sword" placeholder="Search">
					<button class="btn btn-primary" type="button" id="search">Search</button>
				</form>
			</div>
		</div>
	</nav>
	<div id="result"></div>
	<input type="button" value="글쓰기" id="write" data-bs-toggle="modal" data-bs-target="#wModal">
	<br>
	<div id="pageList"></div>

	<!-- 글쓰기 Modal -->
	<div class="modal" id="wModal">
		<div class="modal-dialog">
			<div class="modal-content">
	
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Modal Heading</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				</div>
	
	     		<!-- Modal body -->
				<div class="modal-body">
					<form name="mfrom" id="mform">
						<input type="hidden" id="num" name="num" >
						<label>이름</label>
						<input type="text" class="txt" id="writer" name="writer"> <br> 
	            
						<label>제목</label>
						<input type="text" class="txt" id="subject" name="subject"> <br> 
	
						<label>메일</label>
						<input type="text"  class="txt" id="mail" name="mail"> <br> 
						
						<label>비밀번호</label>
						<input type="password"  class="txt" id="password" name="password"> <br> 
						
						<label>내용</label><br>
						<textarea rows="5" cols="40"  class="txt" id="content" name="content"></textarea>
						<br>
						<br>
						<input type="button" value="전송" id="msend">
					</form>
				</div>
	
	      <!-- Modal footer -->
	      <div class="modal-footer">
	        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
	      </div>
	
	    </div>
	  </div>
	</div>
	
	<!-- 수정 Modal -->
	<div class="modal" id="mModal">
		<div class="modal-dialog">
			<div class="modal-content">
	
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Modal Heading</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				</div>
	
	     		<!-- Modal body -->
				<div class="modal-body">
					<form name="ufrom" id="uform">
						<input type="hidden" id="unum" name="num" >
						<label>이름</label>
						<input type="text" class="txt" id="uwriter" name="writer"> <br> 
	            
						<label>제목</label>
						<input type="text" class="txt" id="usubject" name="subject"> <br> 
	
						<label>메일</label>
						<input type="text"  class="txt" id="umail" name="mail"> <br> 
						
						<label>비밀번호</label>
						<input type="password"  class="txt" id="upassword" name="password"> <br> 
						
						<label>내용</label><br>
						<textarea rows="5" cols="40"  class="txt" id="ucontent" name="content"></textarea>
						<br>
						<br>
						<input type="button" value="전송" id="usend">
					</form>
				</div>
	
	      <!-- Modal footer -->
	      <div class="modal-footer">
	        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
	      </div>
	
	    </div>
	  </div>
	</div>
	<script>
		currentPage = 1;
		$(function() {
			listPageServer(currentPage);
			
			// 검색이벤트
			$("#search").on("click", function() {
				// stype - writer, content, subject
				// sword - 검색어
				listPageServer(currentPage);
			});
			
			// 다음 버튼 이벤트
			$(document).on("click", "#next", function() {
				currentPage = parseInt($(".pageno").last().text());
				listPageServer(currentPage);
			});
			
			// 이전 버튼 이벤트
			$(document).on("click", "#prev", function() {
				currentPage = parseInt($(".pageno").first().text()) + 1;
				listPageServer(currentPage);
			});
			
			// 페이지 번호 버튼 이벤트
			$(document).on("click", ".pageno", function() {
				currentPage = parseInt($(this).text().trim());
				listPageServer(currentPage);
			});
			// 글쓰기 모달창에서 입력후 전송 클릭 이벤트
			$("#msend").on('click', function() {
				// 입력한 모든 값을 가져오기
				fdata = $("#mform").serializeJSON();
				boardWriteServer();
				$("#wModal").modal("hide");
				$(".txt").val("");
			});
			
			// 수정 삭제 등록 이벶트
			$(document).on("click", ".action", function() {
				vname = $(this).attr("name");
				vidx = $(this).attr("idx");
				if (vname == "modify") {
					$("#uModal").modal("show");
					vparent = $(this).parents(".card");
					subject = vparent.find(".btn").text().trim(); // 제목
					writer = vparent.find(".wr").text(); // 글쓴
					mail = vparent.find(".ma").text(); // 이메일
					content = vparent.find(".p3").html(); // 내용
					content = content.replace(/<br>/g, "\r\n");
					$("#uform #unum").val(vidx);
					$("#uform #uwriter").val(writer);
					$("#uform #usubject").val(subject);
					$("#uform #umail").val(mail);
					$("#uform #ucontent").html(content); 
				} else if (vname == "delete") {
					alert(vidx + "번 글을 삭제합니다");
				} else if (vname == "reply") {
					alert(vidx + "번 글에 댓글을 등록합니다");
				}
			});
			// 수정 모달창에서 데이터 수정 후 전송 버튼 클릭 이벤트
			$("#usend").on("click", function() {
				// 수정해서 입력한 모든 값을 가져온다
				udata = $("#ufrom").serializeJSON();
				console.log(udata);
			});
		});
	</script>
</body>
</html>