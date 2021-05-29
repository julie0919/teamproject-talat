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
<h1>회원 프로필</h1>
<c:if test="${empty loginUser}">
  <p>로그인 하지 않았습니다.</p>
</c:if>
<c:if test="${not empty loginUser}">
<table style="border:2px; outset;">
  <tbody>
  <tr>
  <th colspan="3">
  <a style="font-size:25px;">기본정보</a></th>
  <tr> 
    <td rowspan="8"><a><img src='../../upload/${loginUser.profile}_120x120.jpg' class="img-circle" style="border:5px solid gray; margin:3px;"></a><br></td></tr>
  <tr>
    <th>회원번호</th> 
    <td><input name='mno' type='text' value='${loginUser.mno}' readonly>
    <tr>
    <th>이름</th> 
    <td><input name='mname' type='text' value='${loginUser.mname}'>
      <c:if test="${loginUser.mType == 1}">
        <a style="color:#74E19D;"><b> 라이더님</b></a>
      </c:if>
      <c:if test="${loginUser.mType == 2}">
        <a style="color:#74E19D;"><b> 드라이버님</b></a>
      </c:if></td></tr>
  <tr>
    <th>닉네임</th> 
    <td><input name='nicName' type='text' value='${loginUser.nickName}'></td></tr>
  <tr>
    <th>전화</th> 
    <td><input name='tel' type='text' value='${loginUser.tel}'><a style="color:#74E19D;"><b> 인증됨</b></a></td></tr>
  <tr>
    <th>이메일</th> 
    <td><input name='email' type='text' value='${loginUser.email}'><a style="color:#74E19D;"><b> 인증됨</b></a></td></tr>
  <tr>
    <th>생년월일</th> 
    <td><input name='birth' type='date' value='${loginUser.birth}'></td></tr>
  <tr>
    <th>성별</th> 
    <td>
    <input name='gender' type='radio' value='0'${loginUser.gender == 0 ? "checked" : ""}>여자
    <input name='gender' type='radio' value='1'${loginUser.gender == 1 ? "checked" : ""}>남자</td></tr>
  </table>
  <table>
  <tr>
    <th colspan="2">
    <a style="font-size:25px;">상세정보</a></th>
    <th colspan="2">
    <a style="font-size:25px;">나의평가</a></th>
  <tr>
    <th rowspan="3">우편번호</th> 
    <td><input name='postNo' type='text' value='${loginUser.postNo}'></td>
    <th>나의 별점</th> 
    <td><input type="hidden" name="starAverage" value="${loginUser.starAverage}">
    <a style="color:#FF9933;">
        ${loginUser.starAverage == 0 ? "☆☆☆☆☆" :
        loginUser.starAverage > 0 && loginUser.starAverage <= 1 ? "★☆☆☆☆" :
        loginUser.starAverage > 1 && loginUser.starAverage <= 2 ? "★★☆☆☆" :
        loginUser.starAverage >= 2 && loginUser.starAverage <= 3 ? "★★★☆☆" :
        loginUser.starAverage >= 3 && loginUser.starAverage <= 4 ? "★★★★☆" : "5.0 ★★★★★"}</a></td>
    <tr><td><input name='basicAddress' type='text' value='${loginUser.basicAddress}'></td>
    <th>많이받은<br>리뷰</th> 
    <td>
      ${loginUser.reviewAverage == 0 ? "&nbsp;리뷰없음" :
        loginUser.reviewAverage == 1 ? "&nbsp;친절해요!" :
        loginUser.reviewAverage == 2 ? "&nbsp;편안해요!" :
        loginUser.reviewAverage == 3 ? "&nbsp;깨끗해요!" :
        loginUser.reviewAverage == 4 ? "&nbsp;약속된 곳에서 만났어요!" :
        loginUser.reviewAverage == 5 ? "&nbsp;시간 잘 지켜요!" : "약속 잘 지켜요!"}</td></tr>
    <tr><td><input name='detailAddress' type='text' value='${loginUser.detailAddress}'></td></tr>
  <tr>
    <th>
    <c:if test="${loginUser.mType == 1}">
      드라이버<br>
      선호성별
    </c:if>
    <c:if test="${loginUser.mType == 2}">
      라이더<br>
      선호성별
    </c:if></th> 
    <td>
    <input name='preferenceGender' type='radio' value='0'
          ${loginUser.preferenceGender == 0 ? "checked" : ""}>여자
    <input name='preferenceGender' type='radio' value='1'
          ${loginUser.preferenceGender == 1 ? "checked" : ""}>남자
    <input name='preferenceGender' type='radio' value='2'
          ${loginUser.preferenceGender == 2 ? "checked" : ""}>성별무관</td></tr>
    </table>
  <c:if test="${loginUser.mType == 2}">
  <table>
    <tr>
    <th colspan="2">
    <a style="font-size:25px;">차량정보</a></th>
    <th colspan="2">
    <a style="font-size:25px;">드라이버 상세정보</a></th>  
  <tr>
    <th>차량번호</th> 
    <td><input name='carNo' type='text' value='${loginUser.carNo}'></td>
    <th>면허번호</th> 
    <td><input name='licenseNo' type='text' value='${loginUser.licenseNo}'></td></tr>
  <tr>
    <th>차량모델명</th> 
    <td><input name='carModel' type='text' value='${loginUser.carModel}'></td>
    <th>면허종류</th> 
    <td><input name='licenseType' type='text' value='${loginUser.licenseType}'></td></tr>
  <tr>
    <th>차량색상</th> 
    <td><input name='carColor' type='text' value='${loginUser.carColor}'></td>
    <th>면허갱신일</th> 
    <td><input name='licenseRenewal' type='date' value='${loginUser.licenseRenewal}'></td></tr>
  <tr>
    <th>차량연식</th> 
    <td><input name='carYear' type='text' value='${loginUser.carYear}'></td>
    <th>면허인증번호</th> 
    <td><input name='licenseNo' type='text' value='${loginUser.licenseNo}'></td></tr>
  <tr>
    <th>차량명의</th> 
    <td><input name='carOwner' type='text' value='${loginUser.carOwner}'></td></tr>
  <tr>
    <th>면허인증번호</th> 
    <td><input name=licenseVerfNo type='text' value='${loginUser.licenseVerfNo}'></td></tr>
  </tbody>
  </table>
  </c:if>
</c:if>
</body>
</html>