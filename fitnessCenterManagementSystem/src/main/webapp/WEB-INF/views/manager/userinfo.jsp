<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>관리자페이지</title>
  <!-- Bootstrap core CSS-->
  <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="${pageContext.request.contextPath}/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Page level plugin CSS-->
    <script>
    
    	var message='${message}';
    	if(message!="")
    		alert(message);
    		
    </script>

</head>
<body>
  <%@ include file="../header/header_manager.jsp" %>
  <div class="contianer-fuild" style="padding-top:5%;padding-left:5%; padding-right:5%; padding-bottom:5%;">
  <div class="row">
  <div class="input-group mb-3" style="padding-left:60%;">
  <div class="input-group-prepend">
    <button class="btn btn-outline-secondary dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">전체사용자</button>
    <div class="dropdown-menu">
      <a class="dropdown-item" href="#">회원</a>
      <a class="dropdown-item" href="#">트레이너</a>
    </div>
  </div>
  <input type="text" class="form-control" aria-label="Name">
   <div class="input-group-append">
    <button class="btn btn-outline-primary" type="submit" >검색</button>
   </div>
</div>
  </div><% int count=0; %>
  	<c:forEach var="member" items="${members}"  varStatus="status">
  		<% if((count%3)==0) %><div class="row"><%; %>
  		<div class="col-md-4">
  			 <div class="card">
      <div class="card-body">
        <h5 class="card-title">${member.name} 회원님</h5>
        <p class="card-text">담당트레이너:<c:choose> <c:when test="${member.trainer_name=='NULL'}">없음</c:when><c:otherwise>${member.trainer_name}</c:otherwise></c:choose></p>
        <p class="card-text">연락처:${member.phone_number}</p>
        <a href="/manager/reviseMemInfo.do?id=${member.id}" class="btn btn-primary">수정</a>
      </div>
     </div>
     </div>
     <% count++;
     	if(count!=0 && (count%3)==0)
      %></div><%;%>
     </c:forEach>
     <c:forEach var="trainer" items="${trainers}"  varStatus="status">
     <% if((count%3)==0) %><div class="row"><%; %>
  		<div class="col-md-4">
  			 <div class="card">
      <div class="card-body">
        <h5 class="card-title">${trainer.name} 트레이너님</h5>
        <p class="card-text">휴무일:${trainer.closed_day}</p>
        <p class="card-text">연락처:${trainer.phone_number}</p>
        <a href="/manager/reviseTrInfo.do?id=${trainer.id}" class="btn btn-primary">수정</a>
      </div>
     </div>
     </div>
         <% count++;
     	if(count!=0 && (count%3)==0)
      %></div><%;%>
     </c:forEach>
    </div>

	<%@ include file="../footer.jsp" %>
     <!-- Bootstrap core JavaScript-->
    <script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- Core plugin JavaScript-->
    <script src="${pageContext.request.contextPath}/resources/vendor/jquery-easing/jquery.easing.min.js"></script>
    <!-- Page level plugin JavaScript-->

    <!-- Logout Modal-->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <div class="modal-body">로그아웃 하시겠습니까?</div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
            <a class="btn btn-primary" href="/logout">Logout</a>
          </div>
        </div>
      </div>
    </div>
</body>
</html>