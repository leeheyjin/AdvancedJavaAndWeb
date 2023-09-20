/**
 * 
 */
bohoBoardList = function(cpage) {
	vtype = $('#stype option:selected').val();
	vword = $('#sword').val();
	var type = $("#bohoBoard").attr("data-value");
	
	if(vword != null) vword = vword.trim();
	
	$.ajax({
		url : `${mypath}/communitySelectList.do`,
		data : {
			"page"  : cpage,
			"stype" : vtype,
			"sword" : vword,
			"type" : type
		},
		type : "get",
		success : function(res) {
			code = ``;
			code += `<div class="container mt-3">
					 <table class="table table-hover">
					 <thead>
					 <tr>
					 <th>번호</th>
					 <th>게시글유형</th>
					 <th>제목</th>
					 <th>작성자</th>
					 <th>조회수</th>
					 <th>작성일</th>
				   </tr>
				 </thead>
				 <tbody>`
				 
			$.each(res.datas, function(i, v) {
				code += `<tr>
		          <td>${v.comm_no}</td>
		          <td>${v.comm_type}</td>
		          <td idx="${v.comm_no}" onclick="boardHitUpdate(this, ${v.comm_no})" style="cursor:pointer;">${v.comm_ttl}</td>
		          <td>${v.mem_id}</td>
		          <td>${v.comm_hits}</td>
		          <td>${v.comm_date}</td>
		        </tr>`
			})
			code += `</tbody></table></div>`
			$('#result').html(code);

			//페이지처리
			pager = "";

			//이전
			pager += `<div class="pagination justify-content-center" style="margin:20px 0">`;
			pager += `<ul class="pagination">`;
			if(res.sp > 1) {
				pager += `<li class="page-item"><a id="prev" class="page-link" href="#">이전</a></li>`
			}

			//페이지번호
			for(i=res.sp; i<=res.ep; i++) {
				if(i==currentPage) {
					pager += `<li class="page-item active"><a class="page-link pageno" href="#">${i}</a></li>`
				} else {
					pager += `<li class="page-item"><a class="page-link pageno" href="#">${i}</a></li>`
				}
			}

			//다음
			if(res.ep < res.tp) {
				pager += `<li class="page-item"><a id="next" class="page-link" href="#">다음</a></li>`
			}

			pager += `</ul>`
			$("#pageList").html(pager);
			
		},
		error : function(xhr){
			alert(xhr.status);
		},
		dataType : "json"
	})
}

freeBoardList = function(cpage) {
	vtype = $('#stype option:selected').val();
	vword = $('#sword').val();
	var type = $("#freeBoard").attr("data-value");
	
	if(vword != null) vword = vword.trim();
	
	$.ajax({
		url : `${mypath}/communitySelectList.do`,
		data : {
			"page"  : cpage,
			"stype" : vtype,
			"sword" : vword,
			"type" : type
		},
		type : "get",
		success : function(res) {
			code = ``;
			code += `<div class="container mt-3">
					 <table class="table table-hover">
					 <thead>
					 <tr>
					 <th>번호</th>
					 <th>게시글유형</th>
					 <th>제목</th>
					 <th>작성자</th>
					 <th>조회수</th>
					 <th>작성일</th>
				   </tr>
				 </thead>
				 <tbody>`
				 
			$.each(res.datas, function(i, v) {
				code += `<tr>
		          <td>${v.comm_no}</td>
		          <td>${v.comm_type}</td>
		          <td idx="${v.comm_no}" onclick="boardHitUpdate(this, ${v.comm_no})" style="cursor:pointer;">${v.comm_ttl}</td>
		          <td>${v.mem_id}</td>
		          <td>${v.comm_hits}</td>
		          <td>${v.comm_date}</td>
		        </tr>`
			})
			code += `</tbody></table></div>`
			$('#result').html(code);

			//페이지처리
			pager = "";

			//이전
			pager += `<div class="pagination justify-content-center" style="margin:20px 0">`;
			pager += `<ul class="pagination">`;
			if(res.sp > 1) {
				pager += `<li class="page-item"><a id="prev" class="page-link" href="#">이전</a></li>`
			}

			//페이지번호
			for(i=res.sp; i<=res.ep; i++) {
				if(i==currentPage) {
					pager += `<li class="page-item active"><a class="page-link pageno" href="#">${i}</a></li>`
				} else {
					pager += `<li class="page-item"><a class="page-link pageno" href="#">${i}</a></li>`
				}
			}

			//다음
			if(res.ep < res.tp) {
				pager += `<li class="page-item"><a id="next" class="page-link" href="#">다음</a></li>`
			}

			pager += `</ul>`
			$("#pageList").html(pager);
			
		},
		error : function(xhr){
			alert(xhr.status);
		},
		dataType : "json"
	})
}

listSelectServer = function(cpage) {
	vtype = $('#stype option:selected').val();
	vword = $('#sword').val();
	var type = $("#reviewBoard").attr("data-value");
	
	if(vword != null) vword = vword.trim();
	
	$.ajax({
		url : `${mypath}/communitySelectList.do`,
		data : {
			"page"  : cpage,
			"stype" : vtype,
			"sword" : vword,
			"type" : type
		},
		type : "get",
		success : function(res) {
			code = ``;
			code += `<div class="container mt-3">
					 <table class="table table-hover">
					 <thead>
					 <tr>
					 <th>번호</th>
					 <th>게시글유형</th>
					 <th>제목</th>
					 <th>작성자</th>
					 <th>조회수</th>
					 <th>작성일</th>
				   </tr>
				 </thead>
				 <tbody>`
				 
			$.each(res.datas, function(i, v) {
				code += `<tr>
		          <td>${v.comm_no}</td>
		          <td>${v.comm_type}</td>
		          <td idx="${v.comm_no}" onclick="boardHitUpdate(this, ${v.comm_no})" style="cursor:pointer;">${v.comm_ttl}</td>
		          <td>${v.mem_id}</td>
		          <td>${v.comm_hits}</td>
		          <td>${v.comm_date}</td>
		        </tr>`
			})
			code += `</tbody></table></div>`
			$('#result').html(code);

			//페이지처리
			pager = "";

			//이전
			pager += `<div class="pagination justify-content-center" style="margin:20px 0">`;
			pager += `<ul class="pagination">`;
			if(res.sp > 1) {
				pager += `<li class="page-item"><a id="prevReview" class="page-link" href="#">이전</a></li>`
			}

			//페이지번호
			for(i=res.sp; i<=res.ep; i++) {
				if(i==currentPage) {
					pager += `<li class="page-item active"><a class="page-link pagenoReview" href="#">${i}</a></li>`
				} else {
					pager += `<li class="page-item"><a class="page-link pagenoReview" href="#">${i}</a></li>`
				}
			}

			//다음
			if(res.ep < res.tp) {
				pager += `<li class="page-item"><a id="nextReview" class="page-link" href="#">다음</a></li>`
			}

			pager += `</ul>`
			$("#pageList").html(pager);
			
		},
		error : function(xhr){
			alert(xhr.status);
		},
		dataType : "json"
	})
}

answerUpdateServer = function() {
	
	$.ajax({
		url : `${mypath}/answerUpdate.do`,
		data : reply,
//		data : {
//			"cont"  : newcont,
//			"renum" : vidx
//		}
		type : 'post',
		success : function(res) {
			//alert(res.flag);
			if(res.flag=="완료"){
			//화면을 수정			
			$(p1).html(cont);
			}
		},
		error : function(xhr) {
			alert(xhr.status);
		},
		dataType : 'json'
	})
}


answerDeleteServer = function(){
	$.ajax({
		url : `${mypath}/answerDelete.do`,
		data : {"ans_no" : vidx},
		type : 'get',
		success : function(res) {
			alert(res.flag);
			//화면삭제
			$(vdelete).parents('.reply-body').remove();
			
		},
		error : function(xhr) {
			alert(xhr.status);
		},
		dataType : 'json'
	})
}

answerInsertServer = function(){
	$.ajax({
		url : `${mypath}/answerInsert.do`,
		data : rdata,
		type : "get",
		success : function(res){
			 alert(res.flag);
			
				//입력한 댓글을 출력
				answerListServer();
		},
		error : function(xhr) {
		},
		dataType : "json"
	})
}

answerListServer = function(mvo) {
	$.ajax({
		url : `${mypath}/answerList.do`,
		data : {"queNo" : vidx,
				"mvo"   : mvo},
		type : 'get',
		success : function(res){
			rcode = "";
			
			$.each(res, function(i, v) {
			cont = v.ans_dtl;
			cont = cont.replace(/\n/g, "<br>");
			
			rcode += `<div class="reply-body">
			<div class="d-flex mb-4">
			<div class="flex-shrink-0"><img class="rounded-circle" src="./imges/yacamlogo50x50.png" alt="..."></div>
			<div class="ms-3">
			 <div class="fw-bold">
			 <span>관리자</span>&nbsp;&nbsp;&nbsp;&nbsp;
			 <span>${v.ans_date}</span>
			 </div>
				<p class="p1">${cont}</p>
          <p class="p2">`;
          
    if (mvo.mem_grade === "관리자") {
      rcode += `<input type="button" idx="${v.ans_no}" value="댓글수정" name="r_modify" class="action">
                <input type="button" idx="${v.ans_no}" value="댓글삭제" name="r_delete" class="action">`;
    }
    
    rcode += `</p>
        </div>
      </div>
    </div>`;
		console.log(v.ans_date);
		})
		
		
		//등록버튼 또는 제목(this=vreply)을 기준으로 card-body를 찾아서 reply-body(rcode)를 append로 추가한다
		//방식1 바로위에있는 부모 다음
		//$(vreply).parent().next().remove();
		
		//방식2 조상으로(최상단) 올라가서 검색함
		$(vreply).parents('.card').find('.reply-body').remove();
		
		$(vreply).parents('.card').find('.card-body').append(rcode);
		
		},
		error : function(xhr){
			alert(xhr.status);
		},
		dataType : 'json'
	})
}


questionPageServer = function(cpage) {
	vtype = $('#stype option:selected').val();
	vword = $('#sword').val();
	
	if(vword != null) vword = vword.trim();
	
	$.ajax({
		url : `${mypath}/questionList.do`,
		data : {
			"page"  : cpage,
			"stype" : vtype,
			"sword" : vword,
		},
		type : "get",
		success : function(res) {
			code = "";
			code += `<div class="container mt-3">
					 <table class="table table-hover">
					 <thead>
					 <tr>
					 <th>번호</th>
					 <th>문의유형</th>
					 <th>제목</th>
					 <th>작성자</th>
					 <th>작성일</th>
				   </tr>
				 </thead>
				 <tbody>`
				 
			$.each(res.datas, function(i, v) {
			  var redate = v.que_redate ? v.que_redate : v.que_date; // que_redate가 null인지 확인합니다.
			  code += `<tr>
			    <td>${v.que_no}</td>
			    <td>${v.que_typ}</td>
			    <td idx="${v.que_no}" onclick="location.href='${mypath}/questionInfo.do?num=${v.que_no}'" style="cursor:pointer;">${v.que_ttl}</td>
			    <td>${v.mem_id}</td>
			    <td>${redate}</td>`; // que_redate가 null이 아닌 경우에는 redate를 출력합니다.
			  if (v.que_redate) {
			    code += `<td>${v.que_redate}</td>`;
			  }
			  code += `</tr>`;
			});
			
			$('#result').html(code);

			//페이지처리
			pager = "";

			//이전
			pager += `<div class="pagination justify-content-center" style="margin:20px 0">`;
			pager += `<ul class="pagination">`;
			if(res.sp > 1) {
				pager += `<li class="page-item"><a id="prev" class="page-link" href="#">이전</a></li>`
			}

			//페이지번호
			for(i=res.sp; i<=res.ep; i++) {
				if(i==currentPage) {
					pager += `<li class="page-item active"><a class="page-link pageno" href="#">${i}</a></li>`
				} else {
					pager += `<li class="page-item"><a class="page-link pageno" href="#">${i}</a></li>`
				}
			}

			//다음
			if(res.ep < res.tp) {
				pager += `<li class="page-item"><a id="next" class="page-link" href="#">다음</a></li>`
			}

			pager += `</ul>`
			$("#pageList").html(pager);
			
		},
		error : function(xhr){
			alert(xhr.status);
		},
		dataType : "json"
	})
}

eventPageServer = function(cpage) {
	vtype = $('#stype option:selected').val().trim();
	vword = $('#sword').val();
	
	if(vword != null) vword = vword.trim();
	
	$.ajax({
		url : `${mypath}/eventList.do`,
		data : {
			"page"  : cpage,
			"stype" : vtype,
			"sword" : vword,
		},
		type : "get",
		success : function(res) {
			code = "";
			code += `<div class="container mt-3">
					 <table class="table table-hover">
					 <thead>
					 <tr>
					 <th>번호</th>
					 <th>제목</th>
					 <th>작성일</th>
					 <th>현황</th>
				   </tr>
				 </thead>
				 <tbody>`
				 
			$.each(res.datas, function(i, v) {
				var date = new Date(v.ent_date);
				var year = date.getFullYear();
				var month = ("0" + (date.getMonth() + 1)).slice(-2);
				var day = ("0" + date.getDate()).slice(-2);
				var formattedDate = year + "-" + month + "-" + day;

				code += `<tr>
		          <td>${v.ent_no}</td>
		          <td idx="${v.ent_no}" onclick="location.href='${mypath}/eventInfo.do?num=${v.ent_no}'" style="cursor:pointer;">${v.ent_ttl}</td>
		          <td>${formattedDate}</td>
		          <td>${v.ent_type}</td>
		        </tr>`;
			});
			code += `</tbody></table></div>`;
			$('#result').html(code);

			//페이지처리
			pager = "";

			//이전
			pager += `<div class="pagination justify-content-center" style="margin:20px 0">`;
			pager += `<ul class="pagination">`;
			if(res.sp > 1) {
				pager += `<li class="page-item"><a id="prev" class="page-link" href="#">이전</a></li>`;
			}

			//페이지번호
			for(i=res.sp; i<=res.ep; i++) {
				if(i==currentPage) {
					pager += `<li class="page-item active"><a class="page-link pageno" href="#">${i}</a></li>`;
				} else {
					pager += `<li class="page-item"><a class="page-link pageno" href="#">${i}</a></li>`;
				}
			}

			//다음
			if(res.ep < res.tp) {
				pager += `<li class="page-item"><a id="next" class="page-link" href="#">다음</a></li>`;
			}

			pager += `</ul>`;
			$("#pageList").html(pager);
			
		},
		error : function(xhr){
			alert(xhr.status);
		},
		dataType : "json"
	});
}


function noticeHitUpdate(element, noti_no) {
    $.ajax({
        url: `${mypath}/noticeHit.do`,
        data: { "num": noti_no },
        type: 'get',
        success: function(res) {
			if(res.flag == "완료") {
            window.location.href = `${mypath}/noticeInfo.do?num=${noti_no}`;
			}
            console.log("조회수 증가 성공");
            // 조회수 증가 후에 페이지 이동
        },
        error: function(xhr) {
            console.log("조회수 증가 실패:", xhr.status);
//            window.location.href = `${mypath}/communityDetail.do?num=${comm_no}`;
        },
        dataType : 'json'
    });
}

notiPageServer = function(cpage) {
	vtype = $('#stype option:selected').val().trim();
	vword = $('#sword').val();
	
	if(vword != null) vword = vword.trim();
	
	$.ajax({
		url : `${mypath}/noticeList.do`,
		data : {
			"page"  : cpage,
			"stype" : vtype,
			"sword" : vword,
		},
		type : "get",
		success : function(res) {
			code = "";
			code += `<div class="container mt-3">
					 <table class="table table-hover">
					 <thead>
					 <tr>
					 <th>번호</th>
					 <th>제목</th>
					 <th>조회수</th>
					 <th>작성일</th>
				   </tr>
				 </thead>
				 <tbody>`
				 
			$.each(res.datas, function(i, v) {
				code += `<tr>
		          <td>${v.noti_no}</td>
		          <td idx="${v.noti_no}" onclick="noticeHitUpdate(this, ${v.noti_no})" style="cursor:pointer;">${v.noti_ttl}</td>
		          <td>${v.noti_hit}</td>
		          <td>${v.noti_date}</td>
		        </tr>`
			})
			code += `</tbody></table></div>`
			$('#result').html(code);

			//페이지처리
			pager = "";

			//이전
			pager += `<div class="pagination justify-content-center" style="margin:20px 0">`;
			pager += `<ul class="pagination">`;
			if(res.sp > 1) {
				pager += `<li class="page-item"><a id="prev" class="page-link" href="#">이전</a></li>`
			}

			//페이지번호
			for(i=res.sp; i<=res.ep; i++) {
				if(i==currentPage) {
					pager += `<li class="page-item active"><a class="page-link pageno" href="#">${i}</a></li>`
				} else {
					pager += `<li class="page-item"><a class="page-link pageno" href="#">${i}</a></li>`
				}
			}

			//다음
			if(res.ep < res.tp) {
				pager += `<li class="page-item"><a id="next" class="page-link" href="#">다음</a></li>`
			}

			pager += `</ul>`
			$("#pageList").html(pager);
			
		},
		error : function(xhr){
			alert(xhr.status);
		},
		dataType : "json"
	})
}

replyUpdateServer = function() {
	
	$.ajax({
		url : `${mypath}/replyUpdate.do`,
		data : reply,
//		data : {
//			"cont"  : newcont,
//			"renum" : vidx
//		}
		type : 'post',
		success : function(res) {
			//alert(res.flag);
			if(res.flag=="완료"){
			//화면을 수정			
			$(p1).html(cont);
			}
		},
		error : function(xhr) {
			alert(xhr.status);
		},
		dataType : 'json'
	})
}


replyDeleteServer = function(){
	$.ajax({
		url : `${mypath}/replyDelete.do`,
		data : {"mt_no" : vidx},
		type : 'get',
		success : function(res) {
			alert(res.flag);
			//화면삭제
			$(vdelete).parents('.reply-body').remove();
			
		},
		error : function(xhr) {
			alert(xhr.status);
		},
		dataType : 'json'
	})
}

replyListServer = function(mvo) {
	$.ajax({
		url : `${mypath}/replyList.do`,
		data : {"commNo" : vidx,
				"mvo"    : mvo},
		type : 'get',
		success : function(res){
			rcode = "";
			
			$.each(res, function(i, v) {
			cont = v.mt_dtl;
			cont = cont.replace(/\n/g, "<br>");
			
			rcode += `<div class="reply-body">
			<div class="d-flex mb-4">
			<div class="flex-shrink-0"><img class="rounded-circle" src="./imges/guest50x50.png" alt="..."></div>
			<div class="ms-3">
			 <div class="fw-bold">
			 <span>${v.mem_id}</span>&nbsp;&nbsp;&nbsp;&nbsp;
			 <span>${v.mt_date}</span>
			 </div>
				<p class="p1">${cont}</p>
    			  <p class="p2">`;
    			 if (mvo && mvo.mem_id === v.mem_id || "관리자"=== mvo.mem_grade) {
    			  	rcode += `<input type="button" idx="${v.mt_no}" value="댓글수정" name="r_modify" class="action">
    			  	<input type="button" idx="${v.mt_no}" value="댓글삭제" name="r_delete" class="action">`;
				  }
    			  rcode += `</p>
    			  </div>
    			</div>
            </div>`;
		console.log(mvo.mem_id);
		})
		
		//등록버튼 또는 제목(this=vreply)을 기준으로 card-body를 찾아서 reply-body(rcode)를 append로 추가한다
		//방식1 바로위에있는 부모 다음
		//$(vreply).parent().next().remove();
		
		//방식2 조상으로(최상단) 올라가서 검색함
		$(vreply).parents('.card').find('.reply-body').remove();
		
		$(vreply).parents('.card').find('.card-body').append(rcode);
		
		},
		error : function(xhr){
			alert(xhr.status);
		},
		dataType : 'json'
	})
}

replyInsertServer = function(){
	$.ajax({
		url : `${mypath}/replyInsert.do`,
		data : rdata,
		type : "get",
		success : function(res){
			 alert(res.flag);
			
				//입력한 댓글을 출력
				replyListServer();
		},
		error : function(xhr) {
		},
		dataType : "json"
	})
}

function boardHitUpdate(element, comm_no) {
    $.ajax({
        url: `${mypath}/boardHit.do`,
        data: { "num": comm_no },
        type: 'get',
        success: function(res) {
			if(res.flag == "완료") {
            window.location.href = `${mypath}/communityDetail.do?num=${comm_no}`;
			}
            console.log("조회수 증가 성공");
            // 조회수 증가 후에 페이지 이동
        },
        error: function(xhr) {
            console.log("조회수 증가 실패:", xhr.status);
//            window.location.href = `${mypath}/communityDetail.do?num=${comm_no}`;
        },
        dataType : 'json'
    });
}


boardDeleteServer = function(){
	$.ajax({
		url : `${mypath}/boardDelete.do`,
		data : {"num" : vidx},
		type : "get",
		success : function(res){
			//성공하면 list다시 가져오기
			// alert(res.flag);

			currentPage = 1;
			listPageServer(currentPage);

		},
		error : function(xhr){
			alert(xhr.status);
		},
		dataType : "json"
	})
}

boardWriteServer = function() {
	//서버로 전송
	$.ajax({
		url : `${mypath}/boardWrite.do`,
		data : fdata,
		type : 'POST',
		success : function(res) {
			// alert(res.flag);
			listPageServer(1);

		},
		error : function(xhr){
			alert(xhr.status);
		},
		dataType : 'json'
	})
}

listPageServer = function(cpage) {
	vtype = $('#stype option:selected').val();
	vword = $('#sword').val();
	
	if(vword != null) vword = vword.trim();
	
	$.ajax({
		url : `${mypath}/communityList.do`,
		data : {
			"page"  : cpage,
			"stype" : vtype,
			"sword" : vword,
		},
		type : "get",
		success : function(res) {
			code = "";
			code += `<div class="container mt-3">
					 <table class="table table-hover">
					 <thead>
					 <tr>
					 <th>번호</th>
					 <th>게시글유형</th>
					 <th>제목</th>
					 <th>작성자</th>
					 <th>조회수</th>
					 <th>작성일</th>
				   </tr>
				 </thead>
				 <tbody>`
				 
			$.each(res.datas, function(i, v) {
				code += `<tr>
		          <td>${v.comm_no}</td>
		          <td>${v.comm_type}</td>
		          <td idx="${v.comm_no}" onclick="boardHitUpdate(this, ${v.comm_no})" style="cursor:pointer;">${v.comm_ttl}</td>
		          <td>${v.mem_id}</td>
		          <td>${v.comm_hits}</td>
		          <td>${v.comm_date}</td>
		        </tr>`
			})
			code += `</tbody></table></div>`
			$('#result').html(code);

			//페이지처리
			pager = "";

			//이전
			pager += `<div class="pagination justify-content-center" style="margin:20px 0">`;
			pager += `<ul class="pagination">`;
			if(res.sp > 1) {
				pager += `<li class="page-item"><a id="prev" class="page-link" href="#">이전</a></li>`
			}

			//페이지번호
			for(i=res.sp; i<=res.ep; i++) {
				if(i==currentPage) {
					pager += `<li class="page-item active"><a class="page-link pageno" href="#">${i}</a></li>`
				} else {
					pager += `<li class="page-item"><a class="page-link pageno" href="#">${i}</a></li>`
				}
			}

			//다음
			if(res.ep < res.tp) {
				pager += `<li class="page-item"><a id="next" class="page-link" href="#">다음</a></li>`
			}

			pager += `</ul>`
			$("#pageList").html(pager);
			
		},
		error : function(xhr){
			alert(xhr.status);
		},
		dataType : "json"
	})
}