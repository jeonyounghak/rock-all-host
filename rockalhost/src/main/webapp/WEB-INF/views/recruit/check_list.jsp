<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rock All Host에 오신걸 환영합니다.</title>
<%@ include file="../include/header.jsp"%>
<script>
	$(function() {
		$("#btnList").click(function(){
			document.form2.action="${path}/recruit/list.do";
			document.form2.submit();
		});
		$("#btnApp").click(function() {
			alert("가입승인 되었습니다.");
		});
		$("#btnRefuse").click(function() {
			alert("가입거절 되었습니다.");
		});
	});
</script>
<style type="text/css">
#recruit_div_title{
background-color: black;
height: 145px;
color: white;
text-shadow: 1px 2px 1px gray;
text-align: center;
margin-top: 23px;
}
#recruit_write_button{
text-align: center;
}
</style>
</head>
<body>
<%@ include file="../main/nav.jsp" %>
<br>
     <div id="recruit_div_title" ><br>
     <h1>가입신청확인</h1>
     <h6>밴드 가입신청 확인 페이지</h6>
     </div>
     <div style="text-align: left; margin: 1%;">
     <h5 style="font-weight: bold;">이 용 방 법</h5>
     <h6>1. 밴드장님은 가입을 희망하는 일반회원님의 프로필을 확인해주세요.<br><br>
     2. 가입을 승인하려면 가입승인 버튼을, 거절하시려면 가입거절 버튼을 눌러주세요.</h6></div>
	<table border="1" style="width: 100%" class="table table-hover">
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
			<th>등급</th>
			<th>승인</th>
		</tr>
		<c:forEach var="dto" items="${map.list}">
			<form name="form1" method="post" action="${path}/recruit/appr.do">
			<tr>
				<td>${dto.id}</td>
				<td>${dto.name}</td>
				<td>${dto.email}</td>
				<td>${dto.nickName}</td>
				<td>${dto.birth}</td>
				<td>${dto.sex}</td>
				<td>${dto.hp}</td>
				<td>${dto.addr}</td>
				<td>${dto.career}</td>
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
				<td><input type="hidden" name="id" value="${dto.id}">
					<input type="hidden" name="idx" value="${map.idx}">
					<input type="submit" id="btnApp" value="가입승인" class="btn">
					<input type="submit" id="btnRefuse" value="가입거절" class="btn">  
				</td>
			</tr>
			</form>
	</c:forEach>
	</table>
	<div id="recruit_write_button">
	<form name="form2" method="post">
	<input type="button" value="목록" id="btnList" class="btn">
	</form>
	</div>
</body>
</html>