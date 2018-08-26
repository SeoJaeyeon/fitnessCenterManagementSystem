<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
<link href="${pageContext.request.contextPath}/resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
    <!-- Custom styles for this template-->
    <link href="${pageContext.request.contextPath}/resources/css/sb-admin.css" rel="stylesheet">
    <script>
 	   var usertype;
   		if('${type}'=='MANAGER');
   			usertype="manager";
   			if('${type}'=='TRAINER');
   			usertype="trainer";
   			if('${type}'=='MEMBER');
   			usertype="member";
    </script>
</head>

<body class="fixed-nav sticky-footer" id="page-top">
	<c:if test="${type=='MANAGER'}">
 	<%@ include file="../header/header_manager.jsp" %>
  </c:if>
   <c:if test="${type=='TRAINER'}">
 	<%@ include file="../header/header_trainer.jsp" %>
  </c:if>
   <c:if test="${type=='MEMBER'}">
 	<%@ include file="../header/header_member.jsp" %>
  </c:if>

        <div class="container-fluid" style="padding-left: 10%; padding-right:10%; padding-top: 5%; padding-bottom:5%;">	
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>NO</th>
                      <th>작성자</th>
                      <th>제목</th>
                      <th>작성시간</th>
                      <th>조회수</th>
                    </tr>
                  </thead>
 				 <tbody>
 				 <c:forEach var="article" items="${articles}">

						<tr>
							<td>${article.idx}</td>
							<td>${article.writer}</td>
							
								<td><a href="/article?no=${article.idx}">${article.subject}</a></td>
						
							<td>${article.created}</td>
							<td>${article.view}</td>
						</tr>
				</c:forEach>
  				</tbody>
			</table>
				<a href="/write.do" class="btn btn-primary active" role="button" aria-pressed="true">글쓰기</a>
		</div>
	</div>
<%@ include file="../footer.jsp" %>
    <!-- Bootstrap core JavaScript-->
    <script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- Core plugin JavaScript-->
    <script src="${pageContext.request.contextPath}/resources/vendor/jquery-easing/jquery.easing.min.js"></script>
    <!-- Page level plugin JavaScript-->
   	<script src="${pageContext.request.contextPath}/resources/vendor/datatables/jquery.dataTables.js"></script>
    <script src="${pageContext.request.contextPath}/resources/vendor/datatables/dataTables.bootstrap4.js"></script>
        <!-- Custom scripts for all pages-->
    <script src="${pageContext.request.contextPath}/resources/js/sb-admin.min.js"></script>

    <!-- Demo scripts for this page-->
    <script src="${pageContext.request.contextPath}/resources/js/demo/datatables-demo.js"></script>
    
    

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
      