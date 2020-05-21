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
	
	String cookieName = "userid";
	String cookieValue = userid;
	// id / pw일치하면 로그인 성공 + 쿠키 생성
	if(ADMIN_ID.equalsIgnoreCase(userid)&&ADMIN_PW.equals(pw)){
		//성공
		out.println("<script>");
		out.println("alert('로그인 성공')");
		out.println("</script>");
		Cookie cookie = new Cookie(cookieName,cookieValue);
		cookie.setMaxAge(2*30);
		response.addCookie(cookie);
	}else{
		//실패
		out.println("<script>");
		out.println("alert('로그인 실패')");
		out.println("</script>");
		Cookie cookie = new Cookie(cookieName,cookieValue);
		cookie.setMaxAge(0); // 기존에 있었더라도 삭제한다. 
		response.addCookie(cookie);
	}// end if 
%>




<script>
location.href = "login.jsp";
</script>







