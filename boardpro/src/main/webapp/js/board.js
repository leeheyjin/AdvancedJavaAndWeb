/**
 * 
 */

listPageServer = function(cpage) {

	vtype = "";
	vword = "";

	$.ajax({
		url: `/boardpro/boardList.do`,
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
	        <div id="accordion">`
			$.each(res.datas, function(i, v) {
				code += `<div class="card">
	        <div class="card-header">
	       <a class="btn" data-bs-toggle="collapse" href="#collapse${v.num}">
	         ${v.subject}
	       </a>
	     </div>
	     <div id="collapse${v.num}" class="collapse" data-bs-parent="#accordion">
	       <div class="card-body">
	         <div class="p12">
	            <p class="p1">
	               작성자: <span class="wr">${v.writer}</span> &nbsp;&nbsp;&nbsp; 
	               이메일: <span class="ma">${v.mail}</span> &nbsp;&nbsp;&nbsp; 
	               조회수: <span class="hit">${v.hit}</span> &nbsp;&nbsp;&nbsp; 
	               날짜: <span class="da">${v.wdate}</span>
	            </p>
	            <p class="p2">
	               <input type="button" value="수정" name="modify" class="action">
	               <input type="button" value="삭제" name="delete" class="action">
	            </p>
	         </div>
	         <p class="p3">${v.content}</p>
	         <p class="p4">
	               <textarea rows="" cols="50"></textarea>
	               <input type="button" value="등록" name="reply" class="action">
	         </p>
	       </div>
	     </div>
	   </div>`
			}) // $.each

			code += `</div></div>`

			$('#result').html(code);
			// 페이지 처리
			pager = "";
			/*
			<ul class="pagination">
  
  <li class="page-item"><a class="page-link" href="#">1</a></li>
  <li class="page-item active"><a class="page-link" href="#">2</a></li>
</ul>
			*/
			pager += `<ul class="pagination">`;
			if (res.sp > 1) {
				pager += `<li class="page-item"><a id="prev" class="page-link" href="#">Previous</a></li>`;
			}
			for (i = res.sp; i <= res.ep; i++) {
				if(i == cpage) {
					  pager += `<li class="page-item active"><a class="page-link pageno" href="#">${i}</a></li>`;
				} else {
					  pager += `<li class="page-item"><a class="page-link pageno" href="#">${i}</a></li>`;
				}
			}
			if(res.ep < res.tp) {
				pager += `<li class="page-item"><a class="page-link" id="next" href="#">Next</a></li>`;
			}
			pager += `</ul>`;
			$("#pageList	").html(pager);
		},
		error: function(xhr) {
			alert("상태: " + xhr.status)
		},
		dataType: 'json'
	})








}