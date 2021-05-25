<%@page import="com.talat.pms.domain.JourneyRider"%>
<%@page import="java.util.List"%>
<%@ page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
    
<!DOCTYPE html>
<html>
<head>
<title>여정 목록</title>
</head>
<body>
<h1>나의 여정내역</h1>
<table border='1'>
<thead>
<tr>
<th>여정신청번호</th> <th>날짜</th> <th>시간</th> <th>운임요금</th> <th>드라이버</th> <th>출발지 - 도착지</th>
</tr>
</thead>
<tbody>

<c:forEach items="${journeyRiders}" var="jr">
<tr>
  <td>${jr.journeyRiderNo}</td>
  <td>${jr.journey.journeyDate}</td>
  <td>${jr.journey.journeyTime}</td>
  <td>운임요금</td>
  <td>드라이버 이름</td>
  <td>출발지 - 도착지</td>
  </tr>
</c:forEach>
</tbody>
</table>
</body>
</html>
      