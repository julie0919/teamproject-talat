<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>운영자</title>
</head>
<body>
<table border='1'>
<thead>
<tr>
<th style='width:100px;'>이름</th> 
<th style='width:100px;'>이메일</th>
<th style='width:150px;'>전화번호</th>
<th style='width:100px;'>비고</th>
</tr>
</thead>
<tbody>
<tr>
<td>${ad.mname}</td>
<td>${ad.email}</td>
<td>${ad.tel}</td>
<td>${ad.mType == 0 ? "운영자" : ""}(${ad.mType})</td>
</tr>
</tbody>
</table>
</body>
</html>