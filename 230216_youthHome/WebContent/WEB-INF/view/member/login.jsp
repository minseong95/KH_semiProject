<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인하기</title>
<link type="text/css" rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
 <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<form action="login" method="post">
	<div class="mb-3">
  		<label for="exampleFormControlInput1" class="form-label">아이디</label>
  		<input type="text" class="form-control" name="id" id="exampleFormControlInput1">
	</div>
	<div class="mb-3">
  		<label for="exampleFormControlTextarea1" class="form-label">비밀번호</label>
  		<input type="password" class="form-control" name="passwd" id="exampleFormControlInput1" >
	</div>
	<button type="submit">로그인하기</button>
	<button type="button" class="btn enroll">회원가입</button>
	
	<script>
		$(".btn.enroll").on("click", handlerClickBtnEnroll);
		
		function handlerClickBtnEnroll(){
			console.log("btnEnroll누름");
			location.href="<%=request.getContextPath()%>/enroll";			
		}
	</script>
</form>	

</body>
</html>