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
		bandProfile();
		listReply();
		$("#btnList").click(function() {
			document.form1.action = "${path}/recruit/list.do";
			document.form1.submit();
		});
		$("#btnEdit").click(function() {
			document.form1.action = "${path}/recruit/edit.do";
			document.form1.submit();
		});
		$("#btnAppl").click(function() {
			var show = "${dto.show}";
			if(show == 'c'){
				alert("모집이 마감되었습니다.");
				return;
			}
			var myGrade = $("#myGrade").val();
			if (myGrade == 1) {
				if (confirm("가입신청 하시겠습니까?")) {
					document.form1.action = "${path}/recruit/appl_check.do";
					document.form1.submit();
					alert("신청이 완료되었습니다.");
				}
			} else {
				alert("일반회원만 가입할 수 있습니다.");
				return;
			}
		});
		$("#btnCheck").click(function() {
			document.form1.action = "${path}/recruit/check/${dto.idx}";
			document.form1.submit();
		});
		$("#btnClose").click(function() {
			if(confirm("마감하시겠습니까?")){
				document.form1.action = "${path}/recruit/close/${dto.idx}";
				document.form1.submit();				
			}
		});
		$("#btnReply").click(function() {
			var replytext = $("#replytext").val(); //댓글 내용
			var idx = "${dto.idx}"; //게시물 번호
			var param = {
				"replytext" : replytext,
				"idx" : idx
			};

			$.ajax({
				type : "post",
				url : "${path}/reply/insert.do",
				data : param,
				success : function() {
					alert("댓글이 등록되었습니다.");
					listReply();
				}
			});
		});
	});

	function bandProfile() {
		$.ajax({
			type : "get",
			url : "${path}/recruit/band_profile.do?writer=${dto.writer}",
			success : function(result) {
				$("#bandProfile").html(result);
			}
		});
	}

	function changeDate(date) {
		date = new Date(parseInt(date));
		year = date.getFullYear();
		month = date.getMonth();
		day = date.getDate();
		hour = date.getHours();
		minute = date.getMinutes();
		second = date.getSeconds();
		strDate = year + "-" + month + "-" + day + " " + hour + ":" + minute
				+ ":" + second;
		return strDate;
	}

	function listReply() {
		$.ajax({
			type : "get",
			contentType : "application/json",
			url : "${path}/reply/list_json.do?idx=${dto.idx}",
			success : function(result) {
				console.log(result);
				var output = "<table>";
				for ( var i in result) {
					var repl = result[i].replytext;

					repl = repl.replace(/  /gi, "&nbsp;&nbsp;");
					repl = repl.replace(/</gi, "&lt;");
					repl = repl.replace(/>/gi, "&gt;");
					repl = repl.replace(/\n/gi, "<br>");

					output += "<tr><td>" + result[i].replyer;
					date = changeDate(result[i].reg_date);
					output += "(" + date + ")";
					output += "<br>" + repl + "</td></tr>";
				}
				output += "</table>";
				$("#listReply").html(output);
			}
		});
	}
	
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
	<c:if test="${message == 'fail'}">
		<script>
			alert("이미 신청하셨습니다.");
		</script>
	</c:if>
	
	<%@ include file="../main/nav.jsp"%>
<br>
     <div id="recruit_div_title" ><br>
     <h1>밴드원 구인</h1>
     <h6>${dto.idx}번 게시글 상세보기</h6>
     </div><br>
	<form name="form1" method="post">
		<input type="hidden" id="myGrade" name="myGrade"
			value="${sessionScope.grade}">
			<c:choose>
				<c:when test="${message2 == null}">
					<a href="${path}/recruit/recommend/${dto.idx}"><img src="${pageContext.request.contextPath}/images/Like free icon 1.jpeg">추천하기</a>
				</c:when>
				<c:when test="${message2 == 'success'}">
					<a href="${path}/recruit/recommend/${dto.idx}"><img src="${pageContext.request.contextPath}/images/Like free icon 1.jpeg">추천하기</a>
				</c:when>
				<c:when test="${message2 == 'fail'}">
					<a href="${path}/recruit/delete_recommend/${dto.idx}"><img src="${pageContext.request.contextPath}/images/Like free icon 2.jpeg">추천하기</a>
				</c:when>
			</c:choose>
		
		
		<table class="table table-hover table-bordered">
			<tr>
				<td>날짜</td>
				<td><fmt:formatDate value="${dto.reg_date}"
						pattern="yyyy-MM-dd HH:mm:ss" /></td>
				<td>조회수</td>
				<td>${dto.readcount}</td>
			</tr>
			<tr>
				<td>이름</td>
				<td colspan="3" class="dropdown"><a href="#"
					class="dropdown-toogle" data-toggle="dropdown" role="button"
					aria-haspopup="true" aria-expanded="false">${dto.writer}<span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="${path}/recruit/profile/${dto.writer}">프로필</a>
						<li><a href="${path}/message/messagewriter.do">쪽지보내기</a>
					</ul></td>
			</tr>
			<tr>
				<td>제목</td>
				<td colspan="3" style="font-weight: bold; color: black;">${dto.subject}</td>
			</tr>
			<tr>
				<td>모집정보</td>
				<td>포지션 : <c:choose>
						<c:when test="${dto.re_position == 1}">
						보컬
					</c:when>
						<c:when test="${dto.re_position == 2}">
						드럼
					</c:when>
						<c:when test="${dto.re_position == 3}">
						일렉기타
					</c:when>
						<c:when test="${dto.re_position == 4}">
						기타
					</c:when>
						<c:when test="${dto.re_position == 5}">
						베이스
					</c:when>
						<c:when test="${dto.re_position == 6}">
						키보드
					</c:when>
					</c:choose><br> 모집인원 : ${dto.re_num}명 <br> 활동지역 : <c:choose>
						<c:when test="${dto.r_area == 1}">
						강남
					</c:when>
						<c:when test="${dto.r_area == 2}">
						강북
					</c:when>
						<c:when test="${dto.r_area == 3}">
						강서
					</c:when>
						<c:when test="${dto.r_area == 4}">
						강동
					</c:when>
						<c:when test="${dto.r_area == 5}">
						현서
					</c:when>
						<c:when test="${dto.r_area == 6}">
						중구
					</c:when>
					</c:choose>
				</td>
			</tr>
			<tr>
				<td>본문</td>
				<td colspan="3" style="font-weight: bold; color: black;">${dto.content}</td>
			</tr>		
			<tr>
				<td colspan="4" align="center">
				<input type="hidden" name="idx" value="${dto.idx}">
					 <c:choose>
						<c:when test="${sessionScope.nickName == dto.writer}">
							<input type="button" value="수정/삭제" id="btnEdit" class="btn">
							<input type="button" value="신청확인" id="btnCheck" class="btn">
							<input type="button" value="모집마감" id="btnClose" class="btn">
							<input type="button" value="목록" id="btnList" class="btn">
						</c:when>
						<c:when test="${sessionScope.id == null}">
							<input type="button" value="목록" id="btnList" class="btn">
						</c:when>
						<c:when test="${sessionScope.id != dto.writer}">
							<input type="button" value="가입신청" id="btnAppl" class="btn">
							<input type="button" value="목록" id="btnList" class="btn">
						</c:when>					
					</c:choose>
			</tr>
		</table>
	</form>
	<div id="bandProfile"></div>
	<div style="width: 100%; text-align: center;">
		<c:if test="${sessionScope.id != null }">
			<textarea rows="5" cols="234" id="replytext" placeholder="댓글을 작성하세요"></textarea>
			<br>
			<button type="button" id="btnReply" class="btn">댓글쓰기</button>
		</c:if>
	</div>
	<div id="listReply"></div>
	<%@ include file="../main/footerSimple.jsp" %>
</body>
</html>