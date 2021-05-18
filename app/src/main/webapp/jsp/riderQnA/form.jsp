<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.talat.pms.domain.RiderQnA"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>새 라이더 문의</title>
</head>
<body>
<h1>새 라이더 문의</h1>
<form action='add' method='post'>
<hr>
<select name='qtype'>
  <option value='0' selected disabled>-- 문의유형 --</option>
  <option value='1'>분실물 문의</option>
  <option value='2'>안전문제보고</option>
  <option value='3'>파트너의 의견 제공</option>
  <option value='4'>여정 관련 고객지원</option>
</select>
첨부파일: <br>
<hr>
문의내용: <textarea name='qContent' rows='10' cols='60'></textarea><br>
<p><input type='submit' value='등록'>
<a href='list'>목록</a></p>
</form>
</body>
</html>