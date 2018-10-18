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
            <a href="${path}/admin/boardList.do" class="list-group-item">게시판 열람</a>
            <a href="${path}/admin/boardDelList.do" class="list-group-item">삭제된 게시물 열람</a>             
          </div>
        </div>

</body>
</html>