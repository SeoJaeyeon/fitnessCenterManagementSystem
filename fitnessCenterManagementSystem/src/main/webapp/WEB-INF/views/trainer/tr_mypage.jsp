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
  <title>트레이너페이지</title>
  <!-- Bootstrap core CSS-->
  <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="${pageContext.request.contextPath}/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Page level plugin CSS-->
	<script>
		var message="${message}";
		if(message!=""){
			alert("${message}")
		}
		//이미지 미리보기 
    	function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('#ShowImage')
                    .attr('src', e.target.result)
                    .width(150)
                    .height(200);
            };

            reader.readAsDataURL(input.files[0]);
        }
    }
	</script>
</head>

<body class="fixed-nav sticky-footer" id="page-top">
  <!-- header-->
  <%@ include file="../header/header_trainer.jsp" %>
  <!-- header-->
    <div class="container-fluid" style="padding-left: 20%; padding-right:20%; padding-top: 5%; padding-bottom:10%">	
 <div class="card">
  <h5 class="card-header">마이페이지</h5>
  <div class="card-body">
    <form:form method="post" modelAttribute="trainer" enctype="multipart/form-data" action="/trainer/mypage">
            <div class="form-group">
            <img id="ShowImage" src="${img}" style="width:200px"/></br>
            <div class="custom-file">    
			  <input type='file' id="file" name="file" onchange="readURL(this);" /> 
			  </div>  
            </div>
            <div class="form-group ">
            <label for="ShowId">아이디</label>
            <form:input readonly="true" type="text" class="form-control" id="id" name="trainer.id"  path="id"/><p style="color:red"><form:errors path="id"/></p>
            </div>
              <div class="form-row">
            <div class="form-group col-md-6">
              <label for="InputPassword">현재비밀번호</label>
              <input type="password" class="form-control" id="cur_password"  name="cur_password" placeholder="Password">
            </div>
             <div class="form-group col-md-6">
              <label for="InputNewPassword">변경할비밀번호(변경하지 않을 시 기존 비밀번호 입력 )</label>
              <form:input type="password" class="form-control" id="password"  name="password" placeholder="New Password" path="password" /><p style="color:red"><form:errors path="password"/></p>
            </div>
            </div>
              <div class="form-row">
            <div class="form-group col-md-6">
              <label for="InputName">이름</label>
              <form:input readonly="true" type="text" class="form-control" id="name" name="trainer.name"  path="name"/><p style="color:red"><form:errors path="name"/></p>
            </div>
             <div class="form-group col-md-6">
              <label for="phoneNumber">휴대폰 번호</label>
              <form:input type="text" class="form-control" id="phone_number" name="trainer.phone_number" path="phone_number"/><p style="color:red"><form:errors path="phone_number"/></p>
            </div>
            </div>
               <div class="form-group">
              <label for="closedDay">휴무일</label>
              <select id="closed_day" name="closed_day" class="custom-select">
 			 <option value="MON" <c:if test="${closed_day=='MON'}"> selected </c:if>>월요일</option>
 			 <option value="TUE" <c:if test="${closed_day=='TUE'}"> selected </c:if> >화요일</option>
  			<option value="WED" <c:if test="${closed_day=='WED'}"> selected </c:if>>수요일</option>
  			<option value="THU" <c:if test="${closed_day=='THU'}"> selected </c:if>>목요일</option>
  			 <option value="FRI" <c:if test="${closed_day=='FRI'}"> selected </c:if> >금요일</option>
  			<option value="SAT" <c:if test="${closed_day=='SAT'}"> selected </c:if> >토요일</option>
  			<option value="SUN" <c:if test="${closed_day=='SUN'}"> selected </c:if>>일요일</option>
			</select>
            </div>
            <button type="submit" class="btn btn-block btn-primary text-light">개인정보 수정</button>
                  <input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			</form:form>
			</div>
			</div>
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
      