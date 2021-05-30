<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>새 라이더 문의</title>
</head>
<body>
<h1>새 라이더 문의</h1>
<table border='1'>
<tbody>
<tr><th>번호</th> <td>${myJourney.jno}</td></tr>
<tr><th>출발지</th> <td>${myJourney.departure.spotName}</td></tr>
<tr><th>도착지</th> <td>${myJourney.arrival.spotName}</td></tr>
<tr><th>여정날짜</th> <td><fmt:formatDate value="${myJourney.journeyDate}" pattern="yyyy-MM-dd"/></td></tr>
<tr><th>도착시간</th> <td><fmt:formatDate value="${myJourney.journeyTime}" pattern="HH:mm:ss"/></td></tr>
<tr><th>보조석 인원</th> <td>${myJourney.seatPassenger}</td></tr>
<tr><th>뒷자석 인원</th> <td>${myJourney.seatRear}</td></tr>
<c:if test="${myJourney.pet == 0}">
  <tr><th>반려동물 탑승</th><td>아니오</td></tr>
</c:if>
<c:if test="${myJourney.pet == 1}">
  <tr><th>반려동물 탑승</th><td>예</td></tr>
</c:if>
<tr><th>여정 설명</th> <td><textarea name='content' rows='10' cols='60' readonly>${myJourney.content}</textarea></td></tr>
</tbody>
</table>
<hr>
<form action='add2' method='post' enctype="multipart/form-data">
<select name='qtype'>
  <option value='0' disabled>-- 문의유형 --</option>
  <option value='1'>분실물 문의</option>
  <option value='2' selected>안전문제보고</option>
  <option value='3'>파트너의 의견 제공</option>
  <option value='4'>여정 관련 고객지원</option>
</select>
첨부파일: <input type="file" name="file"><br>
<hr>
문의내용: <textarea name='qContent' rows='10' cols='60'></textarea><br>
<p><input type='submit' value='등록'>
<a href='my_journey_list'>목록</a></p>
</form>
</body>
</html>