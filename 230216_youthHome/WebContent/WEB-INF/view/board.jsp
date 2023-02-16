<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>
</head>
<body>
 <table>
 	<thead>
 		<tr>
 			<th>번호</th>
 			<th>작성자</th>
 			<th>제목</th>
 			<th>작성일</th>
 			<th>조회수</th>
 		</tr>
 	</thead>
 	<tbody>
 		<c:forEach var="board" items="${requestScope.board }">
 			<td>${board.idx }</td>
 			<td>${board.writer }</td>
 			<td>${board.subject }</td>
 			<td>${board.createdate }</td>
 			<td>${board.view_cnt }</td>
 		</c:forEach>
 	</tbody>
 </table>


</body>
</html>