<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰관리</title>

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
  <script>
  $(document).ready(function(){
    $("#spreadBtn01").click(function(){
      if($("#hiddenList01").is(":visible")){
         $("#hiddenList01").slideUp();
           }else{
              $("#hiddenList01").slideDown();
            }
        });
      });
  </script> 
<a id="spreadBtn01" class="btn01" style="font-size:13px; vertical-align:bottom;">회원관리 ▼</a>
  <ul id="hiddenList01" class="example01" style="display:none; list-style-type:square; background-color:white; border:solid 3px #01DFD7;">
  <li style="font-size:13px;"><a href='adminlist'>회원 조회</a></li>
  <li style="font-size:13px;"><a href='adminapvllist'>드라이버 승인</a></li>
  <li style="font-size:13px;"><a href='adminreview'>리뷰 관리</a></li>
  </ul><br>
    <script>
  $(document).ready(function(){
      $("#spreadBtn02").click(function(){
        if($("#hiddenList02").is(":visible")){
           $("#hiddenList02").slideUp();
             }else{
                $("#hiddenList02").slideDown();
              }
          });
        });
  </script>
<a id="spreadBtn02" class="btn02" style="font-size:13px; vertical-align:bottom;">카풀관리 ▼</a>
  <ul id="hiddenList02" class="example02" style="display:none; list-style-type:square; background-color:white; border:solid 3px #01DFD7;">
  <li style="font-size:13px;"><a href='adminjourney'>여정 관리</a></li>
  </ul><br>
    </div>
  </div>
  <div style="margin:35px 0px 0px 80px; float:left;"><a style="background-color:white; font-size:20px;">리뷰 관리</a></div>
  <div style="background-color:#FAFAFA; float:left; width:800px; height:500px; margin:20px 0px 0px 200px; border-top: solid 7px #BDBDBD;">
  </div>
</div>
</body>
</html>