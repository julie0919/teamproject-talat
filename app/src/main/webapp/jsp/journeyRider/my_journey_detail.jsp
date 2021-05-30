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
<c:set scope="session" var="myRjno" value="${journeyRider.journeyRiderNo}"/>
<c:set scope="session" var="myRjourney" value="${journeyRider.journey}"/>
<c:set scope="session" var="myRjourneyRoutes" value="${routes}"/>
<table border='1'>
<tbody>
<tr><th>여정신청번호</th> <td><input type='text' name='journeyRiderNo' value='${journeyRider.journeyRiderNo}' readonly></td></tr>
<tr><th>여정 날짜</th><td>${journeyRider.journey.journeyDate}</td></tr>
<tr><th>여정 시간</th><td>${journeyRider.journey.journeyTime}</td></tr>
<tr><th>운임 요금</th><td>${journeyRider.journey.fee}</td></tr>
<tr>
<td>
  <a href='updateSearch?keyword1=${keyword1}&keyword2=${keyword2}&keyword3=${keyword3}&keyword4=${keyword4}'>변경</a>
  <a href='delete?no=${journeyRider.journeyRiderNo}'>취소</a> 
</td>
</tr>
</tbody>
<tfoot>
<c:forEach items="${routes}" var="r">
<c:if test="${r.spotOrder == 1}">
<tr><th>출발지</th> <td><input type='text' name='departure' value='${r.spotName}' readonly></td></tr>
</c:if>
<c:if test="${r.spotOrder == 2}">
<tr><th>경유지</th> <td><input type='text' name='route1' value='${r.spotName}' readonly></td></tr>
</c:if>
<c:if test="${r.spotOrder == 3}">
<tr><th>경유지</th> <td><input type='text' name='route2' value='${r.spotName}' readonly></td></tr>
</c:if>
<c:if test="${r.spotOrder == 100}">
<tr><th>도착지</th> <td><input type='text' name='arrival' value='${r.spotName}' readonly></td></tr>
</c:if>
</c:forEach>
</tfoot>
</table>
<hr>
<div id=qna1>
  <p><a href="../../qna/rider/add1">분실물 문의</a><br>드라이버 파트너와 연락할 수 있게 도와드립니다.</p>
</div>
<div id=qna2>
  <p><a href="../../qna/rider/add2">안전문제보고</a><br>안전 관련 문제가 있다면 알려주세요.</p>
</div>
<div id=qna3>
  <p><a href="../../qna/rider/add3">파트너의 의견 제공</a><br>안전과 관련 없는 추가적인 의견이 있다면 알려주세요.</p>
</div>
<div id=qna4>
  <p><a href="../../qna/rider/add4">여정 관련 고객지원</a><br>도움이 필요한 다른 문제가 있다면 여기를 클릭하세요.</p>
</div>
<a href="my_journey_list">돌아가기</a>
</body>
</html>