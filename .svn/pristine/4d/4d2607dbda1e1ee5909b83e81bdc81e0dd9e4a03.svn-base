<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.board.model.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <style type="text/css">
 	th, td{
 		border: 1px solid blue;
 		
 	}
 </style>
</head>
<body>
	<!-- Url : localhost:8180/board/boardList.jsp -->
	


	<form>
	<table>
		<thead>
			<tr>
				<th>제목</th>
				<th>사용자</th>
				<th>별명</th>
				<th>등록일(yyyy-MM-dd)</th>
			</tr>
		</thead>
		<tbody>
		<%-- 	<%
			 List<BoardVo> boadList = (List<BoardVo>)session.getAttribute("boardList");
			for(int i=0; i<boadList.size(); i++){ %>  --%>
			
			<% for(BoardVo boardVo : (List<BoardVo>)request.getAttribute("boardList") ){ %>
			<tr>
				<td><%=boardVo.getTitle() %></td>
				<td><%=boardVo.getUserId() %></td>
				<td><%=boardVo.getAlias() %></td>
				<td><%=boardVo.getRegDt() %></td>
			</tr>
			<%} %>
			
			
		<%-- 	<td><%=boadList.getTitle() %></td>
				<td><%=boadList.get(i).getUserId() %></td>
				<td><%=boadList.get(i).getAlias() %></td>
				<td><%=boadList.get(i).getRegDt() %></td> --%>
			
		
		
		</tbody>
	</table>
	
	
	</form>
	
</body>
</html>