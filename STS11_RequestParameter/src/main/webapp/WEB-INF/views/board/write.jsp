<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<script>
function chkSubmit() {
	frm = document.forms["frm"];
	
	var name = forms["name"].value.trim();
	var subject = frm["subject"].value.trim();
	if(name==""){
		alert("작성란은 반드시 입력해야 합니다.");
		frm["name"].focus();
		return false;
	}
	if(subject==""){
		alert("제목은 반드시 작성해야 합니다. ");
		frm["subject"].focus();
		return false;
	}
	return true;
}
</script>
<body>
<h2>글작성</h2>
<%-- 글 내용이 많을수 있기 때문에 POST 방식 사용 --%>
<form name="frm" action="writeOk" method="post" onsubmit="return chkSubmit()">
<%-- int 매개변수  받는 setter 도 동작할까? --%>
uid : <input type = "text" name = "uid" value = "123"/><br> <!-- spring 에서 알아서 parseInt 된다 -->
 작성자:
<input type="text" name="name" value = "기무찌"/><br> 
제목:
<input type="text" name="subject" value="기뮤경"/><br>
내용:<br>
<textarea name="content">기뮤다</textarea> <%--게시글 사이즈를 모르기때문에 POST 방식 --%>
<br><br>
<input type="submit" value="등록"/>
</form>
<br>
<button type="button" onclick="location.href='list.jsp'">목록으로</button>
</body>





</html>














