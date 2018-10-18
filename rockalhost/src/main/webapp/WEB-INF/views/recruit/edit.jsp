<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rock All Host에 오신걸 환영합니다.</title>
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 


<link href="${path}/summernote/summernote.css" rel="stylesheet">
<script src="${path}/summernote/summernote.js"></script>
<script>
$(function() {
	$("#btnSave").click(function() {
		var writer = $("#writer");
		var subject = $("#subject");
		var passwd = $("#passwd");
		var content = $("#content");
		var re_position = $("#re_position");
		var re_num = $("#re_num");
		var r_area = $("#r_area");
		var close_date = $("#close_date");
		var id = $("#id");
		
		if(writer.val() == "") {
			alert("이름을 입력하세요");
			writer.focus();
			return;
		} if(subject.val() == "") {
			alert("제목을 입력하세요");
			email.focus();
			return;		
		} if(content.val() == "") {
			alert("내용을 입력하세요");
			content.focus();
			return;
		} if(passwd.val() == "") {
			alert("비밀번호를 입력하세요");
			passwd.focus();
			return;
		} if(re_position.val() == "0"){
			alert("포지션을 선택하세요");
			position.focus();
			return;
		} if(re_num.val() == "0"){
			alert("모집인원을 선택하세요");
			rnum.focus();
			return;
		} if(r_area.val() == "0"){
			alert("활동지역을 선택하세요");
			area.focus();
			return;
		/* } if(close_date.val() == null){
			alert("마감날짜를 선택하세요");
			close_date.focus();
			return; */
		} 
		document.form1.action="${path}/recruit/update.do";
		document.form1.submit();
	});
	$("#btnDelete").click(function() {
		document.form1.action="${path}/recruit/delete.do";
		document.form1.submit();
	});
	
	$("#btnList").click(function(){
		location.href="${path}/recruit/list.do";
	});
	$("#content").summernote({
		height : 150,
		width : 600
	});
});
</script>
<style type="text/css">
#recruit_div_title{
background-color: black;
height: 145px;
color: white;
text-shadow: 1px 2px 1px gray;
text-align: center;
margin-top: 23px;
}

#recruit_write select{
width: 400px;
height: 30px;
}
#recruit_write_button{
text-align: center;
}
</style>
</head>
<body>
<%@ include file="../main/nav.jsp" %>
<br>
     <div id="recruit_div_title" ><br>
     <h1>게시글 수정</h1>
     <h6>${dto.idx}번 게시글 수정하기</h6>
     </div>
<form name="form1" method="post">
 <div id="recruit_write"> 
<table style="width: 100%" class="table table-hover table-bordered">
	<tr>
		<td style="width: 300px;">제목</td>
		<td><input name="subject" id="subject" size="200" value="${dto.subject}"></td>
	</tr>
	<tr>
		<td>모집정보</td>
		<td>
			<select name="re_position" id="re_position">
				<option value="0">-- 포지션 --</option>
				<option value="1">보컬</option>
				<option value="2">드럼</option>
				<option value="3">일렉기타</option>
				<option value="4">기타</option>
				<option value="5">베이스</option>
				<option value="6">키보드</option>
			</select><br>
			<select name="re_num" id="re_num">
				<option value="0">-- 모집인원 --</option>
				<c:forEach begin="1" end="8" var="i">
               	<option value="${i}">${i}</option>
             	</c:forEach>
			</select><br>
			<select name="r_area" id="r_area">
				<option value="0">-- 활동지역 --</option>
				<option value="1">서울</option>
				<option value="2">경기</option>
				<option value="3">강원</option>
				<option value="4">충청북도</option>
				<option value="5">충청남도</option>
				<option value="6">전라북도</option>
			</select><br>
		</td>
	</tr>
	<tr>
		<td>본문</td>
		<td>
			<textarea rows="7" cols="199" name="content" id="content">${dto.content}<br>
			------- 본문 내용 --------
			</textarea>
		</td>
	</tr>
</table>
</div>
<div id="recruit_write_button">
<input type="hidden" name="type" value="1">
			<input type="button" value="확인" id="btnSave" class="btn">
			<input type="button" value="삭제" id="btnDelete" class="btn">
			<input type="button" id="btnList" value="목록" class="btn">		
			<input type="hidden" name="idx" value="${dto.idx}">
</div>
</form>
</body>
</html>