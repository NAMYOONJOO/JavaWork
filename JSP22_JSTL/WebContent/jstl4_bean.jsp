<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="com.lec.beans.*"%>
<%@ page import="java.util.*"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>JSTL & Bean</title>
</head>
<body>
	<%
		Person chang = new Person();
		chang.setName("냄우경");
		chang.setAge(4);
	%>
	<!-- Person객체 생성 -->

	<c:set var="dto" value="<%=chang%>" />
	이름 : ${dto.name }
	<br> 나이 : ${dto.age }
	<br> dto : ${dto }
	<br>

	<hr>
	<%-- EL 은 bean 객체의 내용을 읽어올 수 있다.  --%>
	<jsp:useBean id="p0" class="com.lec.beans.Person">
		<jsp:setProperty name="p0" property="name" value="김궁둥" />
		<jsp:setProperty name="p0" property="age" value="8" />
	</jsp:useBean>

	이름 : ${p0.name }
	<br> 나이 : ${p0.age }
	<br> p0 : ${p0 }
	<br>

	<hr>
	<%--빈(bean) 배열일 경우 --%>
	<%
		Person p1 = new Person();
		p1.setName("고질라");
		p1.setAge(100);
		Person p2 = new Person();
		p2.setName("킹기도라");
		p2.setAge(200);
		Person p3 = new Person();
		p3.setName("모스라");
		p3.setAge(80);

		Person[] arr = { p1, p2, p3 };
	%>
	<c:set var="dtoArr" value="<%=arr%>" />
	<c:forEach var="p" items="${dtoArr }">
	${p.name }<br>
	${p.age }<br>
	${p }><br>
		<hr>
	</c:forEach>

	<%
		ArrayList<Person> list = new ArrayList<Person>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
	%>
<br><br>
	<c:set var="dtoArr" value="<%=list%>" />
	<c:forEach var="p" items="${dtoArr }">
	${p.name }<br>
	${p.age }<br>
	${p }<br>
	</c:forEach>

	<hr>

	${dtoArr[0].name }<br> <!-- dtoArr 은 배열이 아니라 list  -->
	${dtoArr[1].name }<br>
	${dtoArr[2].name }<br>
	${dtoArr[3].name }<br> <!-- ArrayindexException이 뜨지 않고 그냥 넘어간다.  -->

	<hr>
	<%--특정 id의 bean이 있는지 체크 : empty --%>
	<c:if test="${empty dto }">
	dto는 없습니다. <br>
	</c:if>
	<c:if test="${not empty dto }">
	dto는 있습니다. <br>
	</c:if>

	<c:if test="${dto==null}">
	dto는 없습니다. <br>
	</c:if>
	<c:if test="${dto!=null}">
	dto는 있습니다. <br>
	</c:if>
	
	<c:choose>
	<c:when test="${empty ghost }">
	ghost는 없습니다.
	</c:when>
	<c:when test="${not empty ghost }">
	ghost는 있습니다.
	</c:when>
	</c:choose>
	
	<%
	Person park = null;
	%>
	<br>
	<c:set var="v1" value="<%=park %>"/>
	park: ${v1 }<br>
	
	<c:if test = "${empty v2 }">
	v2은 empty 입니다. <br><!--존재하지 않는것도 empty  -->
	</c:if>
	<c:if test = "${empty v1 }">
	v1은 empty 입니다. <br><!-- null값도 empty -->
	</c:if>
</body>
</html>














