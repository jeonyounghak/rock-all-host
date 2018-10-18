<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rock All Host에 오신걸 환영합니다.</title>

<link href="${path}/summernote/summernote.css" rel="stylesheet">
<script src="${path}/summernote/summernote.js"></script>

<script>
$(function() {
	$("#content").summernote({
		toolbar: [
		    // [groupName, [list of button]]
		    ['style', ['bold', 'italic', 'underline', 'clear']],
		    ['font', ['strikethrough', 'superscript', 'subscript']],
		    ['fontsize', ['fontsize']],
		    ['color', ['color']],
		    ['para', ['ul', 'ol', 'paragraph']],
		    ['height', ['height']]
		  ],
		height : 600,
		width : 800
	});
	
	$("#btnSave").click(function() {
		var subject = $("#subject");
		var passwd = $("#passwd");
		var content = $("#content");
		
		if(subject.val() == "") {
			alert("제목을 입력하세요");
			subject.focus();
			return;		
		} 
		if(content.val() == "") {
			alert("내용을 입력하세요");
			content.focus();
			return;
		} 
		if(passwd.val() == "") {
			alert("비밀번호를 입력하세요");
			passwd.focus();
			return;
		}
		document.form1.submit();
	});
	
	$("#btnList").click(function(){
		location.href="${path}/board/list.do";
	});
});
</script>
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50">
<%@ include file="../main/nav.jsp" %>
  <div id="title_div_back">
     <div id="div_title" >
     <br>
     <h1>자유게시판 글쓰기</h1>
     </div>
  </div>
  
<div class="container">
<form name="form1" method="post" action="${path}/board/insert.do">
<table class="table table-hover" border="1">
	<tr>
		<td>이름</td>
		<td><input class="form-control" name="writer" id="writer" readonly="readonly" value="${sessionScope.nickName}"></td>
	</tr>
	<tr>
		<td>제목</td>
		<td><input class="form-control" name="subject" id="subject" size="60"></td>
	</tr>
	<tr>
		<td>본문</td>
		<td>
			<textarea rows="5" cols="60" name="content" id="content"></textarea>
		</td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input class="form-control" type="password" name="passwd" id="passwd"></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input class="btn btn-default" type="button" value="확인" id="btnSave"><input class="btn btn-default" type="button" id="btnList" value="목록">
		</td>
	</tr>
</table>
</form>
</div>

<%@ include file="../main/footer.jsp" %>
</body>
</html>