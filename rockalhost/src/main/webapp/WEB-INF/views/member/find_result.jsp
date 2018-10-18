<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rock All Host에 오신걸 환영합니다.</title>
<style type="text/css">
#findResult_div{
width: 100%;
text-align: center;
margin-top: 50px;
margin-bottom: 50px;
}
#findResult_div_title{
background-color: black;
height: 145px;
color: white;
text-shadow: 1px 2px 1px gray;
}
#findResult_div button{
width: 100px;
height: 40px;
}
#findResult_div_result{
width: 100%;
}
#findResult_div_result div{
width: 400px;
height: 120px;
border: 1px solid gray;
margin: 0px auto;
text-align: center;
}
#findResult_div_a{
font-weight: bold;
font-size: 13px;
}
#findResult_div_a a:link{text-decoration: none; color: black;}
#findResult_div_a a:visited{text-decoration: none; color: black;}
#findResult_div_a a:hover{text-decoration: none; color: white; text-shadow: 1px 1px 1px black;}
#findResult_div_a a:active{text-decoration: none; color: black;}

</style>
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50">
<%@ include file="../main/nav.jsp"%>
   <div id="findResult_div">
     <div id="findResult_div_title" >
     <br>
     <h1>Rock All Host</h1>
     <h6>아이디 찾기</h6>
     </div><br>
<label style="color: gray; font-weight: lighter; font-size: 12px;" >1. 정보입력</label>&nbsp;&nbsp;▷
&nbsp;&nbsp;<label style="border-bottom: 3px solid black; font-weight: bold; color: black; font-size: 15px;" >2. 아이디 확인</label><br><br>

  <div id="findResult_div_result">
    <div><br>
     회원님의 아이디는  &nbsp;<span style="color: white; background-color:black; font-weight: bold; font-size: 30px; border-radius: 5px;"> ${id} </span> 입니다.
    </div>
  </div>

  <div id="findResult_div" >
    <button class="btn" onclick="location.href='${path}/member/home.do'">메인</button>
    <button class="btn" onclick="location.href='${path}/member/login.do'">로그인</button>
  </div>
    <hr/>
    <div id="findResult_div_a" >
      <a href="${path}/member/findIdPage.do">아이디 찾기</a>&nbsp; | 
      <a href="${path}/member/findPasswdPage.do">비밀번호 찾기</a>&nbsp; | &nbsp;
      <a href="${path}/member/preJoin.do">회원가입</a>
    </div>
</div>
<%@ include file="../main/footerSimple.jsp" %>
</body>
</html>