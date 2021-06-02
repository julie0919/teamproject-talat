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
<h2>드라이버 목록</h2>
<table border='1'>
<thead>
<tr>
<th style='width:100px;'>이름</th> 
<th style='width:100px;'>이메일</th>
<th style='width:150px;'>전화번호</th>
<th style='width:100px;'>멤버타입</th>
<th style='width:100px;'>승인상태</th>
</tr>
</thead>
<tbody>
<c:forEach items="${list1}" var="m1">
<c:if test="${m1.mType == 1}">
<tr>
<td><a href='detail?mno=${m1.mno}'>${m1.mname}</a></td>
<td>${m1.email}</td>
<td>${m1.tel}</td>
<td>${m1.mType == 1 ? "라이더" : "드라이버"}</td>
<td>${m1.approval == 0 ? "<a style='color:red;'>미승인</a>" : "<a style='color:blue;'>승인완료</a>"}</td>
</tr>
</c:if>
</c:forEach>
</tbody>
</table>
<br>
<h2>라이더 목록</h2>
<table border='1'>
<thead>
<tr>
<th style='width:100px;'>이름</th> 
<th style='width:100px;'>이메일</th>
<th style='width:150px;'>전화번호</th>
<th style='width:100px;'>멤버타입</th>
</tr>
</thead>
<tbody>
<c:forEach items="${list2}" var="m2">
<c:if test="${m2.mType == 2}">
<tr>
<td><a href='detail?mno=${m2.mno}'>${m2.mname}</a></td>
<td>${m2.email}</td>
<td>${m2.tel}</td>
<td>${m2.mType == 1 ? "라이더" : "드라이버"}</td>
</tr>
</c:if>
</c:forEach>
</tbody>
</table>
</body>
</html>