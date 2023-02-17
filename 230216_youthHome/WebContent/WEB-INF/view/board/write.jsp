<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.util.ArrayList, kh.board.model.vo.BoardVo " %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 작성하기</title>
<link type="text/css" rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/view/header.jsp"></jsp:include>
글 작성 양식을 만들거야..
	<!-- 어뭐야 왜 돼 왜?????/board에서 /write로 바꾸니까 돼는데????ㅅㅂ -->
	<form action="<%=request.getContextPath() %>/write" method="post">
		<div class="mb-4">
		  <label for="exampleFormControlInput1" class="form-label">글 제목</label>
		  <input type="text" class="form-control w-50" name="subject" id="exampleFormControlInput1" >
		</div>
		
		<div class="mb-3 row">
	    <label for="staticEmail" class="col-sm-2 col-form-label">작성자</label>
	    <div class="col-sm-10">
	      <input type="text" readonly class="form-control-plaintext w-25" id="staticEmail" value="유저1 값 가져와..">
	    </div>
	  </div>
		
		<div class="mb-3">
		  <label for="exampleFormControlTextarea1" class="form-label">내용</label>
		  <textarea class="form-control w-50" name="context" id="exampleFormControlTextarea1" rows="3"></textarea>
		</div>
	
		<div class="col-auto">
	    	<button type="submit" class="btn write btn-primary mb-3">등록하기</button>
	  	</div>
	  </form>
	  
 
  			<script>
 				$(".btn.write").on("click", handlerClickBtnWrite);
 				
 				function handlerClickBtnWrite(){
 					console.log("작성하기 버튼 누르기");
 					location.href="<%=request.getContextPath()%>/board" 
 				} 
 			
 			</script> <!-- 글 목록 게시판으로 가기 -->
  
</body>
</html>