<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${routeNum == 1}">
    <input type='text' name='route1'><br>
  <c:if test="${routeNum == 2}">
    <input type='text' name='route1'><br>
    <input type='text' name='route2'><br>
    <c:if test="${routeNum > 2}">
      <p>경유지는 2개까지 가능합니다. </p>
    </c:if>
  </c:if>
</c:if>
<c:if test="${routeNum == 0}">
  <p>경유지를 추가하지 않았습니다. </p>
</c:if>