<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import = 'java.sql.*' %><%-- JDB 관련 import --%>
   <%@ page import = "java.text.SimpleDateFormat" %>
   <%// parameter 받아오기
   int uid = Integer.parseInt(request.getParameter("uid"));
   	%>
   
   <%!
   //JDBC 관련 기본 객체 변수
   Connection conn = null;
   Statement stmt = null;
   PreparedStatement pstmt = null;
   ResultSet rs = null; //SELECT 결과, excuteQuery()
   int cnt = 0; // DML 결과 executeUpdate()
   
   //Connection 에 필요한 값 세팅
   final String DRIVER = "oracle.jdbc.driver.OracleDriver";
   final String URL ="jdbc:oracle:thin:@localhost:1521:XE";
   final String UID = "scott0316";
   final String UPW = "tiger0316";
   %>
   
   <%!
   
   final String SQL_WRITE_DELETE_BY_UID = 
   "DELETE FROM test_write WHERE wr_uid=?";
   %>
   <%
   try{
	  Class.forName(DRIVER);
	  out.println("드라이버 로딩 성공"+"<br>");
	  conn = DriverManager.getConnection(URL,UID,UPW);
	  out.println("conn성공<br>");
	  
	  //트랜잭션 실행
	  pstmt = conn.prepareStatement(SQL_WRITE_DELETE_BY_UID);
	  pstmt.setInt(1,uid);

	  cnt = pstmt.executeUpdate();
	  
	  
   }catch(Exception e){
	   e.printStackTrace();
	   //예외처리
   }finally{
	   //리소스 해제
	   try{
		   if(rs!=null)rs.close();
		   if(stmt!=null)stmt.close();
		   if(pstmt!=null)pstmt.close();
		   if(conn!=null)conn.close();
	   }catch(Exception e){
		   e.printStackTrace();
	   }
   }
   %>
   <%-- 위 트랜잭션이 마무리 되면 페이지 보여주기 --%>


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
























