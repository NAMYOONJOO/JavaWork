<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.*" %>     

<%
	String name = URLDecoder.decode(request.getParameter("name"), "utf-8");
	String age = request.getParameter("age");
%>

이름: <%= name %><br>
나이: <%= age %><br>





