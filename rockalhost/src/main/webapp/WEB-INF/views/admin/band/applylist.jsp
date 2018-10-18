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
<h2>밴드신청리스트</h2>
<table class="table table-hover table-bordered">	
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
    <c:forEach var="row" items="${map.list}">     
    <tbody> 
    <tr> 
      <td>${row.b_idx}</td>
	  <td><a href="${path}/admin/applyshow/${row.b_leaderNick}">${row.b_name}</a></td>
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
</div>
</body>
</html>