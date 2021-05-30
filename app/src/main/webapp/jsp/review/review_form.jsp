<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>드라이버 리뷰 등록</title>
</head>
<body>
<h1>리뷰 등록</h1>
<p>만족스러운 여정이셨나요?</p>

<form action='add' method='post' enctype='multipart/form-data'>

별점: 
<input type='radio' name='star' value='1'>1점 
<input type='radio' name='star' value='2'>2점
<input type='radio' name='star' value='3'>3점
<input type='radio' name='star' value='4'>4점
<input type='radio' name='star' value='5'>5점<br>

<br>

리뷰 메세지: <br>
<jsp:include page="/jsp/review/review_list.jsp"/>
<p><input type='submit' value='제출하기'>
<a href='list'>취소</a></p>

</form>
</body>
</html>

