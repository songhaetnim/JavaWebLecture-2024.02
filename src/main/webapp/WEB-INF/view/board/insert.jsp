<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/_head.jspf" %>
	<style>
		td, th { text-align: center; }
		.disabled-link { pointer-events: none; }
	</style>
</head>
<body>
	<%@ include file="../common/_top.jspf" %>
	
	<div class="container" style="margin-top:80px">
		<div class="row">
			<%@ include file="../common/_aside.jspf" %>
			
			<!-- ================== 본문 영역 ================================== -->
			<div class="col-9">
				<h3><strong class="me-5">게시글 쓰기</strong></h3>
				<hr>
				<div class="row">
				<div class="col-1"></div>
				<div class="col-10">
					<form action="/jw/bbs/board/insert" method="post">
						<table class="table table-borderless">
			                <tr>
			                    <td style="width: 10%;"><label class="col-form-label">제목</label></td>
			                    <td style="width: 90%;"><input type="text" name="title" class="form-control"></td>
			                </tr>
			                <tr>
			     			    <td><label class="col-form-label">내용</label></td>
			      			    <td><textarea class="form-control" rows="10" name="content" ></textarea></td>
			                </tr>
			                <tr>
			                    <td colspan="2">
			                    	<button class="btn btn-primary" type="submit">확인</button>
			                    	<button class="btn btn-secondary" type="reset">취소</button>
			                    </td>
			                </tr>
		              </table>
					</form>
				</div>
				<div class="col-1"></div>
			</div>
				
		</div>
		<!-- ==================본문 영역================================== -->
	</div>
</div>

<%@ include file="../common/_bottom.jspf" %>
	
</body>
</html>