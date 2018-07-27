<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <!-- main.jsp 에서 top, left가 계속 고정되기 때문에 고정되는 부분 잘라내어 따로 뺌  -->
 
<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
		<li class="active"><a href="${pageContext.request.contextPath}/main.jsp">Main <span class="sr-only">(current)</span></a></li>
		
		<li class="active"><a href="${pageContext.request.contextPath}/jspBoard">게시판 생성</a></li> <!--JspBoardServlet.java 로이동  -->
		
		<il class="nav nav-sidebar"><h4>__게시판 목록____</h4></il>
		
		<c:forEach items="${sessionScope.menuBoardList}" var="vo" varStatus="status"> 
			<c:if test="${vo.board_yn eq 'Y'}">
				<li><a href="/jspPosts?board_no=${vo.board_no}&std_id=${vo.std_id }&page=1&pageSize=10" > ${vo.board_nm}</a></li> <!--jspPostsServlet.java 로이동  -->
			</c:if>
		</c:forEach>
		
		
		<li><a href="/studentList?page=1&pageSize=10">학생목록 게시판</a></li>

		<!-- main.jsp에서 학생을 클릭했을 때 a href="/studentList" 어노테이션을 준 kr.or.ddit.student.web 아래 StudectServlet.java 로 이동한다.    -->
		
	</ul>
</div>