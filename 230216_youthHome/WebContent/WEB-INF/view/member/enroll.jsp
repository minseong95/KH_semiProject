<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>kh 회원가입</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
</head>
<body>

	<section>
	<h1>회원가입</h1>
		<form action="<%=request.getContextPath()%>/enroll" method="post"> <!-- 절대경로 -->
			id:<input type="text" name="id"> 
			<br>
			<button type="button" id="dupId">중복 id 확인</button> <!-- 타입으로 '버튼'도 명시해야 함 -->
	          <!-- 버튼이라고 안하면  submit 으로 인식함..?? -->
			<span></span>
			<br>
			passwd:<input type="password" name="passwd">
			<br>
			name:<input type="text" name="name">
			<br>
			email:<input type="text" name="email">
			<br>
			<button type="submit">회원가입</button>
		</form>
	</section>
	
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