<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "java.util.*" %>
    <%@ page import = "java.text.*" %>
<%
	String cookieName1 = "num1";
	String cookieValue1 = ""+(int)(Math.random()*10);
	Cookie cookie1 = new Cookie(cookieName1,cookieValue1);//이름-값으로 쿠키 생성
	cookie1.setMaxAge(2*30); //쿠키 파기(expiry) 시간 설정 (생성시점으로부터 2*30초 후 )
	response.addCookie(cookie1); //response 에 쿠키 정보  추가 
	
	String cookieName2 = "datetime";
	String cookieValue2 = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	Cookie cookie2  = new Cookie(cookieName2, cookieValue2);
	cookie2.setMaxAge(30);
	response.addCookie(cookie2);
%>

<script>
alert("<%= cookieName1%> <%= cookieName2%>쿠키생성")
location.href = "cookieList.jsp";
</script>










