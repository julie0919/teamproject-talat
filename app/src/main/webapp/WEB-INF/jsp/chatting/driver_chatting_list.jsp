<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>드라이버 메시지 목록</title>
  <link rel="stylesheet" href="../css/reset.css">
  <link rel="stylesheet" href="../css/bootstrap.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
<h3>받은 메시지</h3>
<table border='1' class="table table-secondary table-hover">
<thead>
<tr>
<th >여정 번호</th>
<th >보낸 라이더</th>
<th >받은 날짜</th>
<th >받은 시간</th>
</tr>
</thead>
<tbody>
  <c:forEach items="${journey}" var="j">
    <c:forEach items="${chattings}" var="c">
    <c:if test="${j.jno== c.journey.jno}">
    <c:if test="${c.chattingType == 3}">
    <c:if test="${j.driver.mno == loginUser.mno}">
  <tr>
  <td class="table-success"><a href="rider_chatting?no=${c.journey.jno}">${c.journey.jno}</a></td>
  <td class="table-light">${c.rider.mname} 라이더</td>
  <td class="table-success"><fmt:formatDate value="${c.chattingDate}" pattern="yyyy-MM-dd"/></td>
  <td class="table-light"><fmt:formatDate value="${c.chattingTime}" pattern="HH:mm:ss"/></td>
  </tr>
  </c:if>
  </c:if>
  </c:if>
  </c:forEach>
  </c:forEach>
</tbody>
</table>
</body>
</html>