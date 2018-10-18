<%@ include file="../include/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rock All Host에 오신걸 환영합니다.</title>
<script>

$(function() {
	pf_reviewList();
	comment_list();
	
	$("#btnSave").click(function() {
		if($("#writer").val()=="") {
			alert("이름을 입력하세요");
			writer.focus();
			return;
		}
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
	
	$("#btnList").click(function() {
		location.href = "${path}/performance/view/${pf_idx}";
	});
	
});

function pf_reviewList() {
	$.ajax({
		type: "post",
		url: "${path}/review/tabList.do",
		data: "pf_idx=${pf_idx}&curPage=${curPage}&num=${dto.num}",
		success: function(result) {
			$("#review").html(result);
		}
	});
}

function comment_list() {
	var param = "num=${dto.num}&pf_idx=${pf_idx}";
	
	$.ajax({
		type: "post",
		url: "${path}/review/commentList.do",
		data: param,
		success: function(result) {
			$("#commentList").html(result);
		}
	});
}

function commentInsert() {
	var param = "board_num=${dto.num}&passwd="+$("#comment_passwd").val()+"&writer="
	+$("#writer").val()+"&content="+$("#content").val()+"&pf_idx=${pf_idx}";
	$.ajax({
		type: "post",
		url: "${path}/review/commentInsert.do",
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

<%@ include file="../main/nav.jsp" %>
  <div id="title_div_back">
     <div id="div_title" >
     <br>
     <h1>Review View</h1>
     </div>
  </div>

<div class="container">

	<form name="form1" method="post" action="${path}/review/passwdCheck.do">
	<table class="table table-hover" border="1">
		<tr>
			<td>${dto.writer}</td>
			<td>${dto.subject}</td>
			<td>
				<fmt:formatDate value="${dto.reg_date}" pattern="YYYY-MM-dd"/>
			</td>
			<td>평점</td>
			<td>${dto.score}</td>
			<td>조회수</td>
			<td>${dto.readcount}</td>
		</tr>
		<tr>
			<td colspan="7" style="height: 400px;">${dto.content}</td>
		</tr>
		<tr>
			<td style="width: 99px;">비밀번호</td>
			<td colspan="6">
				<input class="form-control" type="password" name="passwd" id="passwd">
				<c:if test="${message == 'error' }">
					<span style="color: red;">비밀번호가 일치하지 않습니다.</span>
				</c:if>
			</td>
		</tr>
		<tr>
			<td colspan="7" align="center">
				<input type="hidden" name="num" value="${dto.num}">
				<input type="hidden" name="pf_idx" value="${pf_idx}">
				<input class="btn btn-default" type="submit" id="btnEdit" value="수정/삭제">
				<input class="btn btn-default" type="button" id="btnList" value="목록">
			</td>
		</tr>
	</table>
	</form>
	
	<table class="table table-hover" border="1">
		<tr>
			<td>
				<input class="form-control" id="writer" readonly="readonly" value="${sessionScope.nickName}">
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
	
	<div id="review"></div>
</div>

<%@ include file="../main/footer.jsp" %>
</body>
</html>