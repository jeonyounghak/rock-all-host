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
			location.href="${path}/admin/performance/list.do";
		});
	});
	
	function list(curPage) {
		location.href="${path}/admin/performance/list.do?curPage="+curPage;
	}
	
</script>

</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50">
	<%@ include file="../../admin/admin_nav.jsp" %>
	
<div class="container" style="width: 1300px">
<h2>공연 열람</h2>
<table class="table table-hover table-bordered">
	<tr>
		<th>일시</th>
		<th>공연포스터</th>
		<th>장르</th>
		<th>공연타이틀</th>
		<th>밴드이름</th>
		<th>지역</th>
		<th>장소</th>
		<th>공연시간</th>
		<th></th>
	</tr>
	
		<c:if test="${list == '[]'}">
			<table  style="width: 100%">
				<tr align="center">
					<td>
						<br><br><br><br>
						<div>검색 내역이 없습니다.</div>
						<br><br><br><br>
						<input class="btn btn-default" type="button" id="btnList" value="목록">
						<br><br><br><br>
					</td>
				</tr>
			</table>
		</c:if>
		
		<c:if test="${list != null}">
		<c:forEach var="dto" items="${list}">
		<c:choose>
 			<c:when test="${dto.show == 'y'}">
 			
 			<tr>
	  			<td><fmt:formatDate value="${dto.pf_date}" pattern="YY-MM-dd"/> ${dto.pf_time}</td>
	  			<td>
	  				<a href="${path}/admin/performance/view/${dto.pf_idx}">
						<img style="height: 50px; width: 50px;" src="${path}/images/${dto.pf_img}">
					</a>
	  			</td>
	  			<td>${dto.gn_name}</td>
	  			<td>
	  				<a href="${path}/admin/performance/view/${dto.pf_idx}">
						${dto.pf_title}
					</a>
	  			</td>
				
				<td>${dto.b_name}</td>
				<td>${dto.ar_name}</td>
				<td>${dto.pf_location}</td>
				<td>${dto.pf_runningTime}</td>
				<td>
					<a onclick="return confirm('공연을 삭제하시겠습니까?')" id="btnDelete" class="btn btn-default"
						href="${path}/admin/performance/delete.do?pf_idx=${dto.pf_idx}">삭제</a>
				</td>
  			</tr>
  			</c:when>
			<c:otherwise></c:otherwise>
		</c:choose>
		</c:forEach>
		</c:if>
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
      		<c:forEach var="num" begin="${page.blockStart}" end="${page.blockEnd}">
        		<c:choose>
        			<c:when test="${num == page.curPage}">
            			<li><span style="color:red">${num}</span></li>
					</c:when>
          			<c:otherwise>
           				<li><a href="#" onclick="list('${num}')">${num}</a></li>
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

<table style="width: 930px">
	<tr align="center">
		<td>
			<form name="search_form" method="post" action="${path}/admin/performance/list.do">
				<select class="btn btn-default" name="search_option">
					<option value="searchAll" <c:if test="${search_option == 'searchAll' }">selected</c:if> >전체검색</option>
					<option value="pf_title" <c:if test="${search_option == 'pf_title' }">selected</c:if> >공연타이틀</option>
					<option value="content" <c:if test="${search_option == 'content' }">selected</c:if> >내용</option>
					<option value="pf_location" <c:if test="${search_option == 'pf_location' }">selected</c:if> >장소</option>
				</select>
				<input class="btn btn-default" name="keyword" value="${keyword}">
				<button class="btn btn-default" id="btnSearch">검색</button>
			</form>
		</td>
	</tr>
</table>

</div>		
</body>
</html>