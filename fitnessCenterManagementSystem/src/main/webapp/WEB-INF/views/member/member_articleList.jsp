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
  <title>회원페이지</title>
    <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="${pageContext.request.contextPath}/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Page level plugin CSS-->
<link href="${pageContext.request.contextPath}/resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
    <!-- Custom styles for this template-->
    <link href="${pageContext.request.contextPath}/resources/css/sb-admin.css" rel="stylesheet">
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
         <li class="nav-item active" data-toggle="tooltip" data-placement="right" title="adminUser">
          <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseMulti" data-parent="#exampleAccordion">
            <i class="fa fa-fw fa-sitemap"></i>
            <span class="nav-link-text">스케줄</span>
          </a>
          <ul class="sidenav-second-level collapse" id="collapseMulti">
            <li>
              <a href="/member">PT일정조회</a>
            </li>
            <li>
              <a href="#">PT신청/예약</a>
            </li>
          </ul>
        </li>
         <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Example Pages">
          <a class="nav-link" href="/member/board.do" >
            <i class="fa fa-fw fa-file"></i>
            <span class="nav-link-text">게시판</span>
          </a>
        </li>
 		<li class="nav-item" data-toggle="tooltip" data-placement="right" title="adminUser">
          <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseMypage" data-parent="#exampleAccordion">
            <i class="fa fa-fw fa-sitemap"></i>
            <span class="nav-link-text">마이페이지</span>
          </a>
          <ul class="sidenav-second-level collapse" id="collapseMypage">
            <li>
              <a href="/trainer/showMemberList">개인정보수정</a>
            </li>
            <li>
              <a href="#">인바디조회</a>
            </li>
          </ul>
        </li>
          <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Example Pages">
          <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#" data-parent="#exampleAccordion">
            <i class="fa fa-fw fa-file"></i>
           <span class="nav-link-text">Q&A</span>
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
	
        <div class="container-fluid" style="padding-left: 10%; padding-right:10%; padding-top: 5%">	
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
							<td>${article.subject}</td>
							<td>${article.created}</td>
							<td>${article.view}</td>
						</tr>
				</c:forEach>
  				</tbody>
			</table>
				<a href="/member/write.do" class="btn btn-primary active" role="button" aria-pressed="true">글쓰기</a>
		</div>
	</div>
  
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
      