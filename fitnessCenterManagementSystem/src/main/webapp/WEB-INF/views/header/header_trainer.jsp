<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="/trainer">헬스일정예약관리시스템</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
         <li class="nav-item ${management}" data-toggle="tooltip" data-placement="right" title="adminUser">
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
          <li class="nav-item ${schedule}" data-toggle="tooltip" data-placement="right" title="Tables">
          <a class="nav-link" href="/trainer">
            <i class="fa fa-fw fa-table"></i>
            <span class="nav-link-text">스케줄</span>
          </a>
        </li>
       <li class="nav-item ${board}" data-toggle="tooltip" data-placement="right" title="Example Pages">
          <a class="nav-link" href="/board.do" >
            <i class="fa fa-fw fa-file"></i>
            <span class="nav-link-text">게시판</span>
          </a>
        </li>
         <li class="nav-item ${mypage}" data-toggle="tooltip" data-placement="right" title="Tables">
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
</body>
</html>