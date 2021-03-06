<%@page import="kr.or.ddit.jspboard.model.JspStudentVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>  <!-- JSTL 사용하려면 추가   -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> <!-- JSTL 포멧라이브러리 사용하려면 추가 -->


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

<title>JspPostsList</title>

<script src="/js/jquery-1.12.4.js"></script>
<link href="/bootstrap-3.3.2-dist/css/bootstrap.css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<script src="/bootstrap-3.3.2-dist/js/bootstrap.js"></script>
<!-- Custom styles for this template -->
<link href="/css/dashboard.css" rel="stylesheet">
<link href="/css/blog.css" rel="stylesheet">

<script>
/* 	$(function(){
$("a.posts_tit").on("click", function() {  // 제목을 클릭햇을때 상세페이지로 이동 
	var tr = $(this).parent().parent();  
	var posts_no = tr.find("input[name=posts_no]").val();
	$("#frm input[name=posts_no]").val(posts_no);
	$("#frm").submit();
	
});
}); */

$(function(){  // tr을 클릭했을때 상세페이지로 이동
	
	$("table tbody tr").on("click", function(){
		$("#frm input[name=posts_no]").val($(this).find("input[name=posts_no]").val());
		
		$("#frm").prop("action", "/jspPostsDetail");
		
		$("#frm").prop("method", "post");
		
		$("#frm").submit();
		
	});
	
	// 게시글 생성버튼 클릭 이벤트  // 
	$("#btnNewPosts").on("click", function() {
		
		$("#frm").prop("action", "jspPostsInsert");
		$("#frm").prop("method", "get");
		$("#frm").submit();
	});
	
});
	
</script>

<link href="/css/common.css" rel="stylesheet">
</head>

<body>

	<!-- top.jsp 부분 잘라내어 따로 뺌  -->
	<%@include file="/common/top.jsp" %>
	
	<!-- jspPostsDetail.java 으로 이동 -->
	<form id="frm" name="frm" action="/jspPostsDetail" method="post">
		<input type="hidden" name="board_no" value="${jspBoardVo.board_no}" /> 
		<input type="hidden" name="std_id" 	 value="${jspBoardVo.std_id}" /> 
		<input type="hidden" name="posts_no" />
	</form>
	
	<div class="container-fluid">
		<div class="row">
		
		<!-- left.jsp 부분 잘라내어 따로 뺌  -->
		<%@include file="/common/left.jsp" %>
		
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">게시글 목록</h2>
						<div class="table-responsive">
							<table class="table table-striped">
								<colgroup>
									<col width="60px">
									<col width="*">
									<col width="120px">
									<col width="100px">
									<col width="60px">
								</colgroup>
								<thead>
									<tr> 
										<th>번호</th>
										<th>제목</th>
										<th>작성자</th>
										<th>작성일시</th>
										<th>조회수</th>
									</tr>
								</thead>	
								
								<tbody>
									<c:choose>
										<c:when test="${!empty jspPostsList}">
												<!-- tr 태그 클릭시 상세페이지로 이동   -->       
											<c:forEach items="${jspPostsList}" var="vo" varStatus="status">
												<tr>                                                                          				
													<td>
														${vo.rnum}
														<input type="hidden" name="posts_no" value="${vo.posts_no}" />		<!-- 게시글번호 -->
														<input type="hidden" name="posts_pno" value="${vo.posts_pno}" />	<!-- 상위게시글번호 -->
														<input type="hidden" name="board_no" value="${vo.board_no}" />		<!-- 게시글번호 -->
													</td>
													<td>${vo.posts_tit}</td>
													<td id="aaaaaa">${vo.posts_wri}</td>                                                    				
													<td>${vo.posts_indt}</td>      				
													<td>${vo.posts_count}</td>
												</tr>                                                                          				
											</c:forEach> 
										</c:when>
										<c:otherwise>
											<tr><td colspan="6" align="center">게시글이 없습니다.</td></tr>
										</c:otherwise>
									</c:choose>
								</tbody> 
							</table>                                                                                   				
						</div>
						
						<!-- 새글등록 -->
						<a class="btn btn-default pull-right" id="btnNewPosts">새글 등록</a>
						
						<!-- Paging -->
						<div class="text-center">
							<ul class="pagination">
								<%=request.getAttribute("pageNavi")%>
							</ul>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>