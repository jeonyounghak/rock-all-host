<%@ include file="../../include/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rock All Host에 오신걸 환영합니다.</title>

<script>
$(function() {
	$("#btnList").click(function(){
		location.href = "${path}/admin/qbList.do";
	});
	
});

function list(curPage) {
	location.href="${path}/admin/qbList.do?curPage="+curPage
		+"&search_option=${search_map.search_option}&keyword=${search_map.keyword}";
}
</script>

</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50">
<%@ include file="../../admin/admin_nav.jsp" %>
 
<div class="container-fluid" style="margin-top: 100px;">
	<div class="row row-offcanvas row-offcanvas-right">
		<%@ include file="qnaSidevar.jsp" %>
		<h2>질문게시판 열람<span style="font-size: 17px;"> &lt;총${count}개&gt;</span></h2>
		        
		<div class="col-xs-10 col-lg-10">
		
		<table border="1" style="width: 930px;" class="table table-hover">
		<tr>
			<th>공연타이틀</th>
			<th>이름</th>
			<th>제목</th>
			<th>날짜</th>
			<th>조회수</th>
			<th></th>
		</tr>
		
		<c:if test="${list == '[]'}">
			<table  style="width: 930px">
				<tr align="center">
					<td>
						<br><br><br><br>
						<div>검색 내역이 없습니다.</div>
						<br><br><br><br>
						<br><br><br><br>
					</td>
				</tr>
			</table>
		</c:if>
		
	 	<c:forEach var="dto" items="${list}">
	 	<c:choose>
	 	<c:when test="${dto.show == 'y' }">
	 		
		<tr>
			<td>[${dto.pf_title}]</td>
			<td>
				<c:forEach var="i" begin="1" end="${dto.re_level }">
					&nbsp;&nbsp;&nbsp;&nbsp;
				</c:forEach>
				<a href="${path}/admin/qbView.do?num=${dto.num}&curPage=${page.curPage}&pf_title=${dto.pf_title}">${dto.subject}</a>
			</td>
			<td>${dto.writer}</td>
			<td>
				<fmt:formatDate value="${dto.reg_date}" pattern="YYYY-MM-dd"/>
			</td>
			<td>
				${dto.readcount}
			</td>
			<td>
				<a onclick="return confirm('게시물을 삭제하시겠습니까?')" id="btnDelete" class="btn btn-default"
					href="${path}/admin/qbHidden.do?num=${dto.num}">삭제</a>
			</td>
		</tr>
		
		</c:when>
			<c:otherwise>
				<tr>
					<td>[${dto.pf_title}]</td>
					<td colspan="5" align="center">삭제된 게시물입니다.</td>
				</tr>
			</c:otherwise>
		</c:choose>
		</c:forEach>
	</table>

<table style="width: 930px">
	<tr align="center">
		<td>
		<form name="search_form" method="post" action="${path}/admin/qbList.do">
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
	</div>
</div> 

</body>
</html>