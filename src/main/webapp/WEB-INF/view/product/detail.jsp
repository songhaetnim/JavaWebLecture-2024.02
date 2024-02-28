<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>Insert title here</title>
   <style>
      td, th { padding: 3px; }
   </style>
</head>
<body style="margin: 50px">
   <h1>상품 조회</h1>
   <hr>
   <table border="1">
      <tr><td>카테고리</td><td>${product.category}</td></tr>
      <tr><td>상품명</td><td>${product.pname}</td></tr>
      <tr><td>가격</td><td>${product.price}</td></tr>
      <tr><td>설명</td><td>${product.description}</td></tr>
      <tr><td>이미지</td><td><img src="/jw/bbs/product/view?filename=${product.pimage}"></td></tr>
   </table>
</body>
</html>