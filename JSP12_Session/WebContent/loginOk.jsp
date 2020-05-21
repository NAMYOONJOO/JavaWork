<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<%--로그인 처리만 하는 페이지 --%>
<%!
public static final String ADMIN_ID = "admin";
public static final String ADMIN_PW = "1234";
%>

<%
	String userid = request.getParameter("userid");
	String pw = request.getParameter("pw");
	
	String sessionName = "userid";
	String sessionValue = userid;
	
	if(ADMIN_ID.equalsIgnoreCase(userid)&&ADMIN_PW.equals(pw)){
		//성공
		out.println("<script>");
		out.println("alert('로그인 성공')");
		out.println("</script>");
		// session create
		session.setAttribute(sessionName, sessionValue);
		}else{
		//실패
		out.println("<script>");
		out.println("alert('로그인 실패')");
		out.println("</script>");
		
	}// end if 
	
%>
<script>
location.href = "login.jsp";
</script>
	