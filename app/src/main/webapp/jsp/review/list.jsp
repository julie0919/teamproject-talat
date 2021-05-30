<%@ page language="java" 
  contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<title>리뷰</title>
</head>
<body>
<h1>리뷰(JSP + JSP 액션태그 + EL + JSTL)</h1>

<table border='1'>
<thead>
<tr>
<th>번호</th> <th>보내는 이</th> <th>받는 이</th> <th>리뷰 메세지</th> <th>별점</th> <th>일자</th>
</tr>
</thead>
<tbody>

<!-- 서블렛에서 mno=1 (관리자)로 설정 관리자가 있다면 -->
<c:if test="${not empty member}">
<c:forEach items="${revD}" var="rd" >
<tr> 
  <td>${rd.rjno}</td> 
  <td>${rd.dwriter.mname}</td> 
  <td>${rd.rpartner.mname}</td> 
  <td>${fn:replace(rd.reviewMessages, ',',' ')}</td> 
  <td>
	  <c:choose>
	    <c:when test="${rd.rstar == 1}">1점</c:when>
	    <c:when test="${rd.rstar == 2}">2점</c:when>  
	    <c:when test="${rd.rstar == 3}">3점</c:when>
	    <c:when test="${rd.rstar == 4}">4점</c:when>
	    <c:when test="${rd.rstar == 5}">5점</c:when>
	  </c:choose>
  </td> 
  <td>${rd.dRevRegisteredDate}</td> 
</tr>
</c:forEach>

<!-- <c:forEach items="${revR}" var="rr">
<tr> 
  <td>${rr.rjno}</td> 
  <td>${rr.rwriter.mname}</td> 
  <td>${rr.dpartner.mname}</td> 
  <td>${fn:replace(rr.reviewMessages, ',',' ')}</td> 
  <td>
    <c:choose>
      <c:when test="${rr.rstar == 1}">1점</c:when>
      <c:when test="${rr.rstar == 2}">2점</c:when>  
      <c:when test="${rr.rstar == 3}">3점</c:when>
      <c:when test="${rr.rstar == 4}">4점</c:when>
      <c:when test="${rr.rstar == 5}">5점</c:when>
    </c:choose>
  </td> 
  <td>${rr.rRevRegisteredDate}</td> 
</tr>
</c:forEach> -->

</c:if>
</tbody>
</table>
</body>
</html>
 