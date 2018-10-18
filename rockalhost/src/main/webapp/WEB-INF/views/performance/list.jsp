<%@ include file="../include/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Rock All Host에 오신걸 환영합니다.</title>
	
<script>
$(function() {
	$("#btnWrite").click(function() {
		location.href="${path}/performance/write.do";
	});
	
	$("#btnList").click(function(){
		location.href="${path}/performance/list.do";
	});
});
	
function list(curPage) {
	location.href="${path}/performance/list.do?curPage="+curPage
		+"&search_option=${search_map.search_option}&keyword=${search_map.keyword}";
}
</script>
<style type="text/css">
#performance_title{
background-color: black;
height: 145px;
color: white;
text-shadow: 1px 2px 1px gray;
text-align: center;
margin-top: 23px;
}
#performance_search select, input {
height: 40px;
}
</style>
</head>

<body>
<%@ include file="../main/nav.jsp" %>
	<br>
	<div id="performance_title" ><br>
		<h1>공연 안내</h1>
		<h6>다양한 공연들이 준비되어 있습니다.  지금 바로 신청하세요.</h6>
	</div>
     	
<div class="container">

<ul>
	<li>
		<div class="row">
		
		<c:if test="${list == '[]'}">
			<table style="width: 930px">
				<tr align="center">
					<td>
						<br><br><br><br>
						<div>공연 내역이 없습니다.</div>
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
  			<div class="col-sm-6 col-md-6" class="wrapper-perform">
    			<div class="thumbnail">
    				<a href="${path}/performance/view/${dto.pf_idx}">
						<img src="${path}/images/${dto.pf_img}">
					</a>
      				<div class="caption">
        				<div class="title">
							<a href="${path}/performance/view/${dto.pf_idx}">
								[ ${dto.gn_name} ]&nbsp;&nbsp;${dto.pf_title}
							</a>
						</div>
						<p>
						<p>밴드이름 : ${dto.b_name}</p>
						<p>글쓴이 : ${dto.writer}</p>
						<p>지역 : ${dto.ar_name}</p>
						<p>장소 : ${dto.pf_location}</p>
						<p>일시 : <fmt:formatDate value="${dto.pf_date}" pattern="YYYY년 MM월 dd일"/> ${dto.pf_time}</p>
        				<p>공연시간 : ${dto.pf_runningTime}</p>
	        			<c:if test="${dto.remainder == 0}">
	        				<p><span style="color: red;">남은 초대석이 없습니다.</span></p>
	        			</c:if>
	        			<c:if test="${dto.remainder > 0}">
	        				<p>초대석 : ${dto.remainder} / ${dto.pf_seats}</p>
	        			</c:if>
        				<hr>
        				<p>조회수 : ${dto.readcount}</p>  
        				<p>평점 : <fmt:formatNumber value="${dto.score}" pattern="##.#점"></fmt:formatNumber></p>         				
        				<p>
							<a href="${path}/performance/view/${dto.pf_idx}" class="btn btn-primary" role="button">자세히보기</a>
        				</p>
      				</div>
    			</div>
  			</div>
  			</c:when>
			<c:otherwise>
			</c:otherwise>
		</c:choose>
		</c:forEach>
		</c:if>
		
		</div>
	</li>
</ul>

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
			<form name="search_form" method="post" action="${path}/performance/list.do">
				<select class="btn btn-default" name="search_option">
					<option value="searchAll" <c:if test="${search_map.search_option == 'searchAll' }">selected</c:if> >전체검색</option>
					<option value="pf_title" <c:if test="${search_map.search_option == 'pf_title' }">selected</c:if> >공연타이틀</option>
					<option value="content" <c:if test="${search_map.search_option == 'content' }">selected</c:if> >내용</option>
					<option value="pf_location" <c:if test="${search_map.search_option == 'pf_location' }">selected</c:if> >장소</option>
				</select>
				<input class="btn btn-default" name="keyword" value="${search_map.keyword}">
				<button class="btn btn-default" id="btnSearch">검색</button>
			</form>
		</td>
	</tr>
</table>

</div>

<%@ include file="../main/footer.jsp" %>
</body>
</html>