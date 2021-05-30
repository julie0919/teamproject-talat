<%@ page language="java" 
  contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>여정 등록</title>
</head>
<body>
<h1>여정 등록</h1>
<p>카풀 등록이 완료되었습니다!</p>

<form action='add' method='post' enctype='multipart/form-data'>
  <table border='1'>
  <tbody>
  <tr>
    <th>출발지</th> 
    <td><input type='text' name='departure' value='${departure}' readonly></td></tr>
  <tr>
    <th>도착지</th> 
    <td><input type='text' name='arrival' value='${arrival}' readonly></td></tr>
  <tr>
    <th>날짜</th> 
    <td><input type='date' name='journeyDate' value='${journeyDate}' readonly></td></tr>
  <tr>
    <th>시간</th> 
    <td><input type='time' name='journeyTime' value='${journeyTime}' readonly></td></tr>
  <tr>
    <th>보조석</th> 
    <td><input type='text' name='seatPsng' value='${seatPassenger}' readonly></td>
    <th>뒷자석</th> 
    <td><input type='text' name='seatRear' value='${seatRear}' readonly></td></tr>

  <tr>
    <th>반려동물 탑승: </th> 
    <td><input type='radio' name='pet' value='0' ${pet == 0 ? "checked" : ""}>예
    <input type='radio' name='pet' value='1' ${pet == 1 ? "checked" : ""}>아니오
    </td></tr>
  </tbody>
  </table>
  </form>

<form action='add' method='post'>
<p>카풀 매칭이 성사되면 드라이버 님의 채팅창으로 연락이 갑니다.<br>
서비스를 계속 이용하실 드라이버 님께서는 다시 시도해주시길 바랍니다.<br>
</p>

<input type='submit' value='카풀 내역 보기'></form>
<div><a href='list'>홈으로 돌아가기</a></div>
</body>
</html>