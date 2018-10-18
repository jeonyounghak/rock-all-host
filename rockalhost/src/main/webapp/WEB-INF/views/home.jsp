<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rock All Host에 오신걸 환영합니다.</title>

<c:if test="${message == 'logout'}">
	<script>alert("로그아웃 처리되었습니다.");</script>
</c:if>
<c:if test="${message == 'success'}">
	<script>alert("회원가입이 완료되었습니다.");</script>
</c:if>
<c:if test="${message == 'bye'}">
	<script>alert("그동안 감사했습니다. (^_^)(_ _)");</script>
</c:if>

<script>
$(document).ready(function(){
  // Initialize Tooltip
  $('[data-toggle="tooltip"]').tooltip(); 
  
  // Add smooth scrolling to all links in navbar + footer link
  $(".navbar a, footer a[href='#myPage']").on('click', function(event) {

    // Make sure this.hash has a value before overriding default behavior
    if (this.hash !== "") {

      // Prevent default anchor click behavior
      event.preventDefault();

      // Store hash
      var hash = this.hash;

      // Using jQuery's animate() method to add smooth page scroll
      // The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
      $('html, body').animate({
        scrollTop: $(hash).offset().top
      }, 800, function(){
   
        // Add hash (#) to URL when done scrolling (default click behavior)
        window.location.hash = hash;
      });
    } // End if
  });
})
</script>

</head>

<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50">
	<%@ include file="main/nav.jsp" %>


	<div id="myCarousel" class="carousel slide" data-ride="carousel">
	    <!-- Indicators -->
	    <ol class="carousel-indicators">
	      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
	      <li data-target="#myCarousel" data-slide-to="1"></li>
	      <li data-target="#myCarousel" data-slide-to="2"></li>
	      <li data-target="#myCarousel" data-slide-to="3"></li>
	    </ol>
	
	    <!-- Wrapper for slides -->
	    <div class="carousel-inner" role="listbox">
	      <div class="item active">
	        <img src="${path}/images/main_band2.jpg" alt="New York" width="1200" height="700">
	        <div class="carousel-caption">
	          <h3>Band</h3>
	          	<p>1. (소규모 대중음악) 밴드</p>
				<p>2. (함께 어울려 다니는) 무리 </p>
	        </div>      
	      </div>
	
	      <div class="item">
	        <img src="${path}/images/main3.jpg" alt="Chicago" width="1200" height="700">
	        <div class="carousel-caption">
	          <h3>Performance</h3>
	          <p>1. 공연</p>
	          <p>2. 연주회</p>
	        </div>      
	      </div>
	    
	      <div class="item">
	        <img src="${path}/images/main_band.png" alt="Los Angeles" width="1200" height="700">
	        <div class="carousel-caption">
	          <h3>Rock</h3>
	          <p>1. 록 음악</p>
	          <p>2. 로큰롤</p>
	        </div>      
	      </div>
	      
	      <div class="item">
	        <img src="${path}/images/main.jpg" alt="Los Angeles" width="1200" height="700">
	        <div class="carousel-caption">
	          <h3>Host</h3>
	          <p>1. (손님을 초대한) 주인</p>
	          <p>2. (TV라디오 프로의) 진행자 </p>
	        </div>      
	      </div>
	    </div>
	
	    <!-- Left and right controls -->
	    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
	      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
	      <span class="sr-only">Previous</span>
	    </a>
	    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
	      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
	      <span class="sr-only">Next</span>
	    </a>
	</div>
	
	
	<!-- Container (The Band Section) -->
	<div id="band" class="container text-center">
	  <h3>THE BAND</h3>
	  <p><em>We love music!</em></p>
	  <p>We have created a fictional band website. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
	  <br>
	</div>
	
	<!-- Footer -->
	<%@ include file="main/footer.jsp" %>
	
</body>
</html>
