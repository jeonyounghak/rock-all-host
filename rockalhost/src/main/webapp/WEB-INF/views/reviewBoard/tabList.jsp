<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script>
$(function() {
	$("#btnWrite").click(function() {
		document.write_form.action="${path}/review/write.do";
		document.write_form.submit();
	});
});

function reviewList(curPage) {
	location.href="${path}/review/list.do?curPage="+curPage+"&pf_idx=${pf_idx}";
}
</script>

<table border="1" style="margin-top: 30px;" class="table table-hover">
	<tr>
		<th>이름</th>
		<th>제목</th>
		<th>평점</th>
		<th>날짜</th>
		<th>조회수</th>
	</tr>
	
	<c:if test="${list == '[]'}">
		<tr align="center">
			<td colspan="5">
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
			<c:choose>
				<c:when test="${curBoard_num == dto.num}">
					<span style="font-weight: bold;">${dto.subject}</span>
					<c:if test="${dto.comment_count > 0 }">
						<span style="color: red;">(${dto.comment_count })</span>
					</c:if>
				</c:when>
				
				<c:otherwise>
					<a href="${path}/review/view.do?num=${dto.num}&pf_idx=${pf_idx}&curPage=${page.curPage}">
						${dto.subject}
					</a>
					<c:if test="${dto.comment_count > 0 }">
						<span style="color: red;">(${dto.comment_count })</span>
					</c:if>
				</c:otherwise>
			</c:choose>
		</td>
		<td>${dto.score}</td>
		<td>
			<fmt:formatDate value="${dto.reg_date}" pattern="YYYY-MM-dd"/>
		</td>
		<td>${dto.readcount}</td>
	</tr>
	
	</c:when>
		<c:otherwise></c:otherwise>
	</c:choose>
	</c:forEach>
	<tr align="center">
		<td colspan="6">
		<form method="post" name="write_form">
			<input type="hidden" name="num" value="${dto.num}">
			<input type="hidden" name="pf_idx" value="${pf_idx}">
			<button id="btnWrite" class="btn btn-default pull-left">글쓰기</button>
		</form>
		</td>
	</tr>
</table>

<table style="width: 930px">
	<tr align="center">
		<td colspan="2">
		<ul class="pagination">
  			<c:if test="${page.curPage > 1}">
        		<li><a href="#" onclick="reviewList('1')">처음</a></li>
     		</c:if>
     			 
     		<c:if test="${page.curBlock > 1 }">
        		<li><a href="#" onclick="reviewList('${page.prevPage}')">이전</a></li>
     		</c:if>
      		<c:forEach var="pageNum" begin="${page.blockStart}" end="${page.blockEnd}">
        		<c:choose>
        			<c:when test="${pageNum == page.curPage}">
            			<li><span style="color:red">${pageNum}</span></li>
					</c:when>
          			<c:otherwise>
           				<li><a href="#" onclick="reviewList('${pageNum}')">${pageNum}</a></li>
          			</c:otherwise>
        		</c:choose>
      		</c:forEach>
      		<c:if test="${page.curBlock < page.totBlock }">
       			<li><a href="#" onclick="reviewList('${page.nextPage}')">다음</a></li>   
      		</c:if>
      		<c:if test="${page.curPage < page.totPage }">
        		<li><a href="#" onclick="reviewList('${page.totPage}')">끝</a></li>
      		</c:if>
      	</ul>
		</td>
	</tr>
</table>
