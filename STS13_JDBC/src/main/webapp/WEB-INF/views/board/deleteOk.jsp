<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
   int cnt = (Integer)request.getAttribute("delete");
   %>

<%if(cnt==0){ %>
<script>
alert("삭제실패");
history.back();
</script>
<%}else{ %>
<script>
alert("삭제성공");
location.href = "list.do"</script>
<%}%>
























