<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rock All Host에 오신걸 환영합니다.</title>
<%@ include file="../../include/header.jsp"%>
<script>
	$(function() {
		bandProfile();
		listReply();
		$("#btnList").click(function() {
			document.form1.action = "${path}/admin/recruit_list.do";
			document.form1.submit();
		});
		$("#btnDelete").click(function() {
			document.form1.action="${path}/admin/recruit_delete.do";
			document.form1.submit();
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

	function bandProfile() {
		$.ajax({
			type : "get",
			url : "${path}/recruit/band_profile.do?writer=${dto.writer}",
			success : function(result) {
				$("#bandProfile").html(result);
			}
		});
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
</head>
<body>

	<%@ include file="../admin_nav.jsp" %>
	<div class="container" style="width: 1300px">
	<h2>게시판 뷰 페이지</h2>
	<form name="form1" method="post">
		<input type="hidden" id="myGrade" name="myGrade"
			value="${sessionScope.myGrade}">
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
				<td>${dto.writer}</td>			
			</tr>
			<tr>
				<td>제목</td>
				<td colspan="3">${dto.subject}</td>
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
					</c:choose><br> 마감일자 : <%-- ${dto.close_date} --%>
				</td>
			</tr>
			<tr>
				<td>본문</td>
				<td colspan="3">${dto.content}</td>
			</tr>

			<tr>
				<td colspan="4" align="center">
				<input type="hidden" name="idx" value="${dto.idx}">
				<input type="button" value="목록" id="btnList" class="btn">
				<input type="button" value="삭제" id="btnDelete" class="btn">
			</tr>
		</table>
	</form>
	<div id="bandProfile"></div>
	<div style="width: 700px; text-align: center;">
		<c:if test="${sessionScope.id != null }">
			<textarea rows="5" cols="80" id="replytext" placeholder="댓글을 작성하세요"></textarea>
			<br>
			<button type="button" id="btnReply" class="btn">댓글쓰기</button>
		</c:if>
	</div>
	<div id="listReply"></div>
	</div>
	
</body>
</html>