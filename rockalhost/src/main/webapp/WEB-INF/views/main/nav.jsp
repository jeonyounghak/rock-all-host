<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<nav class="navbar navbar-default navbar-fixed-top">

  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="${path}">Rock All Host</a>
    </div>
    
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
      
      	<c:if test="${sessionScope.id != null}">
			<li><a>${sessionScope.nickName}(${sessionScope.id})님 반갑습니다.</a></li>
		</c:if>	
		
		<c:choose>
			<c:when test="${sessionScope.id != null}">
				<li class="dropdown">
		          <a class="dropdown-toggle" data-toggle="dropdown" href="#">MY PAGE
		          <span class="caret"></span></a>
		          <ul class="dropdown-menu">
		          	<li><a href="${path}/member/view.do">내정보</a></li>
		          	
		          	<c:if test="${sessionScope.grade == 3 || sessionScope.grade == 2}">
		            	<li><a href="${path}/myband/mybandview.do">내 밴드</a></li>       
		            </c:if>
		            
		            <c:if test="${sessionScope.grade == 1 || sessionScope.grade == null}"></c:if>
		            
		            <li><a href="${path}/message/messagelist.do">내 쪽지함</a></li>
		            <li><a href="${path}/invitation/list.do">내 초대장</a></li>
		            <li><a href="${path}/member/logout.do">로그아웃</a></li>
		          </ul>
		        </li>
		 	</c:when>
		 	
			<c:otherwise>
				<li class="dropdown">
		          <a class="dropdown-toggle" data-toggle="dropdown" href="#">MEMBERSHIP
		          <span class="caret"></span></a>
		          <ul class="dropdown-menu">
		          	<li><a href="${path}/member/login.do">로그인</a></li>
		        	<li><a href="${path}/member/preJoin.do">회원가입</a></li>
		          </ul>
		        </li>
			</c:otherwise>
		</c:choose>
      
      
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">BAND
          <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="${path}/recruit/list.do">밴드원 찾기</a></li>
            <li><a href="${path}/seek/list.do">밴드 찾기</a></li>
			<c:if test="${sessionScope.grade != 3 && grade !=2 && grade != null}"> 
	         	<li><a href="${path}/band/applyview.do">신규밴드 신청</a></li>
         	</c:if> 
          </ul>
        </li>
        
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">PERFORMANCE
          <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="${path}/performance/list.do">공연 보기</a></li>
            <c:if test="${sessionScope.grade == '3'}">
				<li><a href="${path}/performance/write.do">공연 등록</a></li>
			</c:if>
          </ul>
        </li>
        
        <li><a href="${path}/board/list.do">BOARD</a></li>
      </ul>
    </div>
  </div>
  
</nav>