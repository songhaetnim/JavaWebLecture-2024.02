<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>장비 목록</title>
<%@ include file="../common/_head.jspf" %>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 1000px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #333;
            text-align: center;
            margin-bottom: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        th, td {
            padding: 12px;
            text-align: center;
            border-bottom: 1px solid #ddd;
            vertical-align: middle; 
        }
        th {
            background-color: #f2f2f2;
            font-weight: bold;
        }
        img {
            max-width: 80px;
            max-height: 80px;
            display: block;
            margin: 0 auto;
        }
        .action-links {
            text-align: right;
        }
        .action-links a {
            margin: 0 5px;
            padding: 6px 12px;
            color: #fff;
            border: none;
            border-radius: 4px;
            text-decoration: none;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        .action-links a.delete {
            background-color: #f44336;
        }
        .action-links a.delete:hover {
            background-color: #d32f2f;
        }
        .action-links a.update {
            background-color: #4caf50;
        }
        .action-links a.update:hover {
            background-color: #388e3c;
        }
        .action-links a.add {
            background-color: #2196f3;
        }
        .action-links a.add:hover {
            background-color: #1e88e5;
        }
        .action-links a.detail {
            background-color: #ff9800;
        }
        .action-links a.detail:hover {
            background-color: #f57c00;
        }
        .a {
            display: inline-block;
            margin: 20px auto;
            padding: 10px 20px;
            color: #fff;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }
    </style>
</head>
<body>
<%@ include file="../common/_top.jspf" %>
<div class="row">
    <div class="container">
        <h1>장비 목록</h1>
        <table>
            <thead>
                <tr>
                    <th>장비명</th>
                    <th>설명</th>
                    <th>상태</th>
                    <th>이미지</th>
                    <th>작업</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${equipmentList}" var="equipment">
                    <tr>
                        <td>${equipment.equipmentId}</td>
                        <td>${equipment.description}</td>
                        <td>${equipment.condition}</td>
                        <td><img src="${equipment.imageUrl}" alt="장비 이미지"></td>
                        <td class="action-links">
                            <a href="${pageContext.request.contextPath}/auction/ski_equipment/detail?equipmentId=${equipment.equipmentId}" class="detail a">상세</a>
                            <c:if test="${sessuser_id eq equipment.userId}">
                            	<a href="${pageContext.request.contextPath}/auction/ski_equipment/update?equipmentId=${equipment.equipmentId}" class="update a">수정</a>
                            </c:if>
                            <c:if test="${sessuser_id ne equipment.userId}">
                            	<a href="/jw/auctiondb/user/login" class="update a" >수정</a>
                           	</c:if>
                           	<c:if test="${sessuser_id eq equipment.userId or sessuser_id eq 'admin'}">
                           		<a href="${pageContext.request.contextPath}/auction/ski_equipment/delete?equipmentId=${equipment.equipmentId}" class="delete a" onclick="return confirm('삭제하시겠습니까?');">삭제</a>
                           	</c:if>
                           	<c:if test="${sessuser_id ne equipment.userId}">
                           		<c:if test="${sessuser_id ne 'admin'}">
 	                          		<a href="/jw/auctiondb/user/login" class="delete a">삭제</a>
                           		</c:if>
                           	</c:if>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="${pageContext.request.contextPath}/auction/ski_equipment/add" class="action-links add a" style="background-color: #007bff;">장비 추가</a>
    </div>
  </div>
  <%@ include file="../common/_bottom.jspf" %>
</body>
</html>
