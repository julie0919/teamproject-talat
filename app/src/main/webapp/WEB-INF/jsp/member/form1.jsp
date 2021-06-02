<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>회원가입_기본정보</title>
</head>
<body>
<h1>이용 서비스 선택</h1>
<form action='add2' method='post'>
<input type='radio' name='mType' value='2'>라이더
<input type='radio' name='mType' value='1'>드라이버<br>
<h1>기본정보</h1>
이름<br>
<input type='text' name='mname'><br>
이메일<br>
<input type='text' id="email" name='email'><br>
비밀번호<br>
<input type='password' name='password'><br>
전화번호<br>
<input type='text' name='tel' placeholder='-를 제외하고 입력하세요'><br>
생년월일<br>
<input type='date' name='birth'><br>
<input type='submit' value='다음'> <a href='list'>취소</a>
</form>
</body>
</html>