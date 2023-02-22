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
	<ol class="list-group w-25 mt-5 mb-5 mx-4">
          <li class="list-group-item d-flex justify-content-between align-items-start" >
            <div class="ms-2 me-auto">
             <div class="fw-bold text-start">자유게시판</div>
           </div>
          </li>
        </ol>

	<div class="container mx-0">
      
      <div class="row">
          <div class="col-md-10">
              <table class="table table-condensed">
                  <thead>
                      <tr >
                          <th width="10%">제목</th>
                          <th width="60%">${detail.subject}</th>
                      </tr>
                  </thead>
                  <tbody>
                      <tr>
                          <td>작성일
                          </td>
                          <td>
                          ${detail.createdate}
                          </td>
                      </tr>
                      <tr>
                          <td>글쓴이
                          </td>
                          <td>
                          ${detail.writer} <span style='float:right'>조회 :${detail.view_cnt}</span>
                          </td>
                      </tr>
                      <tr>
                          <td colspan="2">
                              <p>${detail.context }</p>
                          </td>
                      </tr>
                  </tbody>
              </table>
              <table class="table table-condensed"></table>
              
              <div class="hstack gap-3">
                <button type="button" class="btn list btn-outline-secondary ms-auto">목록</button>
			    <button type="button" class="btn update btn-outline-secondary">수정</button>
			    <button type="submit" form="deleteForm" class="btn delete btn-outline-secondary">삭제</button>
			    <form id="deleteForm" action="<%=request.getContextPath()%>/delete?id=<%=request.getAttribute("id")%>" method="post"></form>
              </div>
    
	
              
        </div>
      </div>
     
  </div>   

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