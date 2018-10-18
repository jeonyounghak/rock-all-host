<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rock All Host에 오신걸 환영합니다.</title>
<%@ include file="../include/header.jsp"%>
<script type="text/javascript">
	$(function() {
		$("#btnBack").click(function() {
			document.form1.action="javascript:history.back();";
			document.form1.submit();
		});
		$("#btnHome").click(function() {
			document.form1.action="${path}";
			document.form1.submit();
		});
	});
</script>
<style type="text/css">
div {
	text-align: center;
	margin-top: 150px;
}

h2 {
	color: green;
}


img {
	width: 200px;
	height: 100px;
}

span {
	font-weight: bold;
}



</style>
</head>
<body>
<div>
<img src="${pageContext.request.contextPath}/images/xx.png">
<h3>이용에 불편을 드려 죄송합니다.</h3>
<span>잠시 후에 다시 한번 시도해 주시길 부탁 드립니다.</span><br>
<p>동일한 문제가 지속적으로 발생할 경우<br>
고객센터로 문의하여 주십시오.</p><br>
<form name="form1" method="post">
<input type="button" value="이전 페이지로 가기" id="btnBack" class="btn">
<input type="button" value="Rock All Host 홈으로 가기" id="btnHome" class="btn">
</form>
<%@ include file="../main/footerSimple.jsp" %>
</div>
</body>
</html>