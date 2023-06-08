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

nav a{
	display: none; /* 존재하지 않음 */
	/* visibility: hidden; 존재하나 보이지 않음 */
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="javascript:void(0)">Logo</a>
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
					<input class="form-control me-2" type="text" id="sword" placeholder="Search">
					<button class="btn btn-primary" type="button">Search</button>
				</form>
			</div>
		</div>
	</nav>
	<div id="result"></div>
	<br>
	<div id="pageList"></div>

	<script>
		currentPage = 1;
		$(function() {
			listPageServer(currentPage);
		})
	</script>
</body>
</html>