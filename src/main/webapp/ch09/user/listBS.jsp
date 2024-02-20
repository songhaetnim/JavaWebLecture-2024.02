<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<%@ include file="../../common/_head.jspf" %>
	<style>
		td, th { text-align: center; }
		.disabled-link { pointer-events: none; }
	</style>
</head>
<body>
	<%@ include file="../../common/_top.jspf" %>
	
	<div class="container" style="margin-top:80px">
		<div class="row">
			<%@ include file="../../common/_aside.jspf" %>
			
			<div class="col-9">
				<h3><strong class="me-5">사용자 목록</strong>
					<span style="font-size:16px"><a href="/jw/ch09/user/register"><i class="fa-solid fa-user-plus"></i> 사용자 가입</a></span>
				</h3>
				<hr>
				<div class="row">
					<div class="col-1"></div>
					<div class="col-10">
						<table class="table">
							<tr><th>아이디</th><th>이름</th><th>이메일</th><th>등록일</th><th>액션</th></tr>
							<c:forEach var="user" items="${list}">
							<tr>
								<td>${user.uid}</td>
								<td>${user.uname}</td>
								<td>${user.email}</td>
								<td>${user.regDate}</td>
								<td>
									<!-- 본인만 수정 가능 -->
									<c:if test="${user.uid eq sessUid}">	
										<a href="/jw/ch09/user/update?uid=${user.uid}"><i class="fa-solid fa-user-pen"></i></a>
									</c:if>
									<c:if test="${user.uid ne sessUid}">
										<a href="#" class="disabled-link"><i class="fa-solid fa-user-pen"></i></a>
									</c:if>
									<!-- 본인 또는 관리자만 삭제 가능 -->
									<c:if test="${(user.uid eq sessUid) or (sessUid eq 'admin')}">
										<a class="ms-2" href="/jw/ch09/user/delete?uid=${user.uid}"><i class="fa-solid fa-user-minus"></i></a>
									</c:if>
									<c:if test="${(user.uid ne sessUid) and (sessUid ne 'admin')}">
										<a class="ms-2 disabled-link" href="#"><i class="fa-solid fa-user-minus"></i></a>
									</c:if>
								</td>
							</tr>
							</c:forEach>
						</table>
					</div>
					<div class="col-1"></div>
				</div>
			</div>
		</div>
	</div>
	
	<%@ include file="../../common/_bottom.jspf" %>
</body>
</html>