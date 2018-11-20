<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name = "viewport" content="width=device-width, initial-scale=1">

<title>Test Blog Main</title>
</head>
<body>

<%@ include file="header.jsp" %>
	<header class="masthead" style="background-image:url('/resources/img/city_dark.jpg');">
      	<div class="overlay"></div>
      	<div class="container">
        	<div class="row">
          		<div class="col-lg-12 col-md-8 mx-auto">
		            <div class="site-heading">
		            	<c:choose>
		            		<c:when test="${empty login}">
		            			<h1>안녕하세요.</h1>
		            		</c:when>
		            		<c:when test="${!empty login}">
		            			<h1>${login.name}님 안녕하세요.</h1>
		            		</c:when>
		            	</c:choose>
		            	<span class="subheading">블로그를 만들어 자신을 소개해보세요.</span>
		            </div>
	          	</div>
	        </div>
      </div>
	</header>
	
	<section class="text-center">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-md-10 mx-auto ">
				<span class="sampleImages" >
					<img src="/resources/img/about-bg.jpg" >
				</span>
				<span class="sampleImages">
					<img src="/resources/img/post-bg.jpg" >
				</span>			
				<span class="sampleImages">
					<img src="/resources/img/contact-bg.jpg">
				</span>						
				</div>
			</div>
		</div>
	</section>

<%@ include file="footer.jsp" %>
</body>
</html>
