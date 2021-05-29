<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>드라이버 추가정보</h1>
<form action='addd' method='post'>
면허종류<br>
<input style="margin:10px;" type='radio' name='licenseType' value='1'>1종 보통
<input style="margin:10px;" type='radio' name='licenseType' value='2'>2종 보통<br>
면허번호<br>
<input style="margin:10px;" type='text' name='licenseNo' placeholder='"-"를 제외한 12자리'><br>
면허갱신 예정일<br>
<input style="margin:10px;" type='date' name='licenseRenewal'><br>
면허 인증번호<br>
<input style="margin:10px;" type='text' name='licenseVerfNo' placeholder='사진 밑 6자리번호'><br>
차량번호<br>                                    
<input style="margin:10px;" type='text' name='carNo'><br>
차량모델<br>
<input style="margin:10px;" type='text' name='carModel'><br>
차량색상<br>
<input style="margin:10px;" type='text' name='carColor'><br>
<script type="text/javascript">
  window.onload=function() {
    var minYear=2000
    var maxYear=2021
    
    var strYear="";
    for (var i = minYear; i <= maxYear; i++) {
      strYear += "<option value="+i+">"+i+"</option>"
    }
    document.getElementById("carYear").innerHTML = strYear
  }
</script>
차량연식<br>
<select style="margin:10px;" id='carYear' name='carYear'></select><br>
차량명의<br>
<input style="margin:10px;" type='text' name='carOwner'><br>
면허증 사진<br>
<input type='text' name="licensePhoto" value='obfew928_9344howl.jpg' placeholder='obfew928_9344howl.jpg'><br>
<!-- <input type='file' name='licensePhoto' accept="image/*" multiple="multiple">
           <p style='color:#BDBDBD;'>주민번호 뒷자리는 가려주세요</p><br> -->
보험증 사진<br>
<input type='text' name="insurancePhoto" value='obfew928_9334howl.jpg' placeholder='obfew928_9334howl.jpg'><br>
<!-- <input type='file' name='insurancePhoto' accept="image/*" multiple="multiple">
           <p style='color:#BDBDBD;'>세부정보 식별이 가능한 이미지를 등록해 주세요</p><br> -->
차량 측면 사진<br>
<input type='text' name="carPhoto" value='obfew928_9384howl.jpg' placeholder='obfew928_9384howl.jpg'><br>
<!-- <input type='file' name='carPhoto' accept="image/*" multiple="multiple">
           <p style='color:#BDBDBD;'>번호판은 가리고 찍어주세요</p><br> -->
회사 인증<br>
<input type='text' name="corporationPhoto" value='obfew928_9734howl.jpg' placeholder='obfew928_9734howl.jpg'><br>
<!-- <input type='file' name='corporationPhoto' accept="image/*" multiple="multiple">
           <p style='color:#BDBDBD;'>실명이 포함된 사원증 또는 명함을 등록해 주세요</p><br> -->
<input type="hidden" name="approval" value="0">
<input type='submit' value='제출하기'> <input type="button" onclick="location.href='list'" value="취소">
</form>
</body>
</html>