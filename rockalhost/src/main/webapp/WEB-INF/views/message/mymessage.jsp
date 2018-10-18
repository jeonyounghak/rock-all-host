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
	$("#btnWrite").click(function(){
		
		alert("발송완료되었습니다.");
		document.form1.action="${path}/message/messagewriter.do";
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
     <h6>보낸 메세지</h6>
     </div><br>
  <ul class="nav nav-tabs nav-justified" style="text-align: center; width:50%; margin:0 auto;" > 
  <li role="presentation"><a href="${path}/message/messagelist.do">받은 메시지</a></li>
  <li style="background-color: rgb(238,238,238); border-top-right-radius: 10px; " role="presentation"><a href="${path}/message/receiverlist.do">보낸 메시지</a></li>
</ul>    
 
		
<form name="form1" method="post">
<table class="table table-hover table-bordered" style="max-width:80%; margin:5 auto; ">	
	<tbody>
	<tr>      
      <th scope="col">글번호</th>
      <th scope="col">보낸이</th>
      <th scope="col">받는이</th>      
      <th scope="col">제목</th>
      <th scope="col">내용</th>
      <th scope="col">날짜</th>     
    </tr>
    </tbody>     
    <c:forEach var="row" items="${map.list}"> 
    <tbody> 
    <tr> 
      <td>${row.idx}</td>
      <td>${row.sender}</td>
	  <td>${row.receiver}</td>
	  <td><a href="${path}/message/myview.do?idx=${row.idx}">${row.title}</a></td>
	  <td>${row.content}</td>
	   <td>
			<fmt:formatDate value="${row.regdate}" pattern="yyyy-MM-dd HH:mm:ss" />
	 </td>      
     
    </tr>
    </tbody>
    </c:forEach>  
</table>
</form>
<br><br>
<div style="text-align: center;">
<input class="btn btn-default" type="button" value="보내기" id="btnWrite">
</div>

</body>
</html>