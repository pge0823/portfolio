<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/header.jsp" %>

<!--  <body style="background-color:black;">-->
<body class="bodyBlack">
<div class="container backGround" >
	<div class="container innerContainer">
		<form action="/blog/setting" method="post" id="settingForm">
		<div class="form-group">
			<label for="title">title:</label>
			<input type="text" class="form-control" name="title" id="title" value="${blogVO.title}">
		</div>
		<div class="form-group">
			<label for="blogName">blogName:</label>
			<input type="text" class="form-control" name="blogName" id="blogName" value="${blogVO.blogName }">
		</div>
		<div class="form-group">
			<label for="backgroundImage">backgroundImage:</label>
			<div class="background-Image">
				<div>
					<input type="radio" name="backgroundImage" id="backgroundImage" value="home-bg.jpg" <c:if test="${blogVO.backgroundImage eq 'home-bg.jpg'}">checked</c:if>>
					<img src="/resources/img/home-bg.jpg" class="thumbnail-Image">
				</div>
				<div>
					<input type="radio" name="backgroundImage" id="backgroundImage" value="contact-bg.jpg" <c:if test="${blogVO.backgroundImage eq 'contact-bg.jpg'}">checked</c:if>>
					<img src="/resources/img/contact-bg.jpg" class="thumbnail-Image">
				</div>
				<div>
					<input type="radio" name="backgroundImage" id="backgroundImage" value="post-bg.jpg" <c:if test="${blogVO.backgroundImage eq 'post-bg.jpg'}">checked</c:if>>
					<img src="/resources/img/post-bg.jpg" class="thumbnail-Image">
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="siteHeading">siteHeading:</label>
			<input type="text" class="form-control" name="siteHeading" id="siteHeading" value="${blogVO.siteHeading}">
		</div>
		<div class="form-group">
			<label for="subHeading">subHeading:</label>
			<input type="text" class="form-control" name="subHeading" id="subHeading" value="${blogVO.subHeading}">
		</div>
		<div class="form-group">
			<label for="copyright">copyright</label>
			<input type="text" class="form-control" name="copyright" id="copyright" value="${blogVO.copyright}">
		</div>
		<div class="form-group">
			<button id="cancelBtn" type="button" class="btn btn-warning" onclick="backToMain();">취소</button>
			<button id="settingBtn" type="submit" class="btn btn-default" >수정</button>
		</div>
		<input type="hidden" value="${login.email}" name="email" id="email">
		</form>
	</div>
</div>
</body>
<script src="/resources/mainjs/main.js"></script>
<script>
	var msg = "${msg}";
	if( msg == "SUCCESS")
		alert("수정 되었습니다!");
</script>
<%@ include file="../main/footer.jsp"%>