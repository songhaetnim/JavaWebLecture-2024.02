<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">

<head>
<%@ include file="../common/_head.jspf" %>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>역경매 작성</title>
</head>
<body style="margin: 50px;">
<%@ include file="../common/_top.jspf" %>
    <div class="container">
		<div class="row">
			<div class="col-3"></div>
			<div class="col-6">
			    <form action="/jw/mini/aInsert" method="post" enctype="multipart/form-data">
			    	<table class="table table-borderless">
					 <%--		<input type="hidden" name="user_id" value="${sessuser_id}"> --%>
				     <%--		<input type="hidden" name="user_id" value="james"> --%>
				    		<tr>
				    			<td>구매물품</td>
				    			<td><input type="text" class="form-control" name="title" placeholder="제목"></td>
				    		</tr>
				    		<tr>
				    			<td>시작가격</td>
				    			<td><input type="text" class="form-control" name="start_price" placeholder="시작가격"></td>
				    		</tr>
				    		<tr>
				    			<td colspan="2"><textarea class="form-control" name="content" rows="20" cols="50" placeholder="희망사항을 적어주세요."></textarea></td>
				    		</tr>
				    		<tr>
				    			<td>이미지 첨부</td>
				    			<td><input type="file" class="form-control" name="imgFile" multiple></td>
				    		</tr>
				    		<tr>
				    			<td></td>
				              	<td>
				                   <button class="btn btn-primary ms-4" type="submit">확인</button>
				                   <button class="btn btn-secondary" type="reset">취소</button>
				              	</td>
							</tr>
			    	</table>
			    </form>
			<div class="col-3"></div>
			</div>
		</div>
    </div>
    <%@ include file="../common/_bottom.jspf" %>
</body>
</html>