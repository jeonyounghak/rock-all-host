<%@ include file="../include/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rock All Host에 오신걸 환영합니다.</title>

<link href="${path}/summernote/summernote.css" rel="stylesheet">
<script src="${path}/summernote/summernote.js"></script>

<script>
$(function() {
	$("#content").summernote({
		toolbar: [
		// [groupName, [list of button]]
		['style', ['bold', 'italic', 'underline', 'clear']],
		['font', ['strikethrough', 'superscript', 'subscript']],
		['fontsize', ['fontsize']],
		['color', ['color']],
		['para', ['ul', 'ol', 'paragraph']],
		['height', ['height']]
		],
		height : 600,
		width : 911,
		focus: true
	
	});

	
	$("#btnSave").click(function() {
		var writer = $("#writer");
		var pf_title = $("#pf_title");
		var gn_idx = $("#gn_idx");
		var ar_idx = $("#ar_idx");
		var pf_location = $("#pf_location");
		var pf_seats = $("#pf_seats");
		var pf_date = $("#pf_date");
		var pf_time = $("#pf_time");
		var pf_runningTime = $("#pf_runningTime");
		var imgFile = $("#imgFile");
		var content = $("#content");
		
		if(writer.val() == "") {
			alert("이름을 입력하세요.");
			writer.focus();
			return;
		}
		if(pf_title.val() == "") {
			alert("공연 타이틀을 입력하세요.");
			pf_title.focus();
			return;
		}
		if(gn_idx.val() == "") {
			alert("장르를 선택하세요.");
			gn_idx.focus();
			return;
		}
		if(ar_idx.val() == "") {
			alert("지역을 선택하세요.");
			ar_idx.focus();
			return;
		}
		if(pf_location.val() == "") {
			alert("공연장소를 입력하세요.");
			pf_location.focus();
			return;
		}
		if(pf_seats.val() == "") {
			alert("좌석수를 선택하세요.");
			pf_seats.focus();
			return;
		}
		if(pf_date.val() == "") {
			alert("공연일자를 선택하세요.");
			pf_date.focus();
			return;
		}
		checkPf_date();
		if(pf_time.val() == "") {
			alert("공연시작 시간을 입력하세요");
			pf_time.focus();
			return;
		}
		if(pf_runningTime.val() == "") {
			alert("총 공연 시간을 입력하세요.");
			pf_runningTime.focus();
			return;
		}
		if(imgFile.val() == "") {
			alert("공연포스터를 첨부하세요.");
			imgFile.focus();
			return;
		}
		if(content.val() == "") {
			alert("공연내용을 작성하세요.");
			content.focus();
			return;
		}
		document.form1.action="${path}/performance/insert.do";
		document.form1.submit();
	});
	
	$("#btnList").click(function(){
		location.href="${path}/performance/list.do";
	});

	
});

function checkPf_date() {
	   
	function getToday() {
		var today = new Date();
		var year = today.getFullYear();
		var month = today.getMonth()+1;
		var day = today.getDate();
          
		if(month<10) month = "0"+month;
		if(day<10) day = "0"+day;
          
		var today = year+"-"+month+"-"+day;
		return today;
	}
   
	var pf_date = $("#pf_date").val();
	
	if(getToday() > pf_date) {
		alert("유효한 날짜가 아닙니다, 다시 확인해주세요.");
		pf_date.focus();
		return;
	}
}
</script>
<style type="text/css">
#performance_write_title{
background-color: black;
height: 145px;
color: white;
text-shadow: 1px 2px 1px gray;
text-align: center;
margin-top: 23px;
}
.container select {
	height: 35px;
	width: 200px;
}	

</style>

</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50">
<%@ include file="../main/nav.jsp" %>

<div class="container">
<form name="form1" method="post" enctype="multipart/form-data">
<table class="table table-hover" border="1">
	<tr>
		<td>글쓴이</td>
		<td><input class="form-control" name="writer" id="writer" readonly="readonly" 
		value="${sessionScope.nickName}"></td>
	</tr>
	<tr>
		<td>밴드이름</td>
		<td>
			<input class="form-control" readonly="readonly" value="${sessionScope.band_name}">
			<input class="form-control" type="hidden" name="b_idx" id="b_idx" value="${sessionScope.band}">
		</td>
	</tr>
	<tr>
		<td>공연 타이틀</td>
		<td><input class="form-control" name="pf_title" id="pf_title"></td>
	</tr>
 	<tr>
		<td>음악장르</td>
		<td>
			<select name="gn_idx" id="gn_idx">
				<option value="" selected="selected">장르를 선택해주세요.</option>
				<option value="1">발라드</option>
				<option value="2">힙합</option>
				<option value="3">알앤비</option>
				<option value="4">재즈</option>
				<option value="5">록</option>
				<option value="6">포크</option>
			</select>
		</td>
	</tr>
	<tr>
		<td>지역</td>
		<td>
			<select name="ar_idx" id="ar_idx">
				<option value="" selected="selected">지역을 선택해주세요.</option>
				<option value="1">강남</option>
				<option value="2">강동</option>
				<option value="3">강북</option>
				<option value="4">강서</option>
				<option value="5">송파</option>
				<option value="6">성남</option>
			</select>
		</td>
	</tr>
	<tr>
		<td>장소</td>
		<td><input class="form-control" name="pf_location" id="pf_location"></td>
	</tr>
	<tr>
		<td>초대좌석수</td>
		<td>
			<select name="pf_seats" id="pf_seats">
				<option value="0" selected="selected">좌석수를 선택해주세요.</option>
				<c:forEach begin="0" end="70" var="i">
					<option value="${i}">${i}</option>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr>
		<td>공연날짜</td>
		<td><input type="date" name="pf_date" id="pf_date" onchange="checkPf_date()"></td>
	</tr>
	<tr>
		<td>공연 시작시간</td>
		<td><input type="text" class="form-control" name="pf_time" id="pf_time" placeholder="ex) 오후 9시 30분"></td>
	</tr>
	<tr>
		<td>관람시간</td>
		<td><input type="text" class="form-control" name="pf_runningTime" id="pf_runningTime" placeholder="ex) 100분"></td>
	</tr>
	<tr>
		<td>공연 포스터(필수)</td>
		<td>
			<input type="file" name="imgFile" id="imgFile">
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<textarea rows="20" cols="100" name="content" id="content"></textarea>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input class="btn btn-default" type="button" id="btnSave" value="등록">
			<input class="btn btn-default" type="button" id="btnList" value="목록">
		</td>
	</tr>
</table>
</form>
</div>

<%@ include file="../main/footer.jsp" %>
</body>
</html>