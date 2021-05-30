<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>여정 등록</title>
</head>
<body>
<h1>여정 등록: 1단계</h1>
<p>함께 할 라이더를 찾아볼까요!</p>

<form action='add2' method='post'>
출발지: <input type='text' name='departure'><br>
경유지1: <input type='text' name='route1'><br>
경유지2: <input type='text' name='route2'><br>
도착지: <input type='text' name='arrival'><br>
날짜: <input type='date' name='journeyDate'><br>
시간: <input type='time' name='journeyTime'><br>
<p><input type='submit' value='여정 등록하기'>
<a href='list'>취소</a></p>
</form>
</body>
</html>


<!-- 하나의 form에서는 하나의 액션만 취하는것이 맞습니다. 
form 하나로 두개의 액션을 취하고 싶다면, 
첫번째 액션을 ajax로 호출해서 submit 이 성공했을때 
callback 함수로 두번째 액션을 다시 ajax로 호출하면 될것 같습니다. -->

<!-- javaScript 사용시
function submit2(frm) {
frm.action = '../../route/add'
frm.submit();
return true;
}
</script>

<form action='../../route/add' method='post'>

<form action='add2' method= 'post'>
input type='submit' value='여정 등록하기'
input type='button' value='경로 등록하기' onclick='return submit2(this.form);'>
</form> -->