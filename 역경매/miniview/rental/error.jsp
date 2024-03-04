<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="../common/_head.jspf" %>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>에러 발생</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

.container {
	width: 400px;
	padding: 20px;
	background-color: #fff;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	text-align: center;
}

h2 {
	margin-top: 0;
	color: #d9534f;
}

p {
	color: #666;
	margin-bottom: 20px;
}

a {
	display: inline-block;
	padding: 10px 20px;
	background-color: #007bff;
	color: #fff;
	text-decoration: none;
	border-radius: 4px;
	transition: background-color 0.3s;
}

a:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>
<%@ include file="../common/_top.jspf" %>
	<div class="container">
		<h2>에러 발생</h2>
		<p><%=request.getAttribute("error")%></p>
		<a href="/jw/auction/rental/list">렌탈 목록으로 돌아가기</a>
	</div>
	<%@ include file="../common/_bottom.jspf" %>
</body>
</html>

