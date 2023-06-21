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
<script src="../js/jquery.serializejson.min.js"></script>

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
	flex: 75%;
}

.p2 {
	flex: 25%;
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
	display: none;
	visibility: hidden;
}

.form-select {
	margin-right: 5px;
}

#wModal label {
	width: 80px;
}

.btnArea {
	text-align: center;
}

.reply-body {
	margin: 1px;
	padding: 3px;
	border: 1px dotted orange;
	background: #fad1f3;
}
</style>
</head>
<body>
<div id="modiForm">
<textarea rows="5" cols="30"></textarea>
<input type="button" value="확인" id="modiSend">
<input type="button" value="취소" id="modiReset">
</div>
	<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
		<div class="container-fluid">
			<input type="button" value="글쓰기" id="write" class="btn btn-secondary"
				data-bs-toggle="modal" data-bs-target="#wModal"><br />
			<br /> <a class="navbar-brand" href="javascript:void(0)">Logo</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#mynavbar">
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
					</select> <input class="form-control me-2" type="text" id="sword"
						placeholder="Search">
					<button id="search" class="btn btn-primary" type="button">Search</button>
				</form>
			</div>
		</div>
	</nav>
	<div id="result"></div>
	<br />
	<br />
	<div id="pageList"></div>

	<!-- 글쓰기 모달 -->
	<div class="modal" id="wModal">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">글쓰기</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<form name="mfrom" id="mform">

						<input type="hidden" id="num" name="num"> <label>이름</label>
						<input type="text" class="txt form-control" id="writer"
							name="writer"> <br> <label>제목</label> <input
							type="text" class="txt form-control" id="subject" name="subject">
						<br> <label>메일</label> <input type="text"
							class="txt form-control" id="mail" name="mail"> <br>

						<label>비밀번호</label> <input type="password"
							class="txt form-control" id="password" name="password"> <br>

						<label>내용</label> <br>
						<textarea rows="5" cols="40" class="txt form-control" id="content"
							name="content"></textarea>
						<br> <br>
						<div class="btnArea">
							<input type="button" value="전송" id="msend"
								class="btn btn-primary">
							<button type="button" class="btn" data-bs-dismiss="modal">취소</button>
						</div>
					</form>
				</div>


			</div>
		</div>
	</div>

	<!-- 글 수정 모달창 -->
	<div class="modal" id="uModal">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">글 수정</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<form name="uform" id="uform">

						<input type="hidden" id="unum" name="num"> <label>이름</label>
						<input type="text" class="txt form-control" id="uwriter"
							name="writer"> <br> <label>제목</label> <input
							type="text" class="txt form-control" id="usubject" name="subject">
						<br> <label>메일</label> <input type="text"
							class="txt form-control" id="umail" name="mail"> <br>

						<label>비밀번호</label> <input type="password"
							class="txt form-control" id="upassword" name="password">
						<br> <label>내용</label> <br>
						<textarea rows="5" cols="40" class="txt form-control"
							id="ucontent" name="content"></textarea>
						<br> <br>
						<div class="btnArea">
							<input type="button" value="전송" id="usend"
								class="btn btn-primary">
							<button type="button" class="btn" data-bs-dismiss="modal">취소</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>


	<script src="../js/board.js"></script>
	<script>
	myPath = `<%=request.getContextPath()%>
		`;
		let fdata = undefined;
		let currentPage = 1;
		listPageServer(currentPage);

		//	검색 이벤트
		$("#search").on("click", function() {
			//	stype - writer, content, subject
			//	sword - 입력한 값
			listPageServer(currentPage);
		})

		//	다음 버튼 이벤트
		$(document).on("click", "#nextBtn", function() {
			if ($('#modiform').css('display') != 'none') {
				// 이미 열려 있는 모디폼을 닫음
				replyReset();
			}
			
			currentPage = parseInt($(".pageNo").last().text()) + 1;
			listPageServer(currentPage);
		})
		
		//	이전 버튼 이벤트
		$(document).on("click", "#prevBtn", function() {
			if ($('#modiform').css('display') != 'none') {
				// 이미 열려 있는 모디폼을 닫음
				replyReset();
			}
			
			currentPage = parseInt($(".pageNo").first().text()) - 1;
			listPageServer(currentPage);
		})

		//	페이지번호 클릭 이벤트
		$(document).on("click", ".pageNo", function() {
			if ($('#modiform').css('display') != 'none') {
				// 이미 열려 있는 모디폼을 닫음
				replyReset();
			}
			
			currentPage = $(this).text().trim();
			listPageServer(currentPage);
		})
		
		//	글쓰기 이벤트
		//	글쓰기 모달창에서 입력후 전송 클릭 이벤트
		$("#msend").on("click", function() {
			//	입력한 모든 값을 가져오기
			fdata = $("#mform").serializeJSON();
			console.log(fdata);

			boardWriteServer();

			//	모달에 입력한 내용 지우기
			$("#wModal .txt").val("");

			//	모달창 닫기
			$("#wModal").modal("hide");

		})

		//	글 수정, 글 삭제, 댓글 삭제, 댓글 수정
		$(document).on("click", ".action", function() {
			vname = $(this).attr("name");
			vidx = $(this).attr("idx");

			if (vname == "delete") {
				// alert(vidx + "글을 삭제합니다.");
				boardDeleteServer();
			} else if (vname == "modify") {
				// alert(vidx + "글을 수정합니다.");
				// 모달창 실행
				$("#uModal").modal("show");
				vParent = $(this).parents(".card");

				vtitle = vParent.find("a").text().trim(); //	제목
				vwriter = vParent.find(".wr").text(); //	작성자
				vmail = vParent.find(".ma").text(); //	메일
				vpass = vParent.find(".p")
				vcont = vParent.find(".p3").html(); //	내용

				//	모달창에 출력하기
				$("#uform #unum").val(vidx);
				$("#uform #uwriter").val(vwriter);
				$("#uform #umail").val(vmail);
				$("#uform #usubject").val(vtitle);

				//	내용에 <br>태그를 \n으로 변경
				vcont = vcont.replace(/<br>/g, "\r\n");
				$("#uform #ucontent").val(vcont);

			} ELSE IF (VNAME == "REPLY") {
				alert(vidx + "글에 댓글을 답니다.");
				vreply = $(this);
				vtval = $(this).prev().val();
				// 저장할 때 renum, bonum(vidx), cont(vtval), name 필요
				name1 = String.fromCharCode(parseInt(Math.random() * 26 + 65));
				name2 = String.fromCharCode(parseInt(Math.random() * 26 + 97));
				name3 = parseInt(Math.random() * 100 + 1);
				name = name1 + name2 + name3;
				
				// 저장데이터를 객체로 생성
				rdata = { };
				rdata.bonum = vidx;
				rdata.cont = vtval;
				rdata.name = name;
				
				// 서버로 전송
				replyInsertServer();
				$(this).prev().val("");
			} else if (vname == "r_delete") {
				alert(vidx + "번 댓글을 삭제합니다.");
				vdelete = $(this);
				replyDeleteServer();
			} else if (vname == "r_modify") {
				alert(vidx + "번 댓글을 수정합니다.");
				// 다른 곳에 modiform이 열려있는지 확인
				if ($('#modiform').css('display') != 'none') {
					// 이미 열려 있는 모디폼을 닫음
					replyReset();
				}
				/* $(this).parents('.p12').next(); */
				vp3 = $(this).parents('reply-body').find('.p3');
				rcont = $(vp3).html();
				cont = rcont.replace(/<br>/g, '\m');
				// 원래 내용에서 \n으로 변경해서 수정창에 출력
				$("#modiform textarea").val(cont);
				$(vp3).empty().append($('#modiform'));
				$('#modiform').show();
			}
		});
		
		replyReset = function() {
			// 현재 열려 있는 모디폼을 기준으로 p3찾긔
			p3 = $("#modiform").parent();
			// 모디폼을 바디로 이동한다
			$("#modiform").appendTo($('body'));
			// 모디폼을 안보이게 설정
			$("#modiform").hide();
			$(p3).html(rcont);
		}
		//	수정 모달창에서 데이터 수정 후 전송 버튼 클릭이벤트
		$("#usend").on("click", function() {
			//	수정에서 입력한 모든 값을 가져오기
			udata = $("#uform").serializeJSON();
			console.log(udata);

			$("#uform .txt").val("");
			$("#uModal").modal("hide");

			// 서버로 전송 - ajax 수행
			boardUpdateServer();
			//	수정한 내용(udata)으로 본문의 내용을 수정

		})

		//	제목을 클릭해서 조회수 증가
		// aria-expanded="true"
		$(document).on("click", ".card a", function() {
			vreply = $(this); // 제목
			vidx = $(this).attr("idx"); // 글번호
			let hitAttr = $(this).attr("aria-expanded");
			vparents = $(this).parents(".card");
			vhit = parseInt(vparents.find(".hit").text());
			if (hitAttr == "true") {
				//	서버로 전송
				boardHitUpdate();
			}
			replyListServer();
		})
		
		$("#modireset").on("click", function() {
			replyReset();
		});
		
		$("#modiSend").on("click", function() {
			// 새롭게 입력한 값을 가져온다
			newcont = $("#modiForm textarea").val();
			// 엔터기호를 br로 바꾼다
			newcont = newcont.replaceAll(/\n/g, "<br>");
			// 모디폼을 기준으로 p3을 찾는다
			$(p3) = $("#modiForm").parent();
			// 모디폼을 바디로 이동해 안보이게 설정한다
			$("#modiForm").appendTo($("body"));
			$("#modiForm").hide();
			// 서버로 전송 -> db수정
			reply = {};
			reply.cont = newcont;
			reply.renum = vidx;
			
			replyUpdateServer();
			
			// br변경한 새로 입력한 내용을 p3에 출력 - 디비수정성공후에 진행
			
		})
	</script>
</body>
</html>