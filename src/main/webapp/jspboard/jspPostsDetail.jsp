<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<title>JspPostsDetail.jsp </title>

<script src="/js/jquery-1.12.4.js"></script>
<link href="/bootstrap-3.3.2-dist/css/bootstrap.css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<script src="/bootstrap-3.3.2-dist/js/bootstrap.js"></script>
<!-- Custom styles for this template -->
<link href="/css/dashboard.css" rel="stylesheet">
<link href="/css/blog.css" rel="stylesheet">

<script type="text/javascript">
$(document).ready(function(){
	
	// 수정화면 이동
	$("#btnPostsUpdate").on("click", function() {
		$("#frm").prop("action", "/jspPostsUpdate");
		$("#frm").prop("method", "GET");
		$("#frm").submit();
	});
	
	// 답글 작성화면 이동
	$("#btnPostsComment").on("click", function() {
		$("#frm").prop("action", "/jspPostsInsert");
		$("#frm").prop("method", "GET");
		$("#frm").submit();
	});
	
	// 게시글 삭제
	$("#btnPostsDelete").on("click", function() {
		$("#frm").prop("action", "/jspPostsDelete");
		$("#frm").prop("method", "GET");
		$("#frm").submit();
	});
	
	// 댓글 저장 
	$("#btnComment").on("click", function() {
		$("#frm").prop("action", "/jspComment");
		$("#frm").prop("method", "POST");
		$("#frm").submit();
	});
	
});

// 파일다운로드
function fn_fileDownload(file_path, file_upnm, file_renm) {
	$("#frm_file input[name=file_path]").val(file_path);
	$("#frm_file input[name=file_upnm]").val(file_upnm);
	$("#frm_file input[name=file_renm]").val(file_renm);
	
	$("#frm_file").prop("action", "/jspboard/fileDownload.jsp");
	$("#frm_file").submit();
}
</script>
</head>

<body>
	<!-- 게시글 상세조회 페이지화면 / 새글쓰기 등록 후 & 게시글tr리스트 클릭시(jspPostsList.jsp -> /JspPostsDetailServlet -> JspPostsDetail.jsp)뜨는 화면 
		 해당화면에서 
		 수정 버튼 클릭시 수정 화면으로 이동 /
		 삭제 버튼 클릭시 삭제후 리스트 페이지로 이동 jspPostsList.jsp
		 답글 클릭시 신규 작성 페이지로 이동 -->
		 
	<!-- top.jsp 부분 잘라내어 따로 뺌  -->
	<%@include file="/common/top.jsp"%>
	
	<!-- 첨부파일 Form -->
	<form id="frm_file" action="/jspFileServlet" method="POST">
		<input type="hidden" name="flag" />
		<input type="hidden" name="file_no" />
		<input type="hidden" name="file_path" />
		<input type="hidden" name="file_upnm" />
		<input type="hidden" name="file_renm" />
		<input type="hidden" name="posts_no" value="${jspPostsVo.posts_no}" />
		<input type="hidden" name="board_no" value="${jspPostsVo.board_no}" />
	</form>

	<div class="container-fluid">
		<div class="row">

			<!-- left.jsp 부분 잘라내어 따로 뺌  -->
			<%@include file="/common/left.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<form id="frm" class="form-horizontal" role="form" action="#" method="post"> 
					
					<input type="hidden" name="board_no" id="board_no" value="${jspPostsVo.board_no}">
					<input type="hidden" name="posts_no" id="posts_no" value="${jspPostsVo.posts_no}">
					<input type="hidden" name="posts_con" id="posts_con" value="${jspPostsVo.posts_con}">
					<input type="hidden" name="posts_wri" id="posts_wri" value="${jspPostsVo.posts_wri}">

					<div class="form-group">
						<label for="id" class="col-sm-2 control-label">제목</label>
						<div class="col-sm-10">
							<label class="control-label">${jspPostsVo.posts_tit}</label>
						</div>
					</div>

					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">글내용</label>
						<div class="col-sm-10">
							<label class="control-label">${jspPostsVo.posts_con}</label>
						</div>
					</div>

					<!-- 첨부파일 리스트나오는부분 -->
					<div class="form-group">
						<label for="id" class="col-sm-2 control-label">첨부파일</label>
						<div class="col-sm-10">
							<c:forEach items="${jspPostsVo.fileList}" var="file">
								<a href="javascript:fn_fileDownload('${file.file_path}', '${file.file_upnm}', '${file.file_renm}');">
									<label class="control-label">${file.file_renm}</label>
								</a><br/>
							</c:forEach>
						</div>
					</div>

					<!-- 버튼::::: 수정/삭제/답글  -->
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10" style="float: right;">
							<c:if test="${sessionScope.jspStudentVo.std_id eq jspPostsVo.posts_wri}">
								<button id="btnPostsUpdate" class="btn btn-default">수정</button>
								<button id="btnPostsDelete" class="btn btn-default">삭제</button>
							</c:if>
							<button id="btnPostsComment" class="btn btn-default">답글</button>
						</div>
					</div>
					
					<!-- 댓글 뿌려주기  -->
					<div class="form-group">
						<label for="id" class="col-sm-2 control-label">댓글</label>
						<div class="col-sm-6">
							<!-- 댓글 작성하는 부분   -->
							<input type="text" class="form-control" id="com_con" name="com_con" placeholder="댓글내용">
							<c:forEach items="${jspPostsVo.commentList}" var="comment">
								<label class="control-label">${comment.com_con} [${comment.com_wri} / ${comment.com_dt}]</label>
								<br />
							</c:forEach>
						</div>
						<button type="submit" class="btn btn-default" id="btnComment">댓글저장</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
