<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../include/header.jsp" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$(function(){
	$("#btnDelete").click(function(){
		if(confirm("삭제하시겠습니까?")){
		document.form1.action="${path}/admin/adminBandDelete.do";
		document.form1.submit();
		}
	});
});
</script>
</head>
<body>
<%@ include file="../admin_nav.jsp" %>	
<div class="container" style="width: 1300px">
<h2>밴드창설 신청서</h2>

<table class="table table-hover table-bordered">		
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
    onclick="location.href='${path}/admin/memberview/${row.nickName}'">정보보기</button></td>
    </tr>    
    </tbody>
    </c:forEach>
</table>
<form name="form1" method="post">
<div style="text-align: center;">
<input class="btn btn-default" type="button" value="밴드삭제" id="btnDelete">
</div>
<input type="hidden" value="${b_idx}" id="myBand" name="myBand">
</form>
</div>
</body>
</html>