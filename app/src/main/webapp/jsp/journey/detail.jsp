<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>여정 상세</title>
</head>
<body>
<h1>여정 상세보기</h1>
<form action='update' method='post'>
<table border='1'>
<tbody>
<tr><th>번호</th> <td><input type='text' name='jno' value='${journey.jno}' readonly></td></tr>
<c:forEach items="${routes}" var="r">
<c:if test="${r.spotOrder==1}">
<tr><th>출발지</th> <td><input name='departure' type='text' value='${r.spotName}'></td></tr>
</c:if>
<c:if test="${r.spotOrder==2}">
    <tr><th>경유지</th><td><input name='route1' type='text' value='${r.spotName}'></td></tr>
</c:if>
<c:if test="${r.spotOrder==3}">
    <tr><th>경유지</th><td><input name='route2' type='text' value='${r.spotName}'></td></tr>
</c:if>
<c:if test="${r.spotOrder==100}">
<tr><th>도착지</th> <td><input name='arrival' type='text' value='${r.spotName}'></td></tr>
</c:if>
</c:forEach>

<tr><th>여정날짜</th> <td><fmt:formatDate value="${journey.journeyDate}" pattern="yyyy-MM-dd"/></td></tr>
<tr><th>도착시간</th> <td><fmt:formatDate value="${journey.journeyTime}" pattern="HH:mm:ss"/></td></tr>
<tr><th>보조석 인원</th> <td>${journey.seatPassenger}</td></tr>
<tr><th>뒷자석 인원</th> <td>${journey.seatRear}</td></tr>
<c:if test="${journey.pet == 0}">
  <tr><th>반려동물 탑승</th><td>아니오</td></tr>
</c:if>
<c:if test="${journey.pet == 1}">
  <tr><th>반려동물 탑승</th><td>예</td></tr>
</c:if>
<tr><th>여정 설명</th> <td><textarea name='content' rows='10' cols='60'>${journey.content}</textarea></td></tr>
</tbody>
</table>
<input type='submit' value='변경'> 
<a href='delete?jno=${journey.jno}'>삭제</a>
</form>
<p><a href='list'>목록</a></p>
</body>
</html>
