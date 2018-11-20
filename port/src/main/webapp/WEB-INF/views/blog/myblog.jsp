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
    	  <!-- Bootstrap core JavaScript -->
    <script src="/resources/vendor/jquery/jquery.min.js"></script>
    <script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- Custom scripts for this template -->
    <script src="/resources/js/clean-blog.min.js"></script>
	<script src="/resources/mainjs/main.js"></script>
    <!--  Bootstrap core CSS -->
    <link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	
	<!-- Custom styles for this template -->
    <link href="/resources/css/clean-blog.min.css" rel="stylesheet">
	<link href="/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<link href="/resources/maincss/main.css" rel="stylesheet">
    
    
  </head>

<body>
<%@ include file="myblogHeader.jsp"%>
<!-- Main Content -->
<div class="container">
	<div class="row">
		<div class="col-lg-8 col-md-10 mx-auto">
			<div>
				<h1>가장 인기있는 게시물!</h1>
			</div>
			<div class="popularPost">
			</div>
		</div>
	</div>
</div>

<hr>

<script>
	$.getJSON("/blog/" + "${blogVO.email}" + "/board/popularPost", function(
			data) {
		var str = "";

		for (var i = 0; i < Object.keys(data.list).length; i++) {
			var pageUrl = encodeURI(location.href + "/board/readPage?page="
					+ data.pageList[i] + "&bno=" + data.list[i].bno);
			str += "<div class='post-preview'>" + "<a href='"+pageUrl+"'>"
					+ "<h2 class='post-title'>" + data.list[i].title + "</h2>"
					+ "<h3 class='post-subtitle'>" + data.list[i].content
					+ "</h3></a></div><hr>";
		}

		$(".popularPost").html(str);
		//    			$(data.list).each{
		//    				str+="<div class='post-preview'>"+
		//    						"<a href='"+data.pageList[0]
		//    			}
	});
</script>
<%@ include file="myblogFooter.jsp"%>
  </body>
</html>

