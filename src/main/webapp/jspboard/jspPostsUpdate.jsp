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

<title>JspPostsInsert.jsp</title>

<script type="text/javascript" src="/js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="/SE2/js/HuskyEZCreator.js"></script>

<link href="/bootstrap-3.3.2-dist/css/bootstrap.css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<script src="/bootstrap-3.3.2-dist/js/bootstrap.js"></script>
<!-- Custom styles for this template -->
<link href="/css/dashboard.css" rel="stylesheet">
<link href="/css/blog.css" rel="stylesheet">

</head>

<script type="text/javascript">
// 에디터 변수
var oEditors = [];

$(document).ready(function() {
	// Editor Setting
	nhn.husky.EZCreator.createInIFrame({
		oAppRef : oEditors, // 전역변수 명과 동일해야 함.
		elPlaceHolder : "posts_con", // 에디터가 그려질 textarea ID 값과 동일 해야 함.
		sSkinURI : "/SE2/SmartEditor2Skin.html", // Editor HTML
		fCreator : "createSEditor2", // SE2BasicCreator.js 메소드명이니 변경 금지 X
		htParams : {
			// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseToolbar : true,
			// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseVerticalResizer : true,
			// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
			bUseModeChanger : true, 
		}
	});
	
	// 저장버튼 클릭이벤트
	$("#btnSave").click(function(){
		
		var posts_tit = $("#frm input[name=posts_tit]");
		if($.trim(posts_tit.val()) == '') {
			alert("제목을 입력하세요.");
			posts_tit.focus();
			return false;
		}
		
		var posts_con = $.trim(oEditors[0].getContents());
		if(posts_con === '<p>&nbsp;</p>' || posts_con === ''){ // 기본적으로 아무것도 입력하지 않아도 <p>&nbsp;</p> 값이 입력되어 있음. 
			alert("내용을 입력하세요.");
			oEditors.getById['posts_con'].exec('FOCUS');
			return false;
		}
		
		if(confirm("저장하시겠습니까?")) {
			// id가 posts_con인 textarea에 에디터에서 대입
			oEditors.getById["posts_con"].exec("UPDATE_CONTENTS_FIELD", []);
			$("#frm").submit();      /* action="/jspPostsInsert" 로 전송  jspPostsDetailServlet */
		}
	})

    // 첨부파일 추가버튼 클릭 이벤트
	$("#btnAddFile").on("click", function() {
		var fileLen = $("div#fileDiv input[name=file_upnm]").size() + $("div#fileDiv label.control-label").size();
		if(fileLen == 5) {
			alert("첨부파일은 5개이상 추가할 수 없습니다.");
			return false;
		}
		$("div#fileDiv").append($("<input type='file' name='file_upnm' />"));
	});
	
	
}); //$(document).ready(function() { _END

// 파일다운로드
function fn_fileDownload(file_path, file_upnm, file_renm) {
	$("#frm_file input[name=file_path]").val(file_path);
	$("#frm_file input[name=file_upnm]").val(file_upnm);
	$("#frm_file input[name=file_renm]").val(file_renm);
	
	$("#frm_file").prop("action", "/jspboard/fileDownload.jsp");
	$("#frm_file").submit();
}

// 파일삭제
function fn_fileDelete(file_no, file_path, file_upnm) {
	$("#frm_file input[name=flag]").val("delete");
	$("#frm_file input[name=file_no]").val(file_no);
	$("#frm_file input[name=file_path]").val(file_path);
	$("#frm_file input[name=file_upnm]").val(file_upnm);
	$("#frm_file").submit();
}
</script>

<body>
	<!--  -->
	<!-- top.jsp 부분 잘라내어 따로 뺌  -->
	<%@include file="/common/top.jsp"%>
	
	<!-- 첨부파일 Form -->
	<form id="frm_file" action="/jspFileServlet" method="post">
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
				<form  id="frm" action="/jspPostsUpdate" method="POST" enctype="multipart/form-data">
					
					<input type="hidden" name="board_no" id="board_no" value="${jspPostsVo.board_no}" />
					<input type="hidden" name="posts_no" id="posts_no" value="${jspPostsVo.posts_no}" />
	
					<div class="row" style="text-align: left;">
						<div class="col-sm-8 blog-main">
						<h2 class="sub-header">게시글 수정 등록</h2>
							<div class="table-responsive">
								
								<div class="form-group">
									<label for="posts_tit" class="col-sm-2 control-label">제 목</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="posts_tit" name="posts_tit" value="${jspPostsVo.posts_tit}">
									</div>
								</div>
								
								<div class="form-group"> 
									<label for="posts_con" class="col-sm-2 control-label">내 용</label>
									<div class="col-sm-10">
										<textarea class="form-control" id="posts_con" name="posts_con" cols="80" rows="10">${jspPostsVo.posts_con}</textarea>
									</div>
								</div>
								
								<!-- 추가한 첨부파일이 보여질 공간  -->
								<div class="form-group">  <!-- 첨부파일 테이블이용   -->
									<label for="file_upnm" class="col-sm-2 control-label">첨부파일</label>
									<div class="col-sm-8" id="fileDiv">
										<c:forEach items="${jspPostsVo.fileList}" var="file">
											<a href="javascript:fn_fileDownload('${file.file_path}', '${file.file_upnm}', '${file.file_renm}');">
												<label class="control-label">${file.file_renm}</label>
											</a>&nbps;
											<a href="javascript:fn_fileDelete('${file.file_no}', '${file.file_path}', '${file.file_upnm}');"><span>삭제</span></a>
											<br/>
										</c:forEach>
									</div>
									<a href="javascript:void(0);" id="btnAddFile"><img src="../SE2/img/plus-symbol_icon-icons.com_71384.png" alt="" style="width: 20px; height: 20px;" /></a>
								</div>
								
							</div>
							
							<a class="btn btn-default pull-right" id="btnSave">저장</a>
							
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
