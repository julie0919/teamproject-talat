<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>회원가입_추가정보</title>
</head>
<body>
<h1>회원가입_추가정보</h1>
<form action='add' method='post' enctype='multipart/form-data'>
닉네임<br>
<input type='text' name='nicName'><br>
성별<br>
<input type='radio' name='gender' value='0'>여자
<input type='radio' name='gender' value='1'>남자 <br>
<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기"><br>
우편번호<br>
<input type='text' id="postNo" name='postNo'><br>
기본주소<br>
<input type='text' id="basicAddress" name='basicAddress'><br>
상세주소<br>
<input type='text' id="detailAddress" name='detailAddress'><br>

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

프로필사진 등록<br>
<input type='file' name='profile' accept="image/*"><p style='color:red;'>주의_얼굴이 나온 사진첨부</p><br>
선호성별<br>
<input type='radio' name='preferenceGender' value='0'>여자
<input type='radio' name='preferenceGender' value='1'>남자
<input type='radio' name='preferenceGender' value='2'>성별무관<br>
<input type='hidden' name='starAverage' value='5'><br>
<input type='hidden' name='reviewAverage' value='0'><br>
<input type='submit' value='제출하기'> <a href='list'>취소</a>
</form>
</body>
</html>
    