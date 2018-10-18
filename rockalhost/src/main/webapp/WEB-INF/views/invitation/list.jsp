<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rock All Host에 오신걸 환영합니다.</title>

<c:if test="${param.message == 'susess'}">
  <script>
    alert("이메일 발송을 발송했습니다.");
  </script>
</c:if>
<c:if test="${param.message == 'fail'}">
  <script>
    alert("이메일 발송을 실패했습니다.");
  </script>
</c:if>
<style type="text/css">
#invitation_div_title{
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
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50">
   <%@ include file="../main/nav.jsp" %>
   <br>
     <div id="invitation_div_title" >
     <br>
     <h1>내 초대장</h1>
     <h6>최고의 공연에 당신을 초대합니다.</h6>
     </div>

<div class="container">
<table class="table table-hover">   
<c:choose>
   <c:when test="${list == '[]' }">
      <h3>초대장 리스트가 비었습니다.</h3>
   </c:when>
   
   <c:otherwise>   
      <tbody>
      <tr>
         <th>공연 타이틀</th>
         <th>밴드 이름</th>
         <th>일시</th>
         <th>장소</th>
         <th>장수</th>
         <th>신청일자</th>
         <th>초대장 발급</th>
         <th></th>
      </tr>
      
   <c:forEach var="dto" items="${list}">
      <tr>
            <td>
               <a href="${path}/performance/view/${dto.pf_idx}">${dto.pf_title}</a><br>   
            </td>
            <td>${dto.b_name}</td>
            <td>${dto.pf_date} ${dto.pf_time}</td>
            <td>${dto.pf_location}</td>
            <td>
               <span>${dto.count}</span>
               <div>
                  <form name="form1" id="form1" method="post">
                     <input type="hidden" name="iv_idx" value="${dto.iv_idx}">
                     <input type="hidden" name="pf_idx" value="${dto.pf_idx}">
                  </form>
               </div>
            </td>
            <td>
               ${dto.apply_date}
            </td>
            <td>
               <c:if test="${dto.issue == 'n'}">
                  <a onclick="return confirm('초대장을 이메일로 받겠습니까?')" 
                     href="${path}/invitation/email.do?iv_idx=${dto.iv_idx}">
                     [이메일로 받기]</a>
               </c:if>
               <c:if test="${dto.issue == 'y'}">
                  <a onclick="return confirm('초대장을 다시 받겠습니까?')" 
                     href="${path}/invitation/email.do?iv_idx=${dto.iv_idx}">
                     [다시 받기]</a>
               </c:if>
            </td>
            <td>
               <a onclick="return confirm('삭제하시겠습니까?')" 
               href="${path}/invitation/delete.do?iv_idx=${dto.iv_idx}&pf_idx=${dto.pf_idx}&count=${dto.count}">
               [초대장 삭제]</a>
            </td>
         </tr>
      </c:forEach>
   </c:otherwise>
</c:choose>

         </tbody>
      </table>
      
</div>      
<%@ include file="../main/footerSimple.jsp" %>
</body>
</html>