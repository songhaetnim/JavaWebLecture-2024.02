<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>스키 장비 상세 정보</title>
    <%@ include file="../common/_head.jspf" %>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 600px;
            margin: 0 auto;
            background-color: #fff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #333;
            text-align: center;
            margin-bottom: 20px;
        }
        p {
            margin-bottom: 10px;
        }
        .description {
            border-left: 4px solid #007bff;
            padding-left: 10px;
        }
    </style>
</head>
<body>
<%@ include file="../common/_top.jspf" %>
    <div class="container">
        <h1>스키 장비 상세 정보</h1>
        <p class="description">
            <strong>장비 ID:</strong> ${equipment.equipmentId}<br>
            <strong>사용자 ID:</strong> ${equipment.userId}<br>
            <strong>설명:</strong> ${equipment.description}<br>
            <strong>상태:</strong> ${equipment.condition}<br>
            <strong>이미지 URL:</strong><img src="${equipment.imageUrl}" alt="장비 이미지" width="100%"><br>
        </p>
    </div>
  <%@ include file="../common/_bottom.jspf" %>
</body>
</html>
