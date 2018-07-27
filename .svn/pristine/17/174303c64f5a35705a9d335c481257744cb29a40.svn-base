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

<title>Jsp "/student/studentDetail.jsp 07.17"</title>

<script src="/js/jquery-1.12.4.js"></script>
<link href="/bootstrap-3.3.2-dist/css/bootstrap.css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<script src="/bootstrap-3.3.2-dist/js/bootstrap.js"></script>
<!-- Custom styles for this template -->
<link href="/css/dashboard.css" rel="stylesheet">
<link href="/css/blog.css" rel="stylesheet">
</head>

<body>
	<!--  -->
	<!-- top.jsp 부분 잘라내어 따로 뺌  -->
	<%@include file="/common/top.jsp"%>
	

	<div class="container-fluid">
		<div class="row">

			<!-- left.jsp 부분 잘라내어 따로 뺌  -->
			<%@include file="/common/left.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<form  id="frm" class="form-horizontal" role="form"  action="/studentUpdate" method="get">
					<input type="hidden" name="std_id" id="std_id" value="${studentVo.std_id }">     <!-- $("#frm").serialize()  "id=2" -->
					<%--파라미터가 이름도 필요할떄추가  <input type="hidden" id="name" value="${studentVo.name }">   --%>

					<div class="form-group">
						<label for="id" class="col-sm-2 control-label">프로필</label>
						<div class="col-sm-10">
							<img src="/pic?std_id=${studentVo.std_id}"/>  <%-- class="control-label">${studentVo.id }</label> --%>
						</div>
					</div>

					<div class="form-group">
						<label for="id" class="col-sm-2 control-label">학생 아이디</label>
						<div class="col-sm-10">
							<label class="control-label">${studentVo.std_id}</label>
						</div>
					</div>

					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">학생 이름</label>
						<div class="col-sm-10">
							<label class="control-label">${studentVo.name }</label>
						</div>
					</div>

					<div class="form-group">
						<label for="id" class="col-sm-2 control-label">주소1</label>
						<div class="col-sm-10">
							<label class="control-label">${studentVo.addr1 }</label>
						</div>
					</div>


					<div class="form-group">
						<label for="id" class="col-sm-2 control-label">주소2</label>
						<div class="col-sm-10">
							<label class="control-label">${studentVo.addr2 }</label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="id" class="col-sm-2 control-label">우편번호</label>
						<div class="col-sm-10">
							<label class="control-label">${studentVo.zipcd }</label>
						</div>
					</div>
	
					<div class="form-group">
						<label for="call_cnt" class="col-sm-2 control-label">호출횟수</label>
						<div class="col-sm-10">
							<label class="control-label">${studentVo.call_cnt }</label>
						</div>
					</div>

					<div class="form-group">
						<label for="id" class="col-sm-2 control-label">등록일</label>
						<div class="col-sm-10">
							<label class="control-label"><fmt:formatDate value="${studentVo.reg_dt }" pattern="yyyy/MM/dd"/></label>
						</div>
					</div>


					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">학생 수정</button>
						</div>
					</div>

				</form>
			</div>
		</div>
	</div>
</body>
</html>
