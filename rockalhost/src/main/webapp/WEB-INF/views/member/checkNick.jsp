<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rock All Host에 오신걸 환영합니다.</title>
<script>
   function nickOverlapCheck(){
 	  var nickName = document.form1.nickName.value;
 	  var nickName_label = document.getElementById("nickName_label");
 	  var regExp_nickName = /^[\w\Wㄱ-ㅎㅏ-ㅣ가-힣]{2,20}$/;
 	       if (!regExp_nickName.test(nickName)) {
 		   nickName_label.style.color="red";
 		   $("#nickName_label").html("닉네임을 특수문자 제외 2자 ~ 20자 형식으로 입력해주세요.");
		   $("#nickName").focus();
 	      return;
 	   }
         document.form1.action="${path}/member/popNickCheck.do";
         document.form1.submit();
      }
   function apply(){
	    opener.document.form1.nickDuplication.value ="nickCheck";
		opener.document.form1.nickName.value = document.getElementById("nickName").value;
		if (opener != null) {
	    	opener.chkForm = null;
	    	self.close();
		}	
	}
      
</script>

</head>
<style type="text/css">
#checkNick_div{
background-color: black;
height: 145px;
color: white;
text-shadow: 1px 2px 1px gray;
text-align: center;
}
input{
width: 300px;
height: 40px;
}
button {
width: 100px;
height: 40px;
}



</style>
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50">
 <div id="checkNick_div" ><br>
    <h1>Rock All Host</h1>
      <h6>중복검사</h6>
 </div><br>
<h5>닉네임</h5>
<form method="post" name="form1">
<input style="width: 395px" id="nickName" name="nickName" onchange="nickCheck()" value="${nickName}">
<input style="width: 100px;" type="button"  onclick="nickOverlapCheck()" value="중복체크" class="btn" >
<c:if test="${message == 'possible' }">
<label style="color: blue;" id="nickName_label">사용가능한 닉네임입니다.</label>
<button type="button" onclick="apply()" class="btn">적용하기</button>
</c:if>
<c:if test="${message == 'impossible' }">
<label style="color: red;" id="nickName_label">이미 사용중인 닉네임입니다.</label>
</c:if>
</form> 
<%@ include file="../main/footerSimple.jsp" %>
</body>

</html>