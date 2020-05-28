<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dto" class = "com.lec.beans.WriteDTO" scope="page"/>
<jsp:setProperty property="uid" name="dto" value="123"/>
<jsp:setProperty property="subject" name="dto" value="제목입니다."/>
<jsp:setProperty property="name" name="dto" value="안녕하세요"/>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>EL - ActionTag</title>
</head>
<body>
<!-- 원래방식 -->
uid: <%= dto.getUid() %><br>
제목: <%= dto.getSubject() %><br>
작성자: <%= dto.getName() %><br>
<hr>


uid: <jsp:getProperty property="uid" name="dto"/> <br>
제목: <jsp:getProperty property="subject" name= "dto"/><br>
작성자: <jsp:getProperty property="name" name="dto"/><br>
<hr>

<!-- EL -->
uid: ${dto.uid } <br>
제목: ${dto.subject }<br>
작성자: ${dto.name }<br>
댓글: ${dto.comment }<br>
<hr>
</body>
</html>














