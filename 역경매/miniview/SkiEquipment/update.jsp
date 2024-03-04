<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>스키 장비 수정</title>
<%@ include file="../common/_head.jspf" %>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 600px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            color: #333;
        }
        form {
            margin-top: 20px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            color: #555;
            font-weight: bold;
        }
        input[type="text"],
        textarea {
            width: calc(100% - 12px);
            padding: 6px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        textarea {
            height: 100px;
        }
        button[type="submit"] {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        button[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<%@ include file="../common/_top.jspf" %>
    <div class="container">
        <h1>스키 장비 수정</h1>
        <form action="/jw/auction/ski_equipment/update" method="post">
            <label for="equipmentName">장비명:</label>
            <input type="hidden" value="${equipment.equipmentId}" name="equipmentId">
            <input type="text" id="equipmentName" value="${equipment.equipmentId}" disabled="disabled">
            <label for="userId">사용자 ID:</label>
            <input type="hidden" value="${equipment.userId}" name="userId" >
            <input type="text" id="userId" value="${equipment.userId}" disabled="disabled">
            <label for="description">설명:</label>
            <textarea id="description" name="description">${equipment.description}</textarea>
            <label for="condition">상태:</label>
            <input type="text" id="condition" name="condition" value="${equipment.condition}">
            <label for="imageUrl">이미지 URL:</label>
            <input type="text" id="imageUrl" name="imageUrl" value="${equipment.imageUrl}">
            <button type="submit">수정</button>
        </form>
    </div>
  <%@ include file="../common/_bottom.jspf" %>
</body>
</html>
