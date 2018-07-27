<%@page import="kr.or.ddit.jspboard.model.JspStudentVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>  <!-- JSTL 사용하려면 추가   -->
<!-- JSTL 포멧라이브러리 사용하려면 추가 07.13  -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


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

<title>JspStudentList</title>

<script src="/js/jquery-1.12.4.js"></script>
<link href="/bootstrap-3.3.2-dist/css/bootstrap.css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<script src="/bootstrap-3.3.2-dist/js/bootstrap.js"></script>
<!-- Custom styles for this template -->
<link href="/css/dashboard.css" rel="stylesheet">
<link href="/css/blog.css" rel="stylesheet">

<script><!--  -->
	$(function(){
		$("table tbody tr").on("click", function(){
			// tr태그의 data-id 속성 값을 읽어서 input태그의 id값으로 설정 
			// form 태그를 submit
// 			console.log("table tbody tr clicked : " + $(this).data("id") ); /* 클릭했을 떄 학생의 아이디를 얻어오기 작업   */
			$("#std_id").val($(this).data("std_id"));
			$("#frm").submit();   			 /*<!--StudentDetailServlet 으로 이동 <form id="frm" action="/studentDetail" -->  */
		});
	});

</script>

<link href="/css/common.css" rel="stylesheet">
</head>

<body>
<!-- url : localhost:8180/main.jsp 으로 시작해야함  -->

	<!-- top.jsp 부분 잘라내어 따로 뺌  -->
	<%@include file="/common/top.jsp" %>
	
	<!-- tbody 클릭햇을때 얻어온 id를 set해서 StudentDetailServlet 으로 이동 -->
	<form id="frm" action="/studentDetail" method="get">
		<input type="hidden" name="std_id" id="std_id">
	</form>
	
	
	<div class="container-fluid">
		<div class="row">
		
		<!-- left.jsp 부분 잘라내어 따로 뺌  -->
		<%@include file="/common/left.jsp" %>
		
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">학생</h2>
						<div class="table-responsive">
							<table class="table table-striped">
								<thead>
									<tr> 
										<th>학생 ID</th>
										<th>학생 이름</th>
										<th>지명 횟수</th>
										<th>등록일자(yyyy-mm-dd)</th>
									</tr>
								</thead>	
							
						
						
								
								<tbody>
								<!-- EL방식  -->                                                                   				
									<c:forEach items="${studentList}" var="vo">      
										<!-- tr 태그 클릭시 상세페이지로 이동   -->                                    				
										<tr data-id="${vo.std_id }" >  <!--값을 가져오는방법 data-name="${vo.name }"-->                                                                          				
											<td>${vo.std_id }</td>                                                         				
											<td>${vo.name}</td>                                                        				
											<td>${vo.call_cnt}</td>                                                    				
											<td>${vo.reg_dt} </td>   	<%--  <fmt:formatDate value="${vo.reg_dt}" pattern="yyyy-MM-dd"/> 	--%>	
										</tr>                                                                          				
									</c:forEach>                                                                       				
								</tbody>  
								                                                                             				
							</table>                                                                                   				
						</div>                                                                                         				

						<a class="btn btn-default pull-right">사용자 등록</a>

						<div class="text-center">
							<ul class="pagination">
									<%=request.getAttribute("pageNavi") %>
<!-- 								<li><a href="#">1</a></li> -->
<!-- 								<li><a href="#">2</a></li> -->
<!-- 								<li><a href="#">3</a></li> -->
<!-- 								<li><a href="#">4</a></li> -->
<!-- 								<li><a href="#">5</a></li> -->
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>