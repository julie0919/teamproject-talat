<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>승인 상세정보</title>
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
  
  thead > th {
  font-weight:bold;
  }
  
</style>
</head>
<body>

  <c:if test="${not empty apmember}">
  <c:if test="${not empty apmember.profile}">
    <c:set var="profileUrl">../upload/${apmember.profile}_120x120.jpg</c:set>
  </c:if>
  <c:if test="${empty apmember.profile}">
    <c:set var="profileUrl">../images/person_80x80.jpg</c:set>
  </c:if>

<form action='apupdate' method='post'>
<table style="border:2px; outset;">
  <tbody>
  <tr>
  <th colspan="3">
  <a style="font-size:25px;">기본정보</a></th>
  <tr> 
    <td rowspan="7"><a><img src='${profileUrl}' class="img-circle" style="border:5px solid gray; margin:3px;"></a><br></td></tr>
    <tr>
    <th>이름</th> 
    <td>${apmember.mname}</td></tr>
  <tr>
    <th>닉네임</th> 
    <td>${apmember.nickName}</td></tr>
  <tr>
    <th>전화</th> 
    <td>${apmember.tel}</td></tr>
  <tr>
    <th>이메일</th> 
    <td>${apmember.email}</td></tr>
  <tr>
    <th>생년월일</th> 
    <td>${apmember.birth}</tr>
  <tr>
    <th>성별</th> 
    <td>${apmember.gender == 0 ? "여자" : "남자"}</td></tr>
  </table>
  <table>
  <tr>
    <th colspan="2">
    <a style="font-size:25px;">상세정보</a></th>
    <th colspan="2">
    <a style="font-size:25px;">나의평가</a></th>
  <tr>
    <th rowspan="3">우편번호<br>
    <td>${apmember.postNo}</td>
    <th>나의 별점</th> 
    <td>${apmember.starAverage}
    <a style="color:#FF9933;">
        ${apmember.starAverage == 0 ? "☆☆☆☆☆" :
        apmember.starAverage > 0 && apmember.starAverage <= 1 ? "★☆☆☆☆" :
        apmember.starAverage > 1 && apmember.starAverage <= 2 ? "★★☆☆☆" :
        apmember.starAverage >= 2 && apmember.starAverage <= 3 ? "★★★☆☆" :
        apmember.starAverage >= 3 && apmember.starAverage <= 4 ? "★★★★☆" : "★★★★★"}</a></td>
    <tr><td>${apmember.basicAddress}</td>
    <th>많이받은<br>리뷰</th> 
    <td>
      ${apmember.reviewAverage == 0 ? "&nbsp;리뷰없음" :
        apmember.reviewAverage == 1 ? "&nbsp;친절해요!" :
        apmember.reviewAverage == 2 ? "&nbsp;편안해요!" :
        apmember.reviewAverage == 3 ? "&nbsp;깨끗해요!" :
        apmember.reviewAverage == 4 ? "&nbsp;약속된 곳에서 만났어요!" :
        apmember.reviewAverage == 5 ? "&nbsp;시간 잘 지켜요!" : "약속 잘 지켜요!"}</td></tr>
    <tr><td>${apmember.detailAddress}</td></tr>
  <tr>
    <th>
    <c:if test="${apmember.mType == 1}">
      드라이버<br>
      선호성별
    </c:if></th> 
    <td>
      ${apmember.preferenceGender == 0 ? "여자" : apmember.preferenceGender == 1 ? "남자" : "성별무관"}></td></tr>
    </table>
  <table>
    <tr>
    <th colspan="2">
    <a style="font-size:25px;">차량정보</a></th>
    <th colspan="2">
    <a style="font-size:25px;">드라이버 상세정보</a></th>
    <th colspan="2">
    <a style="font-size:25px;">첨부파일 목록</a></th>  
  <tr>
    <th>차량번호</th> 
    <td>${apmember.carNo}</td>
    <th>면허번호</th> 
    <td>${apmember.licenseNo}</td>
    <th>운전면허증</th> 
    <td>${apmember.licensePhoto}</td></tr>
  <tr>
    <th>차량모델명</th> 
    <td>${apmember.carModel}</td>
    <th>면허종류</th> 
    <td>${apmember.licenseType == 1 ? "1종보통" : "2종보통"}</td>
    <th>보험증</th> 
    <td>${dmember.insurancePhoto}</td></tr>
  <tr>
    <th>차량색상</th> 
    <td>${apmember.carColor}</td>
    <th>면허갱신일</th> 
    <td>${apmember.licenseRenewal}</td>
    <th>차량측면</th> 
    <td>${apmember.carPhoto}</td></tr>
  <tr>
    <th>차량연식</th> 
    <td>${apmember.carYear}</td>
    <th>면허인증번호</th> 
    <td>${apmember.licenseNo}</td>
    <th>회사인증</th> 
    <td>${apmember.corporationPhoto}</td></tr>
  <tr>
    <th>차량명의</th> 
    <td>${apmember.carOwner}</td>
  <tr>
    <th>면허인증번호</th> 
    <td>${apmember.licenseVerfNo}'></td></tr>
  </tbody>
</table>
<table>
<tbody>
<tr>
  <th colspan="2">
  <a style="font-size:25px;">기타</a></th>
<tr>
<th>승인상태</th> 
    <td><input type="radio" name="approval" value="0" checked><a style='color:red;'>미승인</a>
    <input type="radio" name="approval" value="1"><a style='color:blue;'>승인하기</a></td></tr>
<tr>
<th>승인일자</th> 
    <td><input name=approvalDate type='date' value='${apmember.approvalDate}' readonly></td></tr>
<tr>
<th>비고</th> 
    <td><textarea name=approvalContent rows="3" cols="30">${apmember.approvalContent}</textarea></td></tr>
</tbody>
</table>
  <div style="padding-left:20px; padding-bottom:20px; padding-top:10px;">
    <input type="submit" value="변경">
    <input type="button" value="취소" onclick="location.href='adminapvllist'">
  </div>
</form>
</c:if>
</body>
</html>