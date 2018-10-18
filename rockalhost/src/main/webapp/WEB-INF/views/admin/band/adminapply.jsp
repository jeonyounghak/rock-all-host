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
	$("#btnInsert").click(function(){		
		var b_leaderNick = document.form1.b_leaderNick.value;
		var b_name = document.form1.b_name.value;
		var b_genre = document.form1.b_genre.value;
		var b_num = document.form1.b_num.value;
		var b_area = document.form1.b_area.value;
		var imgFile = document.form1.imgFile.value;
	    var description = document.form1.description.value;
	      
	    
		document.form1.action="${path}/band/apply.do";
		document.form1.submit();
	});	
});

</script>
</head>
<body>
<%@ include file="../admin_nav.jsp" %>	
<div class="container" style="width: 1300px">
<h2>밴드창설 신청서</h2>
<form name="form1" method="post" enctype="multipart/form-data">
<table class="table table-hover table-bordered">		
   <tbody>   
   <tr>  
      <td>닉네임</td>      
      <td><input  class="form-control" value="${dto.b_leaderNick}" readonly="readonly"></td>
   </tr>
   <tr>
      <td>밴드이름</td>
      <td><input  class="form-control" value="${dto.b_name}" readonly="readonly"></td>
   </tr>
   <tr>
      <td>장르</td>
      <td><input   class="form-control" value="${dto.b_genre}" readonly="readonly"></td>
   </tr>
   <tr>
      <td>필요인원?</td>
      <td><input  class="form-control" value="${dto.b_num}" readonly="readonly"></td>
   </tr>   
   <tr>
      <td>활동지역</td>
       <td><input  class="form-control" value="${dto.b_area}" readonly="readonly"></td>
   </tr>
   <tr>
   	  <td>밴드소개</td>
   	  <td><textarea rows="10" cols="80" name="description" id="description">${dto.description}</textarea>
   </tr>
   <tr>
      <td>밴드로고</td>
		<td>
			<input type="file" name="imgFile" id="imgFile">
		</td>
   </tr>   
   </tbody>        
</table>
</form>
<div style="text-align: center;">
<input class="btn btn-default" type="button" value="승인" id="btnInsert">
</div>
</div>
</body>
</html>