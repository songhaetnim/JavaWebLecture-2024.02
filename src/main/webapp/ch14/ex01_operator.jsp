<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>표현 언어(EL)</title>
	<style>
		td, th { padding: 3px; }
	</style>
</head>
<body style="margin: 50px; margin-bottom: 100px">
	<h1>Expression Language Operator(연산자)</h1>
	<hr>
	<table border="1">
		<tr><th>표현식</th><th>결과</th></tr>
		<tr><td>\${100}</td><td>${100}</td></tr>
		<tr><td>\${"안녕하세요"}</td><td>${"안녕하세요"}</td></tr>
		<%-- + 연산자는 숫자에 대해서만 적용되고 문자열은 숫자로 변환된 후 사용됨 --%>
		<tr><td>\${10 + 1}</td><td>${10 + 1}</td></tr>
		<tr><td>\${10.1 + 1}</td><td>${10.1 + 1}</td></tr>
		<tr><td>\${"10" + 1}</td><td>${"10" + 1}</td></tr>	<%-- "10"이 숫자 10으로 변환됨 --%>
		<tr><td>\${null + 1}</td><td>${null + 1}</td></tr>	<%-- null이 0으로 변환됨 --%>
		<%-- <tr><td>\${"hello" + "world"}</td><td>${"hello" + "world"}</td></tr> --%>
		
		<tr><th colspan="2">산술 연산자</th></tr>
		<tr><td>\${10 - 3}</td><td>${10 - 3}</td></tr>
		<tr><td>\${10 * 3}</td><td>${10 * 3}</td></tr>
		<tr><td>\${10 / 3}</td><td>${10 / 3}</td></tr>
		<tr><td>\${10 div 3}</td><td>${10 div 3}</td></tr>
		<tr><td>\${10 % 3}</td><td>${10 % 3}</td></tr>
		<tr><td>\${10 mod 3}</td><td>${10 mod 3}</td></tr>
	
		<tr><th colspan="2">비교 연산자</th></tr>
		<tr><td>\${10 == 3}</td><td>${10 == 3}</td></tr>
		<tr><td>\${10 eq 3}</td><td>${10 eq 3}</td></tr>
		<tr><td>\${"hello" != "world"}</td><td>${"hello" != "world"}</td></tr>
		<tr><td>\${"hello" ne "world"}</td><td>${"hello" ne "world"}</td></tr>
		<tr><td>\${10 > 3}</td><td>${10 > 3}</td></tr>
		<tr><td>\${10 gt 3}</td><td>${10 gt 3}</td></tr>	<%-- eq, ne, gt, ge, lt, le --%>
		
		<tr><th colspan="2">논리 연산자</th></tr>
		<tr><td>\${10 >= 8 && 4 <= 3}</td><td>${10 >= 8 && 4 <= 3}</td></tr>
		<tr><td>\${10 ge 8 and 4 le 3}</td><td>${10 ge 8 and 4 le 3}</td></tr>
		<tr><td>\${!(10 >= 8 && 4 <= 3)}</td><td>${!(10 >= 8 && 4 <= 3)}</td></tr>
		<tr><td>\${not (10 ge 8 and 4 le 3)}</td><td>${not (10 ge 8 and 4 le 3)}</td></tr>
		<tr><td>\${10 lt 8 or 4 gt 3}</td><td>${10 lt 8 or 4 gt 3}</td></tr>
		
		<tr><th colspan="2">문자열 연산자</th></tr>
		<tr><td>\${empty "hello"}</td><td>${empty "hello"}</td></tr>
		<tr><td>\${empty ""}</td><td>${empty ""}</td></tr>
		<tr><td>\${empty null}</td><td>${empty null}</td></tr>
	</table>
	<%-- 표현식 안에서 문자열은 ' 또는 " 둘다 사용 가능 --%>
	<h3>입력한 파라메터 값은 ${empty param.num ? '"입력하지 않았음"' : param.num} 입니다.</h3>
</body>
</html>