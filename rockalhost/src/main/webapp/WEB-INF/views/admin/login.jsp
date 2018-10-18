<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rock All Host에 오신걸 환영합니다.</title>
<style type="text/css">
#main_login_table{
width: 100%;
text-align: center;
margin: 0px auto;
}
#main_login_table table {
width:100%;
text-align: center;
}
#main_login_table input {
width: 300px;
height: 40px;
}
#main_login_table button {
width: 300px;
height: 40px;
}
#adminlogin_div{
background-color: black;
height: 145px;
color: white;
text-shadow: 1px 2px 1px gray;
text-align: center;
}



</style>
<script type="text/javascript">
$(function(){
	$("#btnLogin").click(function(){
		var id = $("#id").value;
		var message_label = $("#message_label").value;
		var passwd = $("#passwd").value;
		if (id == ""){
			message_label.style.color="red";
			$("#message_label").html("아이디를 입력해주세요.");
			$("#id").focus();
			return;
		}
		if (passwd == ""){
			message_label.style.color="red";
			$("#message_label").html("비밀번호를 입력해주세요.");
			$("#passwd").focus();
			return;
		}else{
			$("#message_label").html("");
		}
		document.form1.action="${path}/admin/login_check.do";
		document.form1.submit();
	})
	
});

</script>

<c:if test="${param.message == 'nologin'}">
  <script>
    alert("로그인 하신 후 사용하세요.");
  </script>
</c:if>

<c:if test="${message == 'error' }">
  <script>
    alert("아이디 또는 비밀번호가 일치하지 않습니다.");
  </script>
</c:if>

<c:if test="${message == 'logout' }">
  <script>
    alert("로그아웃 되었습니다.");
  </script>
</c:if>

</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50">
 <div id="adminlogin_div" ><br>
    <h1>Rock All Host</h1>
      <h6>운영자 로그인</h6>
 </div><br>

<div id="main_login_table">

<form name="form1" method="post">
<table>
 <tr>
  <td><input name="id" id="id" placeholder="아이디"></td>
 </tr>
 <tr>
  <td><label id="message_label"></label>
 </tr>
 <tr> 
  <td><input type="password" name="passwd" id="passwd" placeholder="비밀번호"></td>
 </tr>
 <tr>
  <td><label></label>
 </tr>
 <tr>
  <td><button type="button" id="btnLogin" class="btn">로그인</button></td>
 </tr>
</table>
</form>
</div>
<%@ include file="../main/footerSimple.jsp"%>
</body>
</html>