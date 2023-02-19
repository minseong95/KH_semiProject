<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link type="text/css" rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
 <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/view/header.jsp"></jsp:include>
 서버 확인용 페이지
 
 request.getContextPath()+/
 <a href="<%=request.getContextPath() %>/introYouth">사업소개</a>
 <a href="<%=request.getContextPath() %>/annoucne">모집공고</a>
 <a href="<%=request.getContextPath() %>/board">자유게시판</a>
</body>
</html>