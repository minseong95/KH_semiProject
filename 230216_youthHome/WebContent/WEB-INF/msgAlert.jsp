<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script >
var m = "${msg}";
alert(m);
location.replace("<%=request.getContextPath()%>/");
<%-- href가 아니라 replace를 써야 뒤로가기 해서 f5를 눌렀을 때 로그인 양식이 안뜸.. --%>

<%-- history.go(-2); 뒤로가기 2번 / 양수 2 면 앞으로(forward) 2번 --%>
</script>
</body>
</html>