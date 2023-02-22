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
 
 
 
	 <div class="container text-center mt-5 mb-5">
	      <div class="row mx-2 ">
	        <div class="col mx-2 border ">
	          <h1>청년주택</h1>
	          <svg xmlns="http://www.w3.org/2000/svg" width="70" height="70" fill="currentColor" class="bi bi-houses" viewBox="0 0 16 16">
				<path d="M5.793 1a1 1 0 0 1 1.414 0l.647.646a.5.5 0 1 1-.708.708L6.5 1.707 2 6.207V12.5a.5.5 0 0 0 .5.5.5.5 0 0 1 0 1A1.5 1.5 0 0 1 1 12.5V7.207l-.146.147a.5.5 0 0 1-.708-.708L5.793 1Zm3 1a1 1 0 0 1 1.414 0L12 3.793V2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v3.293l1.854 1.853a.5.5 0 0 1-.708.708L15 8.207V13.5a1.5 1.5 0 0 1-1.5 1.5h-8A1.5 1.5 0 0 1 4 13.5V8.207l-.146.147a.5.5 0 1 1-.708-.708L8.793 2Zm.707.707L5 7.207V13.5a.5.5 0 0 0 .5.5h8a.5.5 0 0 0 .5-.5V7.207l-4.5-4.5Z"/>
		      </svg>
		      <ol class="list-group mb-5 mt-5">
			      <li
			        class="list-group-item d-flex justify-content-between align-items-start">
			        <div class="ms-2 me-auto btn intro">
			          <div class="fw-bold text-start">사업소개</div>
			        </div>
			      </li>
			      <li
			        class="list-group-item d-flex justify-content-between align-items-start">
			        <div class="ms-2 me-auto btn annoucne">
			          <div class="fw-bold">모집공고</div>
			        </div>
			      </li>
			    </ol>
	        </div>
	        <div class="col mx-2 border ">
	        
	          <h1>커뮤니티</h1>
	          <svg xmlns="http://www.w3.org/2000/svg" width="70" height="70" fill="currentColor" class="bi bi-chat-left-text" viewBox="0 0 16 16">
  				<path d="M14 1a1 1 0 0 1 1 1v8a1 1 0 0 1-1 1H4.414A2 2 0 0 0 3 11.586l-2 2V2a1 1 0 0 1 1-1h12zM2 0a2 2 0 0 0-2 2v12.793a.5.5 0 0 0 .854.353l2.853-2.853A1 1 0 0 1 4.414 12H14a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z"/>
 				<path d="M3 3.5a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5zM3 6a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9A.5.5 0 0 1 3 6zm0 2.5a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5z"/>
			  </svg>
			  	
					  <ol class="list-group mt-5">
				      	<li class="list-group-item d-flex justify-content-between align-items-start">
				        <div class="ms-2 me-auto btn board">
				          <div class="fw-bold text-start">자유게시판</div>
				        </div>
				      </li>
				     </ol>
			     	
	        </div>
	      </div>
	 </div>

 
 <script >
 	$(".btn.intro").on("click", handlerClickBtnIntro);
 	$(".btn.annoucne").on("click", handlerClickBtnAnnoucne);
 	$(".btn.board").on("click", handlerClickBtnBoard);
 	
 	function handlerClickBtnIntro(){
 		console.log("버튼 누름");
 		location.href="<%=request.getContextPath() %>/introYouth";
 	}
 	
 	function handlerClickBtnAnnoucne(){
 		console.log("버튼 누름");
 		location.href="<%=request.getContextPath() %>/annoucne";
 	}
 	
 	function handlerClickBtnBoard(){
 		console.log("버튼 누름");
 		location.href="<%=request.getContextPath() %>/board";
 	}
 
 </script>
 
 <jsp:include page="/WEB-INF/view/footer.jsp"></jsp:include> 
 

</body>
</html>