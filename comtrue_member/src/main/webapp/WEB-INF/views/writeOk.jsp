<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>        

<c:choose>
	<c:when test="${result == 0 }">
		<script>
			alert("등록 실패!!!!!!");
			history.back();  
		</script>
	</c:when>
	<c:when test="${result == -1 }">
		<script>
			alert("이메일 또는 연락처 형식이 잘못되었습니다.");
			history.back();   
		</script>
	</c:when>
	<c:when test="${result == -2 }">
		<script>
			alert("이미 존재하는 직원번호입니다. 다른 직원번호를 등록해주세요");
			history.back();   
		</script>
	</c:when>
	<c:otherwise>
		<script>
			alert("등록 성공, 리스트를 출력합니다");
			location.href = "list.y";
		</script>
	</c:otherwise>
</c:choose>












































