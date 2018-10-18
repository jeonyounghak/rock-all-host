<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rock All Host에 오신걸 환영합니다.</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<table class="table table-striped" style="width: 100%;">
	<tr>
		<td colspan="2" style="text-align: center">회원 정보</td>
	</tr>
	<tr>
		<td style="width:240px;">아이디</td>
		<td style="font-weight: bold; color: black;">${dto.id}</td>
	</tr>
	<tr>
		<td>이름</td>
		<td>${dto.name}</td>
	</tr>
	<tr>
		<td>닉네임</td>
		<td style="font-weight: bold; color: black;">${dto.nickName}</td>
	</tr>
	<tr>
		<td>이메일</td>
		<td>${dto.email}</td>
	</tr>
	<tr>
		<td>생년월일</td>
		<td>${dto.birth}</td>
	</tr>
	<tr>
		<td>성별</td>
		<td>${dto.sex}</td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td>${dto.hp}</td>
	</tr>
	<tr>
		<td>주소</td>
		<td>${dto.addr}</td>
	</tr>
	<tr>
		<td>경력</td>
		<td style="font-weight: bold; color: black;">${dto.career}</td>
	</tr>
	<tr>
		<td>주포지션</td>
		<td style="font-weight: bold; color: black;"><c:choose>
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
				</c:choose></td>
	</tr>
	<tr>
		<td>서브포지션</td>
		<td><c:choose>
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
				</c:choose></td>
	</tr>
</table>
</body>
</html>