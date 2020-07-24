<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:choose>
	<c:when test="${empty list || fn:length(list) == 0 }">
			<script>
				alert("해당 정보가 삭제되거나 없습니다");
				history.back();
			</script>
	</c:when>
	
	<c:otherwise>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>view</title>
</head>
<script>
function chkSubmit() { // 폼 검증
	frm = document.forms["frm"];

	var memberId = frm["memberId"].value.trim();
	var name = frm["name"].value.trim();
	var phoneNum = frm["phoneNum"].value.trim();
	var email = frm["email"].value.trim();
	var position = frm["position"].value.trim();

	if (memberId == "") {
		alert("직원 번호는 반드시 작성해야 합니다");
		frm["memberId"].focus();
		return false;
	}
	if (name == "") {
		alert("직원 이름는 반드시 입력해야 합니다");
		frm["name"].focus();
		return false;
	}
	if (phoneNum == "") {
		alert("직원 연락처는 반드시 작성해야 합니다");
		frm["phoneNum"].focus();
		return false;
	}
	if (email == "") {
		alert("직원 이메일는 반드시 입력해야 합니다");
		frm["email"].focus();
		return false;
	}
	if (position == "") {
		alert("직원 직급은 반드시 입력해야 합니다");
		frm["position"].focus();
		return false;
	}

return true;
}

function chkDelete(memberId){
	// 삭제 여부, 다시 확인 하고 진행하기
	var r = confirm("삭제하시겠습니까?");
	if(r){
		location.href = 'deleteOk.y?memberId=' + memberId;
	}
}
</script>
<body>
<h2>수정 / 삭제</h2>
<form name="frm" action="updateOk.y" method="post" onsubmit="return chkSubmit()">
직원 번    호 : <input type="text" name="memberId" value="${list[0].memberId }"/><br>
직원 이    름 : <input type="text" name="name" value="${list[0].name }"/><br>
직원 이메일 : <input type="text" name="email" value="${list[0].email }"/><br>
직원 직    급 : <input type="text" name="position" value="${list[0].position }"/><br>
직원 연락처 : <input type="text" name="phoneNum" value="${list[0].phoneNum }"/><br>
<input type="submit" value="수정하기"/>
</form>
<button onclick="location.href='list.y'">목록보기</button>
<button onclick="chkDelete(${list[0].memberId })">삭제하기</button>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>

	</c:otherwise>
</c:choose>













