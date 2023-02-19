<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ page import="java.util.ArrayList, kh.board.model.vo.BoardVo " %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 자세히 보기</title>
<link type="text/css" rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/view/header.jsp"></jsp:include>
	<div>
	게시판
	</div>

	<hr>
	
	${detail.writer}
	${detail.context }
	
	<hr>
	
	
	<button type="button" class="btn list">목록</button>
    <button type="button" class="btn update">수정</button>
    
    <button type="submit" form="deleteForm" class="btn delete">삭제</button>
    <form id="deleteForm" action="<%=request.getContextPath()%>/delete?id=<%=request.getAttribute("id")%>" method="post"></form>
    <!-- 삭제 될까..? -->
  
    
    <script>
    $(".btn.list").on("click",handlerClickBtnList);
    $(".btn.update").on("click",handlerClickBtnUpdate);
    
    function handlerClickBtnList(){
		console.log("btnList 눌림");
		location.href="<%=request.getContextPath()%>/board"; 
	}
    
    function handlerClickBtnUpdate(){
		console.log("btnUpdate 눌림");
		location.href="<%=request.getContextPath()%>/update?id=<%=request.getAttribute("id")%>"; 
	}

   
    
    
    </script>
</body>
</html>