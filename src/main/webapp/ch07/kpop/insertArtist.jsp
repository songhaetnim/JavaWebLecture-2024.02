<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>K-pop</title>
</head>
<body style="margin: 50px">
	<h1>K-pop Artist 추가</h1>
	<hr>
	<form action="/jw/ch07/kpop/insertArtist" method="post">
		<input type="text" name="name" placeholder="아티스트 이름"><br><br>
		<input type="text" name="debut" placeholder="데뷔일자"><br><br>
		<input type="text" name="songId" placeholder="히트송 아이디"><br><br>
		<input type="submit" value="추가">
	</form>
</body>
</html>