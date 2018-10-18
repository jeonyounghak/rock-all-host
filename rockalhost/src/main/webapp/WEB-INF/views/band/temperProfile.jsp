<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rock All Host에 오신걸 환영합니다.</title>
<script type="text/javascript">
$(function(){
	$("#btnUpdate").click(function(){		
		var career = document.form1.career.value;
		var positionMain = document.form1.positionMain.value;
		var positionSub = document.form1.positionSub.value;		
		
		alert("수정되었습니다.");
	
		document.form1.action="${path}/myband/temperUpdate.do";
		document.form1.submit();
	});		
	$("#btnDelete").click(function(){
			if(confirm("삭제하시겠습니까?")){
				document.form1.action="${path}/myband/temperDelete.do";
				document.form1.submit();	
			}		
	});
});
</script>
</head>
<body>
<%@ include file="../main/nav.jsp" %>
<br>
     <div id="apply_div_title" ><br>
     <h1>나의 밴드 정보</h1>
     <h6>밴드정보를 자세히 입력해주세요.</h6>
     </div>

     <%@ include file="../band/bandsidevar.jsp" %>
 
<form name="form1" method="post">
<table class="table table-hover table-bordered" style="max-width:60%; margin:0 auto; ">	
	<tr>	      
      <td scope="col">이름</td>
      <td>${dto.name}</td>
    </tr>  
    <tr>        
      <td scope="col">닉네임</td>
      <td>${dto.nickName}</td>
    </tr>  
    <tr>
      <th scope="col">이메일</th>        
      <td>${dto.email}</td>
    </tr>
    <tr>     
      <th scope="col">성별</th>      
      <td>${dto.sex}</td>
    </tr>
    <tr>    
      <th scope="col">전화번호</th> 
      <td>${dto.hp}</td>
    </tr>
    <tr>    
      <th scope="col">성별</th>
      <td>${dto.sex}</td>
    </tr>
    <tr>    
      <th scope="col">주소</th>
      <td>${dto.addr}${dto.addrDt}</td>
    </tr>
    <tr>    
      <th scope="col">가입일자</th>      
      <td>${dto.join_date}</td>    
    </tr> 
    <tr>    
      <th scope="col">등급</th>      
      <td><c:if test="${dto.myGrade == 2}">밴드원</c:if>
      	  <c:if test="${dto.myGrade == 3}">밴드장</c:if>
      </td>    
    </tr>   
   
   
   
	<tr>      
      <th scope="col">경력</th>
      <td><input class="form-control" style="width: 30%;" value="${dto.career}" name="career" id="career"></td>      
    </tr>  
    <tr>
    <th scope="col">포지션</th>
    <td><select class="form-control" style="width: 30%;" name="positionMain" id="positionMain" >
             <option value=1 <c:if test="${dto.positionMain == 1}">selected</c:if>>보컬</option>
             <option value=2 <c:if test="${dto.positionMain == 2}">selected</c:if>>드럼</option>
             <option value=3 <c:if test="${dto.positionMain == 3}">selected</c:if>>일렉기타</option>
             <option value=4 <c:if test="${dto.positionMain == 4}">selected</c:if>>기타</option>
             <option value=5 <c:if test="${dto.positionMain == 5}">selected</c:if>>베이스</option>
             <option value=6 <c:if test="${dto.positionMain == 6}">selected</c:if>>키보드</option>
          </select></td>
    </tr> 
    <tr> 
    <th scope="col">서브포지션</th>
    <td><select class="form-control" style="width: 30%;" name="positionSub" id="positionSub"  >
             <option value=1 <c:if test="${dto.positionSub == 1}">selected</c:if>>보컬</option>
             <option value=2 <c:if test="${dto.positionSub == 2}">selected</c:if>>드럼</option>
             <option value=3 <c:if test="${dto.positionSub == 3}">selected</c:if>>일렉기타</option>
             <option value=4 <c:if test="${dto.positionSub == 4}">selected</c:if>>기타</option>
             <option value=5 <c:if test="${dto.positionSub == 5}">selected</c:if>>베이스</option>
             <option value=6 <c:if test="${dto.positionSub == 6}">selected</c:if>>키보드</option>
          </select></td>	  
	</tr> 	
</table>
	<input type="hidden" value="${dto.nickName}" name="nickName" >
	<input type="hidden" value="${dto.myGrade}" name="myGrade" >
</form>
<br>
<div style="text-align: center;">
	<input type="button" class="btn btn-defult" value="수정" id="btnUpdate" > 
	<c:if test="${dto.myGrade != 3}">
	<input  type="button" class="btn btn-defult" value="추방" id="btnDelete">
	</c:if>
	</div>
</body>
</html>