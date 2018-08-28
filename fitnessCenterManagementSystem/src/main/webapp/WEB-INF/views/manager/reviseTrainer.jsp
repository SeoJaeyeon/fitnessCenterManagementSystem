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
    	
    	var delmessage='${delmessage}'
        	if(delmessage!=""){
    			var re=confirm("해당사용자를 정말 삭제하시겠습니까? 한번 삭제된 사용자의 데이터는 복구할 수 없습니다.");
    			if(re)
    				window.location.href = '/manager/trainer/delete.do?id=${trainer.id}';
    		}
    </script>

</head>
<body>
  <%@ include file="../header/header_manager.jsp" %>
<form method="post">
   <div class="container-fulid" style="padding-top:5%; padding-left:10%; padding-right:10%; padding-bottom:5%;">
		     <div class="card">
		  <h5 class="card-header">트레이너조회</h5>
  		<div class="card-body">
  		<div class="form-group">
  			<img id="ShowImage" src="${imgUrl}" style="width:20%; hieght:20%"/>
  		</div>
  		<div class="form-group ">
            <label for="ShowId">아이디</label>
            <input readonly="readonly" style="background-color:#EDEFEF"  type="text" class="form-control" id="id" name="member.id" value="${trainer.id}"/>
        </div>
              <div class="form-row">
            <div class="form-group col-md-6">
              <label for="InputName">이름</label>
              <input readonly="readonly" style="background-color:#EDEFEF"  type="text" class="form-control" id="name" name="member.name" value="${trainer.name}"/>
            </div>
              <div class="form-group col-md-6">
              <label for="InputName">성별</label><br/>
              <input readonly="readonly" style="background-color:#EDEFEF"  type="text" class="form-control"  value=<c:if test="${trainer.gender=='G'}">여성</c:if>
				<c:if test="${trainer.gender=='M'}">남성</c:if>>
				</div>
				</div>
             <div class="form-group">
              <label for="phoneNumber">휴대폰 번호</label>
              <input type="text" style="background-color:#EDEFEF" readonly="readonly" class="form-control" id="phone_number" name="phone_number" value="${trainer.phone_number}">
            </div>
               <div class="form-group">
              <label for="closedDay">휴무일</label>
              <select id="closed_day" name="closed_day" class="custom-select">
 			 <option value="MON" <c:if test="${trainer.closed_day=='MON'}"> selected </c:if>>월요일</option>
 			 <option value="TUE" <c:if test="${trainer.closed_day=='TUE'}"> selected </c:if> >화요일</option>
  			<option value="WED" <c:if test="${trainer.closed_day=='WED'}"> selected </c:if>>수요일</option>
  			<option value="THU" <c:if test="${trainer.closed_day=='THU'}"> selected </c:if>>목요일</option>
  			 <option value="FRI" <c:if test="${trainer.closed_day=='FRI'}"> selected </c:if> >금요일</option>
  			<option value="SAT" <c:if test="${trainer.closed_day=='SAT'}"> selected </c:if> >토요일</option>
  			<option value="SUN" <c:if test="${trainer.closed_day=='SUN'}"> selected </c:if>>일요일</option>
			</select>
            </div>
            <input type="submit" class="btn btn-primary " value="정보수정">
			<a href="/manager/reviseTrInfo.do?delete&id=${trainer.id}" class="btn btn-primary ">삭제</a>
                  <input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</div>
 	</div>
 	</div>
 	</form>
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