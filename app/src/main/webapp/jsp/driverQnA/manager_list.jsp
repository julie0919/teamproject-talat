<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>드라이버 문의 목록_관리자</title>
</head>
<body>
<h1>드라이버 문의 목록_관리자</h1>
<table border='1'>
<thead>
<tr>
<th>번호</th> <th>작성자</th> <th>파트너</th> <th>일자</th> <th>시간</th> <th>상태</th>
</tr>
</thead>
<tbody>
<c:forEach items="${list}" var="dq">
  <tr>
  <td><a href='detail?no=${dq.no}'>${dq.no}</a></td>
  <td>${dq.writer.mname}</td>
  <td>${dq.partner.mname}</td>
  <td><fmt:formatDate value="${dq.registeredDate}" pattern="yyyy-MM-dd"/></td>
  <td><fmt:formatDate value="${dq.registeredDate}" pattern="HH:mm:ss"/></td>
<c:if test="${dq.status==0}">
  <td>답변대기</td>
</c:if>
<c:if test="${dq.status==1}">
  <td>답변완료</td>
</c:if>
  </tr>
</c:forEach>
</tbody>
</table>
</body>
</html>