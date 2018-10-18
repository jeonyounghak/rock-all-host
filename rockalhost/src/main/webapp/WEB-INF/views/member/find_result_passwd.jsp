<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rock All Host에 오신걸 환영합니다.</title>
<script type="text/javascript">

function pwdCheck(){
   var passwd_label = document.getElementById("passwd_label");
   var passwd = document.form1.passwd.value;
   var regExp_pwd = /^[a-z0-9_]{4,5}$/;
   var regExp_id = /^[a-z0-9_]{4,20}$/; 
   
   if ( !regExp_id.test($("#passwd").val())) {
      passwd_label.style.color="red";
      $("#passwd_label").html("4~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.");
         $("#passwd").focus();
         return;
   }else if( !regExp_pwd.test($("#passwd").val())){
      passwd_label.style.color="blue";
      $("#passwd_label").html("유효한 비밀번호 입니다."); 
   }else{
      passwd_label.style.color="orange";
      $("#passwd_label").html("보안에 취약한 비밀번호 입니다.");
   }
}

function pwdCheck2(){
   var passwd2_label = document.getElementById("passwd2_label");
   var passwd = document.form1.passwd.value;
   var passwd2 = document.form1.passwd2.value;
   
   if(passwd != passwd2){
      passwd2_label.style.color="red";
      $("#passwd2_label").html("비밀번호가 일치하지 않습니다.");
         $("#passwd2").focus();   
   }else{
      passwd2_label.style.color="blue";
      $("#passwd2_label").html("비밀번호가 일치합니다."); 
   }
}


$(function (){
   $("#passwdUpdate").click(function(){
      var passwd = document.form1.passwd.value;
      var passwd2 = document.form1.passwd2.value;
      
      if (passwd == ""){
         passwd_label.style.color="red";
         $("#passwd_label").html("비밀번호를 입력해주세요.");
         $("#passwd").focus();
         return;
      }else{
         $("#passwd_label").html("");
      }
      if (passwd2 != passwd){
         passwd2_label.style.color="red";
         $("#passwd2_label").html("비밀번호를 다시  입력해주세요.");
         $("#passwd2").focus();
         return;
      }else{
         $("#passwd2_label").html("");
         document.form1.action="${path}/member/passwdUpdate.do";
         document.form1.submit();
      }
   })
})
</script>
<style type="text/css">
#findPasswd_div{
width: 100%;
text-align: center;
margin-top: 50px;
margin-bottom: 50px;
}
#findPasswd_div label{
font-size: 12px;
}
#findPasswd_div_title{
background-color: black;
height: 145px;
color: white;
text-shadow: 1px 2px 1px gray;
}
#findPasswd_div_a{
font-weight: bold;
font-size: 13px;
}
#findPasswd_div button{
width: 100px;
height: 40px;
}
#findPasswd_div input{
width: 300px;
height: 40px;
font-size: 12px;
}
#findPasswd_div_a a:link{text-decoration: none; color: black;}
#findPasswd_div_a a:visited{text-decoration: none; color: black;}
#findPasswd_div_a a:hover{text-decoration: none; color: white; text-shadow: 1px 1px 1px black;}
#findPasswd_div_a a:active{text-decoration: none; color: black;}
</style>
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50">
<%@ include file="../main/nav.jsp"%>
   <div id="findPasswd_div">
     <div id="findPasswd_div_title" >
     <br>
     <h1>Rock All Host</h1>
     <h6>비밀번호 찾기</h6>
     </div><br>     
<label style="color: gray; font-weight: lighter; font-size: 12px;">1. 정보입력</label>&nbsp;&nbsp;▷
&nbsp;&nbsp;<label style="border-bottom: 3px solid black; font-weight: bold; color: black; font-size: 15px;">2. 비밀번호 재설정</label><br><br>
<form method="post" name="form1">
<input type="hidden" name="id" id="id" value="${id}">
<input type="password" name="passwd" id="passwd" placeholder="비밀번호 / PASSWD" onchange="pwdCheck()"><br>
<label id="passwd_label"></label><br>
<input type="password" name="passwd2" id="passwd2" placeholder="비밀번호 재입력 / PASSWD" onchange="pwdCheck2()"><br>
<label id="passwd2_label"></label><br>
</form>
 <button type="button" id="passwdUpdate">확인</button>
 <hr/>
    <div id="findPasswd_div_a" >
      <a href="${path}/member/findIdPage.do">아이디 찾기</a>&nbsp; | 
      <a href="${path}/member/findPasswdPage.do">비밀번호 찾기</a>&nbsp; | &nbsp;
      <a href="${path}/member/preJoin.do">회원가입</a>
    </div>
</div>
<%@ include file="../main/footerSimple.jsp" %>
</body>
</html>