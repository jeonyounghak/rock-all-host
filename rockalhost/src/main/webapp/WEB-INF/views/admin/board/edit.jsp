<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%>
<%@ include file="../../include/header.jsp" %>
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
	
	$("#btnUpdate").click(function() {
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
		document.form1.action="${path}/admin/boardUpdate.do";
		document.form1.submit();
	});
	
	$("#btnList").click(function(){
		location.href="${path}/admin/boardList.do";
	});
	
	$("#btnDelete").click(function() {
		if(confirm("삭제하시겠습니까?")) {
			document.form1.action = "${path}/admin/boardHidden.do";
			document.form1.submit();
		}
	});
	
});
</script>
</head>

<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50">

<c:if test="${comment_message == 'error' }">
	<script>
		alert("댓글 비밀번호가 일치하지 않습니다.");
	</script>
</c:if>

<%@ include file="../../admin/admin_nav.jsp" %>

<div class="container-fluid" style="margin-top: 100px;">
	<div class="row row-offcanvas row-offcanvas-right">
		<%@ include file="boardSidevar.jsp" %>
		<h2>자유게시판 수정</h2>
		        
		<div class="col-xs-10 col-lg-10">
		
		
<form name="form1" id="form1" method="post">
<table class="table table-hover" border="1">
	<tr>
		<td>이름</td>
		<td><input class="form-control" name="writer" id="writer" readonly="readonly" value="${dto.writer}"></td>
	</tr>
	<tr>
		<td>제목</td>
		<td><input class="form-control" name="subject" id="subject" size="60" value="${dto.subject}"></td>
	</tr>
	<tr align="left">
		<td>본문</td>
		<td>
			<textarea rows="5" cols="60" name="content" id="content">${dto.content }</textarea>
		</td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input class="form-control" type="password" name="passwd" id="passwd" size="40"></td>
	</tr>
	<tr align="center">
		<td colspan="2">
			<input class="btn btn-default" type="hidden" name="num" value="${dto.num}">
			<input class="btn btn-default" type="button" value="수정" id="btnUpdate">
			<input class="btn btn-default" type="button" value="삭제" id="btnDelete">
			<input class="btn btn-default" type="button" id="btnList" value="목록">
		</td>
	</tr>
</table>
</form>

		</div>
	</div>
</div>

</body>
</html>