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
<h1>여정 상세정보</h1>
<jsp:useBean id="journeyRider" type="com.talat.pms.domain.JourneyRider" scope="request"/>
<%
if (journeyRider != null) {
%>
<form action='search2' method='post'>
<table border='1'>
<tbody>
<tr><th>여정번호</th> <td><%=journeyRider.getJourney().getJno()%></td></tr>
<tr>
<th>드라이버</th><td><%=journeyRider.getDriver().getMname()%></td>
<th>평균 별점</th><td><%=journeyRider.getDriver().getStarAverage()%></td>
</tr>
<tr><th>차량정보</th><td>차량정보</td></tr>
<tr>
<th>여정 날짜</th><td><%=journeyRider.getJourney().getJourneyDate()%></td>
<th>여정 시간</th><td><%=journeyRider.getJourney().getJourneyTime()%></td>
<th>운임 요금</th><td><%=journeyRider.getJourney().getFee()%></td>
</tr>
<tr><th>출발지</th><td><%=journeyRider.getJourney().getDeparture()%></td></tr>
<tr><th>경유지</th><td><%=journeyRider.getRoute().getSpotName()%></td></tr>
<tr><th>도착지</th><td><%=journeyRider.getJourney().getArrival()%></td></tr>
<tr>
<th>반려동물 탑승</th><td><%=journeyRider.getJourney().getPet()%></td>
<th>보조석 인원</th><td><%=journeyRider.getJourney().getSeatPassenger()%></td>
<th>뒷자석 인원</th><td><%=journeyRider.getJourney().getSeatRear()%></td>
</tr>
<tr><th>여정설명</th><td><%=journeyRider.getJourney().getContent()%></td></tr>
<tr>
<td>
  <input type='submit' value='돌아가기'><a href='add1'>카풀신청</a> 
</td>
</tr>
</tbody>
<%}%>
</table>
</form>
</body>
</html>