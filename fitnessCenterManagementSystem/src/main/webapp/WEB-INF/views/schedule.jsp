<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page session="false"%>
<%@page import="java.util.*" %>
<%@page import="kr.ac.fcm.DTO.ScheduleDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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

  <!-- Custom styles for this template-->
</head>

<body class="fixed-nav sticky-footer" id="page-top">
  <!-- header -->
 	 <c:if test="${type=='MANAGER'}">
 	<%@ include file="header/header_manager.jsp" %>
  </c:if>
   <c:if test="${type=='TRAINER'}">
 	<%@ include file="header/header_trainer.jsp" %>
  </c:if>
   <c:if test="${type=='MEMBER'}">
 	<%@ include file="header/header_member.jsp" %>
  </c:if>
 <!-- header -->
    <div class="container-fuild" style="padding-top:5%; padding-left:10%; padding-right:10%; padding-bottom:5%;">
 	<div class="row">
 <table class="table table-bordered ">
  <thead >
     <tr class="text-center">
      <th scope="col" style="width:200px; height:" >시간</th>
      <th scope="col" style="width:300px">월</th>
      <th scope="col" style="width:300px">화</th>
      <th scope="col" style="width:300px">수</th>
      <th scope="col" style="width:300px">목</th>
      <th scope="col" style="width:300px">금</th>
      <th scope="col" style="width:300px">토</th>
      <th scope="col" style="width:300px">일</th>
    </tr>
  </thead>
  <tbody class="text-center">
	<% int count=0;
	ArrayList<ScheduleDTO> list=new ArrayList<ScheduleDTO>();
	int size=-1;
	if(request.getAttribute("schedules")!=null){
		list = (ArrayList<ScheduleDTO>)request.getAttribute("schedules");
		size=list.size();
	}
	%>
  	<% for(int time=9; time<22; time++){ %>
    <tr>
      <th scope="row"><%= time %>시~<%= time+1 %>시</th>
	  <%for(int i=0; i<7; i++){ %>
	  	<td
	  		<% if(size>0 && list.get(count).getHour()==time && list.get(count).getDate().getDay()==i)
	  		{%> style="background-color:rgb(204,255,255)">
	  			<%= list.get(count).getMember_name()%> 회원 - 	<%= list.get(count).getTrainer_name()%> 트레이너 
	  			 <%; if(count < size-1) count++; }else{%>><% }%>
	  	</td>
	  	<%}; %>
    </tr>
    <%}%>
  </tbody>
</table>
</div>
</div>
  <%@ include file="footer.jsp" %>
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
      