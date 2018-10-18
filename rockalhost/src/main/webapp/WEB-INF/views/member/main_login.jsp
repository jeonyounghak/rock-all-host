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
margin-top: 50px;
margin-bottom: 50px;
}
#main_login_table table{
width: 100%;
text-align: center;
margin: 0px auto;
}
#main_login_table input{
width: 300px;
height: 40px;
font-size: 12px;
}
#main_login_table label{
font-size: 12px;
}
#main_login_table button{
width: 100px;
height: 40px;
}
#main_login_table h1{
color: white;
text-shadow: 1px 2px 1px gray;
}
#main_login_table_a{
font-weight: bold;
font-size: 13px;
}
#main_login_table_title{
background-color: black;
height: 145px;
}

#main_login_table_a a:link{text-decoration: none; color: black;}
#main_login_table_a a:visited{text-decoration: none; color: black;}
#main_login_table_a a:hover{text-decoration: none; color: white; text-shadow: 1px 1px 1px black;}
#main_login_table_a a:active{text-decoration: none; color: black;}



</style>
<script type="text/javascript">
$(function(){
	$("#btnLogin").click(function(){
		var id = document.form1.id.value;
		var message_label = document.getElementById("message_label");
		var passwd = document.form1.passwd.value;
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
		document.form1.action="${path}/member/login_check.do";
		document.form1.submit();
	})
	
});


</script>
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50">
<%@ include file="../main/nav.jsp"%>
   <div id="main_login_table">
     <div id="main_login_table_title" >
     <br>
     <h1>Rock All Host</h1></div><br>
   <form name="form1" method="post">
     <table>
       <tr>
         <td><input name="id" id="id" placeholder="아이디 / ID"></td>
       </tr>
       <tr>
         <td><label id="message_label"></label>
       </tr>
       <tr> 
        <td><input type="password" name="passwd" id="passwd" placeholder="비밀번호 / PASSWD"></td>
       </tr>
       <tr>
       <td><label></label></td>
       </tr>
       <tr>
         <td>
           <c:if test="${param.message == 'nologin'}">
              <div style="color:red;">로그인 하신 후 사용하세요. </div>
           </c:if>
           <c:if test="${message == 'error'}">
              <div style="color:red;">아이디 또는 비밀번호가 일치하지 않습니다. </div>
           </c:if>
           <c:if test="${message == 'logout'}">
              <div style="color:blue;">로그아웃 처리되었습니다. </div>
           </c:if>
          </td>
       </tr>
       <tr>
          <td><button class="btn" type="button" id="btnLogin">로그인</button></td>
       </tr>
    </table>
  </form>
    <hr/>
  <div id="main_login_table_a" >
   <a href="${path}/member/findIdPage.do">아이디 찾기</a>&nbsp; | 
   <a href="${path}/member/findPasswdPage.do">비밀번호 찾기</a>&nbsp; | &nbsp;
   <a href="${path}/member/preJoin.do">회원가입</a>
  </div>
</div>

<%@ include file="../main/footerSimple.jsp" %>
</body>
</html>