<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
	
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
 	<title>${blogVO.title}</title>

  </head>

<%@ include file="myblogHeader.jsp"%>
<div class="container" id="boardTableContainer">
	<div class="table">
		<div class="table"></div>
		<table class="table boardTable">

			<thead>
				<tr>
					<th colspan="5">
						<select name="searchType" id="searchTypeInput">
							<option value="n"
								<c:out value="${cri.searchType == null?'selected':''}"/>>---</option>
							<option value="t"
								<c:out value="${cri.searchType eq 't'?'selected':''}"/>>제목</option>
							<option value="c"
								<c:out value="${cri.searchType eq 'c'?'selected':''}"/>>내용</option>
							<option value="w"
								<c:out value="${cri.searchType eq 'w'?'selected':''}"/>>작성자</option>
							<option value="tc"
								<c:out value="${cri.searchType eq 'tc'?'selected':''}"/>>제목&내용</option>
						</select> 
						<input type="text" name='keyword' id='keywordInput'	value="${cri.keyword}">
						<button id='searchBtn'>검색</button>
					</th>
				</tr>
				<tr>
					<th class="boardNo board">번호</th>
					<th class="boardTitle board">제목</th>
					<th class="boardWriter board">작성자</th>
					<th class="boardDate board">일시</th>
					<th class="boardViewcnt board">조회</th>
				</tr>
			</thead>
			<tbody id="boardList">
				<tr>
					<td>1</td>
					<td>제목입니다</td>
					<td>이게 보이면 ajax 작동안함</td>
					<td>일시입니다</td>
					<td>1</td>
				</tr>
			</tbody>


		</table>
	</div>
	<div class="boardPage">
		<ul class="pagination">
		</ul>
	</div>
</div>
<script src="/resources/mainjs/main.js"></script>
<script>
	email = "${blogVO.email}";
	console.log("${page}");
	boardLoad("${page}", "${keyword}", "${searchType}");
</script>
<%@ include file="myblogFooter.jsp"%>