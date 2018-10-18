<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rock All Host에 오신걸 환영합니다.</title>
<style type="text/css">
#view_div{
 width: 100%;
 text-align: center;
}
#view_div_div{
 width: 500px;
 margin: 0px auto;
 text-align: center;
}
#view_div_div input{
width: 500px;
height: 40px;
}
#view_div_div select{
width: 500px;
height: 40px;
}
#view_div_div h5{
text-align: left;
margin: 5px;
}
#view_title_div_back{
width: 100%;
text-align: center;
margin-top: 50px;
margin-bottom: 50px;
}
#view_div_title{
background-color: black;
height: 145px;
color: white;
text-shadow: 1px 2px 1px gray;
}
#view_div_label{
border-bottom: 2px solid black; 
font-size: 20px; 
letter-spacing: 5px; 
color: black;
}

</style>

<script type="text/javascript">
  
    function pwdCheck(){
    	var passwd_label = document.getElementById("passwd_label");
    	var passwd = document.form1.passwd.value;
  	
    	
    	if (passwd == ""){
			passwd_label.style.color="red";
			$("#passwd_label").html("비밀번호를 입력해주세요.");
			$("#passwd").focus();
			return;
		}else{
			$("#passwd_label").html("");
		}

    }
    
    $(function(){
    	$("#btnTest").click(function(){
    
    	
    		document.form1.action="${path}/member/test.do";
    		document.form1.submit();
    	});
    });
 
    
    $(function(){
    	$("#btnEdit").click(function(){
    	
    		var passwd = document.form1.passwd.value;
    	
    		if (passwd == ""){
    			passwd_label.style.color="red";
    			$("#passwd_label").html("비밀번호를 입력해주세요.");
    			$("#passwd").focus();
    			return;
    		}else{
    			$("#passwd_label").html("");
    		}
    		document.form1.action="${path}/member/edit.do";
    		document.form1.submit();
    	});
    });
    
    $(function(){
    	$("#btnDelete").click(function(){
    	    if(confirm("탈퇴하시겠습니까?")){
    		document.form1.action="${path}/member/delete.do";
    		document.form1.submit();
    	}
    	});
    });
   
</script>
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50">
<%@ include file="../main/nav.jsp"%>
  <div id="view_title_div_back">
     <div id="view_div_title" >
     <br>
     <h1>Rock All Host</h1>
     <h6>개인 정보</h6>
     </div>
  </div>
<div id="view_div" >
<div id="view_div_div" >
<label id="view_div_label">&nbsp;필수 입력 정보&nbsp;</label><br><br>
<form name="form1" method="post">
<h5>아이디</h5>
  <input style="width: 500px;" id="id" name="id" value="${dto.id}" readonly="readonly"> 
   <br><br>
<h5>비밀번호</h5>
  <input type="password" id="passwd" name="passwd" value="" onchange="pwdCheck()">
  <c:if test="${message == 'fail'}">
   <label style="color: red;" id="passwd_label">비밀번호가 일치 하지 않습니다.</label>
   </c:if>
   <label id="passwd_label"></label><br><br>
<h5>이메일</h5>
   <input id="email" name="email" value="${dto.email}" readonly="readonly">
     <label id="email_label"></label><br><br>
<h5>이름</h5>
   <input id="name" name="name" value="${dto.name }" readonly="readonly">
     <label id="name_label"></label><br><br>
<h5>닉네임</h5>
   <input style="width: 500px" id="nickName" name="nickName" value="${dto.nickName}" readonly="readonly">
    <label id="nickName_label"></label><br><br>
<h5>생년월일</h5>
   <input  id="birth"  name="birth" value="${dto.birth}" readonly="readonly">
     <label id="birth_label"></label><br><br> 
<h5>성별</h5>
   <input name="sex" id="sex" value="${dto.sex }">
       <label id="sex_label"></label><br><br>
<h5>휴대전화</h5>
   <input id="hp" name="hp" value="${dto.hp}" readonly="readonly">
     <label id="hp_label"></label><br><br>
<h5>주소</h5>
   <input style="width: 500px" type="text" id="zip" name="zip" value="${dto.zip }" readonly="readonly">
     <input style="width: 248px" type="text" id="addr" name="addr" value="${dto.addr }" readonly="readonly">
       <input style="width: 248px" type="text" id="addrDt" name="addrDt" value="${dto.addrDt }" readonly="readonly">
         <label id="addr_label"></label><br><br>
 <h5>가입일자</h5>
    <input readonly="readonly" value="${dto.join_date}"><br><br>
     <input type="hidden" id="agreeAd" name="agreeAd" value="동의">
<c:if test="${dto.positionMain  == 99 }">
<label id="view_div_label">&nbsp;선택 입력 정보<br>
<span style="font-size: 9px;">(밴드 가입을 희망하시는 분은 필히 입력을 해주세요.)</span>&nbsp;</label><br><br></c:if>
<c:if test="${dto.positionMain  != 99 }">
<label id="view_div_label">&nbsp;선택 입력 정보&nbsp;</label><br><br></c:if>
  <h5>경력</h5>
    <input id="career" name="career" value="${dto.career }" readonly="readonly"><br><br>
  <h5>메인 포지션</h5>
    <c:if test="${dto.positionMain == 99 }">
    <input id="positionMain" name="positionMain" value="희망 포지션을 선택해주세요." readonly="readonly"><br><br>
    </c:if>
    <c:if test="${dto.positionMain == 1 }">
    <input id="positionMain" name="positionMain" value="보컬" readonly="readonly"><br><br>
    </c:if>
    <c:if test="${dto.positionMain == 2 }">
    <input id="positionMain" name="positionMain" value="드럼" readonly="readonly"><br><br>
    </c:if>
    <c:if test="${dto.positionMain == 3 }">
    <input id="positionMain" name="positionMain" value="일렉기타" readonly="readonly"><br><br>
    </c:if>
    <c:if test="${dto.positionMain == 4 }">
    <input id="positionMain" name="positionMain" value="기타" readonly="readonly"><br><br>
    </c:if>
    <c:if test="${dto.positionMain == 5 }">
    <input id="positionMain" name="positionMain" value="베이스" readonly="readonly"><br><br>
    </c:if>
    <c:if test="${dto.positionMain == 6 }">
    <input id="positionMain" name="positionMain" value="키보드" readonly="readonly"><br><br>
    </c:if>
  <h5>서브 포지션</h5>
    <c:if test="${dto.positionSub == 99 }">
    <input id="positionSub" name="positionSub" value="가능한 세컨 포지션을 선택해주세요." readonly="readonly"><br><br>
    </c:if>
    <c:if test="${dto.positionSub == 1 }">
    <input id="positionSub" name="positionSub" value="보컬" readonly="readonly"><br><br>
    </c:if>
    <c:if test="${dto.positionSub == 2 }">
    <input id="positionSub" name="positionSub" value="드럼" readonly="readonly"><br><br>
    </c:if>
    <c:if test="${dto.positionSub == 3 }">
    <input id="positionSub" name="positionSub" value="일렉기타" readonly="readonly"><br><br>
    </c:if>
    <c:if test="${dto.positionSub == 4 }">
    <input id="positionSub" name="positionSub" value="기타" readonly="readonly"><br><br>
    </c:if>
    <c:if test="${dto.positionSub == 5 }">
    <input id="positionSub" name="positionSub" value="베이스" readonly="readonly"><br><br>
    </c:if>
    <c:if test="${dto.positionSub == 6 }">
    <input id="positionSub" name="positionSub" value="키보드" readonly="readonly"><br><br>
    </c:if>
    <c:if test="${dto.positionSub == 99 }">
    <input id="positionSub" name="positionSub" value="없음" readonly="readonly"><br><br>
    </c:if>
    
<label id="view_div_label">&nbsp;밴드 정보&nbsp;</label><br>
  <h5>내 밴드</h5>
   <c:if test="${dto.myBand == 0}">
     <input id="myBand" name="myBand" value="미가입" readonly="readonly"><br><br>
   </c:if>
   <c:if test="${dto.myBand != 0}">
    <input id="myBand" name="myBand" value="${sessionScope.band_name}" readonly="readonly"><br><br>
    </c:if>
  <label id="view_div_label">&nbsp;활동 등급&nbsp;</label><br><br>
   <c:if test="${dto.myGrade == 1}">
    <input id="myGrade" name="myGrade" value="일반회원" readonly="readonly"><br><br>
    </c:if>
   <c:if test="${dto.myGrade == 2}">
    <input id="myGrade" name="myGrade" value="밴드원" readonly="readonly"><br><br>
   </c:if>
   <c:if test="${dto.myGrade == 3}">
    <input id="myGrade" name="myGrade" value="밴드장" readonly="readonly"><br><br>
   </c:if>
    <input style="width: 100px; float: left;" class="btn" type="button" value="HOME" onclick="location.href='${path}/member/home.do'">
    <input style="width: 200px; float: right;"class="btn" type="button" id="btnEdit" value="내정보 수정">
      </form>
   </div>
 </div>


<%@ include file="../main/footerSimple.jsp" %>  
</body>
</html>