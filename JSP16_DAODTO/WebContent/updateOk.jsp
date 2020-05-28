<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="com.lec.beans.WriteDAO" />
   
   
   <%// parameter 받아오기
   request.setCharacterEncoding("utf-8"); //한글 인코딩 꼭!
   int uid = Integer.parseInt(request.getParameter("uid"));
   String subject = request.getParameter("subject");
   String content = request.getParameter("content");
   	%>
   <%
   int cnt = dao.update(uid,subject, content);
   %>
  
<%if(cnt==0){ %>
<script>
alert("수정실패");
history.back();
</script>
<%}else{ %>
<script>
alert("수정성공");
location.href = "view.jsp?uid=<%=uid%>"</script>
<%}%>















