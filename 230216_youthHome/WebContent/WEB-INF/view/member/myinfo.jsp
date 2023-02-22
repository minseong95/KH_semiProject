<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="kh.member.model.vo.MemberVo" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보보기</title>
<link type="text/css" rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/view/header.jsp"></jsp:include>

	<ol class="list-group w-25 mt-5 mb-5 mx-4">
          <li class="list-group-item d-flex justify-content-between align-items-start" >
            <div class="ms-2 me-auto">
             <div class="fw-bold text-start">내 정보보기</div>
           </div>
          </li>
        </ol>


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
		
					    
			    <table class="table w-25 ms-4">
			
			      <tbody>
			        <tr>
			          <th scope="row">id</th>
			          <td>${myinfo.id}</td>
			
			        </tr>
			        <tr>
			          <th scope="row">name</th>
			          <td>${myinfo.name }</td>
			
			
			        </tr>
			        <tr>
			          <th scope="row">email</th>
			          <td colspan="2">${myinfo.email }</td>
			
			        </tr>
			      </tbody>
			    </table> 
    
	
		</div>
	</c:if>
</body>
</html>