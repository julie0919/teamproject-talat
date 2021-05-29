<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 카풀</title>
</head>
<body>
<h1>카풀 신청이 완료되었습니다!</h1>
	<input type='text' value='${journeyRiders.departure.spotName}' readonly>
	<input type='text' value='${journeyRiders.arrival.spotName}' readonly><br>
	<input type='date' value='${journeyRiders.journey.journeyDate}' readonly>
	<input type='time' value='${journeyRiders.journey.journeyTime}' readonly><br>
	<input type='text' value='${journeyRiders.journey.seatPassenger}' readonly>
	<input type='text' value='${journeyRiders.journey.seatRear}' readonly>
	<input type='text' value='${journeyRiders.journey.pet}' readonly><br>
<p><a href='my_journey_list'>카풀 내역 보기</a> <a href='search1'>홈으로 돌아가기</a></p>
</body>
</html>