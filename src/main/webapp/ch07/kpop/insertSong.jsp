<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>K-pop</title>
</head>
<body style="margin: 50px">
	<h1>K-pop Song 추가</h1>
	<hr>
	<form action="/jw/ch07/kpop/insertSong" method="post">
		<input type="text" name="title" value="${song.title}"><br><br>
		<input type="text" name="lyrics" value="${song.lyrics}"><br><br>
		<input type="submit" value="추가">
	</form>
</body>
</html>