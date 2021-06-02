<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>드라이버 승인</title>
</head>
<body>
<h1>드라이버 승인관리</h1>
<!-- <form action="apupdate" method="post"> -->
<table border="1">
<thead>
<tr>
<th style='width:100px;'>이름</th>
<th style='width:100px;'>프로필</th>
<th style='width:100px;'>운전면허증</th>
<th style='width:100px;'>보험증</th>
<th style='width:100px;'>차량측면</th>
<th style='width:100px;'>회사인증</th>
<th style='width:100px;'>가입일자</th>
<th style='width:100px;'>상태</tr>
</thead>
<tbody>
<c:forEach items="${aplist}" var="a">
<tr>
<td>${a.mname}</td>
<td>${a.profile != null ? "제출완료" : ""}</td>
<td>${a.licensePhoto != null ? "제출완료" : ""}</td>
<td>${a.insurancePhoto != null ? "제출완료" : ""}</td>
<td>${a.carPhoto != null ? "제출완료" : ""}</td>
<td>${a.corporationPhoto != null ? "제출완료" : ""}</td>
<td>${a.registeredDate}</td>
<td align="center">
<c:if test="${a.approval == 0}">
  <a style="color:red;" href="apdetail?mno=${a.mno}">승인대기</a></c:if>
<c:if test="${a.approval == 1}">
  <a style="color:blue;">승인완료</a></c:if>
</td>
</c:forEach>
</tbody>
</table>
</body>
</html>