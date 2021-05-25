<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록</title>
</head>
<body>
<h1>회원 목록</h1>
<p><a href='add1'>회원가입</a></p>
<table border='1'>
<thead>
<tr>
<th style='width:100px;'>이름</th> 
<th style='width:100px;'>이메일</th>
<th style='width:150px;'>전화번호</th>
<th style='width:100px;'>생년월일</th>
<th style='width:100px;'>멤버타입</th>
<th style='width:100px;'>닉네임</th>
<th style='width:100px;'>성별</th>
<th style='width:350px;'>우편번호_주소</th>
<th style='width:100px;'>선호성별</th>
<th style='width:100px;'>가입일</th>
<th style='width:50px;'>별점</th>
<th style='width:100px;'>많이받은 리뷰</th>
</tr>
</thead>
<tbody>
<c:forEach items="${list}" var="m">
<tr>
<td><a href='detail?mno=${m.mno}'>${m.mname}</a></td>
<td>${m.email}</td>
<td>${m.tel}</td>
<td>${m.birth}</td>
<td>${m.mType == 1 ? "라이더" : "드라이버"}</td>
<td>${m.nickName}</td>
<td>${m.gender == 0 ? "여자" : "남자"}</td>
<td>[${m.postNo}]${m.basicAddress}${m.detailAddress}</td>
<td>${m.preferenceGender == 0 ? "여자" : m.preferenceGender == 1 ? "남자" : "성별무관"}</td>
<td>${m.registeredDate}</td>
<td>${m.starAverage}</td>
<td>${m.reviewAverage}</td>
</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>