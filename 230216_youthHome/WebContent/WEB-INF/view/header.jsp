<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link type="text/css" rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
 <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
 <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<header>
		<div>
			<c:choose>
				<c:when test="${empty lgnss }">
					<nav class="navbar-right bg-light pt-3 pb-3  ">
					 <form class="hstack gap-3">
					 	<button class="btn home btn-outline-secondary me-2 mx-4" type="button"> 홈</button>
						<button class="btn login btn-outline-secondary me-2 ms-auto" type="button"> 로그인</button>
						<button class="btn enroll btn-outline-secondary me-4 " type="button">회원가입</button>
						</form>
					</nav>
				</c:when>
				<c:otherwise>
					<nav class="navbar-right bg-light pt-3 pb-3">
					 <form class="hstack gap-3">
					 	<button class="btn home btn-outline-secondary me-2 mx-4" type="button"> 홈</button>
						<button class="btn myinfo btn-outline-secondary me-2 ms-auto" type="button"> 마이페이지</button>
						<button class="btn logout btn-outline-secondary me-4 " type="button">로그아웃</button>
						</form>
					</nav>
				</c:otherwise>
			</c:choose>
		</div>
		
		<script>
		$(".btn.home").on("click",handlerClickBtnHome);
		$(".btn.login").on("click",handlerClickBtnLogin);
		$(".btn.logout").on("click",handlerClickBtnLogout);
		$(".btn.myinfo").on("click",handlerClickBtnMyinfo);
		$(".btn.enroll").on("click",handlerClickBtnEnroll);
		
		
		function handlerClickBtnHome(){
			console.log("btnHome눌림");
			location.href="<%=request.getContextPath()%>/"; 
		}
		
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