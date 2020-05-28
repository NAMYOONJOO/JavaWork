<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>JSTL Core 2</title>
</head>
<body>

	<h2>set, remove, out</h2>
	<c:set var="name" value="나뮨주" />
	이름 :
	<c:out value="nam"></c:out>
	<Br> 이름 :
	<c:out value="${name}"></c:out>
	<br>
	<!-- JSTL 변수는 EL에서 사용 가능 -->
	${name }
	<br>

	<c:remove var="name" />
	<!-- 변수제거 -->
	이름 :
	<c:out value="${name}"></c:out>
	<br>
	<!-- 안나온다 -->
	<hr>
	<%
		int age = 10;
	%>
	나이 : ${age }
	<br>
	<!-- EL은 자바변수를 쓰지 못한다. 출력 안됨 -->
	<!-- Java-> EL (X) -->
	<c:set var="age" value="<%=age%>" />
	<!-- 이짓이 가능하다.  -->
	나이 : ${age }

	<hr>
	<h2>catch</h2>
	<c:catch var="error">
		<!-- 이 안에서 예외 발생시 예외객체를 error변수에 담는다. -->
		<%=2 / 0%>
	</c:catch>
	<br>
	<c:out value="${error }" />
	<br>

	<c:catch var="ex">
	name parameter 값 = <%=request.getParameter("name")%><br>
		<!--Null리턴 -->

		<%
			if (request.getParameter("name").equals("test")) //예외발생코드
		%>
		<!--catch문 때문에 500에러 발생 ㄴㄴ  -->

	</c:catch>

	<!-- 조건문에 해당하는 태그 -->
	<c:if test="${ex!=null }">
		예외 발생<br>
		${ex }<br>
	</c:if>
</body>
</html>














