<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>
<!--  <body style="background-color:black;">-->
<body class="bodyBlack">
<div class="container backGround" >
	<div class="container innerContainer" >
		<form action="/user/loginPost" method="post" id="loginForm">
		<div class="form-group">
			<label for="email">Email address:</label>
			<input type="email" class="form-control" id="email" name="email">
		</div>
		<div class="form-group">
			<label for="password">Password:</label>
			<input type="password" class="form-control" id="password" name="password">
		</div>
		<div class="form-group">
			<label for="checkbox"><input type="checkbox" name="useCookie">자동 로그인</label>
			<button  id="loginBtn" type="button" class="btn btn-default">로그인</button>
			<a href="/user/register"><button id="registBtn" type="button" class="btn btn-primary btn-sm">회원가입</button></a>
		</div>
		</form>
	</div>
</div>
</body>
<script>
	var loginFail = '${loginFail}';
	if(loginFail == 'FAIL'){
		alert("아이디와 비밀번호를 확인해주세요");
	}
</script>
<script src="/resources/mainjs/main.js"></script>
<%@ include file="../main/footer.jsp"%>