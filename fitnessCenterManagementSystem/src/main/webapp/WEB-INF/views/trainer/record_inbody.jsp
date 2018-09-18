<%@page import="java.util.ArrayList"%>
<%@page import="kr.ac.fcm.DTO.InbodyDTO"%>
<%@page import="kr.ac.fcm.dao.InbodyDao"%>
<%@page import="java.util.List"%>
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
 <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.css">
 <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
 <script src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
 <script src="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.min.js"></script>
 <script>
 	var message='${message}'
 	if(message!=''){
 		alert(message);
 		window.close()
 	}
 		
 </script>
</head>
<body sytle="width:350px; height:300px;">
<div style="padding: 5%">
   <blockquote class="blockquote text-right">
  <p class="mb-0">${member.name} 회원님의 인바디를 기록합니다</p>
  <footer class="blockquote-footer">날짜는 오늘자로 등록됩니다</footer>
</blockquote>
<form method="post">
<input type="hidden" name="member_id"  value="${member.id }"/>
<input type="hidden" name="member.name" value="${member.name}" />
  <div class="form-row">
  </div>
  <div class="form-group">
    <input type="text" class="form-control" id="weight" name="weight" placeholder="몸무게">
  </div>
  <div class="form-group">
    <input type="text" class="form-control" id="weight" name="fat" placeholder="체지방">
  </div>
  <div class="form-group">
    <input type="text" class="form-control" id="muscle" name="muscle" placeholder="근육량">
  </div>
  <button type="submit" class="btn btn-primary">기록</button>
       <input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
</form>
</div>
     <!-- Bootstrap core JavaScript-->
    <script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- Core plugin JavaScript-->
    <script src="${pageContext.request.contextPath}/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

</body>
</html>