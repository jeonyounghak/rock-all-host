<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


	<c:forEach var="dto" items="${list}">
		<form name="comment_form" method="post" action="${path}/board/commentDelete.do">
			<table class="table table-hover">
				<tr>
					<td>${dto.writer}</td>
					<td>
						( <fmt:formatDate value="${dto.reg_date}" pattern="yyyy-MM-dd HH:mm:ss" /> )
					</td>
					<td>
						<input class="form-control" id="passwd" name="passwd" type="password" placeholder="댓글 비밀번호">          		
					</td>
					<td>
						<input id="comment_num" name="comment_num" type="hidden" value="${dto.comment_num}">
						<input class="btn btn-default" onclick="return confirm('댓글을 삭제하겠습니까?')" type="submit" id="comment_btnDel" value="삭제">
					</td>
				</tr>
				<tr>
					<td colspan="4">
						${dto.content}
					</td>
				</tr>
			</table>
		</form>
	</c:forEach>

