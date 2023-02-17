<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link type="text/css" rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
 <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
 
<header>
		<div>
			<c:choose>
				<c:when test="${empty lgnss }">
					<button type="button" class="btn login">로그인</button>
					<button type="button" class="btn enroll">회원가입</button>		
				</c:when>
				<c:otherwise>
					<button type="button"class="btn myinfo">마이페이지</button>
					<button type="button" class="btn logout">로그아웃</button>
				</c:otherwise>
			</c:choose>
		</div>
		
		<script>
		$(".btn.login").on("click",handlerClickBtnLogin);
		$(".btn.logout").on("click",handlerClickBtnLogout);
		$(".btn.myinfo").on("click",handlerClickBtnMyinfo);
		$(".btn.enroll").on("click",handlerClickBtnEnroll);
		
		function handlerClickBtnLogin(){
			console.log("btnLogin 눌림");
			location.href="<%=request.getContextPath()%>/login"; 
		}
		function handlerClickBtnLogout(){
			console.log("btnLogout 눌림");
			location.href="<%=request.getContextPath()%>/logout"; 
		}

		function handlerClickBtnMyinfo(){
			console.log("btnmyinfo 눌림");
			location.href="<%=request.getContextPath()%>/myinfo"; 
		}
		
		function handlerClickBtnEnroll(){
			console.log("btnEnroll 눌림");
			location.href="<%=request.getContextPath()%>/enroll"; 
		}
		
		</script>
</header>