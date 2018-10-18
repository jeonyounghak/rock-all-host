<%@ include file="../../include/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rock All Host에 오신걸 환영합니다.</title>

<script type="text/javascript">
$(function() {
	
	$("#btnList").click(function() {
		location.href="${path}/admin/performance/list.do";
	});
			
});

	</script>
	
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50">
	<%@ include file="../../admin/admin_nav.jsp" %>
	
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
					<form name="form1" method="post">
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
										${dto.remainder}장 남음
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
									        <input class="btn btn-default" type="button" id="btnList" value="목록">
									        
										</div>
									</td>
								</tr>

						</table>
						</form>
					</li>
				</ul>
				
			</div>
			
	</div>
</body>
</html>