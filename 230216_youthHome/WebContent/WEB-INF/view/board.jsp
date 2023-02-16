<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page import="java.util.ArrayList, kh.board.model.vo.BoardVo " %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>
<link type="text/css" rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
		<div class>
			<nav class="navbar bg-light">
			  <div class="container-fluid">
			    <span class="navbar-brand mb-0 h1">여기는 헤더..</span>
			  </div>
			</nav>
		</div>
		<!-- 네비 -->
		<div class="mb-5">
			<nav class="navbar bg-light">
			  <div class="container-fluid">
			    <span class="navbar-brand mb-0 h1">자유 게시판</span>
			  </div>
			</nav>
		</div>
		
		
		<!-- 페이지 처리 구현 -->
		<div>
			<select class="form-select form-select-sm"   style= "width:100px;height:30px;">
			  <option>5개</option>
			  <option>10개</option>
			  <option>15개</option>
			  <option>20개</option>
			</select>
		</div>
		
		
		
		<!-- 게시글 목록 테이블 -->
		<table class="table table-bordered">
		  <thead>
		    <tr>
		      <th scope="col">번호</th>
		      <th scope="col">작성자</th>
		      <th scope="col">제목</th>
		      <th scope="col">작성일</th>
		      <th scope="col">조회수</th>
		    </tr>
		  </thead>
		  
			<tbody>
 			
 			<% for(BoardVo board : (ArrayList<BoardVo>)request.getAttribute("selectList") ){ %>
 			<tr>
	 			<td><%=board.getIdx()%></td>
	 			<td><%=board.getWriter()%></td>
	 			<td><a href="<%=request.getContextPath()%>/boardDetail?n=<%=board.getIdx()%>"><%=board.getSubject()%></a></td>
	 			<td><%=board.getCreatedate()%></td>
	 			<td><%=board.getView_cnt()%></td>
 			</tr>
 				<%} %>
 			
 			</tbody>
  			
 			</table>
 			
 			<!-- 페이징 -->
 			<ul class="pagination"> <!-- 페이징네이션 -->
	 			  <c:set var="pageNumber" value="${empty param.p ? 1: param.p}" />
				  <li class="page-item"><a class="page-link" href="#">prev</a></li>
				  
				  <c:forEach var="pNum" items="${requestScope.pageList}">
				    <li class="page-item ${pNum eq pageNumber ? 'active' : '' }"><a class="page-link" href="<%=request.getContextPath()%>/board?p=${pNum}">${pNum}</a></li>
				  </c:forEach>
				  
				  <li class="page-item"><a class="page-link" href="#">next</a></li>
				
	 		</ul>	
 			
 			-----------------------------------------------
 			
 			<div>
			  <a href="#">prev</a>
			  <c:forEach var="pNum" items="${requestScope.pageList}">
			    <a href="<%=request.getContextPath()%>/board?p=${pNum}">${pNum}</a>
			  </c:forEach>
			  <a href="#">next</a>
			</div>
 			
 			
 			
 			<!-- 글 작성하기 버튼 -->
 			<div align="right" class="mb-4">
 				<button type="button" class="btn btn-secondary">글 작성하기</button>
 			</div>
 			
 			
 			
 			
		


</body>
</html>