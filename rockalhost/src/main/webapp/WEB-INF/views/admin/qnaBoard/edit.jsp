<%@ include file="../../include/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		var subject = $("#subject").val();
		var passwd = $("#passwd").val();
		var content = $("#content").val();
		
		if(subject == "") {
			alert("제목을 입력하세요");
			subject.focus();
			return;
		}
		if(content == "") {
			alert("내용을 입력하세요");
			content.focus();
			return;
		}
		if(passwd == "") {
			alert("비밀번호를 입력하세요");
			passwd.focus();
			return;
		}
		document.form1.action="${path}/admin/qbUpdate.do";
		document.form1.submit();
	});
	
	$("#btnDelete").click(function(){
		if(confirm("삭제하시겠습니까?")) {
			document.form1.action = "${path}/admin/qbHidden.do";
			document.form1.submit();
		}
	});
	
	$("#btnList").click(function(){
		location.href="${path}/admin/qbList.do";
	});
});


</script>

</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50">
<%@ include file="../../admin/admin_nav.jsp" %>

<div class="container-fluid">
	<div class="row row-offcanvas row-offcanvas-right">
		<%@ include file="qnaSidevar.jsp" %>
		<h2>질문게시판 수정</h2>
		       
		<div class="col-xs-10 col-lg-10">
		
		<form name="form1" method="post">
		<table class="table table-hover" style="width: 930px;" border="1">
			<tr>
				<td>닉네임</td>
				<td><input class="form-control" name="writer" id="writer" readonly="readonly" value="${dto.writer}"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input class="form-control" name="subject" id="subject" value="${dto.subject}"></td>
			</tr>
			<tr>
				<td colspan="2">
					<textarea rows="5" cols="60" name="content" id="content">${dto.content}</textarea>
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input class="form-control" type="password" name="passwd" id="passwd"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="hidden" name="num" value="${dto.num}">
					
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