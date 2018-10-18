<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rock All Host에 오신걸 환영합니다.</title>
<%@ include file="../../include/header.jsp"%>
<script>
	function list(page) {
		location.href = "${path}/seek/list.do?curPage=" + page;
	}
</script>
</head>
<body>
	<%@ include file="../admin_nav.jsp" %>
 <div class="container" style="width: 1300px">
	<h2>밴드 찾기 페이지</h2>
	<table  class="table table-hover table-bordered">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>날짜</th>
			<th>조회수</th>
			<th>추천</th>
		</tr>
		<c:forEach var="dto" items="${map.list}">
			<c:choose>
				<c:when test="${dto.show == 'y'}">
			<tr>
				<td>${dto.idx}</td>
				<td>
				<a href="${path}/admin/seek_view/${dto.idx}">${dto.subject}</a>
					<c:if test="${dto.cnt > 0}">
						<span style="color:red;">( ${dto.cnt} )</span>
					</c:if>
				</td>
				<td>${dto.writer}</td>
				<td><fmt:formatDate value="${dto.reg_date}"
						pattern="yyyy-MM-dd HH:mm:ss" /></td>
				<td>${dto.readcount}</td>
				<td>${dto.recommend}</td>
			</tr>
				</c:when>
			<c:otherwise>
   				<tr>
     				<td>${dto.idx}</td>
     				<td colspan="5" align="center">
     					삭제된 게시물입니다.
     				</td>
   				</tr>
 			</c:otherwise>	
			</c:choose>
		</c:forEach>
	</table>
	<div style="text-align: center;">
		<ul class="pagination">
			<li><c:if test="${map.pager.curBlock > 1}">
					<a href="#" onclick="list('1')">[처음]</a>
				</c:if> <c:if test="${map.pager.curBlock > 1}">
					<a href="#" onclick="list('${map.pager.prevPage}')"> [이전]</a>
				</c:if> <c:forEach var="idx" begin="${map.pager.blockBegin}"
					end="${map.pager.blockEnd}">
					<c:choose>
						<c:when test="${idx == map.pager.curPage}">
							<span style="color: red;">${idx}</span>
						</c:when>
						<c:otherwise>
							<a href="#" onclick="list('${idx}')">${idx}</a>
						</c:otherwise>
					</c:choose>
				</c:forEach> <c:if test="${map.pager.curBlock < map.pager.totBlock}">
					<a href="#" onclick="list('${map.pager.nextPage}')">[다음]</a>
				</c:if> <c:if test="${map.pager.curPage < map.pager.totPage}">
					<a href="#" onclick="list('${map.pager.totPage}')">[끝]</a>
				</c:if></li>
		</ul>
	
	<form name="form1" method="post" action="${path}/recruit/list.do">
		<select name="search_option" class="btn">
			<option value="writer"
				<c:if test="${map.search_option == 'write'}">selected</c:if>>작성자</option>
			<option value="subject"
				<c:if test="${map.search_option == 'subject'}">selected</c:if>>제목</option>
			<option value="content"
				<c:if test="${map.search_option == 'content'}">selected</c:if>>내용</option>
			<option value="all"
				<c:if test="${map.search_option == 'all'}">selected</c:if>>이름+내용+제목</option>
		</select> 
		<input name="keyword" value="${map.keyword}" class="btn">
		<input type="submit" value="조회" class="btn">
	</form>
	</div>
	</div>
</body>
</html>