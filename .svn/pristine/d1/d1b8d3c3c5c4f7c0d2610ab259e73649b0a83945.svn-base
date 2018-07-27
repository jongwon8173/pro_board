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

<title>Jsp "/student/studentDetail.jsp 07.17"</title>

<script src="/js/jquery-1.12.4.js"></script>
<link href="/bootstrap-3.3.2-dist/css/bootstrap.css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<script src="/bootstrap-3.3.2-dist/js/bootstrap.js"></script>
<!-- Custom styles for this template -->
<link href="/css/dashboard.css" rel="stylesheet">
<link href="/css/blog.css" rel="stylesheet">

<!--  다음 도로명주소 api 가져와 사용하기   -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
$(function(){
	//주소 찾기 버튼 클릭시 이벤트 
	$("#findAddr").click(function(){
		 new daum.Postcode({
		        oncomplete: function(data) {
		            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
		            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
		            //console.log(data.address); 값가져오는거 콘솔에 찍어보기 
		            // 주소변경 
		            $("#addr1Label").text(data.address);
		            $("#addr1Input").val(data.address);
		            
		            $("#zipcdLabel").text(data.zonecode);  
		            $("#zipcdInput").val(data.zonecode);  
		            
		            // 상세주소(input)를 공백으로 초기화
		            $("#addr2").val("");
		        }
		    }).open();
	});
	
	// 학생수정 버튼 클릭시 이벤트 
	$("#updateBtn").on("click", function(){
		//학생이름, 상세주소
		if($("#name").val().length < 2){
			alert("학생이름을 입력해주세요");
			$("#name").focus();
			return false;
		};
		
		if($("#addr2").val().length < 5){
			alert("상세주소를 입력해주세요");
			$("#addr2").focus();
			return false;
		};
		
		// 여기까지 진행되면 validation을 통과한것 --> submit
		/* 	console.log( $("#frm").serialize() );  */
		$("#frm").submit();
	});
	
});
   
</script>

</head>

<body>
	<!-- 학생 수정 버튼 클릭시 StudentUpdateServlet으로 요청이 넘어가고 해당학생정보를 가지고  넘어오는 화면으로 라벨을 input 형식으로 변경하여 입력받고 수정버튼 클릭하면  -->
	<!-- top.jsp 부분 잘라내어 따로 뺌  -->
	<%@include file="/common/top.jsp"%>


	<div class="container-fluid">
		<div class="row">

			<!-- left.jsp 부분 잘라내어 따로 뺌  -->
			<%@include file="/common/left.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<form id="frm" action="/studentUpdate" method="post" 
				 class="form-horizontal" role="form"
				 enctype="multipart/form-data">

					<div class="form-group">
						<label for="id" class="col-sm-2 control-label">프로필</label>
						<div class="col-sm-6">
							<img src="/pic?id=${studentVo.id }"> 	<%-- class="control-label">${studentVo.id }</label> --%>
							<input type="file" name="pic" id="pic" value="${studentVo.pic} }">
							
						</div>
					</div>

					<div class="form-group">
						<label for="id" class="col-sm-2 control-label">학생 아이디</label>
						<div class="col-sm-6">
							<label class="control-label">${studentVo.id}</label> 
							<input type="hidden" class="form-control" id="id" name="id" value="${studentVo.id }" placeholder="학생 아이디">
							<%--라벨을 인풋으로 변경  	<label class="control-label">${studentVo.id }</label> --%>
						</div>
					</div>

					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">학생 이름</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="name" name="name"
								value="${studentVo.name }" placeholder="학생 이름">
						</div>
					</div>

					<div class="form-group">
						<label for="id" class="col-sm-2 control-label">주소1</label>
						<div class="col-sm-6">
							<label id="addr1Label" class="control-label">${studentVo.addr1 }</label>
							<input id="addr1Input" name="addr1" type="hidden"  value="${studentVo.addr1 }" class="form-control" >
							<button id="findAddr" type="button" >주소찾기</button>
						</div>
					</div>


					<div class="form-group">
						<label for="id" class="col-sm-2 control-label">주소2</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="addr2" name="addr2"
								value="${studentVo.addr2 }" placeholder="상세주소">
						</div>
					</div>

					<div class="form-group">
						<label for="id" class="col-sm-2 control-label">우편번호</label>
						<div class="col-sm-6">
							<label id="zipcdLabel" class="control-label">${studentVo.zipcd }</label>
							<input id="zipcdInput" name="zipcd" type="hidden"  value="${studentVo.zipcd }" class="form-control" >
						</div>
					</div>

					<div class="form-group">
						<label for="call_cnt" class="col-sm-2 control-label">호출횟수</label>
						<div class="col-sm-6">
							<label class="control-label">${studentVo.call_cnt }</label>
						</div>
					</div>

					<div class="form-group">
						<label for="id" class="col-sm-2 control-label">등록일</label>
						<div class="col-sm-6">
							<label class="control-label"><fmt:formatDate value="${studentVo.reg_dt }" pattern="yyyy-MM-dd" /></label>
						</div>
					</div>


					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button id="updateBtn" type="button" class="btn btn-default">수정</button>
						</div>
					</div>

				</form>
			</div>
		</div>
	</div>
</body>
</html>
