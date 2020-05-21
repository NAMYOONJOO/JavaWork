<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Session List</title>
</head>
<body>
<%
	if(request.isRequestedSessionIdValid()){ //유효한 request Session 이 있는지 여부
		out.println("유효한 세션이 있습니다.<hr>");
	}else{
		out.println("유효한 세션이 없습니다.<hr>");
	}
	String sessionName, sessionValue;
	Enumeration<String> enumeration = session.getAttributeNames(); // Enumeration<String> 리턴
	//import 필요한부분 ↑
	int i =0;
	while(enumeration.hasMoreElements()){
		sessionName=enumeration.nextElement();// Enumeration<String> String 타입으로 받아온다. 
		sessionValue =  session.getAttribute(sessionName).toString();
		//↑특정 name 의 세션값 추출, name 없으면 null리턴
		//session.getAttribute(sessionName) 가 object 를 리턴하기 때문에 toString 으로 형변환
		out.println((i+1)+"]"+sessionName+" : "+sessionValue+"<br>");
		i++;
	}//end while
	if(i==0){
		out.println("세션이 없읍니다. <br>");
	}
	
	
%>
	<!-- 쿠키 예제랑 비슷 -->
	<!--세션생성하고 삭제하는  Form-->
	<form action="sessionCreate.jsp">
	<input type="submit" value="세션생성" >
	</form>
	<form action="sessionDelete.jsp">
	<input type="submit" value="세션삭제" >
	</form>
	
	<hr>
	<%
	String sessionId = session.getId();
	//세션 아이디 값
	int sessionInterval = session.getMaxInactiveInterval(); //임의로 지정하는 값이 아니다. (쿠키때와 다름)
	out.println("세션 ID: " +sessionId+"<br>");
	out.println("세션 유효시간: " +sessionInterval+"<br>");
	
	%>
	
	
	
	
	<!-- 
	<Servers->web.xml>에 기제되어있는 내용
	  <session-config>
        <session-timeout>30</session-timeout>  -----1800
    </session-config>

	<!-- 세션은 요청하는 브라우저 마다 생성된다 , 여기서 실행하는것과 chrome에서 새로 실행하는것  은 새로운 브라우저를 여는것이라 
   세션이없다고 생선된다.
  -->
	
	
<%
	out.println("--- session.invalidate() 후---<br>");
	//세션무효화 
	//세션 테이블 삭제(session id 무효화 )
	// - 그 안의 모든 attribute(이름)도 삭제됨.
	//새로운 세션 테이블 생성
	
	//session.invalidate();
	
	sessionId = session.getId();
	sessionInterval = session.getMaxInactiveInterval();
	
	out.println("세션 ID: " +sessionId+"<br>");
	out.println("세션 유효시간: " +sessionInterval+"<br>");
	
	
%>
</body>
</html>











