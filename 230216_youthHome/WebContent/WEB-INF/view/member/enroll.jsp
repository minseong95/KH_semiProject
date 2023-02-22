<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>kh 회원가입</title>
<link type="text/css" rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
 <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
</head>
<body>
	<nav class="navbar bg-light">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="<%=request.getContextPath()%>/">메인으로</a>
	  </div>
	</nav>

	<section>
	<h1 class="mx-4">회원가입</h1>
	
	<form action="<%=request.getContextPath()%>/enroll" method="post" class="was-validated w-75 mx-4">
		
	  		
	  		<div class="mb-3">
        	<label class="form-label">아이디</label>
        	<input type="text" class="form-control" name="id"  placeholder="아이디를 입력해주세요" required="" style="height: 48px;"></input>
     	    </div>
	  		<!-- 중복검사때문에 type=text 이거 빼먹으면 안됨..  -->
	  		
	  		<button type="button" class="btn btn-outline-secondary" id="dupId">중복 id 확인</button>
	  		<span></span>
		
		
		
			<div class="mb-3">
        	<label class="form-label">비밀번호</label>
        	<input type="password" class="form-control" name="passwd"  placeholder="비밀번호 입력해주세요" required="" style="height: 48px;"></input>
        	
     	    </div>
		
	  		
		
			<div class="mb-3">
        	<label class="form-label">이름</label>
        	<input type="text" class="form-control" name="name"  placeholder="이름을 입력해주세요" required="" style="height: 48px;"></input>
     	    </div>
		
	  		
		
			<div class="mb-3">
        	<label class="form-label">이메일</label>
        	<input type="email" class="form-control" name="email"  placeholder="이메일을 입력해주세요" required="" style="height: 48px;"></input>
     	    </div>
		
		
		<button type="submit" class="btn btn-secondary btn-lg">가입하기</button>
	</form>
	
	</section>
<jsp:include page="/WEB-INF/view/footer.jsp"></jsp:include> 	
		<!-- 중복체크 -->
		<script>
	 <!-- 이벤트를 처리하는 부분이 필요 -->
	 	$("#dupId").click(checkDupId);
	 	function checkDupId(){
	 		$.ajax({
	 			url:"<%=request.getContextPath()%>/dupid.lo" 
	 			  , type:"post" //type, async, data 생략 가능 
	 			  , async:false
	 			  , data:{id: $("input[type=text]").first().val()} // 인풋 태그이면서 타입이 text인거.. 읽기
	 			  , success: function(result){ //controller에서 날라온 데이터가 result
	 				console.log(result); //result...
	 				if(result === "fail"){ // 아 됐다
	 					$("#dupId").next().html("중복아이디가 있습니다. 다시 입력해주세요.");
	 					$("#dupId").next().css("color","red");	
	 				}else{
	 					$("#dupId").next().html("사용가능 아이디입니다. ");
	 					$("#dupId").next().css("color","blue");
	 				}
	 			} //result적어주는건.. ctrl에서 뭐 주면 받을거고 안주면 안받고.. 
	 			, error : function(request, status, error){
	 				alert(request.status);
	 			}
	 		, });
	 	}
	<!--$.ajax();에서 달러가 객체이름이 되는거..달러=제이쿼리..?-->
	<!--오브젝트에는 정해진 key를 써야 함 url같은거-->
		</script>
	
</body>
</html>