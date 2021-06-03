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
	<input type='text' value='${keyword1}' readonly>
	<input type='text' value='${keyword2}' readonly><br>
	<input type='date' value='${keyword3}' readonly>
	<input type='time' value='${keyword4}' readonly><br>
	<input type='text' value='보조석: ${journeyRiders.journey.seatPassenger}  뒷자석: ${journeyRiders.journey.seatRear}' readonly>
	<c:if test="${journeyRiders.journey.pet == 1}">
	<input type='text' value='반려동물 탑승 O' readonly><br> 
	</c:if>
	<c:if test="${journeyRiders.journey.pet == 0}">
  <input type='text' value='반려동물 탑승 X' readonly><br> 
  </c:if>
	<p>카풀 매칭이 성사되면 라이더 님의 채팅창으로 연락이 갑니다.<br>드라이버님의 사유로 인해 매칭이 취소될 수 있는 점 유의바랍니다.</p>
<p><a href='my_journey_list'>카풀 내역 보기</a> <a href='search1'>홈으로 돌아가기</a></p>
</body>
</html>