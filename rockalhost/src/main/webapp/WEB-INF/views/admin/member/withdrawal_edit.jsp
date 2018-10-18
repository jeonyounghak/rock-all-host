<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rock All Host에 오신걸 환영합니다.</title>
<style type="text/css">
#edit_div{
 width: 100%;
 text-align: center;
}
#edit_div_div{
 width: 500px;
 margin: 0px auto;
 text-align: center;
}
#edit_div_div input{
width: 500px;
height: 40px;
font-size: 13px;
}
#edit_div_div select{
width: 500px;
height: 40px;
}
#edit_div_div h5{
text-align: left;
margin: 5px;
}

#edit_div_title{
background-color: black;
height: 145px;
color: white;
text-shadow: 1px 2px 1px gray;
text-align: center;
}
#edit_div_label{
border-bottom: 2px solid black; 
font-size: 20px; 
letter-spacing: 5px; 
color: black;
}
</style>
<script>

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
          name_label.style.color="blue";
          $("#name_label").html("올바른 이름입니다."); 
       }
    }
    
    function nickCheck(){
       var nickName_label = document.getElementById("nickName_label");
       var nickName = document.form1.nickName.value;
       var regExp_nickName = /^[\w\Wㄱ-ㅎㅏ-ㅣ가-힣]{2,20}$/;
       
       if ( !regExp_nickName.test($("#nickName").val())) {
          nickName_label.style.color="red";
          $("#nickName_label").html("특수문자 제외 2자 ~ 20자 형식으로 입력해주세요.");
             $("#nickName").focus();
             return;
       }else{
          nickName_label.style.color="blue";
          $("#nickName_label").html("멋진 닉네임이네요!"); 
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
          email_label.style.color="blue";
          $("#email_label").html("유효한 이메일 주소입니다."); 
       }
    }

    function hpCheck(){
       var hp_label = document.getElementById("hp_label");
       var hp = document.form1.hp.value;
       var regExp_hp = /^\d{3}\d{3,4}\d{4}$/;
       
       if ( !regExp_hp.test($("#hp").val())) {
              hp_label.style.color="red";
             $("#hp_label").html("잘못된 휴대폰 번호입니다. 하이픈(-)기호를 제외하고 숫자만 입력해주세요.");
              $("#hp").focus();
              return;
       }else{
             hp_label.style.color="blue";
             $("#hp_label").html("올바른 휴대폰 번호입니다."); 
       }
    }
    
    
    $(function(){
       $("#btnAminUpdate").click(function(){
          var id = document.form1.id.value;
          var regExp_id = /^[a-z0-9_]{4,20}$/; 
          var name = document.form1.name.value;
          var regExp_name = /^[가-힣]{2,4}$/;
          var nickName = document.form1.nickName.value;
          var regExp_nickName = /^[\w\Wㄱ-ㅎㅏ-ㅣ가-힣]{2,20}$/;
          var sex = document.form1.sex.value;
          var email = document.form1.email.value;
          var regExp_email = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i; 
          var hp = document.form1.hp.value;
          var regExp_hp = /^\d{3}-\d{3,4}-\d{4}$/;
          var zip = document.form1.zip.value;
          var addr = document.form1.addr.value;
          var addrDt = document.form1.addrDt.value;
          
          if (id == ""){
             id_label.style.color="red";
             $("#id_label").html("아이디를 입력해주세요.");
             $("#id").focus();
             return;
          }else{
             $("#id_label").html("");
          }
          if (name == ""){
             name_label.style.color="red";
             $("#name_label").html("이름을 입력해주세요.");
             $("#name").focus();
             return;   
          }else{
             $("#name_label").html("");
          }
          if (nickName == ""){
             nickName_label.style.color="red";
             $("#nickName_label").html("닉네임을 입력해주세요.");
             $("#nickName").focus();
             return;   
          }else{
             $("#nickName_label").html("");
          }
          if (sex == ""){
             sex_label.style.color="red";
             $("#sex_label").html("성별을 선택해주세요.");
             $("#sex").focus();
             return;
          }else{
             $("#sex_label").html("");
          }
          if (email == ""){
             email_label.style.color="red";
             $("#email_label").html("이메일을 입력해주세요.");
             $("#email").focus();
             return;
          }else{
             $("#email_label").html("");
          }
          if (hp == ""){
             hp_label.style.color="red";
             $("#hp_label").html("휴대전화 번호를 입력해주세요.");
             $("#hp").focus();
             return;
          }else{
             $("#hp_label").html("");
          }
          if (zip == ""){
             addr_label.style.color="red";
             $("#addr_label").html("우편번호를 입력해주세요.");
             $("#zip").focus();
             return;
          }else{
             $("#addr_label").html("");
          }
          if (addr == ""){
             addr_label.style.color="red";
             $("#addr_label").html("주소를 입력해주세요.");
             $("#addr").focus();
             return;
          }else{
             $("#addr_label").html("");
          }
          if (addrDt == ""){
             addr_label.style.color="red";
             $("#addr_label").html("상세주소를 입력해주세요.");
             $("#addrDt").focus();
             return;
          }else{
             $("#addr_label").html("");
          }
          document.form1.action="${path}/admin/adminUpdate.do";
          document.form1.submit();
       });
    });
    
    $(function(){
       $("#btnDelete").click(function(){
          if(confirm("회원정보를 삭제하시겠습니까?")){
             document.form1.action="${path}/admin/delete.do";
              document.form1.submit();   
          }
       })
    })
    
  /*   function nickOverlapCheck(){
       var nickName = document.form1.nickName.value;
       
       document.form1.action="${path}/member/NickCheck.do";
       document.form1.submit();
    }  */
    
    function nickOverlapCheck(){
       var nickName = document.form1.nickName.value;
          /* $("#id").val(); */

        if(nickName == "") {
           nickName_label.style.color="red";
             $("#nickName_label").html("닉네임을 입력해주세요.");
             $("#nickName").focus();
              return;
        }else{
              $("#nickName_label").html("");
          }
          
        var regExp_nickName = /^[\w\Wㄱ-ㅎㅏ-ㅣ가-힣]{2,20}$/;
        if (!regExp_nickName.test(nickName)) {
           $("#nickName_label").html("닉네임을 특수문자 제외 2자 ~ 20자 형식으로 입력해주세요.");
             $("#nickName").focus();
           return;
        }
        window.name = "parentForm";
        window.open("${path}/member/popup_checkNick/"+nickName, "chkForm", "width=600px, height=400px, top=300px, left=650px, resizable = no, scrollbars = no");
     }
     
</script>
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50">
<%@ include file="../admin_nav.jsp"%>
     <div id="edit_div_title" >
     <br>
     <h1>Rock All Host</h1>
     <h6>탈퇴 회원 정보 수정</h6>
     </div><br>
<div id="edit_div" >
 <div id="edit_div_div" >
<label id="edit_div_label">&nbsp;필수 입력 정보&nbsp;</label><br><br>
 <form name="form1" method="post">
   <h5>아이디</h5>
    <input style="width: 500px;" id="id" name="id" value="${dto.id}" readonly="readonly"> 
      <br><br>
   <h5>이메일</h5>
     <input id="email" name="email" value="${dto.email}">
      <label id="email_label"></label><br><br>
   <h5>이름</h5>
     <input id="name" name="name" value="${dto.name }">
      <label id="name_label"></label><br><br>
   <h5>닉네임</h5>
      <input style="width: 499px" id="nickName" name="nickName" value="${dto.nickName}">
      <input type="hidden" name="nickDuplication" value="nickUncheck" >
       <c:if test="${message == 'possible' }">
        <label style="color: blue;" id="nickName_label">사용 가능한 닉네임 입니다.</label>
       </c:if>
       <c:if test="${message == 'impossible' }">
        <label style="color: red;" id="nickName_label">사용중인 닉네임입니다.</label>
       </c:if>
        <label id="nickName_label"></label><br><br>
  <h5>생년월일</h5>
      <input type="date" id="birth"  name="birth" value="${dto.birth}">
       <label id="birth_label"></label><br><br>
  <h5>성별</h5>
      <c:if test="${dto.sex == '남자'}">
      <select id="sex" name="sex" >
         <option value="${dto.sex }">성별</option>
         <option value="남자" selected="selected">남자</option>
         <option value="여자">여자</option>
      </select>
      </c:if>
         <c:if test="${dto.sex == '여자'}">
      <select id="sex" name="sex" >
         <option value="${dto.sex }">성별</option>
         <option value="남자">남자</option>
         <option value="여자" selected="selected">여자</option>
      </select>
      </c:if>
         <label id="sex_label"></label><br><br>
  <h5>휴대전화</h5>
     <input id="hp" name="hp" value="${dto.hp}">
      <label id="hp_label"></label><br><br>
   <h5>주소</h5>
     <input style="width: 499px" type="text" id="zip" name="zip" value="${dto.zip }"><br>
     <input style="width: 248px" type="text" id="addr" name="addr" value="${dto.addr }">
     <input style="width: 248px" type="text" id="addrDt" name="addrDt" value="${dto.addrDt }">
      <label id="addr_label"></label><br><br>
   <h5>가입일자</h5>
     <input readonly="readonly" value="${dto.join_date}"><br><br>
     <input type="hidden" id="agreeAd" name="agreeAd" value="동의">
<c:if test="${dto.positionMain  == 99 }">
<label id="edit_div_label">&nbsp;필수 입력 정보<br>
<span style="font-size: 9px;">(밴드 가입을 희망하시는 분은 필히 입력을 해주세요.)</span>&nbsp;</label><br><br></c:if>
<c:if test="${dto.positionMain  != 99 }">
<label id="edit_div_label">&nbsp;필수 입력 정보&nbsp;</label><br><br></c:if>
   <h5>경력</h5>
    <input id="career" name="career" value="${dto.career }"><br><br>
    <h5>메인 포지션</h5>
    <select name="positionMain" id="positionMain">
      <option value="99" <c:if test="${dto.positionMain == 99}"> selected </c:if>>희망 포지션</option>
      <option value="1"  <c:if test="${dto.positionMain == 1}"> selected </c:if>>보컬</option>
      <option value="2"  <c:if test="${dto.positionMain == 2}"> selected </c:if>>드럼</option>
      <option value="3"  <c:if test="${dto.positionMain == 3}"> selected </c:if>>일렉기타</option>
      <option value="4"  <c:if test="${dto.positionMain == 4}"> selected </c:if>>기타</option>
      <option value="5"  <c:if test="${dto.positionMain == 5}"> selected </c:if>>베이스</option>
      <option value="6"  <c:if test="${dto.positionMain == 6}"> selected </c:if> >키보드</option>
    </select><br><br>
    
  <h5>서브 포지션</h5>
    <select name="positionSub" id="positionSub">
      <option value="99" <c:if test="${dto.positionMain == 99}"> selected </c:if>>희망 포지션</option>
      <option value="1"  <c:if test="${dto.positionMain == 1}"> selected </c:if>>보컬</option>
      <option value="2"  <c:if test="${dto.positionMain == 2}"> selected </c:if>>드럼</option>
      <option value="3"  <c:if test="${dto.positionMain == 3}"> selected </c:if>>일렉기타</option>
      <option value="4"  <c:if test="${dto.positionMain == 4}"> selected </c:if>>기타</option>
      <option value="5"  <c:if test="${dto.positionMain == 5}"> selected </c:if>>베이스</option>
      <option value="6"  <c:if test="${dto.positionMain == 6}"> selected </c:if> >키보드</option>
    </select><br><br>
    <label id="edit_div_label">&nbsp;밴드 정보&nbsp;</label><br>
   <h5>내 밴드</h5>
   <c:if test="${dto.myBand == 0}">
     <input value="미가입" readonly="readonly"><br><br>
   </c:if>
   <c:if test="${dto.myBand != 0}">
    <input value="${dto.myBand }" readonly="readonly"><br><br>
    </c:if>
  <label id="edit_div_label">&nbsp;활동 등급&nbsp;</label><br><br>
   <c:if test="${dto.myGrade == 1}">
    <select name="myGrade" id="myGrade">
     <option value="1" selected="selected" >일반회원</option>
     <option value="2">밴드원</option>
     <option value="3">밴드장</option>
    </select><br><br>
    </c:if>
   <c:if test="${dto.myGrade == 2}">
    <select name="myGrade" id="myGrade">
     <option value="1">일반회원</option>
     <option value="2" selected="selected">밴드원</option>
     <option value="3">밴드장</option>
    </select><br><br>
   </c:if>
   <c:if test="${dto.myGrade == 3}">
    <select name="myGrade" id="myGrade">
     <option value="1">일반회원</option>
     <option value="2">밴드원</option>
     <option value="3" selected="selected">밴드장</option>
    </select><br><br>
   </c:if>
   <label id="edit_div_label">&nbsp;회원 정보 복구&nbsp;</label><br><br>
   <select name="withdrawal" id="withdrawal">
    <option value="y">탈퇴 회원</option>
    <option value="n">아이디 복구</option>
   </select>
</form>
<input style="width: 150px; float: left;" class="btn" type="button" id="btnDelete" value="회원정보 삭제">
<input style="width: 100px;" type="button" class="btn" value="목록" onclick="location.href='${path}/admin/withdrawalList.do'">
<input style="width: 200px; float: right;" class="btn" type="button" id="btnAminUpdate" value="수정하기">
</div>
</div>
<%@ include file="../../main/footerSimple.jsp" %>
</body>
</html>