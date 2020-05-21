<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="cnt" class="com.lec.beans.CountBean" scope="session"/>
<jsp:setProperty name="cnt" property="count"/>
<%-- 위의 setProperty 에선 value 속성이 없다!?  그러면 request시 넘어오는 값에서
	form 의 name 값이 count 인것을 받아옵니다  
	cnt.setCount( Integer.parseInt(request.getParameter("count")));	
--%>

<h3>session1<br>cnt의 getCount 호출</h3>

<jsp:getProperty name="cnt" property="count"/><br/>
<%-- 아래와 동일
<%= cnt.getCount() %>
 --%>
 <a href="scope3_session2.jsp">session2로..</a>


<!-- 예제를 위해 HTML 기본 태그들 생략 -->







