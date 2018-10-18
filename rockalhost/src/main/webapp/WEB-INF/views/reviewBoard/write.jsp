<%@ include file="../include/header.jsp" %>
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
	
	$("#btnInsert").click(function() {
		var subject = $("#subject").val();
		var score = $("#score").val();
		var passwd = $("#passwd").val();
		var content = $("#content").val();
		
		if(subject == "") {
			alert("제목을 입력하세요");
			subject.focus();
			return;	
		} 
		if(score == "") {
			alert("평점을 입력하세요");
			score.focus();
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
		document.form1.action="${path}/review/insert.do"
		document.form1.submit();
	});
	
	$("#btnList").click(function(){
		location.href = "${path}/performance/view/${pf_idx}";
	});
});

function checkScore() {
	var score = $("#score").val();
	
	if(score < 1) {
		alert("1점 이상의 점수를 입력해 주세요.");
		score.focus();
		return;
	}
	if(score > 10) {
		alert("10점 이하의 점수를 입력해 주세요.");
		score.focus();
		return;
	}
	
}

</script>

</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50">
<%@ include file="../main/nav.jsp" %>
  <div id="title_div_back">
     <div id="div_title" >
     <br>
     <h1>Review Write</h1>
     </div>
  </div>
  
<div class="container">
	<form name="form1" method="post">
		<table class="table table-hover" border="1">
			<tr>
				<td>닉네임</td>
				<td><input class="form-control" name="writer" id="writer" readonly="readonly" value="${sessionScope.nickName}"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input class="form-control" name="subject" id="subject"></td>
			</tr>
			<tr>
				<td>평점</td>
				<td><input class="form-control" type="number" max="10" min="1" name="score" id="score" 
				placeholder="10 ~ 1 점" value="10" onchange="checkScore()"></td>
			</tr>
			<tr align="center">
				<td colspan="2">
					<textarea rows="5" cols="60" name="content" id="content"></textarea>
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input class="form-control" type="password" name="passwd" id="passwd"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="hidden" name="pf_idx" value="${pf_idx}">
					<input class="btn btn-default" type="button" value="확인" id="btnInsert">
					<input class="btn btn-default" type="button" id="btnList" value="목록">
				</td>
			</tr>
		</table>
	</form>
</div>

<%@ include file="../main/footer.jsp" %>
</body>
</html>