<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ page import="java.util.ArrayList, kh.youth.model.vo.YouthVo " %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>현 모집 공고</title>
<link type="text/css" rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/view/header.jsp"></jsp:include>

<!-- 게시글 목록 테이블 -->
		<table class="table table-bordered">
		  <thead>
		    <tr>
		      <th scope="col">번호</th>
		      <th scope="col">구분</th>
		      <th scope="col">공고명</th>
		      <th scope="col">공고게시일</th>
		      <th scope="col">청약신청일</th>
		      <th scope="col">담당부서/사업자</th>
		    </tr>
		  </thead>
		  
			<tbody>
 			
 			<% for(YouthVo Youth : (ArrayList<YouthVo>)request.getAttribute("selectList") ){ %>
 			<tr>
	 			<td><%=Youth.getIdx()%></td>
	 			<td><%=Youth.getDivision()%></td>
	 			<td><%=Youth.getAnnName()%></td>
	 			<td><%=Youth.getAnnDate()%></td>
	 			<td><%=Youth.getApplyDate()%></td>
	 			<td><%=Youth.getManager()%></td>
 			</tr>
 				<%} %>
 			
 			</tbody>
  			
 			</table>
 			
 			<!-- 페이징 -->
 			<ul class="pagination"> <!-- 페이징네이션 -->
	 			  <c:set var="pageNumber" value="${empty param.p ? 1: param.p}" />
				  <li class="page-item"><a class="page-link" href="#">prev</a></li>
				  
				  <c:forEach var="pNum" items="${requestScope.pageList}">
				    <li class="page-item ${pNum eq pageNumber ? 'active' : '' }"><a class="page-link" href="<%=request.getContextPath()%>/annoucne?p=${pNum}">${pNum}</a></li>
				  </c:forEach>
				  
				  <li class="page-item"><a class="page-link" href="#">next</a></li>
				
	 		</ul>	

</body>
</html>