<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>여정 목록</title>
</head>
<body>
<h1>여정 목록</h1>
<table border='1'>
<thead>
<tr>
<th>번호</th> <th>드라이버</th> <th>출발지</th> <th>도착지</th> <th>시간</th> <th>일자</th>
</tr>
</thead>
<tbody>

<c:forEach items="${list}" var="j">
 <tr>
  <td><a href='detail?jno=${j.jno}'>${j.jno}</a></td>
  <td>${j.driver.mname}</td>
  <td>${j.departure.spotName}</td>
  <td>${j.arrival.spotName}</td>
  
  <!-- javaScript 사용시 다중 submit 을 통해 j.departure / arrival 로 사용가능 -->
  
  <td><fmt:formatDate value="${j.journeyTime}" pattern="HH:mm:ss"/></td>
  <td><fmt:formatDate value="${j.journeyDate}" pattern="yyyy-MM-dd"/></td>
  </tr>
</c:forEach>

</tbody>
</table>
<form action='search' method='get'>
<input type='text' name='keyword'> 
<button>검색</button>
</form>
<form method='get'>
<select name='item'>
  <option value='0' >전체</option>
  <option value='1' >출발지</option>
  <option value='2' >도착지</option>
</select>
<input type='search' name='keyword' value=''> 
<button>검색</button>
</form>
</body>
</html>
    