<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 상세정보</title>
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
<body>

  <c:if test="${not empty rmember}">
  <c:if test="${not empty rmember.profile}">
    <c:set var="profileUrl">../../upload/${rmember.profile}_120x120.jpg</c:set>
  </c:if>
  <c:if test="${empty rmember.profile}">
    <c:set var="profileUrl">../../images/person_80x80.jpg</c:set>
  </c:if>

<form action='Rupdate' method='post' enctype='multipart/form-data'>
<table style="border:2px; outset;">
  <tbody>
  <tr>
  <th colspan="3">
  <a style="font-size:25px;">기본정보</a></th>
  <tr> 
    <td rowspan="8"><a><img src='${profileUrl}' class="img-circle" style="border:5px solid gray; margin:3px;"></a><br>
    <input name='profile' type='file' value="${rmember.profile}"></td></tr>
  <tr>
    <th>회원번호</th> 
    <td><input name='mno' type='text' value='${rmember.mno}' readonly>
    <tr>
    <th>이름</th> 
    <td><input name='mname' type='text' value='${rmember.mname}'>
      <c:if test="${rmember.mType == 2}">
        <a style="color:#74E19D;"><b> 라이더님</b></a>
      </c:if>
      <c:if test="${rmember.mType == 1}">
        <a style="color:#74E19D;"><b> 드라이버님</b></a>
      </c:if></td></tr>
  <tr>
    <th>닉네임</th> 
    <td><input name='nickName' type='text' value='${rmember.nickName}'></td></tr>
  <tr>
    <th>전화</th> 
    <td><input name='tel' type='text' value='${rmember.tel}'><a style="color:#74E19D;"><b> 인증됨</b></a></td></tr>
  <tr>
    <th>이메일</th> 
    <td><input name='email' type='text' value='${rmember.email}'><a style="color:#74E19D;"><b> 인증됨</b></a></td></tr>
  <tr>
    <th>생년월일</th> 
    <td><input name='birth' type='date' value='${rmember.birth}'></td></tr>
  <tr>
    <th>성별</th> 
    <td>
    <input name='gender' type='radio' value='0'${rmember.gender == 0 ? "checked" : ""}>여자
    <input name='gender' type='radio' value='1'${rmember.gender == 1 ? "checked" : ""}>남자</td></tr>
  </table>
  <table>
  <tr>
    <th colspan="2">
    <a style="font-size:25px;">상세정보</a></th>
    <th colspan="2">
    <a style="font-size:25px;">나의평가</a></th>
  <tr>
    <th rowspan="3">우편번호<br>
    <input type="button" onclick="execDaumPostcode()" value="우편번호 찾기"></th> 
    <td><input name='postNo' id='postNo' type='text' value='${rmember.postNo}'></td>
    <th>나의 별점</th> 
    <td><a style="color:#FF9933;">
        ${rmember.starAverage == 0 ? "☆☆☆☆☆" :
        rmember.starAverage > 0 && rmember.starAverage <= 1 ? "★☆☆☆☆" :
        rmember.starAverage > 1 && rmember.starAverage <= 2 ? "★★☆☆☆" :
        rmember.starAverage >= 2 && rmember.starAverage <= 3 ? "★★★☆☆" :
        rmember.starAverage >= 3 && rmember.starAverage <= 4 ? "★★★★☆" : "5.0 ★★★★★"}</a></td>
    <tr><td><input name='basicAddress' id='basicAddress' type='text' value='${rmember.basicAddress}'></td>
    <th>많이받은<br>리뷰</th> 
    <td>
      ${rmember.reviewAverage == 0 ? "&nbsp;리뷰없음" :
        rmember.reviewAverage == 1 ? "&nbsp;친절해요!" :
        rmember.reviewAverage == 2 ? "&nbsp;편안해요!" :
        rmember.reviewAverage == 3 ? "&nbsp;깨끗해요!" :
        rmember.reviewAverage == 4 ? "&nbsp;약속된 곳에서 만났어요!" :
        rmember.reviewAverage == 5 ? "&nbsp;시간 잘 지켜요!" : "약속 잘 지켜요!"}</td></tr>
    <tr><td><input name='detailAddress' id='detailAddress' type='text' value='${rmember.detailAddress}'></td></tr>
  <tr>
    <th>
    <c:if test="${rmember.mType == 1}">
      드라이버<br>
      선호성별
    </c:if>
    <c:if test="${rmember.mType == 2}">
      라이더<br>
      선호성별
    </c:if></th> 
    <td>
    <input name='preferenceGender' type='radio' value='0'
          ${rmember.preferenceGender == 0 ? "checked" : ""}>여자
    <input name='preferenceGender' type='radio' value='1'
          ${rmember.preferenceGender == 1 ? "checked" : ""}>남자
    <input name='preferenceGender' type='radio' value='2'
          ${rmember.preferenceGender == 2 ? "checked" : ""}>성별무관</td></tr>
    </table>
  <div style="padding-left:20px; padding-bottom:20px; padding-top:10px;">
    <input type="submit" value="변경">
    <button type="button" onclick="location.href='delete?mno=${rmember.mno}'">삭제</button>
  </div>
  
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
function execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postNo').value = data.zonecode;
                document.getElementById("basicAddress").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("detailAddress").focus();
            }
        }).open();
    }
</script>

</form>
</c:if>
</body>
</html>