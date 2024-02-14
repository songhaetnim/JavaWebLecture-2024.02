<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body style="margin: 50px">
	<h1>회원 가입</h1>
	<hr>
	<form action="/jw/ch06/register" method="post">
		<input type="text" name="uid" placeholder="아이디"><br><br>
		<input type="password" name="pwd" placeholder="패스워드"><br><br>
		<input type="password" name="pwd2" placeholder="패스워드 확인"><br><br>
		<input type="text" name="name" placeholder="이름"><br><br>
		<input type="text" name="email" placeholder="이메일"><br><br>
		<input type="submit" value="등록">
		
	</form>

</body>
</html>