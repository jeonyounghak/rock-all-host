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
	$("#btnReply").click(function(){		
		var sender = document.form1.sender.value;
		var receiver = document.form1.receiver.value;
		var title = document.form1.title.value;
		var content = document.form1.content.value;
		
		alert("발송완료되었습니다.");
		document.form1.action="${path}/message/messagereply.do";
		document.form1.submit();
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
     <h6>답변 보내기</h6>
     </div><br>
<%@ include file="../main/message.jsp" %>		
<form name="form1" method="post">
<table class="table table-hover table-bordered" style="max-width:80%; margin:5 auto; ">   
   <tbody>   
   <tr>  
      <td>보낸이</td>      
      <td><input class="form-control" id="sender" name="sender" value="${dto.sender}" readonly="readonly"></td>
   </tr>
   <tr>
      <td>받는이</td>
      <td><input class="form-control" id="receiver" name="receiver" value="${dto.receiver}" readonly="readonly"></td>
   </tr>
   <tr>
      <td>제목</td>
      <td><input class="form-control" id="title" name="title"></td>
   </tr>
   <tr>
      <td>내용</td>
      <td><input class="form-control" id="content" name="content"></td>
   </tr>   
   </tbody>        
</table>
</form>
<br><br>
<div style="text-align: center;">
<input class="btn btn-default" type="button" value="보내기" id="btnReply">
</div>
</body>
</html>