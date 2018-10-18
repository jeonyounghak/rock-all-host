<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rock All Host에 오신걸 환영합니다.</title>
<script>

$(function() {
	comment_list();
	
	$("#btnSave").click(function() {
		if($("#comment_passwd").val()=="") {
            alert("비밀번호를 입력하세요");
            comment_passwd.focus();
            return;
         }
		if($("#content").val()=="") {
			alert("내용을 입력하세요");
			content.focus();
			return;
		} 
		commentInsert();
	});
	
	$("#btnReply").click(function(){
		document.form1.action="${path}/admin/boardReply.do";
		document.form1.submit();
	});
	
	$("#btnList").click(function(){
		location.href="${path}/admin/boardList.do?curPage=${curPage}";
	});
	
});

function comment_list() {
	$.ajax({
		type: "post",
		url: "${path}/admin/boardCommentList.do",
		data: "num=${dto.num}",
		success: function(result) {
			$("#commentList").html(result);
		}
	});
}

function commentInsert() {
	var param = "board_num=${dto.num}&passwd="+$("#comment_passwd").val()+"&writer="
	+$("#writer").val()+"&content="+$("#content").val();
	$.ajax({
		type: "post",
		url: "${path}/admin/boardCommentInsert.do",
		data: param,
		success: function(result) {
			$("#comment_passwd").val("");
			$("#content").val("");
			comment_list();
		}
	});
}
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
		<h2>자유게시판 상세보기</h2>
		        
		<div class="col-xs-10 col-lg-10">
		
		
<form name="form1" method="post" action="${path}/admin/boardPasswdCheck.do">

	<table class="table table-hover" style="width: 930px;" border="1">
	<tr>
		<td style="width: 99px;">날짜</td>
		<td>${dto.reg_date }</td>
		<td style="width: 99px;">조회수</td>
		<td>${dto.readcount }</td>
	</tr>
	<tr>
		<td style="width: 99px;">이름</td>
		<td colspan="3">${dto.writer }</td>
	</tr>
	<tr>
		<td style="width: 99px;">제목</td>
		<td colspan="3">${dto.subject }</td>
	</tr>
	<tr>
		<td style="height: 100px">본문</td>
		<td colspan="3">${dto.content }</td>
	</tr>
	<tr>
		<td style="width: 99px;">비밀번호</td>
		<td colspan="3">
			<input class="form-control" type="password" name="passwd" id="passwd">
			<c:if test="${message == 'error' }">
				<span style="color: red;">비밀번호가 일치하지 않습니다.</span>
			</c:if>
		</td>
	</tr>
	<tr>
		<td colspan="4" align="center">
			<input type="hidden" name="num" value="${dto.num}">
			<input class="btn btn-default" type="submit" id="btnEdit" value="수정/삭제">
			<input class="btn btn-default" type="button" id="btnReply" value="답변">
			<input class="btn btn-default" type="button" id="btnList" value="목록">
		</td>
	</tr>
</table>
</form>

	<table class="table table-hover" style="width: 930px;" border="1">
		<tr>
			<td>
				<input class="form-control" id="writer" readonly="readonly" value="관리자">
				<input class="form-control" id="comment_passwd" type="password" placeholder="비밀번호"> 
			</td>
		</tr>
		<tr>
			<td align="center">
				<textarea style="" rows="5" cols="80" id="content" placeholder="내용을 입력하세요."></textarea>
			</td>
		</tr>
		<tr>
			<td align="center">
				<button class="btn btn-default" id="btnSave" type="button">확인</button>
			</td>
		</tr>
	</table>

<div id="commentList"></div>

		</div>
	</div>
</div>

</body>
</html>