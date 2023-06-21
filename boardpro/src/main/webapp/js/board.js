replyUpdateServer = function() {
	$.ajax({
		url: `${myPath}/ReplyUpdate.do`,
		type: 'post',
		data: reply,
		success: function(res) {
			if (res.flag == "성공") {
				$(p3).html(cont);
			}
		},
		error: function(xhr) {
			alert("상태: " + xhr.status);
		},
		dataType: 'json'
	})
}

replyDeleteServer = function() {
	$.ajax({
		url: `${myPath}/ReplyDelete.do`,
		data: { "renum": vidx },
		type: 'get',
		success: function(res) {
			alert(res.flag);
		},
		error: function(xhr) {
			alert("상태: " + xhr.status);
			vdelete.parents('.reply-body').remove();
		},
		dataType: 'json'
	})
}
replyListServer = function() {
	$.ajax({
		url: `${myPath}/ReplyList.do`,
		data: { "bonum": vidx },
		type: 'get',
		success: function(res) {
			rcode = ``;
			$.each(res, function(i, v) {
				cont = v.cont;
				cont.replaceAll(/\n/g, "<br>");
				rcode += `
				<div class="reply-body">
					<div class="p12">
						<p class="p1">
						작성자 : <span class="wr">${v.name}</span> &nbsp;&nbsp;&nbsp;&nbsp;
						날짜 : <span class="date">${v.redate}</span>
						</p>
						<p class="p2">
						<input type="button" idx= "${v.num}" value="댓글수정" name="rmodify" class="action">
						<input type="button" idx= "${v.num}" value="댓글삭제" name="rdelete" class="action">
						</p>
					</div>
					<p class="p3">${content}</p>
				</div>
				`;
				// 등록버튼 또는 제목을 기준으로 카드바디를 찾아서 리플라이바디를 붙인다
				$(vreply).parents(".card").find(".reply-body").remove();
				$(vreply).parents(".card").find(".card-body").append(rcode);

			})
		},
		error: function(xhr) {

		},
		dataType: 'json'
	})
}

replyInsertServer = function() {
	$.ajax({
		url: `${myPath}/ReplyInsert.do`,
		/* date: {
			"bonum": vidx,
			"cont": vtval,
			"name": name,
		},*/
		data: rdata,
		type: 'post',
		success: function(res) {
			// alert(res.flag);
			if (res.flag == "성공") {
				// 입력한 댓글을 출력
				replyListServer();
			}
		},
		error: function(xhr) {
			alert("상태: " + xhr.status);
		},
		dataType: 'json'
	})
}

boardWriteServer = function() {
	//	서버로 전송
	$.ajax({
		url: `${myPath}/BoardWrite.do`,
		data: fdata,
		type: "post",
		success: function(res) { listPageServer(1) },
		dataType: "Json"
	})
}

listPageServer = function(cpage) {
	vtype = $("#stype option:selected").val().trim();
	vword = $("#sword").val().trim();

	if (vword != null) vword = vword.trim();

	$.ajax({
		url: `${myPath}/BoardList.do`,
		data: {
			"page": cpage,
			"stype": vtype,
			"sword": vword
		},
		type: 'post',
		success: function(res) {
			code = "";
			code += `<div class="container mt-3">
			<h2>Accordion Example</h2>
			<div id="accordion">`;
			$.each(res.datas, function(i, v) {
				content = v.content;

				content = content.replace(/\r\n/g, "<br>")

				code += `
				<div class="card">
					<div class="card-header">
						<a class="btn" idx="${v.num}" data-bs-toggle="collapse" href="#collapse${v.num}">
						${v.subject}
						</a>
					</div>
					<div id="collapse${v.num}" class="collapse" data-bs-parent="#accordion">
						<div class="card-body">
							<div class="p12">
								<p class="p1">
								작성자 : <span class="wr">${v.writer}</span> &nbsp;&nbsp;&nbsp;&nbsp;
								이메일 : <span class="ma">${v.mail}</span>&nbsp;&nbsp;&nbsp;&nbsp;
								조회수 : <span class="hit">${v.hit}</span>&nbsp;&nbsp;&nbsp;&nbsp;
								날짜 : <span class="date">${v.wdate}</span>
								</p>
								<p class="p2">
								<input type="button" idx= "${v.num}" value="수정" name="modify" class="action">
								<input type="button" idx= "${v.num}" value="삭제" name="delete" class="action">
								</p>
							</div>
							<p class="p3">${content}</p>
							<p class="p4">
								<textarea cols="80" rows="5"></textarea>
								<input type="button" idx= "${v.num}" value="등록" name="reply" class="action">
							</p>
						</div>
					</div>
				</div>
				`;
			})
			code += `</div></div>`;
			$("#result").html(code);

			//	페이지 처리
			let pager = "";

			//  이전
			pager += `<ul class="pagination">`;
			if (res.sp > 1) {
				pager += `<li class="page-item"><a id="prevBtn" class="page-link" href="#">Previous</a></li>`;
			}
			//  페이지번호
			for (i = res.sp; i <= res.ep; i++) {
				if (i == cpage) {
					pager += `<li class="page-item active"><a class="page-link pageNo" href="#">${i}</a></li>`;
				} else {
					pager += `<li class="page-item"><a class="page-link pageNo" href="#">${i}</a></li>`;
				}
			}

			//  다음
			if (res.ep < res.tp) {
				pager += `<li class="page-item"><a id="nextBtn" class="page-link" href="#">Next</a></li>`;
			}

			pager += `</ul>`;
			$("#pageList").html(pager);
		},
		error: function(xhr) {
			alert("상태: " + xhr.status)
		},
		dataType: 'json'
	})
}

boardUpdateServer = function() {
	$.ajax({
		url: `${myPath}/BoardUpdate.do`,
		data: udata,
		type: "post",
		success: function(res) {
			//	성공 했으면 udata의 내용으로 본문의 내용을 변경
			// alert(res.flag);

			vParent.find("a").text(udata.subject);	//	제목
			vParent.find(".wr").text(udata.wirter);	//	작성자
			vParent.find(".ma").text(udata.mail);	//	메일

			cont = udata.content;
			cont = cont.replace(/\r\n/g, "<br>")

			vParent.find(".p3").html(cont);	//	내용
		},
		error: function(xhr) {
			alert(xhr.status);
		},
		dataType: "json"
	})
}

boardDeleteServer = function() {
	$.ajax({
		url: `${myPath}/BoardDelete.do`,
		data: { "num": vidx },
		type: "get",
		success: function(res) {
			//	성공하면 list 다시 가져오기
			// alert(res.flag);
			currentPage = 1;
			listPageServer(currentPage);
		},
		error: function(xhr) {
			alert(xhr.status);
		},
		dataType: "json"
	})
}

boardHitUpdate = function() {
	$.ajax({
		url: `${myPath}/BoardHitUpdate.do`,
		data: { "num": vidx },
		type: "get",
		success: function(res) {
			//	성공하면 화면의 조회수 변경
			vhit = vhit + 1;
			vparents.find(".hit").text(vhit);
		},
		error: function(xhr) {
			alert(xhr.status);
		},
		dataType: "json"
	})
}