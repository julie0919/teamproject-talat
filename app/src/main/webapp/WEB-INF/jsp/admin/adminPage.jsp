<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<style type="text/css">
 a:link { color: #01A9DB; text-decoration: none;}
 a:visited { color: #01A9DB; text-decoration: none;}
 a:hover { color: #01A9DB; text-decoration: none;}
</style>

</head>
<script src="http://code.jquery.com/jquery-1.12.0.min.js"></script>
<body>
<div>
  <div style="font-size:13px; height:15px;">
    <img src="../jsp/admin/talat_logo.jpeg" alt="logo" style="float: left; width:15%; float: left;"
    onclick="location.href='admin'">
    <div style="margin:30px; 30px; float:right;">
    <a href="logout"> 로그아웃</a>
    </div>
  </div>
</div>
<!-- 백그라운드 폼 -->
<div style="width:1300px; height:650px; background-color:#e4f2ef; margin:150px auto; float:center;
      border-top: solid 3px #01DFD7;">
  <div style="float:left; width:180px; height:700px; padding:auto; font-size:20px;">
  <div style="width:130px; height:400px; margin:30px auto; text-align:center; ">

  <li class="nav-item dropdown"  style="list-style:none;">
      <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">회원관리</a>
    <div class="dropdown-menu">
      <a class="dropdown-item" href="adminlist">회원 조회</a>
      <a class="dropdown-item" href="adminapvllist">드라이버 승인</a>
      <a class="dropdown-item" href="adminreview">리뷰관리</a>
    </div>
  </li>
 <li class="nav-item dropdown"  style="list-style:none;">
      <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">카풀관리</a>
    <div class="dropdown-menu">
      <a class="dropdown-item" href="adminjourney">여정관리</a></div></li>
    </div>
  </div>
  <div style="background-color: white; float: left; width:550px; height:210px; margin:100px 0px 0px 10px; border-top: solid 3px #01DFD7;">
  처리내역
  </div>
  <div style="background-color: white; float: left; width:330px; height:210px; margin:100px 0px 0px 10px; border-top: solid 3px #01DFD7;">
  신고
  </div>
  <div style="background-color: white; float: left; width:290px; height:210px; margin:20px 0px 0px 10px; border-top: solid 3px #01DFD7;">
  문의
  </div>
  <div style="background-color: white; float: left; width:290px; height:210px; margin:20px 0px 0px 10px; border-top: solid 3px #01DFD7;">
  리뷰
  </div>
  <div style="background-color: white; float: left; width:290px; height:210px; margin:20px 0px 0px 10px; border-top: solid 3px #01DFD7;">
  실시간이용
  </div>
</div>
</body>
</html>