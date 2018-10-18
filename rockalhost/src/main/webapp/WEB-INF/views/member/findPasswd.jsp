<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rock All Host에 오신걸 환영합니다.</title>
<script type="text/javascript">
$(function (){
	$("#passwdFind").click(function(){
		var id = $("#id").val();
		var name = $("#name").val();
		var email = $("#email").val();
		
		if(id == ""){
			id_label.style.color="red";
			$("#id_label").html("아이디를 입력해주세요.");
			$("#id_label").focus();
			return;
		}else{
			$("#id_label").html("");
		}
		if(name == ""){
			name_label.style.color="red";
			$("#name_label").html("이름을 입력해주세요.");
			$("#name_label").focus();
			return;
		}else{
			$("#name_label").html("");
		}
		if(email == ""){
			email_label.style.color="red";
			$("#email_label").html("이메일을 입력해주세요.");
			$("#email_label").focus();
			return;
		}else{
			$("#email_label").html("");
		}
		document.form1.action="${path}/member/findpasswd.do";
		document.form1.submit();
	})
})

function idCheck(){
	var id_label = document.getElementById("id_label");
	var id = document.form1.id.value;
	var regExp_id = /^[a-z0-9_]{4,20}$/; 
	
	if ( !regExp_id.test($("#id").val())) {
		id_label.style.color="red";
		$("#id_label").html("4~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.");
	      $("#id").focus();
	      return;	
	}else{
		$("#id_label").html("");
	}
}


function nameCheck(){
    	var name_label = document.getElementById("name_label");
    	var name = document.form1.name.value;
    	var regExp_name = /^[가-힣]{2,4}$/;
    	
    	if ( !regExp_name.test($("#name").val())) {
    		name_label.style.color="red";
    		$("#name_label").html("한글(2~4자리)만 입력 가능합니다.");
    	      $("#name").focus();
    	      return;
    	}else{
    		$("#name_label").html(""); 
    	}
    }
    
function emailCheck(){
	var email_label = document.getElementById("email_label");
	var email = document.form1.email.value;
	var regExp_email = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i; 
	
	if ( !regExp_email.test($("#email").val())) {
		    email_label.style.color="red";
			$("#email_label").html("이메일 주소를 다시 확인해주세요.(양식에 맞게 입력해주세요.)");
		    $("#email").focus();
		      return;
	}else{
		$("#email_label").html(""); 
	}
}



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
<label style="border-bottom: 3px solid black; font-weight: bold; color: black; font-size: 15px;">1. 정보입력</label>&nbsp;&nbsp;▶
&nbsp;&nbsp;<label style="color: gray; font-size:12px; font-weight: lighter;">2. 비밀번호 재설정</label><br><br>
<form method="post" name="form1">
<input name=id id="id" placeholder="아이디 / ID" onchange="idCheck()"><br>
<label id="id_label"></label><br>
<input name="name" id="name" placeholder="이름 / NAME" onchange="nameCheck()"><br>
<label id="name_label"></label><br>
<input name="email" id="email" placeholder="이메일 / EMAIL" onchange="emailCheck()"><br>
<label id="email_label"></label><br>
<c:if test="${message == 'fail' }">
  <label style="color: red">아이디 또는 이름, 이메일이 일치 하지 않습니다.</label><br>
</c:if>
<button class="btn" type="button" id="passwdFind">확인</button>
</form>
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