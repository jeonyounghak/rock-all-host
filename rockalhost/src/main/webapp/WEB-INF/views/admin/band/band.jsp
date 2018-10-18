<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../include/header.jsp" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../admin_nav.jsp" %>
<div class="container" style="width: 1300px">

<h2>전체밴드리스트</h2>	

<table class="table table-hover table-bordered" >	
	<tbody>
	<tr>
      <th scope="col">글번호</th>
      <th scope="col">밴드이름</th>
      <th scope="col">장르</th>
      <th scope="col">인원수</th>
      <th scope="col">리더닉네임</th>
      <th scope="col">활동지역</th>
      <th scope="col">창설날짜</th>
    </tr>
    </tbody> 
    <c:forEach var="row" items="${list}"> 
    <tbody> 
    <tr> 
      <td>${row.b_idx}</td>
	  <td><a href="${path}/admin/adminband/${row.b_idx}">${row.b_name}</a></td>
	  <td>${row.gn_name}</td>
	  <td>${row.b_num}</td>
	  <td>${row.b_leaderNick}</td>
	  <td>${row.ar_name}</td>	  
	  <td><fmt:formatDate value="${row.found_date}"
			pattern="yyyy-MM-dd HH:mm:ss"/> </td>	
    </tr>    
    </tbody>
    </c:forEach>    
</table>

<table style="width: 100%;">
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


<div id="search_div" style="text-align: center;">
<form name="search_form" method="post" action="${path}/admin/bandSearch.do">
   <select name="search_option" class="btn">
      <option value="b_name">밴드이름</option>
      <option value="b_genre">장르</option>
      <option value="searchAll">밴드이름+장르</option>
   </select>
   <input class="btn"  name="keyword" id="keyword">
   <button class="btn"  id="btnSearch">검색</button>
</form>
</div>

<%@ include file="../../main/footerSimple.jsp" %>
</body>
</html>
</body>
</html>