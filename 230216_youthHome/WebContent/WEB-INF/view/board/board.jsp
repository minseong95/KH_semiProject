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
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/view/header.jsp"></jsp:include>

	
		 <ol class="list-group w-25 mt-5 mb-5 mx-4">
          <li class="list-group-item d-flex justify-content-between align-items-start" >
            <div class="ms-2 me-auto">
             <div class="fw-bold text-start">자유게시판</div>
           </div>
          </li>
        </ol>
		
		
		<!-- 페이지 처리 구현 -->
		<div>
			<form action="/board"> <!-- url 이게 맞으려나.. // 왜 그냥 submit으로하면 url로 cnt가 안나오지??  --> 
				<select name="cnt" onchange="submit();" class="form-select form-select-sm"  style= "width:100px;height:30px;">
				  <option value= "5" <c:if test="${cnt == 5 }">selected</c:if> > 5개</option>
				  <option value="10" <c:if test="${cnt == 10 }">selected</c:if> > 10개</option>
				  <option value="15" <c:if test="${cnt == 15 }">selected</c:if>> 15개</option>
				  <option value="20""<c:if test="${cnt == 20 }">selected</c:if>> 20개</option>
				</select>
			</form>
		</div-->
		
		
		<!-- 게시글 목록 테이블 -->
		<table class="table table-bordered ">
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
	 			<td><a href="<%=request.getContextPath()%>/boardDetail?id=<%=board.getIdx()%>"><%=board.getSubject()%></a></td>
	 			<td><%=board.getCreatedate()%></td>
	 			<td><%=board.getView_cnt() %></td>
 			</tr>
 				<%} %>
 			
 			</tbody>
  			
 			</table>
 			
 			<!-- 페이징 -->
 			<ul class="pagination"> <!-- 페이징네이션 -->
	 			  <c:set var="pageNumber" value="${empty param.p ? 1: param.p}" />
	 			  
	 			  
	 			   <c:choose>
	 		 			<c:when test="${pNum eq 1}">
	 		 				 <li class="page-item"><a class="page-link" href="#">prev</a></li>
	 		 			</c:when>
	 		 			<c:otherwise>
	 		 		 		<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/board?p=1">prev</a></li>
	 		 			</c:otherwise>
	 		 	   </c:choose>
	 			   
	 			   
	 			   
				  <!-- li class="page-item"><a class="page-link" href="#">prev</a></li-->
				  
				  
				  <c:forEach var="pNum" items="${requestScope.pageList}">
				    <li class="page-item ${pNum eq pageNumber ? 'active' : '' }"><a class="page-link" href="<%=request.getContextPath()%>/board?p=${pNum}">${pNum}</a></li>
				  </c:forEach>
				  
				  
					<!-- 아 마지막 페이지를 구해서 eq 뒤에 넣으면..   -->
				  <c:choose>
	 		 			<c:when test="${pNum eq 3}">
	 		 				<li class="page-item"><a class="page-link" href="#">next</a></li>
	 		 			</c:when>
	 		 			<c:otherwise>
	 		 				<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/board?p=3">next</a></li>
	 		 			</c:otherwise>
	 		 	</c:choose>
				  
				  
				  <!-- li class="page-item"><a class="page-link" href="#">next</a></li-->
				
	 		</ul>	
 			
 			
			<div align="right" class="mb-4">
 				<button type="button" class="btn write btn-secondary">글 작성하기</button>
 			</div>
 			
 			
 			<script>
 				$(".btn.write").on("click", handlerClickBtnWrite);
 				
 				function handlerClickBtnWrite(){
 					console.log("작성하기 버튼 누르기");
 					location.href="<%=request.getContextPath()%>/write"
 				}
 			
 			
 			</script>
		


</body>
</html>