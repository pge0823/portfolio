/**
 * 
 */




//start for register.jsp
var checkingBeforeRegister = function(){
	var registerForm = document.getElementById('registerForm');
	var userNameInput = document.getElementById('name');
	var emailInput =  document.getElementById('email');
	var passwordInput = document.getElementById('password');
	var passwordConfirmInput = document.getElementById('passwordConfirm');
	
	var name = userNameInput.value;
	var email = emailInput.value;
	var password = passwordInput.value;
	var passwordConfirm = passwordConfirmInput.value;
	
	if(name== null || name==""){
		alert('이름을 입력하세요.');
		userNameInput.focus();
	}else if(email==null || email ==""){
		alert('email을 입력하세요. 아이디로 활용됩니다.');
		emailInput.focus();
	}else if(password == null || password==""){
		alert('비밀번호를 입력하세요');
		passwordInput.focus();
	}else if(passwordConfirm == null || passwordConfirm ==""){
		alert('비밀번호를 한번 더 입력하세요');
		passwordConfirmInput.focus();
	}else if(password != passwordConfirm){
		alert('비밀번호가 다릅니다.');
		passwordConfirmInput.value ="";
		passwordInput.value="";
		document.getElementById('password').focus();
	}else{
		registerForm.submit();
	}
	
}


var backToMain = function(){
	self.location.href="/main";
	
}
//end for register.jsp

//start for setting.jsp

$("#settingBtnForAjax").on("click", function(){
	var email = $("#email").val();
	var title = $("#title").val();
	var blogName = $("#blogName").val();
	var backgroundImage = $("input:radio[name=backgroundImage]:checked").val();
	var siteHeading = $("#siteHeading").val();
	var subHeading = $("#subHeading").val();
	var copyright = $("#copyright").val();	
	
	
	$.ajax({
		type:'post',
		url:'/blog/setting',
		headers : {
			"Content-Type" : "application/json",
			"X-HTTP-Method-Override" : "POST"
		},
		dataType:'text',
		data : JSON.stringify({
			email:email,
			title : title,
			blogName : blogName,
			backgroundImage : backgroundImage,
			siteHeading : siteHeading,
			subHeading : subHeading,
			copyright : copyright
		}),
		success:function(result){
			
			if(result=="SUCCESS"){
				console.log("수정완료");
				alert("수정 되었습니다.");
			}
		}
	});
});




//end for setting.jsp

//start for login.jsp
	
$("#loginBtn").on("click", function(){
	var loginForm = $("#loginForm");
	var email = $("#email").val();
	var dotPos = email.lastIndexOf('.');
	if(dotPos == -1){
		loginForm.submit();
	}else{
		$("#email").val( email.substring(0,dotPos) + "\." + email.substring(dotPos+1));
	}
	
	loginForm.submit();
	
});

//end for login.jsp


//start for myblogHeader.jsp


//end for myblogHeader.jsp

//start for board.jsp
	var email=null;
	var prettifyDate = function(timeValue){
		var dateObj = new Date(timeValue);
		var year = dateObj.getFullYear();
		var month = dateObj.getMonth()+1;
		var date = dateObj.getDate();
		return year+"/"+month+"/"+date;
	}

	
	var boardLoad = function (page, keyword, searchType){
		var url=window.location.href;
		var des = location.href + "/list?page="+page+"&keyword="+encodeURI(keyword, "UTF-8")+"&searchType="+searchType;
		$.getJSON(des, function(data){
			var str="";
			var pageUrl = "";
			console.log(data.list.length);
			$(data.list).each(
				function(){
					pageUri = url+"/readPage?page="+page+"&bno="+this.bno+"&keyword="+keyword+"&searchType="+searchType;
					
					str+="<tr><td>"+
					this.bno+"</td><td>"+
					"<a href='"+pageUri+"'>"+
					this.title+"</a></td><td>"+
					this.writer+"</td><td>"+
					prettifyDate(this.regdate)+"</td><td>"+
					this.viewcnt+"</td></tr>";
				});
			str+="<tr><td></td><td></td><td></td><td colspan='2'><a href='"+url+"/newPage'><button id='newPageBtn' class='btn btn-primary btn-sm' type='button' >새 글</button></a></td></tr>";
			
			$("#boardList").html(str);
			
			
			printPaging(data.pageMaker);
			
		});
	}
	
	
	function printPaging(pageMaker){
		var str ="";
		
		if(pageMaker.prev){
			str +="<li><a href='"+(pageMaker.startPage-1)+"' data-keyword='"+pageMaker.cri.keyword+"' data-searchType='"+pageMaker.cri.searchType+"'> << </a></li>";
		}
		for(var i=pageMaker.startPage, len=pageMaker.endPage; i<=len; i++){
			var strClass=pageMaker.cri.page == i?'class=active':'';
			str += "<li "+strClass+"><a href='"+i+"' data-keyword='"+pageMaker.cri.keyword+"' data-searchType='"+pageMaker.cri.searchType+"'>"+i+"</a></li>";
		}
		if(pageMaker.next){
			str +="<li><a href='"+(pageMaker.endPage+1)+"' data-keyword='"+pageMaker.cri.keyword+"' data-searchType='"+pageMaker.cri.searchType+"'> >> </a></li>";
		}
		$(".pagination").html(str);
	}
	
	$(".boardPage").on("click", "li a", function(event){
		event.preventDefault();
		var url = window.location.href;
		var page = $(this).attr("href");
		var keyword = $(this).attr("data-keyword");
		var searchType=$(this).attr("data-searchType");
		console.log(email);
		console.log(page);
		boardLoad(page, keyword, searchType);
	});

	$("#searchBtn").on("click", function(){
		var keyword = $("#keywordInput").val();
		var searchType = $("#searchTypeInput").val();
		console.log("keyword = " + keyword + " searchType = " + searchType);
		
		boardLoad(1, keyword, searchType);
	});
	
	
	
//end for board.jsp

//start for readPage.jsp
	
	var listPage = function(page){
		
		var uri = window.location.href;
		var index = uri.lastIndexOf('/');
		var destination = uri.substring(0,48);
		console.log(uri);
		console.log(index);
		window.location.href=destination;
		
		console.log("여기는 동작 안하나?");
	}
	
	
	
	
//end for readPage.jsp