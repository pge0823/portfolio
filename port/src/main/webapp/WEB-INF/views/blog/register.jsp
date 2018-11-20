<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="myblogHeader.jsp" %>

    <!-- Main Content -->
    <div class="container innerContainer">
		<form action="" method="post" id="">
		<div class="form-group">
			<label for="title">제목</label>
			<input type="text" class="form-control" name="title" id="title">
		</div>
		<div class="form-group">
			<label for="writer">작성자</label>
			<input type="text" class="form-control" name="title" id="title" value="${login.email}" disabled>
		</div>
		<div class="form-group">
			<label for="content">내 용</label>
			<textarea class="form-control" rows="10" name="content" id="content"></textarea>
		</div>
		<div class="form-group">
			<button id="cancelBtn" type="button" class="btn btn-warning" onclick="backToMain();">취소</button>
			<button id="registerBtn" type="button" class="btn btn-default" onclick="checkingBeforeRegister();">등록</button>
		</div>
		</form>
	</div>

    <hr>
<%@ include file="myblogFooter.jsp" %>