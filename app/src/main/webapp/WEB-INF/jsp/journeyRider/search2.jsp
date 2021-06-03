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
  <link rel="stylesheet" href="../css/reset.css">
  <link rel="stylesheet" href="../css/bootstrap.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
<h1>함께 할 드라이버를 찾아볼까요!</h1>
<form>
<input type='text' name='keyword1' value='${param.keyword1}' readonly>
<input type='text' name='keyword2' value='${param.keyword2}' readonly><br>
<input type='date' name='keyword3' value='${param.keyword3}' readonly>
<input type='time' name='keyword4' value='${param.keyword4}' readonly><br>
</form>
 
<table class="table table-hover table-secondary" border='1'>
<thead>
<tr>
<th>여정 번호</th> <th>드라이버</th> <th>출발지</th> <th>도착지</th> <th>시간</th> <th>일자</th> <th>채팅</th> <th>신청</th>
</tr>
</thead>
<tbody>
<c:forEach items="${journeyRiders}" var="jr">
<tr>
  <td class="table-success"><a href='search_detail?no=${jr.journey.jno}'>${jr.journey.jno}</a></td>
  <td class="table-light">${jr.driver.mname}</td>
  <td class="table-success">${jr.departure.spotName}</td> 
  <td class="table-light">${jr.arrival.spotName}</td> 
  <td class="table-success">${jr.journey.journeyTime}</td>
  <td class="table-light">${jr.journey.journeyDate}</td>
  <td class="table-success"><button type="button" class="btn btn-success" onclick="window.open('../../driver_chatting?no=${jr.journey.jno}', '_blank','width=400,height=400')">채팅</button></td>
  <td class="table-light"><button type="button" class="btn btn-success" onclick="location.href='add?no=${jr.journey.jno}'">카풀신청</button></td>
  
</tr>
</c:forEach> 
</tbody>
</table>
</body>
</html>
      