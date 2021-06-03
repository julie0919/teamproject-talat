<%@ page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>라이더 메시지 목록</title>
<link rel="stylesheet" href="../css/reset.css">
  <link rel="stylesheet" href="../css/bootstrap.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
<h3>받은 메시지</h3>
<table border='1' class="table table-secondary">
<thead>
<tr>
<th scope="col">여정 번호</th>
<th scope="col">보낸 드라이버</th>
<th scope="col">받은 날짜</th>
<th scope="col">받은 시간</th>
</tr>
</thead>
<tbody>
<c:forEach items="${chattings}" var="c">
<c:if test="${c.chattingType == 4}">
<c:if test="${loginUser.mno == c.rider.mno}">
  <tr>    
  <td class="table-success"><a href="#" onClick="window.open('driver_chatting?no=${c.journey.jno}', '_blank','width=400,height=400')">${c.journey.jno}</a></td>
  <td class="table-light">
  <c:forEach items="${journey}" var="j">
    <c:if test="${c.journey.jno == j.jno}">
      ${j.driver.mname} 드라이버
    </c:if>
  </c:forEach>
  </td>
  <td class="table-success"><fmt:formatDate value="${c.chattingDate}" pattern="yyyy-MM-dd"/></td>
  <td class="table-light"><fmt:formatDate value="${c.chattingTime}" pattern="HH:mm:ss"/></td>
  </tr>
  </c:if>
  </c:if>
</c:forEach>
</tbody>
</table>
</body>
</html>