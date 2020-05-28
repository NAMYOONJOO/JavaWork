<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.lec.beans.*" %>    
<jsp:useBean id="dao" class="com.lec.beans.WriteDAO"/> <%-- DAO bean 생성 --%>

   <%// parameter 받아오기
   int uid = Integer.parseInt(request.getParameter("uid"));
   	%>
   
  
   <%-- 위 트랜잭션이 마무리 되면 페이지 보여주기 --%>
<%
   int cnt = dao.deleteByUid(uid);
   %>

<%if(cnt==0){ %>
<script>
alert("삭제실패");
history.back();
</script>
<%}else{ %>
<script>
alert("삭제성공");
location.href = "list.jsp"</script>
<%}%>
























