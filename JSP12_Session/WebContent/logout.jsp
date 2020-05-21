<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String sessionName = "userid";
	//세션 삭제
	session.removeAttribute(sessionName);
%>
<script>
location.href = "login.jsp"
</script>













