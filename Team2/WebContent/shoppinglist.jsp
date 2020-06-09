<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
$(document).ready(function(){ 
	

// JSON
var url = "https://openapi.naver.com/v1/search/shop?query="+"소파"

$.ajax({
	url : url,
	headers : { 
		'X-Naver-Client-Id':'Fd5OqnTUuUF6qX27jBWS',
		'X-Naver-Client-Secret':'7xhDrhhGUJ'},	
	type: 'GET',
	success : function(data,status){
		alert ('로딩')
		if(status=="success") parseJSON(data);
	
	} 
 })

		
 });

	
	 
function parseJSON(jsonObj){
	alert('성공')
	var row = channel.item;
	var table = "<tr><th>id</th><th>작성자</th><th>글제목</th><th>글내용</th><th>조회수</th><th>작성일</th></tr>"


	var i;

	for (i = 0; i < row.length; i++) {
		table += "<tr>";
		table += "<td>" + row[i].title + "</td>";
		table += "<td>" + row[i].image + "</td>";
		table += "<td>" + row[i].lprice + "</td>";
		table += "<td>" + row[i].brand + "</td>";

		table += "</tr>";
	}
	$("#demoJSON").html(table);
}
</script>
</head>
<body>
<table id="demoJson"></table>
</body>
</html>










