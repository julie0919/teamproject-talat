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
<form action='update' method='post' enctype='multipart/form-data'>
<table style="border:2px; outset;">
  <tbody>
  <tr>
    <th>사진</th> 
    <td><a><img src='../upload/${member.profile}_120x120.jpg' class="img-circle" style="border:5px solid gray; margin:3px;"></a><br>
           <input name='photo' type='file'></td></tr>
  <tr>
    <th>회원번호</th> 
    <td><input name='mno' type='text' value='${member.mno}' readonly>
  <tr>
    <th>이름</th> 
    <td><input name='mname' type='text' value='${member.mname}'>
      <c:if test="${member.mType == 1}">
        <a style="color:#74E19D;"><b> 라이더님</b></a>
      </c:if>
      <c:if test="${member.mType == 2}">
        <a style="color:#74E19D;"><b> 드라이버님</b></a>
      </c:if></td></tr>
  <tr>
    <th>닉네임</th> 
    <td><input name='nicName' type='text' value='${member.nicName}'></td></tr>
  <tr>
    <th>전화</th> 
    <td><input name='tel' type='text' value='${member.tel}'><a style="color:#74E19D;"><b> 인증됨</b></a></td></tr>
  <tr>
    <th>이메일</th> 
    <td><input name='email' type='text' value='${member.email}'><a style="color:#74E19D;"><b> 인증됨</b></a></td></tr>
  <tr>
    <th>가입일</th>
    <td>
    <input type="date" name="registereDate" value="${member.registeredDate}" readonly></td></tr>
  <tr>
    <th>생년월일</th> 
    <td><input name='birth' type='date' value='${member.birth}'></td></tr>
  <tr>
    <th>성별</th> 
    <td>
    <input name='gender' type='radio' value='0'${member.gender == 0 ? "checked" : ""}>여자
    <input name='gender' type='radio' value='1'${member.gender == 1 ? "checked" : ""}>남자</td></tr>
  <tr>
    <th>우편번호</th> 
    <td><input name='postNo' type='text' value='${member.postNo}'></td></tr>
  <tr>
    <th>기본주소</th> 
    <td><input name='basicAddress' type='text' value='${member.basicAddress}'></td></tr>
  <tr>
    <th>상세주소</th> 
    <td><input name='detailAddress' type='text' value='${member.detailAddress}'></td></tr>
  <tr>
    <th>
    <c:if test="${member.mType == 1}">
      드라이버<br>
      선호성별
    </c:if>
    <c:if test="${member.mType == 2}">
      라이더<br>
      선호성별
    </c:if></th> 
    <td>
    <input name='preferenceGender' type='radio' value='0'
          ${member.preferenceGender == 0 ? "checked" : ""}>여자
    <input name='preferenceGender' type='radio' value='1'
          ${member.preferenceGender == 1 ? "checked" : ""}>남자
    <input name='preferenceGender' type='radio' value='2'
          ${member.preferenceGender == 2 ? "checked" : ""}>성별무관</td></tr>
  <tr>
    <th>나의 별점</th> 
    <td><input type="hidden" name="starAverage" value="${starAverage}">
    <a style="color:#FF9933;">
        ${member.starAverage}&nbsp;${member.starAverage == 0 ? "☆☆☆☆☆" :
        member.starAverage > 0 && member.starAverage <= 1 ? "★☆☆☆☆" :
        member.starAverage > 1 && member.starAverage <= 2 ? "★★☆☆☆" :
        member.starAverage >= 2 && member.starAverage <= 3 ? "★★★☆☆" :
        member.starAverage >= 3 && member.starAverage <= 4 ? "★★★★☆" : "5.0 ★★★★★"}</a></td></tr>
  <tr>
    <th>많이받은<br>리뷰</th> 
    <td>
      ${member.reviewAverage == 0 ? "&nbsp;없음" :
        member.reviewAverage == 1 ? "&nbsp;친절해요!" :
        member.reviewAverage == 2 ? "&nbsp;편안해요!" :
        member.reviewAverage == 3 ? "&nbsp;깨끗해요!" :
        member.reviewAverage == 4 ? "&nbsp;약속된 곳에서 만났어요!" :
        member.reviewAverage == 5 ? "&nbsp;시간 잘 지켜요!" : "약속 잘 지켜요!"}</td></tr>
  </tbody>
  <tfoot>
  <tr><td colspan='2'>
  <input type="submit" value="변경">
  <button type="button" onclick="location.href='delete?no=${member.mno}'">삭제</button>
  </td></tr>
  </tfoot>
</table>
</form>
</body>
</html>