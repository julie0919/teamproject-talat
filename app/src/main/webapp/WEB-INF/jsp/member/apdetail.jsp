<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>승인관리</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<style type="text/css">
  table {
    border:1px;
    bordercolor:#000000;
    margin-left:20px;
  }
  th, td {
    border:1px solid black;
    padding-left:5px;
  }
  
</style>
</head>
<h1>승인관리</h1>
<body>
<form action='apupdate' method='post'>
<table style="border:2px; outset;">
  <tbody>
  <tr>
    <th>승인여부선택</th>
    <td><input name="approval" type="radio" value="0" ${apmember.approval == 0 ? "checked" : ""}><a style="color:red;">승인거부</a>
        <input name="approval" type="radio" value="1" ${apmember.approval == 1 ? "checked" : ""}><a style="color:blue;">승인</a></td>
  </tr>
  <tr>
    <th>비고</th>
    <td><textarea name="approvalContent" rows='2' cols='15'>${apmember.approvalContent}</textarea></td>
  </tr>
  </tbody>
</table>
<input type="submit" value="변경">
</form>
</body>
</html>