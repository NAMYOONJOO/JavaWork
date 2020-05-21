<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<%--Error 핸들링 페이지라는 것을 명시하는 것이다.  --%>
<% response.setStatus(200); %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>에러안내</title>
</head>
<body>
에러가 발생해습니다. .<br>
에러 타입은 : <%= exception.getClass().getName()%>
예외 메세지는 : <%= exception.getMessage() %>

</body>
</html>














