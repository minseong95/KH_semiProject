<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정하기</title>
 <link type="text/css" rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
 <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/view/header.jsp"></jsp:include>

		<ol class="list-group w-25 mt-5 mb-5 mx-4">
          <li class="list-group-item d-flex justify-content-between align-items-start" >
            <div class="ms-2 me-auto">
             <div class="fw-bold text-start">글 수정하기</div>
           </div>
          </li>
        </ol>


	<!-- 아 작성자 어떻게 끌고오지.. -->
	<form action="<%=request.getContextPath() %>/update?id=<%=request.getAttribute("id")%>" method="post" class="mx-4">
		<div class="mb-4">
		  <label for="exampleFormControlInput1" class="form-label">글 제목</label>
		  <input type="text" class="form-control w-50" name="subject"  >
		</div>
		
		<div class="mb-3 row">
	    <label for="staticEmail" class="col-sm-2 col-form-label">작성자</label>
	    <div class="col-sm-10">
	      <input type="text" readonly class="form-control-plaintext w-25" id="staticEmail" value="${userId}">
	    </div>
	  </div>
		
		<div class="mb-3">
		  <label for="exampleFormControlTextarea1" class="form-label">내용</label>
		  <textarea class="form-control w-50" name="context" id="exampleFormControlTextarea1" rows="3"></textarea>
		</div>
	
		<div class="col-auto">
	    	<button type="submit" class="btn update btn-primary mb-3">수정하기</button>
	  	</div>
	  </form>
	  
	  <script>
 				$(".btn.update").on("click", handlerClickBtnUpdate);
 				
 				function handlerClickBtnUpdate(){
 					console.log("수정하기 버튼 누르기");
 					location.href="<%=request.getContextPath()%>/boardDetail" 
 				} //수정완료되면 다시 그 게시물로 가게 하기 위해서..
 			
 			</script>

</body>
</html>