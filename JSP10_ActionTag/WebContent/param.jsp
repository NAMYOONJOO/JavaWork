<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>param</title>
</head>
<body>
<!-- Action Tag -->
<h2>현재 페이지는 param 페이지 </h2>
<%
int num = 788;
%>
<jsp:forward page="subParam.jsp">
	<jsp:param value="test123" name="id"/>
	<jsp:param value="<%= num %>" name="pw"/>
</jsp:forward>

<p> 위 라인의 내용은 subParam 페이지 의 내용입니다 </p>

</body>
</html>














