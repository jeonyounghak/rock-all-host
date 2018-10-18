<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rock All Host에 오신걸 환영합니다.</title>
</head>
<body>
<%@ include file="../main/nav.jsp" %>
<h1>밴드원 모집 페이지</h1>
<table border="1" style="width: 100%" class="table table-hover">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>이름</th>
		<th>날짜</th>
		<th>조회수</th>
	</tr>
	<c:forEach var="row" items="${map.list}">
	<tr>
		<td>${row.num}</td>
		<td>${row.subject}</td>
		<td>${row.writer}</td>
		<td><fmt:formatDate value="${row.reg_date}"
			pattern="yyyy-MM-dd HH:mm:ss"/> </td>
		<td>${row.readcount}</td>
	</tr>
</c:forEach>	
</table>
</body>
</html>