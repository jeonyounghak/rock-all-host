﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#myband_title{
background-color: black;
height: 145px;
color: white;
text-shadow: 1px 2px 1px gray;
text-align: center;
margin-top: 23px;
}

</style>
</head>
<body>
<%@ include file="../main/nav.jsp" %>	
<br>
     <div id="myband_title" ><br>
     <h1>밴드 정보</h1>
     <h6> 밴드멤버 리스트</h6>
     </div><br>
<div class="container-fluid">
   <div class="row row-offcanvas row-offcanvas-right">
	<%@ include file="../band/bandsidevar.jsp" %>
   <div class="col-xs-10 col-lg-10">
<table class="table table-hover table-bordered" style="max-width:80%; margin:0 auto; ">	
	<tbody>
	<tr>      
      <th scope="col">밴드이름</th>
      <th scope="col">닉네임</th>
      <th scope="col">포지션</th>
      <th scope="col">등급</th>
      <th scope="col">경력</th>  
      <th scope="col">정보</th>   
    </tr>
    </tbody> 
    <c:forEach var="row" items="${map.list}"> 
    <tbody> 
    <tr> 
      <td>${row.b_name}</td>
	  <td>${row.nickName}</td>
	  <td>${row.po_name}</td>
	  <td>${row.gra_name}</td>
	  <td>${row.career}</td>	 
    <td><button class="btn btn-default" 
    onclick="location.href='${path}/myband/temperProfile/${row.nickName}'">정보보기</button></td>
    
    </tr>    
    </tbody>
    </c:forEach>
</table>
</div>
</div>
</div>

</body>
</html>