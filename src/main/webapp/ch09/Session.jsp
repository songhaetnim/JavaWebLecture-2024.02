<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Session 활용</title>
</head>
<body style="margin: 50px">
	<h1>Session활용</h1>
	<hr>
	<h3>price = ${price}</h3>
	<h3>uid = ${uid}</h3>
	<h3>fruits : ${fruits[0]}, ${fruits[1], ${fruits[2]}</h3>
	<c:if test="${empty uid}">        <!-- session scope의 uid 변수에 값이 없는 경우 -->
		<h3>로그인 하세요.</h3>
	</c:if>
	<c:if test="${not empty uid}">    <!-- 로그인 하였으면 -->
		<h3>${uid}님 환영합니다.</h3>
	</c:if>
</body>
</html>
	
		
	
	
	
	
