<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="myblogHeader.jsp" %>

    <!-- Main Content -->
    <div class="container innerContainer">
    	<form action="" id="pageForm">
		<div class="form-group">
			<label for="title">제목</label>
			<input type="text" class="form-control" name="title" id="title" value="${blogBoardVO.title }"disabled>
		</div>
		<div class="form-group">
			<label for="writer">작성자</label>
			<input type="text" class="form-control" name="writer" id="writer" value="${blogBoardVO.writer}" disabled>
		</div>
		<div class="form-group">
			<label for="content">내 용</label>
			<textarea class="form-control" rows="15" name="content" id="content" disabled>${blogBoardVO.content}</textarea>
		</div>
		</form>
		<div class="form-group">
			<form action="/blog/${blogVO.email}/board" method="post">
				<input type="hidden" name="page" value="${page}">
				<input type="hidden" name="keyword" value="${keyword}">
				<input type="hidden" name="searchType" value="${searchType}">
				<input type="submit" id="" class="btn btn-primary btn-sm" value="목록">
			</form>
			<button style="display:none" id="cancelBtn" type="button" class="btn btn-warning btn-sm" onclick="cancel();">취소</button>
			<c:if test="${login.email eq blogBoardVO.writer || login.email eq blogVO.email}">
				<button id="deleteBtn" type="button" class="btn btn-danger btn-sm" onclick="del();">삭제</button>
			</c:if>
			<c:if test="${login.email eq blogBoardVO.writer}">
				<button id="updateBtn" type="button" class="btn btn-default btn-sm" onclick="update();">수정</button>
			</c:if>
		</div>
		<script>
			console.log("bBVO"+"${blogBoardVO.email}");
			console.log("login"+"${login.email}");
			console.log("bVO"+"${blogVO.email}");
			var isUpdateForm = false;
			console.log(location.href);
			var update = function(){
				if(isUpdateForm){
					//isUpdateForm==true인 경우 수정 버튼을 누르면 제출해야한다.
					var index = location.href.lastIndexOf('/');
					var des = location.href.substring(0, index);
					var url = location.href;
					var bno = "${blogBoardVO.bno}";
					var titleVal=$('#title').val();
					var contentVal=$('#content').val();
					console.log(title + " and " + content);
					
					$.ajax({
						type:'PUT',
						url:des+"/"+bno,
						headers:{
							"Content-Type":"application/json",
							"X-HTTP-Method-Override" : "PUT"
						},
						data:JSON.stringify({bno:bno, title:titleVal, content:contentVal}),
						dataType:'text',
						success:function(result){
							location.href=url;
						}
					});
					
					
				}else{
					//isUpdateForm==false인 경우 updateForm으로 변경해준다.
					$("#cancelBtn").css("display", "inline");
					$("#title, #content").prop("disabled", false);
					$("#title").focus();
					isUpdateForm = true;
				}
			}
			var cancel = function(){
				$("#title").val("${blogBoardVO.title}");
				$("#writer").val("${blogBoardVO.writer}");
				$("#content").val("${blogBoardVO.content}");
				$("#title, #writer, #content").prop("disabled", true);
				$("#cancelBtn").css("display", "none");
				isUpdateForm=false;
			}
			
			var del = function(){
				var bno = "${blogBoardVO.bno}";
				var index = location.href.lastIndexOf('/');
				var des = location.href.substring(0, index);
				$.ajax({
					type:'DELETE',
					url:des+"/"+bno,
					headers:{
						"Content-Type":"application/json",
						"X-HTTP-Method-Override" : "DELETE"
					},
					dataType:'text',
					success:function(result){
						if(result=="SUCCESS"){
							alert("삭제되었습니다");	
						}
						else{
							alert("삭제에 실패했습니다");
						}
						location.href=des;
					}
				});
				
				
			}
			
		</script>
	</div>
    <hr>
<%@ include file="myblogFooter.jsp" %>