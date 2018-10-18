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
	
	$("#btnSave").click(function() {
		document.form1.submit();
	});
	
	$("#btnList").click(function(){
		location.href="${path}/admin/boardList.do";
	});
});
</script>
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50">
<%@ include file="../../admin/admin_nav.jsp" %>

<div class="container-fluid" style="margin-top: 100px;">
	<div class="row row-offcanvas row-offcanvas-right">
		<%@ include file="boardSidevar.jsp" %>
		<h2>자유게시판 답글</h2>
		        
		<div class="col-xs-10 col-lg-10">
		
		
<form name="form1" method="post" action="${path}/admin/boardInsertReply.do">
<table class="table table-hover" border="1">
	<tr>
		<td>이름</td>
		<td><input class="form-control" name="writer" id="writer" readonly="readonly" value="관리자"></td>
	</tr>
	<tr>
		<td>제목</td>
		<td><input class="form-control" name="subject" id="subject" size="60" value="Re: ${dto.subject }"></td>
	</tr>
	<tr>
		<td>본문</td>
		<td>
			<textarea class="form-control" rows="5" cols="60" name="content" id="content">${dto.content}</textarea>
		</td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input class="form-control" type="password" name="passwd" id="passwd"></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="hidden" name="num" value="${dto.num}">
			<input class="btn btn-default" type="button" value="확인" id="btnSave">
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