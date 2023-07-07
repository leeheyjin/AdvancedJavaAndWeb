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
					<input type="number" name="unitsInStock" class="form-control">
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
					<input type="button" class="btn btn-primary" value="등록" onclick="checkAddProduct()">
				</div>
			</div>
		</form>
	</div>
	<jsp:include page="footer.jsp" />
	<script type="text/javascript">
		CKEDITOR.replace("description")
		
		function checkAddProduct() {
			let form = document.newProduct;
			// 상품 아이디 체크: 첫글자는 P, 숫자를 조합해 5~12자까지 입력 가능
			let regExpId = /^P[0-9]{4, 11}/;
			if (regExpId.test(form.productId.value)) {
				alert("[상품코드] P와 숫자를 조합해 5~12자리까지 입력가능합니다");
				form.productId.select();
				form.productId.focus();
				return;
			}
			// 상품명 체크: 4~12자까지 입력가능
			if(form.pname.value.length < 4 || form.pname.value.length > 12) {
				alert("[상품명] 최소 4자에서 최대 12자까지 입력하세요");
				form.name.select();
				form.name.focus();
				return;
			}
			
			if (form.unitPrice.value < 0) {
				alert("[금액] 음수를 입력할 수 없습니다");
				form.unitPrice.select();
				form.unitPrice.focus();
				return false;
			}
			
			let regExpUnitPrice = /^\d+(?:[.]?[\d]?[\d])?$/;
			if(!regExpUnitPrice.test(form.unitPrice.value)) {
				alert("[금액] 소수점 둘째자리까지만 허용됩니다");
				form.unitPrice.select();
				form.unitPrice.focus();
				return;
			}
			
			// 재고수
			if (isNaN(form.unitsInStock.value)) {
				alert("[재고수] 숫자만 입력 가능합니다");
				form.unitsInStock.select();
				form.unitsInStock.focus();
				return;
			}
			
			alert("상품이 정상 등록되었습니다.");
			form.submit();
		}
	
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