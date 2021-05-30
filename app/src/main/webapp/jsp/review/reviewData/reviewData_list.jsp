<%@ page language="java" 
  contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>리뷰메세지</title>
</head>
<body>
<h1>리뷰 목록</h1>
<p><a href='add'>새 리뷰메세지</a></p>
<table border='1'>
<thead>
<tr>
<th>번호</th> <th>리뷰 메세지</th>
</tr>
</thead>
<tbody>

<c:forEach items="${reviews}" var="r">
<tr> 
  <td>${r.revNo}</td> 
  <td>${r.review}</td> 
</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>
 