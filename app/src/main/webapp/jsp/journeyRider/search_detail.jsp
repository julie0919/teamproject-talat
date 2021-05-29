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
<h1>여정 상세정보</h1>
<form action='search2' method='get'>
<table border='1'>
<tbody>
<tr>
<th>드라이버</th><td>${journeyRider.driver.mname}</td>
<th>평균 별점</th><td>${journeyRider.driver.starAverage}</td>
</tr>
<tr><th>차량정보</th><td>차량색상|차량모델명|차량번호</td></tr>
<tr>
<th>여정 날짜</th><td>${journeyRider.journey.journeyDate}</td>
<th>여정 시간</th><td>${journeyRider.journey.journeyTime}</td>
<th>운임</th><td>${journeyRider.journey.fee}</td>
</tr>
<tr><th>출발지</th><td>${journeyRider.departure.spotName}</td></tr>
<tr><th>경유지</th><td>${journeyRider.spot.spotName}</td></tr>
<tr><th>도착지</th><td>${journeyRider.arrival.spotName}</td></tr>
<tr>
<th>반려동물 탑승</th><td>${journeyRider.journey.pet == 0 ? "아니오" : "예"}</td>
<th>보조석 인원</th><td>${journeyRider.journey.seatPassenger}명</td>
<th>뒷자석 인원</th><td>${journeyRider.journey.seatRear}명</td>
</tr>
<tr><th>여정설명</th><td><textarea name='content' rows='10' cols='60'>${journeyRider.journey.content}</textarea></td></tr>
<tr>
<td>
  <input type='reset' value='돌아가기' onClick="history.back()"><a href='add'>카풀신청</a> 
</td>
</tr>
</tbody>
</table>
</form>
</body>
</html>