<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="kh.member.model.vo.MemberVo" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보보기</title>
</head>
<body>
<h1>내 정보보기</h1>
	<h4>EL request Attribute</h4>
	<c:if test ="${empty myinfo }">
		<div>
		<h4>로그인되지 않았습니다. 정보가 없습니다. </h4>
		<a href="<%=request.getContextPath()%>/login">로그인페이지로 이동</a>
		</div>
	</c:if>
	
	<!--el태그 이용 : 장점.. 내가 꺼내려는 애한테 값이 없으면 그냥 빈칸만 출력됨.  -->
	<!-- 단점은 내가 오타나서 안나오는건지 걍 값이 없어서 안나오는건지 알 수 없음 -->
	<c:if test ="${not empty myinfo }">
		<div>
			id: ${myinfo.id}
			<br>
			name:${myinfo.name }
			<br>
			email:${myinfo.email }
		</div>
	</c:if>
</body>
</html>