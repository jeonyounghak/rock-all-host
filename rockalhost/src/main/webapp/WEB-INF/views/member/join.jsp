<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rock All Host에 오신걸 환영합니다.</title>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullAddr = ''; // 최종 주소 변수
                var extraAddr = ''; // 조합형 주소 변수
                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    fullAddr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    fullAddr = data.jibunAddress;
                }
                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                if(data.userSelectedType === 'R'){
                    //법정동명이 있을 경우 추가한다.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }
                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('zip').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('addr').value = fullAddr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById('addrDt').focus();
            }
        }).open();
    }
    
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
    		id_label.style.color="blue";
    		$("#id_label").html("");
    	}
    }

    function pwdCheck(){
    	var passwd_label = document.getElementById("passwd_label");
    	var passwd = document.form1.passwd.value;
    	var regExp_id = /^[a-z0-9_]{4,20}$/; 
    	var regExp_pwd = /^[a-z0-9_]{4,5}$/;
    	
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
    		$("#nickName_label").html(""); 
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
    	$("#btnInsert").click(function(){
    		var id = document.form1.id.value;
    		var idDuplication = document.form1.idDuplication.value;
    		var regExp_id = /^[a-z0-9_]{4,20}$/; 
    		var passwd = document.form1.passwd.value;
    		var passwd2 = document.form1.passwd2.value;
    		var name = document.form1.name.value;
    		var regExp_name = /^[가-힣]{2,4}$/;
    		var nickName = document.form1.nickName.value;
    		var nickDuplication = document.form1.nickDuplication.value
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
    		if (form1.idDuplication.value == "idUncheck" ){
    			id_label.style.color="red";
    			$("#id_label").html("아이디 중복 체크를 진행해주세요.");
    			$("#id").focus();
    			return;
    		}else{
    			$("#id_label").html("");
    		}
    		if (passwd == ""){
    			passwd_label.style.color="red";
    			$("#passwd_label").html("비밀번호를 입력해주세요.");
    			$("#passwd").focus();
    			return;
    		}else{
    			$("#passwd_label").html("");
    		}
    		if (passwd2 == ""){
    			passwd2_label.style.color="red";
    			$("#passwd2_label").html("비밀번호를 다시  입력해주세요.");
    			$("#passwd2").focus();
    			return;
    		}else{
    			$("#passwd2_label").html("");
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
    		if (form1.nickDuplication.value == "nickUncheck" ){
    			nickName_label.style.color="red";
    			$("#nickName_label").html("닉네임 중복 체크를 진행해주세요.");
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
    		document.form1.action="${path}/member/insert.do";
    		document.form1.submit();
    	});
    });
    
    function inputNickChk(){
    	document.joinForm.nickDuplication.value ="nickUncheck";
    }
    
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
    
    
    function inputIdChk(){
    	document.joinForm.idDuplication.value ="idUncheck";
    }
    
    function idOverlapCheck(){
  	  var id = document.form1.id.value;
  		  /* $("#id").val(); */

  	   if(id == "") {
  		   id_label.style.color="red";
 		   $("#id_label").html("아이디를 입력해주세요.");
 		   $("#id").focus();
  	       return;
  	   }else{
  		 $("#id_label").html("");
  	   }
  	 var regExp_id = /^[a-z0-9_]{4,20}$/; 
  	   if (!regExp_id.test(id)) {
  		 $("#id_label").html("4~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.");
 	     $("#id").focus();
  	      return;
  	   }
  	   window.name = "parentForm";
  	   window.open("${path}/member/popup_checkId/"+id, "chkForm", "width=600px, height=400px, top=300px, left=650px, resizable = no, scrollbars = no");
  	}
   
    
</script>
<style type="text/css">
#join_div{
 width: 100%;
 text-align: center;
}
#join_div_div{
 width: 500px;
 margin: 0px auto;
 text-align: center;
}
#join_div_div input{
width: 500px;
height: 40px;
font-size: 13px;
}
#join_div_div select{
width: 500px;
height: 40px;
}
#join_div_div h5{
text-align: left;
margin: 5px;
}

#join_title_div_back{
width: 100%;
text-align: center;
margin-top: 50px;
margin-bottom: 50px;
}
#join_div_title{
background-color: black;
height: 145px;
color: white;
text-shadow: 1px 2px 1px gray;
}
#join_div_label{
border-bottom: 2px solid black; 
font-size: 20px; 
letter-spacing: 5px; 
color: black;
}

</style>
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50">
<%@ include file="../main/nav.jsp"%>
  <div id="join_title_div_back">
     <div id="join_div_title" >
     <br>
     <h1>Rock All Host</h1>
     <h6>회원가입</h6>
     </div>
  </div>

<div id="join_div" >
  <div id="join_div_div" >
    <label id="join_div_label">&nbsp;필수 입력 정보&nbsp;</label><br><br>
      <form name="form1" method="post">
        <h5>아이디</h5>
          <input style="width: 395px;" id="id" name="id" onchange="idCheck()" onkeydown="inputIdChk()"> 
          <input type="hidden" name="idDuplication" value="idUncheck">
          <input class="btn" style="width: 100px;" type="button" onclick="idOverlapCheck()" value="중복체크"  >
            <label id="id_label"></label><br><br>
        <h5>비밀번호</h5>
          <input type="password" id="passwd" name="passwd" onchange="pwdCheck()">
            <label id="passwd_label"></label><br><br>
        <h5>비밀번호 확인</h5>
          <input type="password" id="passwd2" name="passwd2" onchange="pwdCheck2()">
            <label id="passwd2_label"></label><br><br>
        <h5>이메일</h5>
          <input id="email" name="email" onchange="emailCheck()">
          <label id="email_label"></label><br><br>
        <h5>이름</h5>
          <input id="name" name="name" onchange="nameCheck()">
            <label id="name_label"></label><br><br>
        <h5>닉네임</h5>
          <input style="width: 395px" id="nickName" name="nickName" onchange="nickCheck()" onkeydown="inputNickChk()">
          <input type="hidden" name="nickDuplication" value="nickUncheck" >
          <input class="btn" style="width: 100px;" type="button"  onclick="nickOverlapCheck()" value="중복체크"  >
            <label id="nickName_label"></label><br><br>
        <h5>생년월일</h5>
          <input type="date" id="birth"  name="birth" value="1990-01-01">
            <label id="birth_label"></label><br><br>
        <h5>성별</h5>
          <select id="sex" name="sex" >
            <option value="" selected="selected">성별</option>
            <option value="남자">남자</option>
            <option value="여자">여자</option>
          </select>
            <label id="sex_label"></label><br><br>
        <h5>휴대전화</h5>
          <input id="hp" name="hp" placeholder="하이픈(-)기호를 제외하고 숫자만 입력해주세요." onchange="hpCheck()">
            <label id="hp_label"></label><br><br> 
        <h5>주소</h5>
          <input style="width: 395px" type="text" id="zip" name="zip" placeholder="우편번호">
          <input style="width: 100px; height: 40px;" class="btn" type="button" onclick="sample6_execDaumPostcode()" value="검색"><br>
          <input style="width: 248px" type="text" id="addr" name="addr" placeholder="주소">
          <input style="width: 248px" type="text" id="addrDt" name="addrDt" placeholder="상세주소">
            <label id="addr_label"></label><br><br>
            <input type="hidden" id="agreeAd" name="agreeAd" value="동의">
        <label id="join_div_label">&nbsp;선택 입력 정보&nbsp;</label><br><br>
        <h5>경력</h5>
          <input id="career" name="career"><br><br> 
        <h5>메인 포지션</h5>
          <select name="positionMain" id="positionMain">
           <option value="99" selected="selected">희망 포지션</option>
           <option value="1">보컬</option>
           <option value="2">드럼</option>
           <option value="3">일렉기타</option>
           <option value="4">기타</option>
           <option value="5">베이스</option>
           <option value="6">키보드</option>
          </select><br><br> 
        <h5>서브 포지션</h5>
          <select name="positionSub" id="positionSub">
           <option value="99" selected="selected">가능한 세컨 포지션</option>
           <option value="1">보컬</option>
           <option value="2">드럼</option>
           <option value="3">일렉기타</option>
           <option value="4">기타</option>
           <option value="5">베이스</option>
           <option value="6">키보드</option>
           <option value="99">없음</option>
          </select><br><br>  
      </form>
        <input class="btn" type="button" id="btnInsert" value="가입하기"><br>
  </div>
</div>
<%@ include file="../main/footerSimple.jsp" %>
</body>
</html>