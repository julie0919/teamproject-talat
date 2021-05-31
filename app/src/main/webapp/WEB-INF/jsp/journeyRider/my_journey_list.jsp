<%@page import="com.talat.pms.domain.JourneyRider"%>
<%@page import="java.util.List"%>
<%@ page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<th>여정신청번호</th> 
<th>여정번호</th>
<th>날짜</th> 
<th>시간</th> 
<th>운임요금</th> 
<th>드라이버</th> 
<th>출발지 - 도착지</th>
<th>별점</th>
</tr>
</thead>
<tbody>
<c:forEach items="${journeyRiders}" var="jr">
<tr>
  <td><a href="my_journey_detail?no=${jr.journeyRiderNo}">${jr.journeyRiderNo}</a></td>
  <td>${jr.journey.jno}</td>
  <td>${jr.journey.journeyDate}</td>
  <td>${jr.journey.journeyTime}</td>
  <td>${jr.journey.fee}</td>
  <td>
  <c:forEach items="${journey}" var="j">
    <c:if test="${jr.journey.jno == j.jno}">
      ${j.driver.mname}
    </c:if>
  </c:forEach>
  </td>
  <td>${jr.departure.spotName} - ${jr.arrival.spotName}</td>
  <td>별점</td>
  </tr>
</c:forEach>
</tbody>
</table>
</body>
<script>
var result = '${msg}';
if(result === 'reqSuccess'){
  alert('등록이 완료되었습니다.');
}
</script>
</html>
      