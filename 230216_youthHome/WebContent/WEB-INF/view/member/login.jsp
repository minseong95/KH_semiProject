<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인하기</title>
<link type="text/css" rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
 <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
 <script src="https://code.jquery.com/jquery-3.6.3.js"></script>
</head>
<body>


	<nav class="navbar bg-light">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="<%=request.getContextPath()%>/">메인으로</a>
	  </div>
	</nav>

<!-- 로그인 -->

	<div class="row">
		<div class="col">
		<h4 class="text-center">로그인하기</h4>
			<form action="login" method="post" class="mt-4 px-5">
				<div class="mb-3 form-floating mt-5">
			  		<input type="text" class="form-control" name="id" id="exampleFormControlInput1" placeholder="아이디">
			  		<label for="exampleFormControlInput1" class="form-label">아이디</label>
				</div>
				<div class="mb-3 form-floating">
			  		<input type="password" class="form-control" name="passwd" id="exampleFormControlInput1" placeholder="비밀번호" >
			  		<label for="exampleFormControlTextarea1" class="form-label">비밀번호</label>
				</div>
				<button type="submit" class="btn btn-outline-secondary">로그인하기</button>
			</form>		
		</div>	
		<div class="col d-grid gap-2 col-6 mx-auto px-5" >
			<h4 class="text-center">회원가입</h4>
			<button type="button" class="btn enroll btn-outline-secondary btn-lg " >회원가입</button>
		</div>
	</div>
	
	<script>
		$(".btn.enroll").on("click", handlerClickBtnEnroll);
		
		function handlerClickBtnEnroll(){
			console.log("btnEnroll누름");
			location.href="<%=request.getContextPath()%>/enroll";			
		}
	</script>


</body>
</html>