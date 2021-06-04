<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>라이더 메시지</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
  <link rel="stylesheet" href="../css/reset.css">
  <link rel="stylesheet" href="../css/bootstrap.min.css">
  <style>
  .bg-light {
    background: #fff;
    height: calc(100% - 50px);
  }

  .driver-chat {
    float: right;
    clear: both;
    border-top-left-radius: 0px;
    background: #e4f2ef;
    margin-bottom: 20px;
    display: inline-block;
    padding: 10px;
    color: white;
  }
  
  .arrow_box_driver {
  position: relative;
  background: #46BD7B;
 
}
.arrow_box_driver:after {

  left: 100%;
  top: 70%;
  border: solid transparent;
  content: "";
  height: 0;
  width: 0;
  position: absolute;
  pointer-events: none;
  border-color: rgba(35, 218, 199, 0);
  border-left-color: #46BD7B;
  border-width: 10px;
  margin-top: -15px;
}

  .rider-chat {
    float: left;
    clear: both;
    border-top-left-radius: 0px;
    margin-bottom: 20px;
    background: #c4c4c4;
    display: inline-block;
    padding: 10px;
    color: black;
  }
  
  .arrow_box_rider {
  position: relative;
  background: #c4c4c4;
}
.arrow_box_rider:after{
  right: 100%;
  top: 50%;
  border: solid transparent;
  content: "";
  height: 0;
  width: 0;
  position: absolute;
  pointer-events: none;
  border-color: rgba(196, 196, 196, 0);
  border-right-color: #c4c4c4;
  border-width: 5px;
  margin-top: -5px;
}
  </style>
</head>
<body>
<form action="chatting_add?" method="post">
<c:set scope="request" var="ct" value="${chatting}"/>
<div class="card bg-light mb-3" style="max-width: 100%;">
<div class="card-header">${ct.rider.mname} 라이더</div>
<div class="card-body">
<c:forEach items="${journeys}" var="j">
<c:forEach items="${chattings}" var="c">
<c:if test="${c.journey.jno == j.jno}">
<c:if test="${j.driver.mno == loginUser.mno}">
<div class="chat">
<c:if test="${c.chattingType == 3}">
<span class="rider-chat arrow_box_rider">${ct.rider.mname} 라이더 : ${c.chattingContent}</span>
</c:if>
<c:if test="${c.chattingType == 4}">
<span class="driver-chat arrow_box_driver" >${c.chattingContent}</span>
</c:if>
</div>
</c:if>
</c:if>
</c:forEach>
</c:forEach>
<input type='hidden' name='no' value='${ct.journey.jno}'>
<input type='hidden' name='cttype' value='${4}'>
<input type='hidden' name='mno' value='${ct.rider.mno}'>
<div class="input-group mb-3">
  <input type="text" class="form-control" placeholder="내용을 입력해주세요" aria-describedby="button-addon2" name="input">
  <button class="btn btn-success" type="submit" id="button-addon2">전송</button>
</div>
</div>
</div>
</form>
</body>
</html>
      