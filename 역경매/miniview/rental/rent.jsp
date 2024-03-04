<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<%@ include file="../common/_head.jspf" %>
    <meta charset="UTF-8">
    <title>렌탈 등록</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        form {
            background-color: #fff;
            border-radius: 10px;
            padding: 30px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            width: 400px;
            color: #333;
        }
        h2 {
            text-align: center;
            color: #764ba2;
            margin-bottom: 30px;
        }
        label {
            display: block;
            margin-bottom: 5px;
        }
        input[type="text"],
        input[type="datetime-local"],
        input[type="number"],
        input[type="submit"] {
            width: calc(100% - 22px);
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #764ba2;
            color: #fff;
            cursor: pointer;
            border: none;
        }
        input[type="submit"]:hover {
            background-color: #5c2d91;
        }
    </style>
    <script>
        window.onload = function() {
            var startDateInput = document.getElementById('startDate');
            var endDateInput = document.getElementById('endDate');

            // 오늘 날짜를 가져오는 함수
            function getToday() {
                var now = new Date();
                var year = now.getFullYear();
                var month = String(now.getMonth() + 1).padStart(2, '0');
                var day = String(now.getDate()).padStart(2, '0');
                return year + '-' + month + '-' + day + 'T00:00'; // 시간까지 포함
            }

            // 시작 날짜를 오늘로 설정
            startDateInput.value = getToday();

            // 종료 날짜가 시작 날짜로부터 3일 이상 이후의 날짜만 선택 가능하도록 설정
            startDateInput.addEventListener('change', function() {
                var startDate = new Date(startDateInput.value);
                var minEndDate = new Date(startDate.getTime() + (3 * 24 * 60 * 60 * 1000)); // 3일 후
                var minEndDateString = minEndDate.toISOString().slice(0, 16); // ISO 포맷으로 변환
                endDateInput.min = minEndDateString;
            });

            // 폼 제출 시 유효성 검사
            document.querySelector('form').addEventListener('submit', function(event) {
                var startDate = new Date(startDateInput.value);
                var endDate = new Date(endDateInput.value);

                // 시작 날짜와 종료 날짜를 비교하여 유효성 검사
                if (endDate <= startDate || startDateInput.value === '' || endDateInput.value === '') {
                    alert('시작 날짜와 종료 날짜를 다시 확인해주세요.');
                    event.preventDefault(); // 폼 제출 중지
                }
            });
        };
    </script>
</head>
<body>
<%@ include file="../common/_top.jspf" %>
    <form action="/jw/auction/rental/rent" method="post">
        <h2>새 렌탈 등록</h2>
        <label for="equipmentId">장비 ID:</label>
        <input type="text" name="equipmentId" id="equipmentId" required>
        <label for="startDate">시작 날짜:</label>
        <input type="datetime-local" name="startDate" id="startDate" required>
        <label for="endDate">종료 날짜:</label>
        <input type="datetime-local" name="endDate" id="endDate" required>
        <label for="totalPrice">총 가격:</label>
        <input type="number" name="totalPrice" id="totalPrice" required>
        <input type="submit" value="렌탈 등록">
    </form>
    <%@ include file="../common/_bottom.jspf" %>
</body>
</html>
