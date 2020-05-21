<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>미성년자 페이지</title>
</head>
<body>
<%!
String str;
int age;
%>
<%
 str = request.getParameter("age");
 age = Integer.parseInt(str);
 %>
 당신은<%=age %>세 입니다.
 미성년자군요/..... 사이트를 이용하실 수 없습니다.
 <%=19-age %>년뒤에 다시 오거라ㅋㄷㅋㄷ
 <a href = "input_age.html"> 처음으로</a>
</body>
</html>














