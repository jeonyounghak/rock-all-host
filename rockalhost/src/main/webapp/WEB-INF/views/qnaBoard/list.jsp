<%@ include file="../include/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rock All Host에 오신걸 환영합니다.</title>

<script>
$(function() {
	$("#btnWrite").click(function() {
		document.form2.action="${path}/qna/write.do";
		document.form2.submit();
	});
	
	$("#btnList").click(function(){
		location.href = "${path}/performance/view/${pf_idx}";
	});
	
});


function list(curPage) {
	location.href="${path}/qna/list.do?curPage="+curPage+"&pf_idx=${pf_idx}";
}
</script>

</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50">
<%@ include file="../main/nav.jsp" %>
  <div id="title_div_back">
     <div id="div_title" >
     <br>
     <h1>Q & A List</h1>
     </div>
  </div>
  
<div class="container">
	<table border="1" style="margin-top: 30px;" class="table table-hover">
		<tr>
			<th>이름</th>
			<th>제목</th>
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
			<td>${dto.writer}</td>
			<td>
				<c:forEach var="i" begin="1" end="${dto.re_level }">
					&nbsp;&nbsp;&nbsp;&nbsp;
				</c:forEach>
				<a href="${path}/qna/view.do?num=${dto.num}&pf_idx=${pf_idx}&curPage=${page.curPage}">${dto.subject}</a>
			</td>
			<td>
				<fmt:formatDate value="${dto.reg_date}" pattern="YYYY-MM-dd"/>
			</td>
			<td>${dto.readcount}</td>
		</tr>
		
		</c:when>
			<c:otherwise>
				<td colspan="4" align="center">삭제된 게시물입니다.</td>
			</c:otherwise>
		</c:choose>
		</c:forEach>
		<tr align="center">
			<td colspan="6">
			<form method="post" name="form2">
				<input type="hidden" name="num" value="${dto.num}">
				<input type="hidden" name="pf_idx" value="${pf_idx}">
				<input class="btn btn-default pull-left" type="button" id="btnList" value="목록">
				<button id="btnWrite" class="btn btn-default pull-right">글쓰기</button>
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
</body>
</html>