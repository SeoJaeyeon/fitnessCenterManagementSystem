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
<form:form method="post" modelAttribute="member">
   <div class="container-fulid" style="padding-top:5%; padding-left:10%; padding-right:10%;">
		     <div class="card">
		  <h5 class="card-header">회원추가</h5>
  		<div class="card-body">
            <div class="form-row">
            <div class="form-group col-md-6">
              <label for="InputId">아이디</label>
              <form:input type="text" class="form-control" id="id" name="id" placeholder="ID" path="id"/><p style="color:red"><form:errors path="id"/></p>
            </div>
            <div class="form-group col-md-6">
              <label for="InputPassword">비밀번호</label>
              <form:input type="password" class="form-control" id="password"  name="password" placeholder="Password" path="password"/><p style="color:red"><form:errors path="password"/></p>
            </div>
            </div>
              <div class="form-row">
            <div class="form-group col-md-6">
              <label for="InputName">이름</label>
              <form:input type="text" class="form-control" id="name" name="name" placeholder="Name" path="name"/><p style="color:red"><form:errors path="name"/></p>
            </div>
              <div class="form-group col-md-6">
              <label for="InputName">성별</label><br/>
			<div class="form-check form-check-inline">
  				<input class="form-check-input" type="radio" name="gender" id="M" value="M" checked>
  				<label class="form-check-label" for="inlineRadio1">남성</label>
			</div>
				<div class="form-check form-check-inline">
  				<input class="form-check-input" type="radio" name="gender" id="G" value="G">
  			<label class="form-check-label" for="inlineRadio2">여성</label>
				</div>
				</div>
				</div>
				<div class="form-row">
             <div class="form-group col-md-12">
              <label for="phoneNumber">휴대폰 번호</label>
              <form:input type="text" class="form-control" id="phone_number" name="phone_number" placeholder="Phone_number" path="phone_number"/><p style="color:red"><form:errors path="phone_number"/></p>
            </div>
            </div>
  			<div class="form-row">
             <div class="form-group col-md-12">
              <label for="pt">주 pt횟수</label>
              <select id="pt" name="pt" class="custom-select">
 			 <option value="0" selected>0</option>
 			 <option value="1">1</option>
  			<option value="2">2</option>
  			<option value="3">3</option>
  			 <option value="4">4</option>
  			<option value="5">5</option>
  			<option value="6">6</option>
  			<option value="7">7</option>
			</select>
            </div>
            </div>
            <div class="form-row">
             <div class="form-group col-md-12">
              <label for="trianer">담당트레이너</label>
              <select id="trainer_id" name="trainer_id" class="custom-select">
              <c:forEach var="trainer" items="${trainers}">
              <option value="${trainer.id}">${trainer.name}</option>
			</c:forEach>
			</select>
            </div>      
            </div>      
            <button type="submit" id="btnSave" class="btn btn-block btn-primary text-light">서비스 이용자 등록</button>
                  <input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</div>
 	</div>
 	</div>
 	</form:form>
 	
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