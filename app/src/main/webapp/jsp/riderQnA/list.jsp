<%@page import="com.talat.pms.domain.RiderQnA"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>라이더 문의 목록</title>
</head>
<body>
<h1>라이더 문의 목록</h1>
<table border='1'>
<thead>
<tr>
<th>번호</th> <th>문의 유형</th> <th>작성자</th> <th>파트너</th> <th>등록일</th> <th>답변상태</th>
</tr>
</thead>
<tbody>
<%
List<RiderQnA> list = (List<RiderQnA>) request.getAttribute("list");
for (RiderQnA rq : list) {
  out.println("<tr>");
  out.println("<td><a href='detail?no=" + rq.getNo() + "'>" + rq.getNo() + "</a></td>");
  out.println("<td>" + rq.getQtype().getTypeTitle() + "</td>");
  out.println("<td>" + rq.getWriter().getMname() + "</td>");
  out.println("<td>" + rq.getPartner().getMname() + "</td>");
  out.println("<td>" + rq.getRegisteredDate() + "</td>");
  if (rq.getStatus() == 0) {
    out.println("<td>답변대기</td>");
  } else {
    out.println("<td>답변완료</td>");
  }
  out.println("</tr>");
}
%>
</tbody>
</table>
</body>
</html>