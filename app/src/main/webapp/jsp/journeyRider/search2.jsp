<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>여정 검색</title>
</head>
<body>
<h1>함께 할 드라이버를 찾아볼까요!</h1>
<form>
<input type='text' name='keyword1' value='${param.keyword1}' readonly>
<input type='text' name='keyword2' value='${param.keyword2}' readonly><br>
<input type='date' name='keyword3' value='${param.keyword3}' readonly>
<input type='time' name='keyword4' value='${param.keyword4}' readonly><br>
</form>
 
 <form action="add" method="post">
<table border='1'>
<thead>
<tr>
<th>여정 번호</th> <th>드라이버</th> <th>출발지</th> <th>도착지</th> <th>시간</th> <th>일자</th> <th>채팅</th> <th>신청</th>
</tr>
</thead>
<tbody>
<c:forEach items="${requestScope.journeyRiders}" var="jr">
<tr>
  <td><a href='detail1?no=${jr.journey.jno}'>${jr.journey.jno}</a></td>
  <td>${jr.driver.mname}</td>
  <td>${jr.departure.spotName}</td> 
  <td>${jr.arrival.spotName}</td> 
  <td>${jr.journey.journeyTime}</td>
  <td>${jr.journey.journeyDate}</td>
  <td>채팅</td>
  <td><input type="submit" value="카풀신청"></td>
</tr>
</c:forEach> 
</tbody>
</table>
</form>
</body>
</html>
      