<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!--  <body style="background-color:black;">-->
<body class="bodyBlack">
<%@ include file="../main/header.jsp" %>
<div class="container backGround" >
	<div class="container innerContainer">
		<form action="/user/register" method="post" id="registerForm">
		<div class="form-group">
			<label for="name">User name:</label>
			<input type="text" class="form-control" name="name" id="name">
		</div>
		<div class="form-group">
			<label for="email">Email address:</label>
			<input type="email" class="form-control" name="email" id="email">
		</div>
		<div class="form-group">
			<label for="password">Password:</label>
			<input type="password" class="form-control" name="password" id="password">
		</div>
		<div class="form-group">
			<label for="passwordConfirm">Password Confirm:</label>
			<input type="password" class="form-control" name="passwordConfirm" id="passwordConfirm">
		</div>
		<div class="form-group">
			<button id="cancelBtn" type="button" class="btn btn-warning" onclick="backToMain();">취소</button>
			<button id="registerBtn" type="button" class="btn btn-default" onclick="checkingBeforeRegister();">등록</button>
		</div>
		</form>
	</div>
</div>
<%@ include file="../main/footer.jsp"%>
</body>
<script src="/resources/mainjs/main.js"></script>
