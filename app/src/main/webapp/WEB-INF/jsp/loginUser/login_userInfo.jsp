<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="../images/favicon.png" type="image/png"/>
<title>라이더 문의 상세</title>
  <link rel="stylesheet" href="../css/reset.css">
  <link rel="stylesheet" href="../css/bootstrap.min.css">
  <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
  <link rel="stylesheet" href="../css/qnaDetail.css">
</head>
<body>
<div id="wrap">
  <div id="header">
      <a href="../../home"><h1>TALAT</h1><img alt="talat_logo" src="../../../images/talat_logo2.png"></a>
      <ul class="nav nav-pills">
        <li class="nav-item"><a class="nav-link" href="#"><b>마이페이지</b></a></li>
        <li class="nav-item"><a class="nav-link" href="#"><b>고객지원&nbsp;&nbsp;</b></a></li>
        <li class="nav-item"><a class="nav-link logout" href="#"><b>로그아웃</b></a></li>
      </ul>
  </div><!-- id="header" -->
  <div id="content">
    <div id="mainContainer">
      <ul class="nav nav-tabs">
        <li class="nav-item myPage">
          <a class="nav-link disabled" data-bs-toggle="tab" href="#"><h3><b>마이페이지</b></h3></a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" data-bs-toggle="tab" href="#"><b>프로필</b></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" data-bs-toggle="tab" href="#"><b>나의 여정내역</b></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" data-bs-toggle="tab" href="#"><b>고객지원</b></a>
        </li>
      </ul>
      
  <div id="main">
      <c:if test="${not empty loginUserInfo.profile}">
        <c:set var="profileUrl">../upload/${loginUserInfo.profile}_120x120.jpg</c:set>
      </c:if>
      <c:if test="${empty loginUserInfo.profile}">
        <c:set var="profileUrl">../images/person_80x80.jpg</c:set>
      </c:if>
<h1>회원 프로필</h1>
<div id="table_top">
<table style="float:left;">
  <tbody>
  <tr>
  <th colspan="3">
  <a style="font-size:25px;"><b>기본정보</b></a></th>
  <tr> 
    <td rowspan="11"><a><img src='${profileUrl}' class="img-circle" style="border:5px solid gray; margin:3px;"></a><br></td></tr>
  <tr>
    <th>회원번호&nbsp;</th> 
    <td><input name='mno' type='text' value='${loginUserInfo.mno}' readonly>
    <tr>
    <th>이름&nbsp;</th> 
    <td><input name='mname' type='text' value='${loginUserInfo.mname}'>
      <c:if test="${loginUserInfo.mType == 1}">
        <a style="color:#74E19D;"><b> 드라이버님 </b></a>
      </c:if>
      <c:if test="${loginUserInfo.mType == 2}">
        <a style="color:#74E19D;"><b> 라이더님 </b></a>
      </c:if></td></tr>
  <tr>
    <th>닉네임&nbsp;</th> 
    <td><input name='nicName' type='text' value='${loginUserInfo.nickName}'></td></tr>
  <tr>
    <th>전화&nbsp;</th> 
    <td><input name='tel' type='text' value='${loginUserInfo.tel}'><a style="color:#74E19D;"></a></td></tr>
  <tr>
    <th>이메일&nbsp;</th> 
    <td><input name='email' type='text' value='${loginUserInfo.email}'><a style="color:#74E19D;"></a></td></tr>
  <tr>
    <th>생년월일&nbsp;</th> 
    <td><input name='birth' type='date' value='${loginUserInfo.birth}'></td></tr>
  <tr>
    <th>성별&nbsp;</th> 
    <td>
    <input name='gender' type='radio' value='0'${loginUserInfo.gender == 0 ? "checked" : ""}>여자
    <input name='gender' type='radio' value='1'${loginUserInfo.gender == 1 ? "checked" : ""}>남자</td></tr>
  <tr>
    <th rowspan="3">주소&nbsp;</th> 
    <td><input name='postNo' type='text' value='${loginUserInfo.postNo}'></td></tr>
    <tr>
    <td><input name='basicAddress' type='text' value='${loginUserInfo.basicAddress}'></td>
    <tr>
    <td><input name='detailAddress' type='text' value='${loginUserInfo.detailAddress}'></td></tr>
  </table>
  </div>
<div>
<table style="margin-left:20px;">
  <tr>
    <th colspan="2">
    <a style="font-size:25px;"><b>상세정보</b></a></th>
  <tr>
    <th>선호성별&nbsp;</th> 
    <td>
    <input name='preferenceGender' type='radio' value='0'
          ${loginUserInfo.preferenceGender == 0 ? "checked" : ""}>여자
    <input name='preferenceGender' type='radio' value='1'
          ${loginUserInfo.preferenceGender == 1 ? "checked" : ""}>남자
    <input name='preferenceGender' type='radio' value='2'
          ${loginUserInfo.preferenceGender == 2 ? "checked" : ""}>성별무관</td></tr>
<tr>
  <th colspan="2">
    <a style="font-size:25px;">나의평가</a></th>
<tr>
  <th>나의 별점&nbsp;</th>
    <td>
    <a style="color:#FF9933;">${loginUserInfo.starAverage}&nbsp;
        ${loginUserInfo.starAverage == 0 ? "☆☆☆☆☆" :
        loginUserInfo.starAverage > 0 && loginUserInfo.starAverage <= 1 ? "★☆☆☆☆" :
        loginUserInfo.starAverage > 1 && loginUserInfo.starAverage <= 2 ? "★★☆☆☆" :
        loginUserInfo.starAverage >= 2 && loginUserInfo.starAverage <= 3 ? "★★★☆☆" :
        loginUserInfo.starAverage >= 3 && loginUserInfo.starAverage <= 4 ? "★★★★☆" : "★★★★★"}</a></td>
  <tr>
    <th>많이받은리뷰&nbsp;</th>
      <td>${loginUserInfo.reviewAverage == 0 ? "&nbsp;리뷰없음" :
        loginUserInfo.reviewAverage == 1 ? "&nbsp;친절해요!" :
        loginUserInfo.reviewAverage == 2 ? "&nbsp;편안해요!" :
        loginUserInfo.reviewAverage == 3 ? "&nbsp;깨끗해요!" :
        loginUserInfo.reviewAverage == 4 ? "&nbsp;약속된 곳에서 만났어요!" :
        loginUserInfo.reviewAverage == 5 ? "&nbsp;시간 잘 지켜요!" : "약속 잘 지켜요!"}</td></tr>
  </table>
   </div>
    </div><!-- id="main" -->
  </div><!-- id="mainContainer" -->
</div><!-- id="content" -->
</div><!-- id="wrapper" -->
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
     </div><!— id="footer_wrap" —>
  </div><!— id="footer" —>
</body>
</html>