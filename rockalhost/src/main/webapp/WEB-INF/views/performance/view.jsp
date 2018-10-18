<%@ include file="../include/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rock All Host에 오신걸 환영합니다.</title>

<c:if test="${param.message == 'doubleInvi'}">
  <script>
    alert("이미 신청한 공연입니다.");
  </script>
</c:if>

<script type="text/javascript">
$(function() {
	pf_qnaList();
	pf_reviewList();
	
	$("#btnList").click(function() {
		location.href="${path}/performance/list.do";
	});
			
	$("#btnInvitation").click(function() {
		var count = document.getElementById("count").value;
				
		if(count != 0) {
			if(confirm(count+"장을 신청하시겠습니까?")) {
				document.form1.action="${path}/invitation/insert.do";
				document.form1.submit();
			}
		}else {
			alert("수량을 선택해주세요.");
			document.form1.count.focus();
			return;
		}
	});
			
	$("#btnDonation").click(function(){
		document.form1.action="${path}/donation/donation.do";
		document.form1.submit();
	});
	
	function pf_reviewList() {
		$.ajax({
			type: "post",
			url: "${path}/review/tabList.do",
			data: "pf_idx=${dto.pf_idx}",
			success: function(result) {
				$("#review").html(result);
			}
		});
	}
	
	function pf_qnaList() {
		$.ajax({
			type: "post",
			url: "${path}/qna/tabList.do",
			data: "pf_idx=${dto.pf_idx}",
			success: function(result) {
				$("#qna").html(result);
			}
		});
	}
	
			
});

	</script>
	
<style type="text/css">
#performance_view_title{
background-color: black;
height: 145px;
color: white;
text-shadow: 1px 2px 1px gray;
text-align: center;
margin-top: 23px;
}
	
</style>	
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50">
	<%@ include file="../main/nav.jsp" %>
	<br>
     <div id="performance_view_title" ><br>
     <h1>공연 안내</h1>
     <h6>${dto.pf_title} - 상세 정보</h6>
     </div>
		<div class="container">
		
			<div>
				<div style="display: none;">
					<a href="#"></a>
					<a href="#"></a>
				</div>
				
				<ul>
			 	 	<li style="display: list-item;">
			 	 		<img style="width: 930px; height: auto;" src="${path}/images/${dto.pf_img}">
			 	 	</li>
				</ul>
			</div>

			<div>
				<h3>[${dto.gn_name}]&nbsp;${dto.pf_title}</h3>
				<ul>
					<li>
					<form name="form1" method="post" action="${path}/performance/edit.do">
						<table style="width: 930px;" class="table table-hover">
								<tr>
									<td>글쓴이</td>
									<td>${dto.writer}</td>
								</tr>
								<tr>
									<td>연출</td>
									<td>${dto.b_name}</td>
								</tr>
								<tr>
									<td>지역</td>
									<td>${dto.ar_name}</td>
								</tr>
								<tr>
									<td>장소</td>
									<td>${dto.pf_location}</td>
								</tr>
								<tr>
									<td>일시</td>
									<td>
										<fmt:formatDate value="${dto.pf_date}" pattern="YYYY년 MM월 dd일"/> ${dto.pf_time}
									</td>
								</tr>
								<tr>
									<td>공연시간</td>
									<td>${dto.pf_runningTime}</td>
								</tr>
								<tr>
									<td>평점</td>
									<td>${dto.score} 점</td>
								</tr>
								<tr>
									<td>남은 초대석</td>
									<td>${dto.remainder} / ${dto.pf_seats}</td>
								</tr>
								
							<c:if test="${sessionScope.band_name != dto.b_name}">
								<tr>
									<td><span>초대장</span></td>
									<c:if test="${dto.remainder == 0}">
									    <td><span style="color: red;">남은 초대석이 없습니다.</span>
									</td>
									</c:if>
									<c:if test="${dto.remainder > 0}">
									<td>
										<div>
											<select name="count" id="count">
												<option value="0" selected="selected">인원 수를 선택하세요.</option>
													<option value="1">1인</option>
													<option value="2">2인</option>
											</select>
										</div>
									</td>
									</c:if>
								</tr>
							</c:if>												
								<tr>
									<td>설명</td>
									<td>${dto.content}</td>
								</tr>
								<tr align="center">
									<td colspan="2">
										<div>
											<input type="hidden" name="pf_idx" value="${dto.pf_idx}">
									       
									        <c:if test="${sessionScope.band_name != dto.b_name}">
									        	<c:if test="${dto.remainder > 0}">
									        		<input class="btn btn-default" type="button" id="btnInvitation" value="초대장 받기">
												</c:if>
												<c:if test="${dto.remainder == 0}"></c:if>
<!-- 												<input class="btn btn-default" type="button" id="btnDonation" value="후원하기"> -->
											</c:if>   
									  
									        <input class="btn btn-default" type="button" id="btnList" value="목록">
									        
									        <c:if test="${sessionScope.nickName == dto.writer}">
												<input class="btn btn-default" type="submit" id="btnEdit" value="수정/삭제">
											</c:if>
										</div>
									</td>
								</tr>

						</table>
						</form>
					</li>
				</ul>
				
				<br>
				<h3 class="text-center">Performance Board</h3>  
				<ul class="nav nav-tabs">
	    			<li class="active"><a data-toggle="tab" href="#review">공연 후기</a></li>
	    			<li><a data-toggle="tab" href="#qna">Q & A</a></li>
	  			</ul>
	
				<div class="tab-content">
					<div id="review" class="tab-pane fade in active"></div>
					
				    <div id="qna" class="tab-pane fade"></div>
				</div>	
			</div>
			
	</div>
<%@ include file="../main/footer.jsp" %>
</body>
</html>