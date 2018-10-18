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
		<td colspan="2" style="text-align: center">밴드 정보</td>
	</tr>
	<tr>
		<td>밴드장닉네임</td>
		<td>${dto.b_leaderNick}</td>
	</tr>
	<tr>
		<td>밴드명</td>
		<td>${dto.b_name}</td>
	</tr>
		<td>밴드인원</td>
		<td>${dto.b_num}명</td>
	<tr>
		<td>밴드장르</td>
		<td>
		<c:choose>
			<c:when test="${dto.b_genre == 1}">
				발라드
			</c:when>
			<c:when test="${dto.b_genre == 2}">
				힙합
			</c:when>
			<c:when test="${dto.b_genre == 3}">
				알앤비
			</c:when>
			<c:when test="${dto.b_genre == 4}">
				재즈
			</c:when>
			<c:when test="${dto.b_genre == 5}">
				록
			</c:when>
			<c:when test="${dto.b_genre == 6}">
				포크
			</c:when>
		</c:choose>
		</td>
	</tr>
	<tr>
		<td>활동지역</td>
		<td>
			<c:choose>
				<c:when test="${dto.b_area == 1}">
					강남
				</c:when>
				<c:when test="${dto.b_area == 2}">
					강동		
				</c:when>
				<c:when test="${dto.b_area == 3}">
					강북		
				</c:when>
				<c:when test="${dto.b_area == 4}">
					강서		
				</c:when>
				<c:when test="${dto.b_area == 5}">
					송파		
				</c:when>
				<c:when test="${dto.b_area == 6}">
					성남		
				</c:when>			
			</c:choose>	
		</td>	
	</tr>
	<tr>
		<td>밴드소개</td>
		<td>${dto.description}</td>
	</tr>
</table>
</body>
</html>