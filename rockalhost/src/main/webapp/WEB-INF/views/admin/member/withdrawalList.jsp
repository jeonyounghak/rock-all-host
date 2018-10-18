<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rock All Host에 오신걸 환영합니다.</title>
<%@ include file="../../include/header.jsp" %>
<style type="text/css">
Restore_a{
color: green;
}

#search_div{
margin: 0px auto;
text-align: center;
} 


</style>
</head>
<body>
<%@ include file="../admin_nav.jsp"%>
<div class="container" style="width: 1300px">
<h2>탈퇴회원 리스트 <span style="font-size: 17px;"> &lt;총${withdrawalCount}명&gt;</span></h2>
<table class="table table-hover table-bordered">
 <tr>
  <td>등급</td>
  <td>아이디</td>
  <td>닉네임</td>
  <td>이름</td> 
  <td>가입밴드</td>
  <td>포지션</td>
  <td>경력</td>
  <td>복구</td>
 </tr>
<c:forEach var="row" items="${list}">
  <tr>
  <c:if test="${row.myGrade == 1}">
  <td>일반회원</td>
  </c:if>
    <c:if test="${row.myGrade == 2}">
  <td>밴드원</td>
  </c:if>
    <c:if test="${row.myGrade == 3}">
  <td>밴드장</td>
  </c:if>
  <td><a href="${path}/admin/withdrawalListView/${row.id}">${row.id}</a></td>
  <td>${row.nickName}</td>
  <td>${row.name}</td>
    <c:if test="${row.myBand == 99}">
  <td>미가입</td>
  </c:if>
  <c:if test="${row.myBand != 99}">
  <td>가입</td>
  </c:if>
  <c:if test="${row.positionMain == 1}">
  <td>보컬</td>
  </c:if>
  <c:if test="${row.positionMain == 2}">
  <td>드럼</td>
  </c:if>
  <c:if test="${row.positionMain == 3}">
  <td>일렉기타</td>
  </c:if>
  <c:if test="${row.positionMain == 4}">
  <td>기타</td>
  </c:if>
  <c:if test="${row.positionMain == 5}">
  <td>베이스</td>
  </c:if>
  <c:if test="${row.positionMain == 6}">
  <td>키보드</td>
  </c:if>
  <c:if test="${row.positionMain == 99}">
  <td>없음</td>
  </c:if>
  <td>${row.career}</td>
  <td><a id="Restore_a" href="${path}/admin/onclickRestore/${row.id}" onclick="return confirm('${row.id} 아이디를 복구하시겠습니까?')">아이디 복구</a></td>
 </tr>
</c:forEach>
</table>
<!-- 페이지 -->
<table style="width: 100%">
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

<div id="search_div">
<form name="search_form" method="post" action="${path}/admin/withdrawalSearch.do">
   <select name="search_option" class="btn" >
      <option value="id">아이디</option>
      <option value="nickName">닉네임</option>
      <option value="name">이름</option>
      <option value="searchAll">닉네임+이름</option>
   </select>
   <input  name="keyword" id="keyword" class="btn" >
   <button class="btn"  id="btnSearch">검색</button>
</form>
</div>
</div>


<%@ include file="../../main/footerSimple.jsp" %>
</body>
</html>