<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>승인 관리</title>
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
    <img src="../jsp/admin/talat_logo.jpeg" alt="logo" style="float: left; width:15%; float:left;"
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

<!--   <a id="spreadBtn02" class="btn01" style="font-size:13px; vertical-align:bottom;">회원관리 ▼</a>
  <ul id="hiddenList01" class="example01" style="display:none; list-style-type:square; background-color:white; border:solid 3px #01DFD7;">
  <li style="font-size:13px;"><a href='adminlist'>회원 조회</a></li>
  <li style="font-size:13px;"><a href='adminapvllist'>드라이버 승인</a></li>
  <li style="font-size:13px;"><a href='adminreview'>리뷰 관리</a></li>
  </ul><br> -->
  <li class="nav-item dropdown"  style="list-style:none;">
      <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">회원관리</a>
    <div class="dropdown-menu">
      <a class="dropdown-item" href="adminlist">회원 조회</a>
      <a class="dropdown-item" href="adminapvllist">드라이버 승인</a>
      <a class="dropdown-item" href="adminreview">리뷰관리</a>
    </div>
  </li>
<!--  <script>
   $(document).ready(function(){
      $("#spreadBtn02").click(function(){
        if($("#hiddenList02").is(":visible")){
           $("#hiddenList02").slideUp();
             }else{
                $("#hiddenList02").slideDown();
              }
          });
        });
  </script> -->
 <li class="nav-item dropdown"  style="list-style:none;">
      <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">카풀관리</a>
    <div class="dropdown-menu">
      <a class="dropdown-item" href="adminjourney">여정관리</a></div></li>
  <br>
    </div>
  </div>
  <div style="margin:35px 0px 0px 80px; float:left;"><a style="background-color:white; font-size:20px;">드라이버 승인</a></div>
  <div style="background-color:#FAFAFA; float:left; width:800px; height:500px; margin:20px 0px 0px 200px; border-top: solid 7px #BDBDBD;">
    <table style="margin:10px auto; width:750px; text-align:center; border-collapse:collapse; border-top:1px solid; border-bottom:1px solid;">
    <thead style="background-color:#D8D8D8;">
      <tr style="border-top:1px solid; border-bottom:1px solid;">
        <th>이름</th>
        <th>프로필</th>
        <th>운전면허증</th>
        <th>보험증</th>
        <th>차량측면</th>
        <th>회사인증</th>
        <th>가입일자</th>
        <th>상태</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${aplist2}" var="a">
      <tr style="border-top:1px solid; border-bottom:1px solid;">
        <td style="background-color:#EFFBFB;">${a.mname}</td>
        <td id="1">승인완료</td>
        <td id="2" style="background-color:#EFFBFB;">승인완료</td>
        <td id="3">승인완료</td>
        <td id="4" style="background-color:#EFFBFB;">승인완료</td>
        <td id="5">승인완료</td>
        <td style="background-color:#EFFBFB;">${a.registeredDate}</td>
        <td><a style="color:blue;">승인완료</a></td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
</div>
</body>
</html>