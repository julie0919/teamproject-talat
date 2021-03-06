<%@page import="com.talat.pms.domain.JourneyRider"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>여정 상세정보</title>
</head>
<body>
<h1>나의 여정내역</h1>
<p>여정 상세정보</p>
<form action='update' method='post'>
<table border='1'>
<tbody>
<tr><th>여정 날짜</th><td>${journeyRider.journey.journeyDate}</td></tr>
<tr><th>여정 시간</th><td>${journeyRider.journey.journeyTime}</td></tr>
<tr><th>운임 요금</th><td>${journeyRider.journey.fee}</td></tr>
<tr>
<td>
  <input type='submit' value='변경'><a href='delete?no=${journeyRider.journeyRiderNo}'>취소</a> 
</td>
</tr>
</tbody>
<tfoot>
<tr><th>출발지</th> <td><input type='text' name='departure' value='${journeyRider.departure.spotName}' readonly></td></tr>
<tr><th>도착지</th> <td><input type='text' name='Arrival' value='${journeyRider.arrival.spotName}' readonly></td></tr>
</tfoot>
</table>
</form>
<hr>
<p>분실물 문의<br>드라이버 파트너와 연락할 수 있게 도와드립니다.</p>
<p>안전문제보고<br>안전 관련 문제가 있다면 알려주세요.</p>
<p>파트너의 의견 제공<br>안전과 관련 없는 추가적인 의견이 있다면 알려주세요.</p>
<p>여정 관련 고객지원<br>도움이 필요한 다른 문제가 있다면 여기를 클릭하세요.</p>
<a href="list">돌아가기</a>
</body>
</html>