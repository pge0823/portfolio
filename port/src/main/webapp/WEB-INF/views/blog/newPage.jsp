<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="myblogHeader.jsp" %>

    <!-- Main Content -->
    <div class="container innerContainer">
    	<form id="postForm" method="post">
		<div class="form-group">
			<label for="title">제목</label>
			<input type="text" class="form-control" name="title" id="title">
		</div>
		<div class="form-group">
			<label for="writer">작성자</label>
			<input type="text" class="form-control" name="writer" id="writer" value="${login.email}" disabled>
		</div>
		<div class="form-group">
			<label for="content">내 용</label>
			<textarea class="form-control" rows="15" name="content" id="content" ></textarea>
		</div>
		</form>
		<div class="form-group">
			<button id="cancelBtn" type="button" class="btn btn-warning" onclick="cancel();">취소</button>
			<button id="registBtn" type="button" class="btn btn-default" onclick="regist();">등록</button>
		</div>
		<script>
			
			var cancel = function(){
				var index = window.location.href.lastIndexOf('/');
				var url = window.location.href.substring(0,index);
				window.location.href=url;
			}
			var regist = function(){
				var url = window.location.href;
				var form = $("#postForm");
				$("#writer").attr("disabled", false);
				form.attr("action", url);
				form.submit();
			}
			console.log($("#writer").val());
		</script>
	</div>
    <hr>
<%@ include file="myblogFooter.jsp" %>