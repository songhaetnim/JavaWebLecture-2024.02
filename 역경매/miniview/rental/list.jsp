<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<%@ include file="../common/_head.jspf" %>
    <meta charset="UTF-8">
    <title>렌탈 목록</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
            color: #333;
        }
        .container {
            width: 80%;
            margin: 20px auto;
            overflow: hidden;
            text-align: center;
        }
        h2 {
            margin-top: 50px;
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
        a:hover {
            background-color: #0056b3;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            border-radius: 5px;
            overflow: hidden;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            background-color: #fff;
        }
        th, td {
            padding: 15px;
            text-align: center;
        }
        th {
            background-color: #007bff;
            color: #fff;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #ddd;
        }
    </style>
</head>
<body>
<%@ include file="../common/_top.jspf" %>
    <div class="container">
    	<div class="row mb-5">
    		<div class="col-1"></div>
    		<div class="col-10">
				<h2>렌탈 목록</h2>
				<a href="/jw/auction/rental/rent" style="background-color: #007bff;" class="a">새 렌탈 추가</a>
				<table>
				<tr>
					<th>렌탈 ID</th>
					<th>사용자 ID</th>
					<th>장비명</th>
					<th>시작 날짜</th>
					<th>종료 날짜</th>
					<th>총 가격</th>
					<th>결제 상태</th>
					<th>작업</th>
				</tr>
				<c:forEach var="rental" items="${rentals}">
				<tr>
					<td>${rental.rentalId}</td>
					<td>${rental.userId}</td>
					<td>${rental.equipmentId}</td>
					<td>${fn:substring(fn:replace(rental.startDate,"T"," "), 2, 10)}</td>
					<td>${fn:substring(fn:replace(rental.endDate,"T"," "), 2, 10)}</td>
					<td><fmt:formatNumber value="${rental.totalPrice}" type="number" pattern="#,##0	"></fmt:formatNumber></td>
					<td>${rental.paymentStatus == 1 ? "완료" : "미완료"}</td>
					<td>
					<c:if test="${sessuser_id eq rental.userId or sessuser_id eq 'admin'}">
						<a href="/jw/auction/rental/return?rentalId=${rental.rentalId}" style="background-color: #007bff;" class="a">반납</a>
					</c:if>
					<c:if test="${sessuser_id ne rental.userId}">
						<c:if test="${sessuser_id ne 'admin'}">
							<a href="#" style="background-color: #007bff;" class="a">반납</a>
						</c:if>
					</c:if>
					</td>
				</tr>
				</c:forEach>
				</table>
    		</div>
    		<div class="col-1"></div>
    	</div>
    </div>
    <%@ include file="../common/_bottom.jspf" %>
</body>
</html>
