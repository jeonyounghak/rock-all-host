<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rock All Host에 오신걸 환영합니다.</title>
<%@ include file="../include/header.jsp"%>
<script>
	$(function() {
		$("#btnWrite").click(function() {
			var result= $("#result").val();
			if(result == ""){
				alert("로그인 후 글쓰기가 가능합니다.");
			}
			if(result == 2){
				alert("일반회원등급만 글쓰기가 가능합니다.");
			}
			if(result == 3){
				alert("일반회원등급만 글쓰기가 가능합니다.");
			}
			document.form2.submit();
		});
	});
	function list(page) {
		location.href = "${path}/seek/list.do?curPage=" + page;
	}
</script>
<style type="text/css">
#seek_div_title{
background-color: black;
height: 145px;
color: white;
text-shadow: 1px 2px 1px gray;
text-align: center;
margin-top: 23px;
}
#seek_search input,select {
height: 40px;
}
</style>
</head>
<body>
	<%@ include file="../main/nav.jsp"%>
	<br>
     <div id="seek_div_title" ><br>
     <h1>밴드 구직</h1>
     <h6>자유롭게 구직 글을 작성하세요.</h6>
     </div>
     <div style="text-align: left; margin: 1%;">
     <h5 style="font-weight: bold;">이 용 방 법</h5>
     <h6>1. 일반회원님은 원하시는 밴드를 찾기위한 글을 작성해주세요.<br><br>
     2. 밴드장님들은 원하시는 회원을 찾아 관심을 등록 해주세요.</h6></div>
	<form name="form2" method="post" action="${path}/seek/grade_check.do">
     	<input type="hidden" id="result" value="${sessionScope.grade}">
    	<input type="submit" value="글쓰기" id="btnWrite" class="btn">     
     </form>
	<table border="1" style="width: 100%; text-align: center;"
		class="table table-hover">
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
				<a href="${path}/seek/view/${dto.idx}">${dto.subject}</a>
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
	</div>
	
	<div id="seek_search">
	<form name="form1" method="post" action="${path}/recruit/list.do">
		<select name="search_option">
			<option value="writer"
				<c:if test="${map.search_option == 'write'}">selected</c:if>>작성자</option>
			<option value="subject"
				<c:if test="${map.search_option == 'subject'}">selected</c:if>>제목</option>
			<option value="content"
				<c:if test="${map.search_option == 'content'}">selected</c:if>>내용</option>
			<option value="all"
				<c:if test="${map.search_option == 'all'}">selected</c:if>>이름+내용+제목</option>
		</select> 
		<input name="keyword" value="${map.keyword}" style="width:200px;">
		<input type="submit" value="조회" class="btn">
	</form>
	</div>
	<%@ include file="../main/footerSimple.jsp" %>
</body>
</html>