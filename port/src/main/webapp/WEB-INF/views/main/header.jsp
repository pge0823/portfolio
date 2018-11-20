<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name = "viewport" content="width=device-width, initial-scale=1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/resources/maincss/main.css"></link>
</head>
<body>



	
	
	<nav class="nav navbar-inverse navbar-expand-lg navbar-light fixed-top">
		<div class="container">
			<div class="navbar-header navbar-left">
				<button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbarResponsive">
	       		  	 <span class="icon-bar"></span>
	         		 <span class="icon-bar"></span>
	         		 <span class="icon-bar"></span>
	        	</button>
				<a class="navbar-brand" href="/">Test Blog Main</a>
			</div>
			<!-- 메뉴 버튼 -->
			
			<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="nav navbar-nav">
				<li class=""><a href="/">Home</a></li>
				<li class=""><a href="/blog/pge0823@naver.com">제작자</a></li>
				<c:if test="${!empty login}">
					<li><a href="/blog/${login.email}">My blog</a></li>
				</c:if>
			</ul>
			
			<ul class="nav navbar-nav navbar-right">
				
				<c:choose>
					<c:when test="${empty login}">
						<li>
							<a href="/user/register"><span class="glyphicon glyphicon-user"></span>회원가입</a>
						</li>
						<li>
							<a href="/user/login"><span class="glyphicon glyphicon-log-in"></span>로그인</a>
						</li>		
					</c:when>
					<c:when test="${!empty login}">
						
						<li>
							<a href="/blog/setting"><span class="glyphicon glyphicon-cog"></span>블로그관리</a>
						</li>
						<li>
							<a href="/user/logout"><span class="glyphicon glyphicon-log-out"></span>로그아웃</a>
						</li>
					</c:when>
				</c:choose>
				
			</ul>
			</div>
		</div>
	</nav><!-- header part -->
</body>
</html>
	
