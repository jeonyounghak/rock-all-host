<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>	    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rock All Host에 오신걸 환영합니다.</title>
<script>
$(function() {
	$("#btnWrite").click(function() {
		location.href="${path}/board/write.do";
	});
	
	$("#btnList").click(function(){
		location.href = "${path}/board/list.do";
	});
});

function list(curPage) {
	location.href="${path}/board/list.do?curPage="+curPage
			+"&search_option=${search_map.search_option}&keyword=${search_map.keyword}";
}
</script>

</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50">
<%@ include file="../main/nav.jsp" %>
  <div id="title_div_back">
     <div id="div_title" >
     <br>
     <h1>자유게시판</h1>
     </div>
  </div>
  
<div class="container">
<table border="1" class="table table-hover">
	<tr>
		<th width="600px;">제목</th>
		<th>이름</th>
		<th>날짜</th>
		<th>조회수</th>
	</tr>
	
	<c:if test="${list == '[]'}">
		<tr align="center">
			<td colspan="4">
				<br><br><br><br>
				<div>게시글이 없습니다.</div>
				<br><br><br><br>
			</td>
		</tr>	
	</c:if>
 	
 	<c:forEach var="dto" items="${list}">
 	<c:choose>
 	<c:when test="${dto.show == 'y' }">
 		
	<tr>
		<td>
			<c:forEach var="i" begin="1" end="${dto.re_level }">
				&nbsp;&nbsp;
			</c:forEach>
			
			<a href="${path}/board/view/${dto.num}">${dto.subject}</a>
			<c:if test="${dto.comment_count > 0 }">
				<span style="color: red;">(${dto.comment_count})</span>
			</c:if>
		</td>
		<td>${dto.writer}</td>
		<td>${dto.reg_date}</td>
		<td>${dto.readcount}</td>
	</tr>
	</c:when>
		<c:otherwise>
			<tr>
				<td colspan="4" align="center">삭제된 게시물입니다.</td>
			</tr>
		</c:otherwise>
	</c:choose>
	</c:forEach>
</table>

<table style="width: 930px">
	<tr align="center">
		<td>
		<form name="search_form" method="post" action="${path}/board/list.do">
			<select class="btn btn-default" name="search_option">
				<option value="searchAll" 
					<c:if test="${search_map.search_option == 'searchAll'}">selected</c:if>
							>전체검색</option>
				<option value="writer"
					<c:if test="${search_map.search_option == 'writer'}">selected</c:if>
							>이름</option>
				<option value="subject" 
					<c:if test="${search_map.search_option == 'title'}">selected</c:if>
							>제목</option>
				<option value="content" 
					<c:if test="${search_map.search_option == 'content'}">selected</c:if>
							>내용</option>
			</select>
			<input class="btn btn-default" name="keyword" value="${search_map.keyword}">
			
			<input class="btn btn-default pull-left" type="button" id="btnList" value="목록">
			<button class="btn btn-default" id="btnSearch">검색</button>
			<input id="btnWrite" class="btn btn-default pull-right" type="button" value="글쓰기">
		</form>
		</td>
	</tr>
	
</table>

<table style="width: 930px">
	<tr align="center">
		<td colspan="2">
		<ul class="pagination">
  			<c:if test="${page.curPage > 1}">
        		<li><a href="#" onclick="list('1')">처음</a></li>
     		</c:if>
     			 
     		<c:if test="${page.curBlock > 1 }">
        		<li><a href="#" onclick="list('${page.prevPage}')">이전</a></li>
     		</c:if>
      		<c:forEach var="pageNum" begin="${page.blockStart}" end="${page.blockEnd}">
        		<c:choose>
        			<c:when test="${pageNum == page.curPage}">
            			<li><span style="color:red">${pageNum}</span></li>
					</c:when>
          			<c:otherwise>
           				<li><a href="#" onclick="list('${pageNum}')">${pageNum}</a></li>
          			</c:otherwise>
        		</c:choose>
      		</c:forEach>
      		<c:if test="${page.curBlock < page.totBlock }">
       			<li><a href="#" onclick="list('${page.nextPage}')">다음</a></li>   
      		</c:if>
      		<c:if test="${page.curPage < page.totPage }">
        		<li><a href="#" onclick="list('${page.totPage}')">끝</a></li>
      		</c:if>
      	</ul>
		</td>
	</tr>
</table>

</div>

<%@ include file="../main/footer.jsp" %>
</body>
</html>