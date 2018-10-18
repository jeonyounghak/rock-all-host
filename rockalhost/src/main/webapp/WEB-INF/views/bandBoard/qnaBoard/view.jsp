<%@ include file="../../include/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rock All Host에 오신걸 환영합니다.</title>
<script>

$(function() {
	$("#btnReply").click(function(){
		document.form1.action="${path}/bandBoard/qbReply.do";
		document.form1.submit();
	});
	
	$("#btnList").click(function(){
		location.href="${path}/bandBoard/qbList.do?curPage=${curPage}&b_idx=${b_idx}";
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

<%@ include file="../../main/nav.jsp" %>
  <div id="title_div_back">
     <div id="div_title" >
     <br>
     <h1>Band Q & A View</h1>
     </div>
  </div>

<div class="container-fluid">
	<div class="row row-offcanvas row-offcanvas-right">
		<%@ include file="../../band/bandsidevar.jsp" %>        
		<div class="col-xs-10 col-lg-10">
					
	<form name="form1" method="post" action="${path}/bandBoard/qbPasswdCheck.do">
	<table class="table table-hover" style="margin-top: 30px; width: 930px;" border="1">
		<tr>
			<td>${dto.writer}</td>
			<td>[ ${pf_title} ] ${dto.subject}</td>
			<td>
				<fmt:formatDate value="${dto.reg_date}" pattern="YYYY-MM-dd"/>
			</td>
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
				<input type="hidden" name="b_idx" value="${b_idx}">
				<input type="hidden" name="pf_idx" value="${dto.pf_idx}">
				
				<input class="btn btn-default" type="submit" value="수정/삭제">
        		<input class="btn btn-default" type="button" id="btnReply" value="답변">
				<input class="btn btn-default" type="button" id="btnList" value="목록">
			</td>
		</tr>
	</table>
	</form>
	
		</div>
	</div>
</div>

<%@ include file="../../main/footer.jsp" %>
</body>
</html>