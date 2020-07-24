<%@page import="oracle.jdbc.proxy.annotation.GetProxy"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.regex.*"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>글작성</title>
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
</script>
<body>
	<h2>직원 등록</h2>
	<%-- 글 내용이 많을수 있기 때문에 POST 방식 사용 --%>
	<form name="frm" action="writeOk.y" method="post"
		onsubmit="return chkSubmit()">
		직원 번호: <input type="text" name="memberId" /><br> 직원 이름: <input
			type="text" name="name" /><br> 직원 연락처: <input type="text"
			name="phoneNum" /><br> 직원 직급: <input type="text"
			name="position" /><br> 직원 이메일: <input type="text" name="email" /><br>
		<input type="submit" value="등록" />
	</form>
	<br>
	<button type="button" onclick="location.href='list.y'">목록으로</button>


</body>
</html>















