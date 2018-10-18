<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rock All Host에 오신걸 환영합니다.</title>
</head>
<body>
 <div class="col-xs-2 col-lg-2" id="sidebar">
          <div class="list-group">
            <a href="${path}/myband/mybandview.do" class="list-group-item">내 밴드</a>
            <a href="${path}/bandBoard/rbList.do?b_idx=${sessionScope.band}" class="list-group-item">리뷰 게시판</a>
            <a href="${path}/bandBoard/qbList.do?b_idx=${sessionScope.band}" class="list-group-item">질문 게시판</a>
            <c:if test="${sessionScope.grade == 2}">
            <a href="${path}/myband/mylist.do" class="list-group-item">내 밴드원</a>
            </c:if>
            <c:if test="${sessionScope.grade == 3}">
            <a href="${path}/myband/leaderlist.do" class="list-group-item">내 밴드원</a>
            </c:if>             
          </div>
        </div>

</body>
</html>