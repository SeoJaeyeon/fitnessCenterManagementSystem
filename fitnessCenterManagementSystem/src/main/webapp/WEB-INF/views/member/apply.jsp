<%@page import="kr.ac.fcm.DTO.user.TrainerDTO"%>
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
	<script>
		var sm='${message}';
		
		if(sm!="")
			alert(sm);
	
	</script>

</head>

<body class="fixed-nav sticky-footer" id="page-top">
  <!-- header -->
 	<%@ include file="../header/header_member.jsp" %>
 <!-- header -->
    <div class="container-fuild" style="padding-top:5%; padding-left:10%; padding-right:10%; padding-bottom:5%;">
    <div class="row">
    	<p>담당트레이너: ${trainer.name}</p>
    </div>
 	<div class="row">
 <table class="table table-bordered ">
  <thead >
     <tr class="text-center">
      <th scope="col" style="width:200px" >시간</th>
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
	
	TrainerDTO trainer=(TrainerDTO)request.getAttribute("trainer");
	
	int cd=-1;
	switch(trainer.getClosed_day()){
	case "MON":
		cd=0;
		break;
	case "TUE":
		cd=1;
		break;
	case "WED":
		cd=2;
		break;
	case "THU":
		cd=3;
		break;
	case "FRI":
		cd=4;
		break;
	case "SAT":
		cd=5;
		break;
	case "SUN":
		cd=6;
		
	}
	%>
  	<% for(int time=9; time<22; time++){ %>
    <tr>
      <th scope="row"><%= time %>시~<%= time+1 %>시</th>
	  <%for(int i=0; i<7; i++){ %>
	  	<td>
	  		<%if(size==0 || count==size || list.get(count).getHour()!=time || list.get(count).getDate().getDay()!=i+1){%><a href="/member/ptapply.do?day=<%=i%>&hour=<%=time%>">신청</a><%}
	  		else if(list.get(count).getMember_id().equals(request.getAttribute("id").toString()) && list.get(count).getHour()==time && list.get(count).getDate().getDay()==i+1){%>
	  		<a href="/member/ptcancle.do?day=<%=i%>&hour=<%=time%>" style="color:red">취소</a><%; count++;}else{
	  		%><a href="/member/ptreserv.do?day=<%=i%>&hour=<%=time%>" style="color:blue">예약대기</a><%; count++;}%>
	  	</td>
	  	<%}; %>
    </tr>
    <%}%>
  </tbody>
</table>
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
      