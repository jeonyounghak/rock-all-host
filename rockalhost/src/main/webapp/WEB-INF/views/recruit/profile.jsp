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
			document.form1.action="${path}/recruit/list.do";
			document.form1.submit();
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

</style>
</head>
<body>
<%@ include file="../main/nav.jsp" %>
<br>
     <div id="recruit_div_title" ><br>    
	 <h2>회원정보</h2>
     <h6>게시글 작성자 프로필</h6>
     </div>
     <div style="text-align: left; margin: 1%;">
     <h5 style="font-weight: bold;">이 용 방 법</h5>
     <h6>1. 일반회원님은 게시글을 작성한 밴드장님의 프로필을 확인해주세요.<br><br>
     2. 밴드가입을 희망하시는 일반회원님은 게시글로 돌아가서 가입신청을 눌러주세요.</h6></div>
<table border="1" style="width: 100%" class="table table-hover">
	<tr>
		<th>가입밴드</th>
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
		<td>${dto.myBand}</td>
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
	</tr>
</table>
	<form name="form1" method="post">
	<input type="button" value="목록" id="btnList" style="text-align: center;" class="btn">
	</form>
</body>
</html>