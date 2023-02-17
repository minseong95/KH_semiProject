<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ page import="java.util.ArrayList, kh.board.model.vo.BoardVo " %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 자세히 보기</title>
</head>
<body>
	<div>
	게시판
	</div>
	
	<ul>
 <% for(BoardVo detail : (ArrayList<BoardVo>)request.getAttribute("detail") ){ %>
	<li><%=detail.getWriter() %> | <%=detail.getSubject() %>
	     <%=detail.getContext() %> | <%=detail.getCreatedate() %>  </li>
 <%} %>
</ul>

</body>
</html>