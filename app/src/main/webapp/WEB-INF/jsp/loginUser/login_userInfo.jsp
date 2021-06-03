<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 상세정보</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<style type="text/css">
  table {
    border:1px;
    bordercolor:#000000;
    margin-left:20px;
  }
  th, td {
    border:1px solid black;
    padding-left:5px;
  }
  
</style>
</head>
<body>

  <c:if test="${not empty loginUserInfo.profile}">
    <c:set var="profileUrl">../upload/${loginUserInfo.profile}_120x120.jpg</c:set>
  </c:if>
  <c:if test="${empty loginUserInfo.profile}">
    <c:set var="profileUrl">../images/person_80x80.jpg</c:set>
  </c:if>

<h1>회원 프로필</h1>
<table style="border:2px; outset;">
  <tbody>
  <tr>
  <th colspan="3">
  <a style="font-size:25px;">기본정보</a></th>
  <tr> 
    <td rowspan="8"><a><img src='${profileUrl}' class="img-circle" style="border:5px solid gray; margin:3px;"></a><br></td></tr>
  <tr>
    <th>회원번호</th> 
    <td><input name='mno' type='text' value='${loginUserInfo.mno}' readonly>
    <tr>
    <th>이름</th> 
    <td><input name='mname' type='text' value='${loginUserInfo.mname}'>
      <c:if test="${loginUserInfo.mType == 1}">
        <a style="color:#74E19D;"><b> 드라이버님</b></a>
      </c:if>
      <c:if test="${loginUserInfo.mType == 2}">
        <a style="color:#74E19D;"><b> 라이더님</b></a>
      </c:if></td></tr>
  <tr>
    <th>닉네임</th> 
    <td><input name='nicName' type='text' value='${loginUserInfo.nickName}'></td></tr>
  <tr>
    <th>전화</th> 
    <td><input name='tel' type='text' value='${loginUserInfo.tel}'><a style="color:#74E19D;"><b> 인증됨</b></a></td></tr>
  <tr>
    <th>이메일</th> 
    <td><input name='email' type='text' value='${loginUserInfo.email}'><a style="color:#74E19D;"><b> 인증됨</b></a></td></tr>
  <tr>
    <th>생년월일</th> 
    <td><input name='birth' type='date' value='${loginUserInfo.birth}'></td></tr>
  <tr>
    <th>성별</th> 
    <td>
    <input name='gender' type='radio' value='0'${loginUserInfo.gender == 0 ? "checked" : ""}>여자
    <input name='gender' type='radio' value='1'${loginUserInfo.gender == 1 ? "checked" : ""}>남자</td></tr>
  </table>
  <table>
  <tr>
    <th colspan="2">
    <a style="font-size:25px;">상세정보</a></th>
    <th colspan="2">
    <a style="font-size:25px;">나의평가</a></th>
  <tr>
    <th rowspan="3">우편번호</th> 
    <td><input name='postNo' type='text' value='${loginUserInfo.postNo}'></td>
    <th>나의 별점</th> 
    <td><input type="hidden" name="starAverage" value="${loginUserInfo.starAverage}">
    <a style="color:#FF9933;">
        ${loginUserInfo.starAverage == 0 ? "☆☆☆☆☆" :
        loginUserInfo.starAverage > 0 && loginUserInfo.starAverage <= 1 ? "★☆☆☆☆" :
        loginUserInfo.starAverage > 1 && loginUserInfo.starAverage <= 2 ? "★★☆☆☆" :
        loginUserInfo.starAverage >= 2 && loginUserInfo.starAverage <= 3 ? "★★★☆☆" :
        loginUserInfo.starAverage >= 3 && loginUserInfo.starAverage <= 4 ? "★★★★☆" : "5.0 ★★★★★"}</a></td>
    <tr><td><input name='basicAddress' type='text' value='${loginUserInfo.basicAddress}'></td>
    <th>많이받은<br>리뷰</th> 
    <td>
      ${loginUserInfo.reviewAverage == 0 ? "&nbsp;리뷰없음" :
        loginUserInfo.reviewAverage == 1 ? "&nbsp;친절해요!" :
        loginUserInfo.reviewAverage == 2 ? "&nbsp;편안해요!" :
        loginUserInfo.reviewAverage == 3 ? "&nbsp;깨끗해요!" :
        loginUserInfo.reviewAverage == 4 ? "&nbsp;약속된 곳에서 만났어요!" :
        loginUserInfo.reviewAverage == 5 ? "&nbsp;시간 잘 지켜요!" : "약속 잘 지켜요!"}</td></tr>
    <tr><td><input name='detailAddress' type='text' value='${loginUserInfo.detailAddress}'></td></tr>
  <tr>
    <th>
    <c:if test="${loginUserInfo.mType == 1}">
      드라이버<br>
      선호성별
    </c:if>
    <c:if test="${loginUserInfo.mType == 2}">
      라이더<br>
      선호성별
    </c:if></th> 
    <td>
    <input name='preferenceGender' type='radio' value='0'
          ${loginUserInfo.preferenceGender == 0 ? "checked" : ""}>여자
    <input name='preferenceGender' type='radio' value='1'
          ${loginUserInfo.preferenceGender == 1 ? "checked" : ""}>남자
    <input name='preferenceGender' type='radio' value='2'
          ${loginUserInfo.preferenceGender == 2 ? "checked" : ""}>성별무관</td></tr>
    </table>
  <c:if test="${loginUserInfo.mType == 1}">
  <table>
    <tr>
    <th colspan="2">
    <a style="font-size:25px;">차량정보</a></th>
    <th colspan="2">
    <a style="font-size:25px;">드라이버 상세정보</a></th>  
  <tr>
    <th>차량번호</th> 
    <td><input name='carNo' type='text' value='${loginUserInfo.carNo}'></td>
    <th>면허번호</th> 
    <td><input name='licenseNo' type='text' value='${loginUserInfo.licenseNo}'></td></tr>
  <tr>
    <th>차량모델명</th> 
    <td><input name='carModel' type='text' value='${loginUserInfo.carModel}'></td>
    <th>면허종류</th> 
    <td><input name='licenseType' type='text' value='${loginUserInfo.licenseType}'></td></tr>
  <tr>
    <th>차량색상</th> 
    <td><input name='carColor' type='text' value='${loginUserInfo.carColor}'></td>
    <th>면허갱신일</th> 
    <td><input name='licenseRenewal' type='date' value='${loginUserInfo.licenseRenewal}'></td></tr>
  <tr>
    <th>차량연식</th> 
    <td><input name='carYear' type='text' value='${loginUserInfo.carYear}'></td>
    <th>면허인증번호</th> 
    <td><input name='licenseNo' type='text' value='${loginUserInfo.licenseNo}'></td></tr>
  <tr>
    <th>차량명의</th> 
    <td><input name='carOwner' type='text' value='${loginUserInfo.carOwner}'></td></tr>
  <tr>
    <th>면허인증번호</th> 
    <td><input name=licenseVerfNo type='text' value='${loginUserInfo.licenseVerfNo}'></td></tr>
  </tbody>
  </table>
  </c:if>
</body>
</html>