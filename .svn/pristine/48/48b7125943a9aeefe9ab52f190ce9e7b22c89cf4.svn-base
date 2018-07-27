<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

<title>jspBoard.jsp</title>

<script src="${pageContext.request.contextPath}/js/jquery-1.12.4.js"></script>
<link href="${pageContext.request.contextPath}/bootstrap-3.3.2-dist/css/bootstrap.css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<script src="${pageContext.request.contextPath}/bootstrap-3.3.2-dist/js/bootstrap.js"></script>
<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/css/dashboard.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/blog.css" rel="stylesheet">

<!--  다음 도로명주소 api 가져와 사용하기   -->
<!-- <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script> -->

<script>

$(function(){
	// 생성버튼 클릭 이벤트
	$("#btnCreate").on("click", function() {
		var tr = $(this).parent().parent();
		$("#frm input[name=flag]").val("INSERT");
		$("#frm input[name=board_no]").val("-1");
		$("#frm input[name=std_id]").val($("#jspBoard input[name=std_id]").val());
		$("#frm input[name=board_nm]").val(tr.find("input[name=board_nm]").val());
		$("#frm input[name=board_yn]").val(tr.find("select[name=board_yn]").val());
		
		$("#frm").submit();
	});
	
	// 수정버튼 클릭 이벤트
	$("a[class*=update]").on("click", function() {
		var tr = $(this).parent().parent();
		$("#frm input[name=flag]").val("UPDATE");
		$("#frm input[name=board_no]").val(tr.find("input[name=board_no]").val());
		$("#frm input[name=std_id]").val($("#jspBoard input[name=std_id]").val());
		$("#frm input[name=board_nm]").val(tr.find("input[name=board_nm]").val());
		$("#frm input[name=board_yn]").val(tr.find("select[name=board_yn]").val());
		
		$("#frm").submit();
	});
	
});

</script>

</head>

<body>
	<!-- top.jsp 부분 잘라내어 따로 뺌  -->
	<%@include file="/common/top.jsp"%>
	
	<!-- 게시판 추가, 수정 -->
	<form id="frm" action="jspBoardSave" method="post">
		<input type="hidden" name="flag" />
		<input type="hidden" name="board_no" />
		<input type="hidden" name="std_id" />
		<input type="hidden" name="board_nm" />
		<input type="hidden" name="board_yn" />
	</form>	
	
	<div class="container-fluid">
		<div class="row">

			<!-- left.jsp 부분 잘라내어 따로 뺌  -->
			<%@include file="/common/left.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<form id="jspBoard" name="jspBoard" action="/jspboardInsert" method="post" class="form-horizontal" role="form">
					
					<input type="hidden" name="std_id" value="${sessionScope.jspStudentVo.std_id}" />
					
					
					<div class="row">
						<div class="col-sm-8 blog-main">
						<h2 class="sub-header">게시판 생성</h2>
							<div class="table-responsive">
								
								<table class="table table-striped">
									<tbody>
<!-- 										<tr> -->
<!-- 											<th>게시판 생성</th> -->
<!-- 										</tr> -->
										<tr> <!--  id="btnCreate">생성 a태그 클릭시 input 으로 입력받은 값을 폼에 셋팅해서 가지고  jspboardInsert servlet으로 감. -->
											<td>
												<input type="text" class="form-control" id="board_nm" name="board_nm" placeholder="게시판 이름">
											</td>
											<td>
												<select id="board_yn" name="board_yn" class="form-control">
													<option value="Y">사용</option>
													<option value="N">미사용</option>
												</select>
											</td>
											<td>
												<a class="btn btn-default" id="btnCreate">생성</a>
											</td>
										</tr>


										<tr>
											<th>생성한 게시판</th>
										</tr>
										
										<!-- JSPBOARD 리스트 JspboardInsert 에서 jspBoardList이름으로 vo에 담아 넘어온값을 테이블로 출력, 다시 board 정보를 가지고 수정버튼 클릭시 <a class update 수정-->
										<c:forEach items="${jspBoardList}" var="vo" varStatus="status">
											
											<tr> 
												<td>
													<input type="hidden" name="board_no" value="${vo.board_no}" />	<!-- 게시판번호 -->
													<input type="hidden" name="std_id" value="${vo.std_id}" />	<!-- 학생아이디 -->
													<input type="text" class="form-control" id="board_nm" name="board_nm" value="${vo.board_nm}">
												</td>
												<td>
													<select id="board_yn" name="board_yn" class="form-control">
														<option value="Y" <c:if test="${vo.board_yn eq 'Y'}">selected="selected"</c:if>>사용</option>
														<option value="N" <c:if test="${vo.board_yn eq 'N'}">selected="selected"</c:if>>미사용</option>
													</select>
												</td>
												<td>
													<a class="btn btn-default update">수정</a>
												</td>
											</tr>
										</c:forEach>
										
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
