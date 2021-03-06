<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Signin 로그인</title>

    <!-- Bootstrap core CSS -->
    <link href="/bootstrap-3.3.2-dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/css/signin.css" rel="stylesheet">
	
	
	<!--  정적 인클루드-->
	<%@ include file="/common/jquery.jsp" %>
	<style type="text/css">
		#error{
			color:red;
			font-size:10pt;
		}
	</style>
	
   	<script>
   	function getCookie(name){
   		var cookies = document.cookie;
   		
   		var cookieArr = cookies.split("; ");
   		var cookieResult = "";
   		for(var i in cookieArr){
   			var cookie = cookieArr[i];
   			var cookieNameValue = cookie.split("=");
   			
   			var cookieName = cookieNameValue[0];
			var cookieValue = cookieNameValue[1];
			
			if( name == cookieName ){
				cookieResult = cookieValue;
				break;
			}
   		}
			return cookieResult;
   	}
   	// set쿠키 추가 하기 
   	function setCookie(cookieName, cookieValue, expires){
   		var dt = new Date();
   		dt.setDate(dt.getDate() + parseInt(expires));
   		document.cookie = cookieName + "=" + cookieValue + "; path=/; expires=" + dt.toGMTString();
   	}
   	
   	// 쿠키 삭제
   	function deleteCookieValue(cookieName){
   		setCookie(cookieName, "", -1);
   	}
   	
   	
   	// 문서로딩 완료 후 실행  getCookie()
   	$(function() {
   		if(getCookie("rememberMe") == "y"){
	   		//userId Input에 userId cookie값을 설정 
	   		$("#userId").val(getCookie("userId"));
	   		$("#rememberMe").attr("checked", true);
	   		$("#rememberMe").val(getCookie("rememberMe"));
	   	}
   		
   		// rememberMe 체크박스 클릭 이벤트
   		$("#rememberMe").on("click",function(){
   			
   			if($(this).is(":checked")){
   			// rememberMe cookie 설정
   				setCookie("rememberMe", "y" , 30);
   				setCookie("userId", $("#userId").val(), 30);
   			}else{
   				// 쿠키 제거
   				deleteCookieValue("rememberMe");
   			}
   		});
   	});
   	
   		
  	
   	
  
   		/* 자바코드를 스크립트로 변경하기 
   		String[] cookies = cookie.split("; ");
		String cookieResult ="";

		// cookieStr :  uerId=brown, rememberMe=y, checkYn=n
		for (String cookieStr : cookies) {
			String[] cookieNameValue = cookieStr.split("=");
			
			String cookieName = cookieNameValue[0];
			String cookieValue = cookieNameValue[1];
			
			if(name.equals(cookieName)){
				cookieResult = cookieValue;
				break;
			}
		}
		return cookieResult;*/
   		
   		
   		
   	</script>
   	
  </head>

  <body>
  
 
<%--   <c:if test="" ></c:if> --%>
<%--   <c:if test="${errMsg == null }" var=""></c:if> --%>
<!--  
	1. 사용자가 로그인 화면을 접속한다. ( localhost:8180/jb/login/login.jsp )
	2. 사용자가 아이디, 비밀번호를 입력 후 signin 버튼을 클릭
	-> signin 버튼이 속한 form태그의 action속성에 설정된 url로 요청 
	3, LoginServlet 파라미터(userId, password)를 확인 후 고정된 값을 비교 , 같을 경우에는 response객체의 writer 객체를 이용하여 
	 화면에 "접속성공" 틀릴경우에는 "접속 실패" 메세지 출력
	 * action="/loginServlet" 페이지로 전송,  name="uerId" 값을 전송 getparameter("")가 name값을 바라보고 가져온다..
 -->
 
    <div class="container">

      <form class="form-signin" action="/loginServlet" method="post">  
        <h2 class="form-signin-heading">Please sign in</h2>
        
        <label for="userId" class="sr-only">uerId</label>
        <input type="text" id="userId" name="userId" class="form-control" placeholder="Id" required autofocus 
        		 value="${param.userId }">
        
        <label for="password" class="sr-only">Password</label>
        <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
           <div id="error">${errMsg}</div>
      
        <div class="checkbox">
           <label>
            <input type="checkbox" id="rememberMe" name="rememberMe" value="remember-me"> Remember me
          </label> 
        </div>
        
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        
  
        
      </form>

    </div> <!-- /container -->

  </body>
  	

  
</html>
