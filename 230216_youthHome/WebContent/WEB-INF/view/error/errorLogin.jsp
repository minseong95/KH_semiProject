<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error</title>
</head>
<body>
	<script>
		var errMsg='<%= (String)request.getAttribute("errorMsg") %>'; 
		//request.getAttribute("errorMsg") 자체는 Object라서
		//String 으로 바꿔줘야 함. 
		//var errMsg = '${errorMsg}'; // 따옴표 중요함!!!!!!!!EL 에다가 따옴표.. 
		alert(errMsg);
	</script>
	
	<h4>로그인되지 않았습니다. 로그인페이지로 이동하세요. </h4>
	<a href="<%=request.getContextPath()%>/login">로그인페이지로 이동</a>
</body>
</html>