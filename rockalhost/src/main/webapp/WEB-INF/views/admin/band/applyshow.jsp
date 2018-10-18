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
	$("#btnApply").click(function(){
			if(confirm("이 밴드를 승인하겠습니까??")){
				document.form1.action="${path}/admin/adminapply.do";
				document.form1.submit();	
			}		
			alert("승인이 완료되었습니다.");
	});
});
</script>
</head>
<body>
<%@ include file="../admin_nav.jsp" %>	
<div class="container" style="width: 1300px">
<h2>밴드창설 신청서</h2>	
<form name="form1" method="post">
<table class="table table-hover table-bordered">		
   <tbody>   
   <tr>  
      <td>닉네임</td>      
      <td><input  style="width: 30%;" class="form-control" value="${dto.b_leaderNick}" readonly="readonly"></td>
   </tr>
   <tr>
      <td>밴드이름</td>
      <td><input  style="width: 30%;" class="form-control" value="${dto.b_name}" readonly="readonly"></td>
   </tr>
   <tr>
      <td>장르</td>
      <td><input  style="width: 30%;" class="form-control" value="${dto.gn_name}" readonly="readonly"></td>
   </tr>
   <tr>
      <td>필요인원?</td>
      <td><input  style="width: 30%;" class="form-control" value="${dto.b_num}" readonly="readonly"></td>
   </tr>   
   <tr>
      <td>활동지역</td>
       <td><input  style="width: 30%;" class="form-control" value="${dto.ar_name}" readonly="readonly"></td>
   </tr>
   <tr>
   	  <td>밴드소개</td>
   	  <td><textarea class="form-control" readonly="readonly" rows="10" cols="80"
   	  style="width: 70%;" name="description" id="description">${dto.description}</textarea>
   </tr>
   <tr>
      <td>밴드로고</td>
		<td>
			<c:if test="${dto.b_logo == '-'}">
			<span>밴드로고가 없습니다.</span>
			</c:if>
			<c:if test="${dto.b_logo != '-'}">
			<img src="${path}/images/${dto.b_logo}" style="width: 400px; height: 300px;">					
			</c:if>
		</td>
   </tr>   
   </tbody>        
</table>
<input type="hidden" value="${dto.b_leaderNick}" name="b_leaderNick" >
</form>
<div style="text-align: center;">
<input type="button" class="btn btn-defult" value="승인" id="btnApply"> 
</div>
</body>
</html>