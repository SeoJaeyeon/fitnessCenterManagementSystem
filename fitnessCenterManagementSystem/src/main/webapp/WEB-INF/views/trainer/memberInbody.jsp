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
  <title>트레이너페이지</title>
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
    
    	var message='${message}';
    	if(message!="")
    		alert(message);
    		
    	
    	<%
     	List<InbodyDTO> inbodyList=new ArrayList<InbodyDTO>();
    	
    	if(request.getAttribute("inbody")!=null){
    		inbodyList=(ArrayList<InbodyDTO>)request.getAttribute("inbody");
    	}
    	
    	%>
    	
    	
    function showPopup() { 
    	window.open("/trainer/record_inbody?id=${member.id}", "인바디기록", "width=350, height=300, left=100, top=50"); 
    	
    }
    </script>

</head>
<body >
  <%@ include file="../header/header_trainer.jsp" %>
   <div class="container-fuild" style="padding-top:5%; padding-left:10%; padding-right:10%; padding-bottom:5%;text-align: center">
   <div class="row" style="text-align: center">
   <div style="width:25%"></div>
   <div class="card" style="width:50%">
      <div class="card-body">
        <h5 class="card-title">${member.name} 회원님</h5>
        <p class="card-text">성별: <c:choose><c:when test="${member.gender=='M'}">남성</c:when><c:otherwise>여성</c:otherwise></c:choose></p>
        <p class="card-text">주 pt횟수: ${member.pt}회</p>
        <p class="card-text">연락처: ${member.phone_number}</p>
      </div>
     </div>
     <div style="width:25%"></div>
     </div>
 	<div class="row" style="text-align: center">
 	<div id="inbody-chart" style="height: 250px; width: 100%"></div>
 	</div>
      <p class="display-4">인바디 기록을 활용하기 전에 꼭 확인해주세요!</p>    
      <p>1. 기록 확인을 요청한 회원이 <mark>본인</mark>이 맞나요?<br/></p>
      <p>2. 마지막으로 기록한 날짜가 <mark>3개월</mark>이 넘어간다면? --><input type="button" class="btn btn-primary" value="인바디기록" onclick="showPopup();" /></p> 
      <p>3. 기록에 문제가 있다면 관리자에게 문의해주세요<br/></p>
 	</div>
 </div>
 <script>

 new Morris.Bar({
	  element: 'inbody-chart',
	  data: [
	    <% for(int i=0; i<inbodyList.size(); i++){%>
	    { y: '<%=inbodyList.get(i).getRecord().toString()%>',a:<%=inbodyList.get(i).getWeight()%>,
	    b: <%=inbodyList.get(i).getFat()%>, c:<%=inbodyList.get(i).getMuscle()%> },<%};%>
	  ],
	  xkey: 'y',
	  ykeys: ['a', 'b','c'],
	  labels: ['몸무게', '체지방','근육량']
	});
 </script>

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