<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
<title>여정 등록</title>
</head>
<body>
<h1>여정 등록: 2단계</h1>
<p>함께 할 라이더를 찾아볼까요!</p>

<form action='add3' method='post' enctype='multipart/form-data'>
  <table border='1'>
  <tbody>
  <tr>
    <th>출발지</th> 
    <td><input type='text' name='departure' value='${departure}' readonly></td></tr>
  <c:if test="${fn:length(routes) == 3}">
  <tr><th>경유지1</th> 
    <td><input type='text' name='route1' value='${bname2}' readonly></td></tr>
  </c:if>
  <c:if test="${fn:length(routes) == 4}">
  <tr><th>경유지1</th> 
    <td><input type='text' name='route1' value='${bname2}' readonly></td></tr>
  <tr><th>경유지2</th> 
    <td><input type='text' name='route2' value='${bname3}' readonly></td></tr>
  </c:if>
  
  <tr>
    <th>도착지</th> 
    <td><input type='text' name='arrival' value='${arrival}' readonly></td></tr>
  <tr>
    <th>날짜</th> 
    <td><input type='date' name='journeyDate' value='${journeyDate}' readonly></td></tr>
  <tr>
    <th>시간</th> 
    <td><input type='time' name='journeyTime' value='${journeyTime}' readonly></td></tr>
  </tbody>
  </table>
  </form>

<form action='add' method='post'>
<h2>상세 옵션</h2>
라이더 좌석 선택<br>
보조석: <input type='text' name='seatPsng'><br>
뒷좌석: <input type='text' name='seatRear'><br>
반려동물 탑승: 

<input type='radio' name='pet' value='1'>
<label for='pet'>예</label>&nbsp;&nbsp;&nbsp;
<input type='radio' name='pet' value='0'>
<label for='pet'>아니오</label><br>
여정 운임: <input type='text' name='fee'>원<br>
<h2>여정 설명</h2>
<textarea name='journeyContent' rows='10' cols='60'></textarea><br>
<p><input type='submit' value='여정 등록하기'>
<a href='list'>취소</a></p>
</form>
</body>
</html>
