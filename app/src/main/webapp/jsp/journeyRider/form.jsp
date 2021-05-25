<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 카풀</title>
</head>
<body>
<h1>카풀 신청이 완료되었습니다!</h1>
<form action='add' method='post'>
<input type='text' name='' value='출발지' readonly>
<input type='text' name='' value='도착지' readonly><br>
<input type='date' name='' value='날짜' readonly>
<input type='time' name='' value='시간' readonly><br>
<input type='text' name='' value='보조석:1' readonly>
<input type='text' name='' value='반려동물탑승' readonly><br>
<p><a href='list'>카풀 내역 보기</a> <a href='search1'>홈으로 돌아가기</a></p>
</form>
</body>
</html>