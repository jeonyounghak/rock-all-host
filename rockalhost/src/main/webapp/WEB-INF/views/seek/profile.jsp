<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rock All Host에 오신걸 환영합니다.</title>
<%@ include file="../include/header.jsp" %>
<script>
	$(function() {
		$("#btnList").click(function(){
			document.form1.action="${path}/seek/list.do";
			document.form1.submit();
		});
	});
</script>

</head>
<body>
<%@ include file="../main/nav.jsp" %>
<h2>회원정보</h2>
<table border="1" style="width: 1200px" class="table table-hover">
	<tr>
		<th>아이디</th>
		<th>이름</th>
		<th>이메일</th>
		<th>닉네임</th>
		<th>생년월일</th>
		<th>성별</th>
		<th>전화번호</th>
		<th>주소</th>
		<th>경력</th>
		<th>주포지션</th>
		<th>서브포지션</th>
		<th>밴드등급</th>
	</tr>
	<tr>
		<td>${dto.id}</td>
		<td>${dto.name}</td>
		<td>${dto.email}</td>
		<td>${dto.nickName}</td>
		<td>${dto.birth}</td>
		<td>${dto.sex}</td>
		<td>${dto.hp}</td>
		<td>${dto.addr}</td>
		<td>${dto.career}년</td>
		<td>
		<c:choose>
					<c:when test="${dto.positionMain == 1}">
						보컬
					</c:when>
					<c:when test="${dto.positionMain == 2}">
						드럼
					</c:when>
					<c:when test="${dto.positionMain == 3}">
						일렉기타
					</c:when>
					<c:when test="${dto.positionMain == 4}">
						기타
					</c:when>
					<c:when test="${dto.positionMain == 5}">
						베이스
					</c:when>
					<c:when test="${dto.positionMain == 6}">
						키보드
					</c:when>
				</c:choose>
		</td>
		<td>
		<c:choose>
					<c:when test="${dto.positionSub == 1}">
						보컬
					</c:when>
					<c:when test="${dto.positionSub == 2}">
						드럼
					</c:when>
					<c:when test="${dto.positionSub == 3}">
						일렉기타
					</c:when>
					<c:when test="${dto.positionSub == 4}">
						기타
					</c:when>
					<c:when test="${dto.positionSub == 5}">
						베이스
					</c:when>
					<c:when test="${dto.positionSub == 6}">
						키보드
					</c:when>
				</c:choose>
		</td>
		<td>
		<c:choose>
			<c:when test="${dto.myGrade == 1}">일반회원</c:when>
			<c:when test="${dto.myGrade == 2}">밴드원</c:when>
			<c:when test="${dto.myGrade == 3}">밴드장</c:when>
		</c:choose>
		</td>
	</tr>
</table>
	<form name="form1" method="post">
	<input type="button" value="목록" id="btnList" style="text-align: center;" class="btn">
	</form>
</body>
</html>