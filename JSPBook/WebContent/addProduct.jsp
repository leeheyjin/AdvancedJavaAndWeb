<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>상품 등록</title>
<!-- WYSIGSYG(What you see is what you get): 보이는 것 그대로 디비에 드간다 -->
<script type="text/javascript" src="/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="/js/jquery-3.6.0.js"></script>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">상품 등록</h1>
		</div>
	</div>
	<div class="container">
		<form action="processAddProduct.jsp" name="newProduct" class="form-horizontal" method="post" enctype="multipart/form-data">
			<div class="form-group row">
				<label class="col-sm-2">상품코드</label>
				<div class="col-sm-3">
					<input type="text" name="productId" class="form-control" required>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">상품명</label>
				<div class="col-sm-3">
					<input type="text" name="pname" class="form-control" required>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">가격</label>
				<div class="col-sm-3">
					<input type="text" name="unitPrice" class="form-control" required>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">상세정보</label>
				<div class="col-sm-3">
					<textarea rows="3" cols="500" name="description"
						class="form-control"></textarea>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">제조사</label>
				<div class="col-sm-3">
					<input type="text" name="manufacturer" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">분류</label>
				<div class="col-sm-3">
					<input type="text" name="category" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">재고 수</label>
				<div class="col-sm-3">
					<input type="text" name="unitsInStock" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">상태</label>
				<div class="col-sm-5">
					<input type="radio" name="condition" value="new" id="new"><label for="new">신규 제품</label> 
					<input type="radio" name="condition" value="old" id="old"><label for="old">중고 제품</label> 
					<input type="radio" name="condition" value="refurbished" id="refurbished"><label for="refurbished">리퍼 제품</label>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">상품 이미지</label>
				<div class="col-sm-3">
					<input type="file" name="filename" id="filename" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">미리보기</label>
				<div class="col-sm-3 divImg"></div>
			</div>
			<div class="form-group row">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="submit" class="btn btn-primary" value="등록">
				</div>
			</div>
		</form>
	</div>
	<jsp:include page="footer.jsp" />
	<script type="text/javascript">
		CKEDITOR.replace("description")
		
		$(function() {
			$("#filename").on("change", handleImgFileSelect);
		});

		function handleImgFileSelect(e) {
			let	files = e.target.files;
			let fileArr = Array.prototype.slice.call(files);
			fileArr.forEach(function(f) { 
				if (!f.type.match("image.*")) {
					alert("이미지 파일만 가능합니다.")
					return false; // 함수 종료
				}
				let reader = new FileReader();
				reader.onload = function(e) {
					let imgHtml = `<img src="\${e.target.result}" style="width: 100%;" />`; 
					$(".divImg").html(imgHtml);
				};
				reader.readAsDataURL(f);	 
			});
		}
	</script>
</body>
</html>