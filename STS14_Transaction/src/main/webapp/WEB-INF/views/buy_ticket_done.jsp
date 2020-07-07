<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>구매 완료</title>
</head>
<body>
<p>결제 완료</p>
고객 아이디 : ${ticketInfo.userId } <br />
티켓 구매수 : ${ticketInfo.ticketCount } <br />
<button onclick="history.back()">돌아가기</button>
</body>
</html>

