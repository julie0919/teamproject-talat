<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>라이더 문의 목록_관리자</title>
</head>
<body>
<h1>라이더 문의 목록_관리자</h1>
<table border='1'>
<thead>
<tr>
<th>번호</th> <th>작성자</th> <th>파트너</th> <th>일자</th> <th>시간</th> <th>상태</th>
</tr>
</thead>
<tbody>
<c:forEach items="${list}" var="rq">
  <tr>
  <td><a href='detail?no=${rq.no}'>${rq.no}</a></td>
  <td>${rq.writer.mname}</td>
  <td>${rq.partner.mname}</td>
  <td><fmt:formatDate value="${rq.registeredDate}" pattern="yyyy-MM-dd"/></td>
  <td><fmt:formatDate value="${rq.registeredDate}" pattern="HH:mm:ss"/></td>
<c:if test="${rq.status==0}">
  <td>답변대기</td>
</c:if>
<c:if test="${rq.status==1}">
  <td>답변완료</td>
</c:if>
  </tr>
</c:forEach>
</tbody>
</table>
</body>
</html>