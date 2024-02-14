<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="margin : 50px">
	<h1>Simple Calculator</h1>
	<hr>
	<form action="/jw/ch06/calc2" method="post">
		<input type="text" name="num1"  value="${num1 }">
		<select name="op">
			<option value="+" selected>＋</option>
			<option value="-" >－</option>
			<option value="*" >×</option>
			<option value="/" >÷</option>
		</select>
		<input type="text" name="num2" value="${num2}">
		<input type="submit" value="=">
		<input type="text" value="${result}" disabled>
	</form>
	<br>
	<button onclick="location.href='/jw/ch06/calc2'">처음으로</button>
</body>
</html>