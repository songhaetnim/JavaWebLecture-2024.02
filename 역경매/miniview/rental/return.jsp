<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="../common/_head.jspf" %>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>렌탈 반납</title>
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
}

h2 {
	margin-top: 0;
	color: #333;
}

input[type="text"] {
	width: 100%;
	padding: 10px;
	margin-bottom: 10px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type="submit"] {
	width: 100%;
	padding: 10px;
	background-color: #007bff;
	color: #fff;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	transition: background-color 0.3s;
}

input[type="submit"]:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>
<%@ include file="../common/_top.jspf" %>
	<div class="container">
		<h2>렌탈 반납</h2>
		<form action="/jw/auction/rental/return" method="post">
			<label for="rentalId">렌탈 번호 확인</label><br> 
			<input type="text" id="rentalId" name="rentalId" value="${rentals.rentalId}"><br> 
			<input type="submit" value="확인">
		</form>
	</div>
	<%@ include file="../common/_bottom.jspf" %>
</body>
</html>
