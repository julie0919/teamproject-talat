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
    border:1px solid black;
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
<table>
  <tbody>
  <tr>
    <th>사진</th> 
    <td><img src='upload/${loginUser.profile}_120x120.jpg' class="img-circle" style="border:5px solid gray; margin:3px;"></td></tr>
  <tr>
    <th>이름</th> 
    <td>${loginUser.mname}&nbsp;
      <c:if test="${loginUser.mType == 1}">
        <a style="color:#74E19D;"><b> 라이더님</b></a>
      </c:if>
      <c:if test="${loginUser.mType == 2}">
        <a style="color:#74E19D;"><b> 드라이버님</b></a>
      </c:if></td></tr>
  <tr>
    <th>닉네임</th> 
    <td>${loginUser.nicName}</td></tr>
  <tr>
    <th>전화</th> 
    <td>${loginUser.tel}<a style="color:#74E19D;"><b> 인증됨&nbsp;</b></a></td></tr>
  <tr>
    <th>이메일</th> 
    <td>${loginUser.email}<a style="color:#74E19D;"><b> 인증됨&nbsp;</b></a></td></tr>
  <tr>
    <th>가입일</th> 
    <td>${loginUser.registeredDate}</td></tr>
  <tr>
    <th>생년월일</th> 
    <td>${loginUser.birth}</td></tr>
  <tr>
    <th>성별</th> 
    <td>
    <c:if test="${loginUser.gender == 0}">
      <a>여자</a>
    </c:if>
    <c:if test="${loginUser.gender == 1}">
      <a>남자</a>
    </c:if></td></tr>
  <tr>
    <th>우편번호</th> 
    <td>${loginUser.postNo}</td></tr>
  <tr>
    <th>기본주소</th> 
    <td>${loginUser.basicAddress}</td></tr>
  <tr>
    <th>상세주소</th> 
    <td>${loginUser.detailAddress}</td></tr>
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
      ${loginUser.preferenceGender == 0 ? "checked onclick='return(false);'" : "onclick='return(false);'"}>여자
    <input name='preferenceGender' type='radio' value='1'
      ${loginUser.preferenceGender == 1 ? "checked onclick='return(false);'" : "onclick='return(false);'"}>남자
    <input name='preferenceGender' type='radio' value='2'
      ${loginUser.preferenceGender == 2 ? "checked onclick='return(false);'" : "onclick='return(false);'"}>성별무관
  <tr>
    <th>나의 별점</th> 
    <td><a style="color:#FF9933;">
        ${loginUser.starAverage}&nbsp;${loginUser.starAverage == 0 ? "☆☆☆☆☆" :
        loginUser.starAverage > 0 && loginUser.starAverage <= 1 ? "★☆☆☆☆" :
        loginUser.starAverage > 1 && loginUser.starAverage <= 2 ? "★★☆☆☆" :
        loginUser.starAverage >= 2 && loginUser.starAverage <= 3 ? "★★★☆☆" :
        loginUser.starAverage >= 3 && loginUser.starAverage <= 4 ? "★★★★☆" : "5.0 ★★★★★"}</a></td></tr>
  <tr>
    <th>많이받은<br>리뷰</th> 
    <td>
      ${loginUser.reviewAverage == 0 ? "&nbsp;없음" :
        loginUser.reviewAverage == 1 ? "&nbsp;친절해요!" :
        loginUser.reviewAverage == 2 ? "&nbsp;편안해요!" :
        loginUser.reviewAverage == 3 ? "&nbsp;깨끗해요!" :
        loginUser.reviewAverage == 4 ? "&nbsp;약속된 곳에서 만났어요!" :
        loginUser.reviewAverage == 5 ? "&nbsp;시간 잘 지켜요!" : "약속 잘 지켜요!"}</td></tr>
  </tbody>
  <tfoot>
  <tr><td colspan='2'>
  </td></tr>
</tfoot>
</table>
</c:if>
</body>
</html>