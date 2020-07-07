<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="old.*"%>
   <%
   int cnt = (Integer)request.getAttribute("update");
   
   %>
  
<%if(cnt==0){ %>
<script>
alert("수정실패");
history.back();
</script>
<%}else{ %>
<script>
alert("수정성공");
location.href = "view.do?uid=<%=request.getParameter("uid")%>"</script>

<%}%>















