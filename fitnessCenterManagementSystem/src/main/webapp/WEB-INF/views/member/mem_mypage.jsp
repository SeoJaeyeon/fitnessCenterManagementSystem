<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>회원페이지</title>
 <!-- Bootstrap core CSS-->
  <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="${pageContext.request.contextPath}/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Page level plugin CSS-->
  
  <script>
  	var message='${message}';
  	if(message!=""){
  		alert(message);
  	}
  </script>
  
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <!-- header -->
 	<%@ include file="../header/header_member.jsp" %>
 	  <div class="container-fluid" style="padding-left: 20%; padding-right:20%; padding-top: 5%">	
 <div class="card">
  <h5 class="card-header">마이페이지</h5>
  <div class="card-body">
    <form:form method="post" modelAttribute="member" action="/member/mypage">
           
            <div class="form-group ">
            <label for="ShowId">아이디</label>
            <form:input readonly="true" style="background-color:white"  type="text" class="form-control" id="id" name="id"  path="id"/><p style="color:red"><form:errors path="id"/></p>
            </div>
              <div class="form-row">
            <div class="form-group col-md-6">
              <label for="InputPassword">현재비밀번호</label>
              <input type="password" class="form-control" id="cur_password"  name="cur_password" placeholder="Current Password">
            </div>
             <div class="form-group col-md-6">
              <label for="InputNewPassword">변경할비밀번호(변경하지 않을 시 기존 비밀번호 입력 )</label>
              <form:input type="password" class="form-control" id="password"  name="member.password" placeholder="New Password" path="password" /><p style="color:red"><form:errors path="password"/></p>
            </div>
            </div>
              <div class="form-row">
            <div class="form-group col-md-6">
              <label for="InputName">이름</label>
              <form:input readonly="true" style="background-color:white"  type="text" class="form-control" id="name" name="member.name"  path="name"/><p style="color:red"><form:errors path="name"/></p>
            </div>
             <div class="form-group col-md-6">
              <label for="phoneNumber">휴대폰 번호</label>
              <form:input type="text" class="form-control" id="phone_number" name="member.phone_number" path="phone_number"/><p style="color:red"><form:errors path="phone_number"/></p>
            </div>
            </div>
            <div class="form-row">
             <div class="form-group col-md-6"> 
             <label for="phoneNumber">주PT횟수(변경문의는 헬스장에 해주시기 바랍니다)</label>
             <form:input type="text" class="form-control" id="pt"  name="member.pt" path="pt" style="background-color:white" readonly="true"/><form:errors path="pt"/>
             </div>
             <div class="form-group col-md-6"> 
             <label for="phoneNumber">담당트레이너(변경문의는 헬스장에 해주시기 바랍니다)</label>
             <form:input type="text" class="form-control" id="trainer"  name="member.trainer_id" style="background-color:white"  path="trainer_id" readonly="true"/><form:errors path="trainer_id"/>
             </div>
            </div>
             <input type="hidden" name="gender" value="${member.gender}" id="gender"
				value="${_csrf.token}" />
            <button type="submit" class="btn btn-block btn-primary text-light">개인정보 수정</button>
                  <input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			</form:form>
			</div>
			</div>
		</div>
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