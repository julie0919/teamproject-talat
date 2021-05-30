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
<h1>드라이버 목록</h1>
<p><a href='add1'>회원가입</a></p>
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
<c:forEach items="${list}" var="m">
<tr>
<td><a href='detail?mno=${m.mno}'>${m.mname}</a></td>
<td>${m.email}</td>
<td>${m.tel}</td>
<td>${m.mType == 1 ? "라이더" : "드라이버"}</td>
</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>