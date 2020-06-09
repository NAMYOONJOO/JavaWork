<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/CSS/common.css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<script src="${pageContext.request.contextPath }/JS/board.js"></script>

<title>SPA 게시판</title>
</head>
<body>
<h2>게시판 - SPA</h2>
<%-- 글목록 --%>
<div id="list">
	<div>
		<div id="pageinfo"></div>
		<div id="pageRows"></div>
	</div>
	
	<div class="clear"></div>
	
	<table>
		<thead>
			<th>#</th>
			<th>UID</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>작성일</th>
		</thead>
		
		<tbody>
		
		</tbody>
	</table>

</div>

<br>
<%-- 페이징 --%>
<div class="center">
	<ul class="pagination" id="pagination">
	
	</ul>
</div>


<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>















