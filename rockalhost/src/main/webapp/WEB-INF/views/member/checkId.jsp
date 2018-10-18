<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rock All Host에 오신걸 환영합니다.</title>
<script>
   function idOverlapCheck(){
 	  var id = document.form1.id.value;
 	  var regExp_id = /^[a-z0-9_]{4,20}$/; 
 	  var id_label = document.getElementById("id_label");
 	   
 	  if (!regExp_id.test(id)) {
 		  id_label.style.color="red";
 		  $("#id_label").html("4~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.");
	      $("#id").focus();
 	      return;
 	   }
         document.form1.action="${path}/member/popIdCheck.do";
         document.form1.submit();
      }
   
   function apply(){
	    opener.document.form1.idDuplication.value ="idCheck";
		opener.document.form1.id.value = document.getElementById("id").value;
		if (opener != null) {
	    	opener.chkForm = null;
	    	self.close();
		}	
	}
      
</script>
<style type="text/css">
#checkId_div{
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
button{
width: 100px;
height: 40px;
}


</style>
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50">
 <div id="checkId_div" ><br>
    <h1>Rock All Host</h1>
      <h6>중복검사</h6>
 </div><br>
<h5>아이디</h5>
<form method="post" name="form1">
<input style="width: 395px" id="id" name="id" onchange="idCheck()" value="${id}">
<input style="width: 100px;" type="button" class="btn" onclick="idOverlapCheck()" value="중복체크"  >
<c:if test="${message == 'possible' }">
<label style="color: blue;" id="id_label" >사용가능한 아이디입니다.</label>
<button type="button" onclick="apply()" class="btn">적용하기</button>
</c:if>
<c:if test="${message == 'impossible' }">
<label style="color: red;" id="id_label">이미 사용중인 아이디입니다.</label>
</c:if>
</form> 
<%@ include file="../main/footerSimple.jsp" %>
</body>

</html>