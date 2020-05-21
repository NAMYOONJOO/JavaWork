<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="cnt" class="com.lec.beans.CountBean" scope="page"/>
      
<b>cnt의 getCount 호출</b><br/>

<jsp:getProperty name="cnt" property="count"/><br/>

<a href="scope1_page1.jsp">page1로..</a>


<!-- 예제를 위해 HTML 기본 태그들 생략 -->


