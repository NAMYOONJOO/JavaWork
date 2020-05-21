<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import = 'java.sql.*' %><%-- JDB 관련 import --%>
   <%@ page import = "java.text.SimpleDateFormat" %>
   
    <% //parameter 받아오기 
   	int uid = Integer.parseInt(request.getParameter("uid"));
   // ※ 이 단계에서 parameter 검증 필요 (생략하겠습니다. 검증패턴 writeOk.jsp 참고하기 )
   //나중에 코드작성할 때 나는 검증 하기 >_<
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
   
   //쿼리문 준비
   final String SQL_WRITE_SELECT_BY_UID= //글 읽어오기 
   "SELECT * FROM test_write WHERE wr_uid = ?";
   
   
   %>
   <%
   String name = "";
   String subject = "";
   String content = "";
   String regdate = "";
   int viewcnt = 0;
   %>
   <%
   try{
	  Class.forName(DRIVER);
	  out.println("드라이버 로딩 성공"+"<br>");
	  conn = DriverManager.getConnection(URL,UID,UPW);
	  out.println("conn성공<br>");
	  
	  //트랜잭션 실행
	  pstmt = conn.prepareStatement(SQL_WRITE_SELECT_BY_UID);
	  pstmt.setInt(1,uid);
	  rs = pstmt.executeQuery();
	  
	  //한개의 레코드만 select된다. 
	  //while문 돌릴 필요 없다. 
	  	if(rs.next()){
	  		subject = rs.getString("wr_subject");
	  		content = rs.getString("wr_content"); //아까 list에서는 안했다. ( NULL허용)
	  		if(content==null)content=""; //null처리
	  		name= rs.getString("wr_name");
	  		viewcnt = rs.getInt("wr_viewcnt");
	  		Date d = rs.getDate("wr_regdate");
	  		Time t = rs.getTime("wr_regdate");
	  		
	  		
	  		regdate = "";
	  		if(d != null){
	  			regdate = new SimpleDateFormat("yyyy-MM-dd").format(d)+""
	  					+ new SimpleDateFormat("hh:mm:ss").format(t);
	  		}
	  		
	  	}else{
	  		//wr_uid 값의 레코드가 없다는 뜻
	  		//쿼리문이 실패했다는 뜻 ㄴㄴㄴ 쿼리문은 성공
%>	  		<script>
	  		alert("해당정보가 삭제되거나 없습니다.");
	  		history.back();
	  		</script>
<%	  		
	  		return;
	  	}
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







<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>수정화면 <%=subject %></title>
</head>
<script>
function chkSubmit(){
	   frm=document.forms['frm'];
	   var subject = frm['subject'].value.trim();
	   
	   if(subject == ""){
	      alert("제목은 반드시 작성해야 합니다");
	      frm['subject'].focus();
	      return false;
	   }
	   return true;
	}
</script>
<body>
<h2>수정</h2>
<form name="frm" action="updateOk.jsp" method= "post" onsubmit="return chkSubmit()">
<input type="hidden" name = "uid" value="<%= uid%>"/>
작성자 : <%= name %><br> <%-- 작성자 이름 변경 불가 --%>
제목 : <input type = "text" name = "subject" value="<%= subject %>"/><br>
내용 : <br>
<textarea name = "content"><%= content %></textarea>
<hr>
<input type="submit" value="수정">
</form>
<button onclick="history.back()">이전으로</button>
<button onclick="location.href='list.jsp'">목록보기</button>
</body>
</html>














