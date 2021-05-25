<%@page import="com.talat.pms.domain.JourneyRider"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
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
<tr><th>여정 날짜</th><td>날짜</td></tr>
<tr><th>여정 시간</th><td>시간</td></tr>
<tr><th>운임 요금</th><td>요금</td></tr>
<tr>
<td>
  <input type='submit' value='변경'><a href='delete?no='>취소</a> 
</td>
</tr>
</tbody>
<tfoot>
<tr><th>출발지</th> <td><input type='text' name='departure' value='출발지' readonly></td></tr>
<tr><th>도착지</th> <td><input type='text' name='Arrival' value='도착지' readonly></td></tr>
</tfoot>
</table>
</form>
</body>
</html>