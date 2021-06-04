<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="../images/favicon.png" type="image/png"/>
<title>Talat 메인 페이지에 오신 것을 환영합니다!</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
  <link rel="stylesheet" href="../css/reset.css">
  <link rel="stylesheet" href="../css/bootstrap.min.css">
<style>
/* header */
#header{
  height: 70px;
}
#header h1{ 
  position: absolute; left: -9999px; width: 0; height: 0; overflow: hidden; text-indent: -9999px;
}
#header img{
  display: inline-block; position: absolute; left: 50px; top: 20px;
  width: 110px;
}
.nav,.nav-item{
  display: inline-block;
}
#header .nav{
  position: absolute;
  right: 50px;
  top: 24px;
}
a.nav-link{
  padding: 3px 12px;
}
a.nav-link.active:hover{
  background:#23DAC7;
}
.nav-item{
  font-size: 14px;
}

#email, #password {
  width:200px;
  height:40px;
}

#login {
  border-top-left-radius:5px;
  border-bottom-left-radius: 5px;
  border-top-right-radius:5px;
  border-bottom-right-radius: 5px;
  margin:20px;
  background-color:#00FFBF;
  width:90px;
  height:50px;
  border:0;
  online:0;
  font-color:white;
}

/* content */
#content{
  width: 100%;
  background-image:url('../images/main_bg.jpg');
  background-repeat: no-repeat;
  background-position: center top;
  background-size: 100%;
}
#main{
  width: 500px;
  margin: 0 auto;
  padding-top: 150px;
  padding-bottom: 150px;
}
.card-subtitle img{
  display: inline-block;
  width: 72px;
  margin: 0 5px 7px 0px;
}
.card-subtitle span{
  color:#555;
}
.card-body{
  width: 500px;
  padding: 40px 30px 37px 30px;
  text-align: center;
  color: #333;
}
.card-body btn{
  margin-top: 10px;
}
.card-text{
  margin: 20px auto;
  font-size: 14px;
  line-height: 180%;
}

/* footer */
#footer{
  background:#fff;
  width: 100%;
  height: 270px;
  position: absolute;
}
#footer-wrap dt,dl,dd,a{
  display:inline-block;
}
#footer-wrap{
  width: 100%; margin:0 auto;
  height: 180px;
  position: relative;
  margin: 90px 0 0 0px;
  background: rgba(127, 127, 127, 0.2);
}
#inner-footer{
  width: 850px; height: 145px; margin: 0 0 0 50px; position: relative; padding: 23px 0 0 0px;
  font-size: 10px;
  color: #9E9E9E;
  line-height: 150%;
  float:left;
}
#bottom-menu{
  margin:10px auto 25px;
  display:block;
}
#bottom-menu dd{
  font-size: 12px;
}
#bottom_shortcut{
  font-size: 12px;
  margin-bottom: 5px;
}
#inner-footer .hide{
  position: absolute; left: -9999px; width: 0; height: 0; overflow: hidden; text-indent: -9999px;
}
#footer a{text-decoration: none; color: #888;}
#sns-wrap{
  float:right;
  margin:120px 50px 0 0;
}
.sns1,.sns2,.sns3,.sns4{color: #b5b5b5; float:left; padding:0 5px;}
</style>
</head>
<body>
<form method='post'>
  <div id="wrap">
    <div id="header">
        <h1>TALAT</h1><img alt="talat_logo" src="../images/talat_logo2.png">
        <ul class="nav nav-pills">
          <li class="nav-item"><a class="nav-link" href="#"><b>로그인</b></a></li>
          <li class="nav-item"><a class="nav-link" href="#"><b>고객지원&nbsp;&nbsp;</b></a></li>
          <li class="nav-item"><a class="nav-link active" href="#"><b>회원가입</b></a></li>
        </ul>
      </div><!-- id="header" -->
      <div id="content">
        <div id="main">
          <div class="card">
            <div class="card-body">
              <div class="card text-white bg-primary mb-3" style="max-width: 80rem; height: 300px; background-color:#e4f2ef;">
                <div class="card-header" style="padding-top:20px; font-size:30px">로그인</div>
<div class="form-group">
  <div class="form-floating mb-3" style="margin-top:20px;">
    <input type="email" id="email" name="email" placeholder=" UserEmail">
  </div>
  <div class="form-floating">
    <input type="password" id="password" name="password" placeholder=" Password">
  </div>
</div>
  <div>
    <input type="checkbox" name='saveEmail' style="margin:10 auto;"><a style="font-size:12px;">&nbsp;이메일저장&nbsp;</a>
    <a style="font-size:12px;">&nbsp;아이디/비밀번호 찾기</a>
              </div>
              <input id="login" type="submit" value="로그인" style="margin: auto;">
            </div>
          </div>
        </div><!-- id="card" -->
      </div><!-- id="main" -->
    </div><!-- id="content" -->
  </div><!-- id="wrap" -->
</form>
  
  <div id="footer">
    <div id="footer-wrap">
       <div id="inner-footer">
         <dl id="bottom-menu">
           <dt class="hide">하단메뉴</dt>
             <dd><a href="#">서비스 소개</a>&nbsp;&nbsp;</dd>
             <dd><a href="#">이용약관</a>&nbsp;&nbsp;</dd>
             <dd><a href="#">제휴제안</a>&nbsp;&nbsp;</dd>
             <dd><a href="#"><b>개인정보취급방침</b></a>&nbsp;&nbsp;</dd>
             <dd><a href="#">이용안내</a></dd>
         </dl>
         <dl id="bottom_shortcut">
           <dt class="hide">하단바로가기</dt>
             <dd><a href="#">회원가입</a></dd>
             <dd>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">드라이버&nbsp;페이지&nbsp;바로가기</a></dd>
             <dd>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">라이더&nbsp;페이지&nbsp;바로가기</a></dd>
             <dd>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">관리자&nbsp;페이지&nbsp;바로가기</a></dd>
             <dd>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">고객지원</a></dd>
         </dl>
         <address>
           <div class="ellipsis">
             법인명(상호): 주식회사 타랏 | 대표자(성명): 김비트 대표 | 개인정보관리책임자: 이무마(help@talatcorp.com)
           </div>
           <div class="ellipsis">
             사업자등록번호:231-81-23567 [사업자 정보확인] | 주소: 서울특벽시 비트구 비트대로 557 (비트빌딩)5층 &copy;TALAT ALL RESERVED.
           </div>
           <div class="ellipsis">
             고객센터 운영시간:10:00 ~ 18:00 | 고객센터 : 02-111-1111 | 이용문의:talatalatalat@talat.com 
             고객지원 서비스 카카오톡 아이디:@bitbit | 페이스북:@talatalat123
           </div>
         </address>
       </div><!-- id="inner_footer" -->
       <ul id="sns-wrap">
          <li class="sns1">
            <i class="fab fa-twitter-square fa-2x"></i>
          </li>
          <li class="sns2">
            <i class="fab fa-instagram fa-2x"></i>
          </li>
          <li class="sns3">
            <i class="fab fa-youtube fa-2x"></i>
          </li>
          <li class="sns4">
            <i class="fab fa-facebook fa-2x"></i>
          </li>
        </ul>
     </div><!-- id="footer_wrap" -->
  </div><!-- id="footer" -->
</body>
</html>