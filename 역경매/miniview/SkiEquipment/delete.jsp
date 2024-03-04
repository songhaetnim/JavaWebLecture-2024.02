<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../common/_head.jspf" %>
    <meta charset="UTF-8">
    <title>스키 장비 삭제</title>
</head>
<body>
<%@ include file="../common/_top.jspf" %>
    <h1>스키 장비 삭제</h1>
    <p>다음 장비를 삭제하시겠습니까?</p>
    <p>장비 ID: ${equipment.equipmentId}</p>
    <p>사용자 ID: ${equipment.userId}</p>
    <p>장비명: ${equipment.equipmentName}</p>
    <p>설명: ${equipment.description}</p>
    <p>상태: ${equipment.condition}</p>
    <p>이미지 URL: ${equipment.imageUrl}</p>
    <form action="/auction/ski_equipment/delete" method="post">
        <input type="hidden" name="equipmentId" value="${equipment.equipmentId}">
        <button type="submit">삭제</button>
    </form>
  <%@ include file="../common/_bottom.jspf" %>
</body>
</html>
