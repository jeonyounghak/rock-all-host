<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rock All Host에 오신걸 환영합니다.</title>
<%@ include file="../include/header.jsp" %>
</head>
<body>
<h2>회원 리스트 </h2>
<table border="1" width="700px">
 <tr>
  <td>등급</td>
  <td>아이디</td>
  <td>닉네임</td>
  <td>이름</td> 
  <td>가입밴드</td>
  <td>포지션</td>
  <td>경력</td>
 </tr>
<c:forEach var="row" items="${list}">
  <tr>
  <td>${row.myGrade}</td>
  <td><a href="${path}/member/listView/${row.id}">${row.id}</a></td>
  <td>${row.nickName}</td>
  <td>${row.name}</td>
  <td>${row.myBand}</td>
  <td>${row.positionMain}</td>
  <td>${row.career}</td>
 </tr>
</c:forEach>
</table>
<%@ include file="../main/footerSimple.jsp" %>
</body>
</html>