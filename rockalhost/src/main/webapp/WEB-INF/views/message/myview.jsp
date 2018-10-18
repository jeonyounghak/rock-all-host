<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rock All Host에 오신걸 환영합니다.</title>
<script type="text/javascript">
$(function(){
	$("#btnUpdate").click(function(){		
		if(confirm("삭제하시겠습니까?")){
			document.form1.action="${path}/message/receiverupdate.do?idx=${dto.idx}";
			document.form1.submit();	
		}
	});
});

</script>
<style type="text/css">
#messagelist_div_title{
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
     <div id="messagelist_div_title" >
     <br>
     <h1>내 쪽지함</h1>
     <h6>상세보기</h6>
     </div><br>
  <ul class="nav nav-tabs nav-justified" style="text-align: center; width:50%; margin:0 auto;" > 
  <li role="presentation"><a href="${path}/message/messagelist.do">받은 메시지</a></li>
  <li style="background-color: rgb(238,238,238); border-top-right-radius: 10px; " role="presentation"><a href="${path}/message/receiverlist.do">보낸 메시지</a></li>
</ul>    
<form name="form1" method="post">	
<table class="table table-hover table-bordered" style="max-width:80%; margin:5 auto; ">  
   <tbody>
   <tr>      
     <td>글번호</td>
     <td>${dto.idx}</td>
   </tr> 
   <tr>  
      <td>보낸이</td>
      <td>${dto.sender}</td>
   </tr>
   <tr>
      <td>받는이</td>
      <td>${dto.receiver}</td>
   </tr>
   <tr>
      <td>제목</td>
      <td>${dto.title}</td>
   </tr>
   <tr>
      <td scope="col">내용</td>
      <td>${dto.content}</td>
   </tr>
   <tr>
      <td>보낸시간</td>
      <td>
			<fmt:formatDate value="${dto.regdate}" pattern="yyyy-MM-dd HH:mm:ss" />
	  </td>   
    </tbody>
</table>
<input type="hidden" value="${dto.sender}" id="sender" name="sender">
<input type="hidden" value="${dto.receiver}" id="receiver" name="receiver">
<br><br>
<div style="text-align: center;">
<input class="btn btn-default" type="button" value="삭제" id="btnUpdate">
</div>
</form>


</body>
</html>