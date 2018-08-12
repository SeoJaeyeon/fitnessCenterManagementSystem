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

  <!-- Custom styles for this template-->
</head>

<body class="fixed-nav sticky-footer" id="page-top">
  <!-- Navigation-->
   <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="#">헬스일정예약관리시스템</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
         <li class="nav-item " data-toggle="tooltip" data-placement="right" title="adminUser">
          <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseMulti" data-parent="#exampleAccordion">
            <i class="fa fa-fw fa-sitemap"></i>
            <span class="nav-link-text">회원관리</span>
          </a>
          <ul class="sidenav-second-level collapse" id="collapseMulti">
            <li>
              <a href="/trainer/showMemberList">회원조회</a>
            </li>
            <li>
              <a href="#">인바디기록</a>
            </li>
            <li>
              <a href="/trainer/showInbody">인바디조회</a>
            </li>
          </ul>
        </li>
          <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Tables">
          <a class="nav-link" href="/trainer">
            <i class="fa fa-fw fa-table"></i>
            <span class="nav-link-text">스케줄</span>
          </a>
        </li>
         <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Example Pages">
          <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#" data-parent="#exampleAccordion">
            <i class="fa fa-fw fa-file"></i>
            <span class="nav-link-text">게시판</span>
          </a>
        </li>
         <li class="nav-item active" data-toggle="tooltip" data-placement="right" title="Tables">
          <a class="nav-link" href="/trainer/mypage">
            <i class="fa fa-fw fa-table"></i>
            <span class="nav-link-text">마이페이지</span>
          </a>
        </li>
        <li class="nav justify-content-end">
          <a class="nav-link" data-toggle="modal" data-target="#exampleModal">
            <i class="fa fa-fw fa-sign-out"></i>Logout</a>
        </li>
      </ul>
    </div>
    </div>
  </nav>
   <div class="container" style="padding-top:5%">
 	<div class="row">
 		<div class="col-md-3"></div>
 			<div class="col-md-6">
 <div class="card">
  <h5 class="card-header">마이페이지</h5>
  <div class="card-body">
    <h5 class="card-title">정보수정</h5>
    <form method="post">
            <div class="form-group">
              <label for="InpuImage">사진</label>          
			  <input type='file' id="file" name="file" onchange="readURL(this);" /> 
		      <img id="ShowImage" src="#"/>
            </div>
            <div class="form-group">
            <label for="ShowId">아이디</label>
            <input type="text" class="form-control" id="id" name="id" value="${trainer.id}" disabled="disabled"/>
            </div>
            <div class="form-group">
              <label for="InputPassword">현재비밀번호</label>
              <input type="password" class="form-control" id="password"  name="password" placeholder="Password"/>
            </div>
             <div class="form-group">
              <label for="InputNewPassword">변경할비밀번호</label>
              <input type="password" class="form-control" id="newpassword"  name="newpassword" placeholder="New Password"/>
            </div>
            <div class="form-group">
              <label for="InputName">이름</label>
              <input type="text" class="form-control" id="name" name="name" value="${trainer.name}" disabled="disabled"/>
            </div>
             <div class="form-group">
              <label for="phoneNumber">휴대폰 번호</label>
              <input type="text" class="form-control" id="phone_number" name="phone_number" value="${phone_number}" />
            </div>
               <div class="form-group">
              <label for="closedDay">휴무일</label>
              <select id="closed_day" name="closed_day" class="custom-select">
 			 <option value="MON" <c:if test="${closed_day==MON}"> selected </c:if>>월요일</option>
 			 <option value="TUE" <c:if test="${closed_day=='TUE'}"> selected </c:if> >화요일</option>
  			<option value="WED" <c:if test="${closed_day=='WED'}"> selected </c:if>>수요일</option>
  			<option value="THU" <c:if test="${closed_day=='THU'}"> selected </c:if>>목요일</option>
  			 <option value="FRI" <c:if test="${closed_day=='FRI'}"> selected </c:if> >금요일</option>
  			<option value="SAT" <c:if test="${closed_day=='SAT'}"> selected </c:if> >토요일</option>
  			<option value="SUN" <c:if test="${closed_day=='SUN'}"> selected </c:if>>일요일</option>
			</select>
            </div>
            <button type="submit" class="btn btn-block btn-primary text-light">서비스 이용자 등록</button>
                  <input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			</form>
			</div>
			</div>
		</div>
			<div class="col-md-3"></div>
 	</div>
 	</div>
 	<div class="col-md-3"></div>
  
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
      