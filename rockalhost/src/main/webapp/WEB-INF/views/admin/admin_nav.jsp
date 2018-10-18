<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<H2 style="text-align: center;"><a href="${path}/admin/management/main.do">Rock All Host</a></H2>
<nav class="navbar navbar-default">
   <div class="container-fluid">
      <div class="navbar-header">
         <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" 
         data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
         <span class="sr-only"></span>
         <span class="icon-bar"></span>
         <span class="icon-bar"></span>
         <span class="icon-bar"></span>         
         </button>                 
      </div>
      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      
      <ul class="nav navbar-nav">   
      <li><a href="${path}/admin/logout.do">로그아웃</a></li>
            
      <li class="dropdown">
         <a href="#" class="dropdown-toogle" data-toggle="dropdown" role="button"
            aria-haspopup="true" aria-expanded="false">회원관리<span class="caret"></span></a>
            <ul class="dropdown-menu">
               <li><a href="${path}/admin/memberList.do">회원열람</a></li>
               <li><a href="${path}/admin/withdrawalList.do">탈퇴회원 관리</a></li>
            </ul>
         </li>
         
         <li class="dropdown">
            <a href="#" class="dropdown-toogle" data-toggle="dropdown" role="button"
               aria-haspopup="true" aria-expanded="false">밴드관리<span class="caret"></span></a>
            <ul class="dropdown-menu">
               <li><a href="${path}/admin/list.do">밴드열람</a></li>
               <li><a href="${path}/admin/applylist.do">밴드승인</a></li>
               <li><a href="#">삭제된 밴드열람</a></li>
            </ul>
         </li>
         
         <li class="dropdown">
            <a href="#" class="dropdown-toogle" data-toggle="dropdown" role="button"
               aria-haspopup="true" aria-expanded="false">모집관리<span class="caret"></span></a>
            <ul class="dropdown-menu">
               <li><a href="${path}/admin/recruit_list.do">밴드원모집 관리</a></li>
               <li><a href="${path}/admin/seek_list.do">밴드찾기 관리</a></li>
            </ul>
         </li>
         
         <li class="dropdown">
            <a href="#" class="dropdown-toogle" data-toggle="dropdown" role="button"
               aria-haspopup="true" aria-expanded="false">공연관리<span class="caret"></span></a>
            <ul class="dropdown-menu">
               <li><a href="${path}/admin/performance/list.do">공연열람</a></li>
               <li><a href="${path}/admin/performance/delList.do">삭제된 공연열람</a></li>
            </ul>
         </li>
         
         <li class="dropdown">
            <a href="#" class="dropdown-toogle" data-toggle="dropdown" role="button"
               aria-haspopup="true" aria-expanded="false">게시판 관리<span class="caret"></span></a>
            <ul class="dropdown-menu">
               <li><a href="${path}/admin/boardList.do">자유 게시판</a></li>
               <li><a href="${path}/admin/rbList.do">리뷰 게시판</a></li>
               <li><a href="${path}/admin/qbList.do">질문 게시판</a></li>
            </ul>
         </li>
         
         <li class="dropdown">
            <a href="#" class="dropdown-toogle" data-toggle="dropdown" role="button"
               aria-haspopup="true" aria-expanded="false">통계<span class="caret"></span></a>
            <ul class="dropdown-menu">
               <li><a href="${path}/admin/chart/m_sex">회원통계</a></li>
               <li><a href="${path}/admin/chart/b_area">밴드통계</a></li>
               <li><a href="${path}/admin/chart/pf_genre">공연통계</a></li>
            </ul>
         </li>
         
      </ul>         
   </div>
   </div>
</nav>


 