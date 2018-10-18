<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$(function(){
   $("#btnUpdate").click(function(){            
      var b_name = document.form1.b_name.value;
      var b_genre = document.form1.b_genre.value;
      var b_num = document.form1.b_num.value;
      var b_area = document.form1.b_area.value;
      var b_logo = document.form1.imgFile.value;
       var description = document.form1.description.value;
       
       alert("정보가 수정되었습니다.");
       
      document.form1.action="${path}/myband/mybandupdate.do";
      document.form1.submit();
   });   
});

</script>
<style type="text/css">
#myband_title{
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
<%@ include file="../main/nav.jsp" %>   
<br>
     <div id="myband_title" ><br>
     <h1>밴드 정보</h1>
     <c:if test="${sessionScope.grade == 2}">
     <h6>${dto.b_name}</h6>
     </c:if>
      <c:if test="${sessionScope.grade == 3}">
     <h6>밴드 정보를 수정하실 수 있습니다.</h6>
     </c:if>
     </div><br>
<div class="container-fluid">
   <div class="row row-offcanvas row-offcanvas-right">
   <%@ include file="../band/bandsidevar.jsp" %>
   <div class="col-xs-10 col-lg-10">
<c:if test="${sessionScope.grade == 3}">
<form name="form1" method="post" enctype="multipart/form-data">
<table class="table table-hover table-bordered" style="max-width:80%; margin:0 auto; ">   
   <tbody>   
   <tr>  
      <td>밴드리더</td>      
      <td><input  style="width: 30%;" class="form-control" id="b_leaderNick" name="b_leaderNick" value="${dto.b_leaderNick}" readonly="readonly"></td>
   </tr>
   <tr>
      <td>밴드이름</td>
      <td><input  style="width: 30%;" class="form-control" id="b_name" name="b_name" value="${dto.b_name}"></td>
   </tr>
   <tr>
      <td>장르</td>
      <td><select  style="width: 30%;" class="form-control" name="b_genre" id="b_genre">
             <option value=1 <c:if test="${dto.gn_name == '발라드'}">selected</c:if>>발라드</option>
             <option value=2 <c:if test="${dto.gn_name == '힙합'}">selected</c:if>>힙합</option>
             <option value=3 <c:if test="${dto.gn_name == '알앤비'}">selected</c:if>>알앤비</option>
             <option value=4 <c:if test="${dto.gn_name == '재즈'}">selected</c:if>>재즈</option>
             <option value=5 <c:if test="${dto.gn_name == '록'}">selected</c:if>>록</option>
             <option value=6 <c:if test="${dto.gn_name == '포크'}">selected</c:if>>포크</option>
          </select>
      </td>
   </tr>
   <tr>
      <td>인원</td>
      <td><select  style="width: 30%;" class="form-control" name="b_num" id="b_num">             
             <option value=1 <c:if test="${dto.b_num == 1}">selected</c:if>>1</option>
             <option value=2 <c:if test="${dto.b_num == 2}">selected</c:if>>2</option>
             <option value=3 <c:if test="${dto.b_num == 3}">selected</c:if>>3</option>
             <option value=4 <c:if test="${dto.b_num == 4}">selected</c:if>>4</option>
             <option value=5 <c:if test="${dto.b_num == 5}">selected</c:if>>5</option>
             <option value=6 <c:if test="${dto.b_num == 6}">selected</c:if>>6</option>
          </select>
      </td>
   </tr>   
   <tr>
      <td>활동지역</td>
      <td><select  style="width: 30%;" class="form-control" name="b_area" id="b_area">             
             <option value=1 <c:if test="${dto.ar_name == '강남'}">selected</c:if>>강남</option>
             <option value=2 <c:if test="${dto.ar_name == '강동'}">selected</c:if>>강동</option>
             <option value=3 <c:if test="${dto.ar_name == '강북'}">selected</c:if>>강북</option>
             <option value=4 <c:if test="${dto.ar_name == '강서'}">selected</c:if>>강서</option>
             <option value=5 <c:if test="${dto.ar_name == '송파'}">selected</c:if>>송파</option>
             <option value=6 <c:if test="${dto.ar_name == '성남'}">selected</c:if>>성남</option>
          </select>
      </td>
   </tr>
   <tr>
        <td>밴드소개</td>
        <td><textarea rows="10" cols="80" name="description" id="description">${dto.description}</textarea>
   </tr>
   <tr>
      <td>밴드로고</td>
      <td>
         <c:if test="${dto.b_logo == '-'}">
         <span>밴드로고가 없습니다.</span>
         </c:if>
         <c:if test="${dto.b_logo != '-'}">
         <img src="${path}/images/${dto.b_logo}" style="width: 400px; height: 300px;">               
         </c:if>
         <input type="file" name="imgFile" id="imgFile">
         <input type="hidden" value="${dto.b_idx}" name="b_idx">
      </td>
   </tr>   
   </tbody>           
</table>
</form>
<div style="text-align: center;">
<input class="btn btn-default" type="button" value="수정하기" id="btnUpdate">
</div>
</c:if>
<c:if test="${sessionScope.grade == 2}">
<table class="table table-hover table-bordered" style="max-width:80%; margin:0 auto; ">   
   <tbody>   
   <tr>  
      <td>밴드리더</td>      
      <td><input  style="width: 30%;" class="form-control" id="b_leaderNick" name="b_leaderNick" value="${dto.b_leaderNick}" readonly="readonly"></td>
   </tr>
   <tr>
      <td>밴드이름</td>
      <td><input  style="width: 30%;" class="form-control" id="b_name" name="b_name" value="${dto.b_name}" readonly="readonly"></td>
   </tr>
   <tr>
      <td>장르</td>
      <td><select  style="width: 30%;" class="form-control" name="b_genre" id="b_genre">
             <option disabled="disabled" value=1 <c:if test="${dto.gn_name == '발라드'}">selected</c:if>>발라드</option>
             <option disabled="disabled" value=2 <c:if test="${dto.gn_name == '힙합'}">selected</c:if>>힙합</option>
             <option disabled="disabled" value=3 <c:if test="${dto.gn_name == '알앤비'}">selected</c:if>>알앤비</option>
             <option disabled="disabled" value=4 <c:if test="${dto.gn_name == '재즈'}">selected</c:if>>재즈</option>
             <option disabled="disabled" value=5 <c:if test="${dto.gn_name == '록'}">selected</c:if>>록</option>
             <option disabled="disabled" value=6 <c:if test="${dto.gn_name == '포크'}">selected</c:if>>포크</option>
          </select>
      </td>
   </tr>
   <tr>
      <td>인원</td>
      <td><select  style="width: 30%;" class="form-control" name="b_num" id="b_num">             
             <option disabled="disabled" value=1<c:if test="${dto.b_num == 1}">selected</c:if>>1</option>
             <option disabled="disabled" value=2<c:if test="${dto.b_num == 2}">selected</c:if>>2</option>
             <option disabled="disabled" value=3<c:if test="${dto.b_num == 3}">selected</c:if>>3</option>
             <option disabled="disabled" value=4<c:if test="${dto.b_num == 4}">selected</c:if>>4</option>
             <option disabled="disabled" value=5<c:if test="${dto.b_num == 5}">selected</c:if>>5</option>
             <option disabled="disabled" value=6<c:if test="${dto.b_num == 6}">selected</c:if>>6</option>
          </select>
      </td>
   </tr>   
   <tr>
      <td>활동지역</td>
      <td><select  style="width: 30%;" class="form-control" name="b_area" id="b_area">             
             <option disabled="disabled" value=1 <c:if test="${dto.ar_name == '강남'}">selected</c:if>>강남</option>
             <option disabled="disabled" value=2 <c:if test="${dto.ar_name == '강동'}">selected</c:if>>강동</option>
             <option disabled="disabled" value=3 <c:if test="${dto.ar_name == '강북'}">selected</c:if>>강북</option>
             <option disabled="disabled" value=4 <c:if test="${dto.ar_name == '강서'}">selected</c:if>>강서</option>
             <option disabled="disabled" value=5 <c:if test="${dto.ar_name == '송파'}">selected</c:if>>송파</option>
             <option disabled="disabled" value=6 <c:if test="${dto.ar_name == '성남'}">selected</c:if>>성남</option>
          </select>
      </td>
   </tr>
   <tr>
        <td>밴드소개</td>
        <td><textarea class="form-control" rows="10" cols="80" name="description" id="description" readonly="readonly">${dto.description}</textarea>
   </tr>
   <tr>
      <td>밴드로고</td>
      <td>
         <c:if test="${dto.b_logo == '-'}">
         <span>밴드로고가 없습니다.</span>
         </c:if>
         <c:if test="${dto.b_logo != '-'}">
         <img src="${path}/images/${dto.b_logo}" style="width: 400px; height: 300px;">               
         </c:if>
      </td>
   </tr>   
   </tbody>           
</table>
</c:if>
</div>
</div>
</div>

</body>
</html>