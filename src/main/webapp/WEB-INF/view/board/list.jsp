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
	<script>
		function search() {
			const field = $('#field').val();
			const query = $('#query').val();
			location.href = '/jw/bbs/board/list?p=${currentBoardPage}&f=' + field + '&q=' + query;
		}
	</script>
</head>
<body>
	<%@ include file="../common/_top.jspf" %>
	
	<div class="container" style="margin-top:80px">
		<div class="row">
			<%@ include file="../common/_aside.jspf" %>
			
			<div class="col-9">
				<table class="table table-sm table-borderless">
					<tr>
						<td style="width: 52%; text-align: left">
							<h3><strong class="me-5">게시글 목록</strong>
								<span style="font-size:16px"><a href="/jw/bbs/board/insert"><i class="fa-solid fa-pen-to-square"></i> 글 쓰기</a></span>
							</h3>
						</td>
						<td style="width: 16%">
							<select class="form-control" id="field">
								<option value="title" ${field eq 'title' ? 'selected' : ''}>제목</option>
								<option value="content" ${field eq 'content' ? 'selected' : ''}>본문</option>
								<option value="uname" ${field eq 'uname' ? 'selected' : ''}>글쓴이</option>
							</select>
						</td>
						<td style="width: 24%">
						<c:if test="${empty query}">
							<input class="form-control" type="text" id="query" placeholder="검색할 내용">
						</c:if>
						<c:if test="${not empty query}">
							<input class="form-control" type="text" id="query" value="${query}">
						</c:if>
						</td>
						<td style="width: 8%">
							<button class="btn btn-outline-primary" onclick="search()">검색</button>
						</td>
					</tr>
				</table>
				<hr>
				
				<table class="table">
					<tr>
						<th style="width: 8%">ID</th>
						<th style="width: 52%">제목</th>
						<th style="width: 14%">글쓴이</th>
						<th style="width: 16%">수정시간</th>
						<th style="width: 10%">조회수</th>
					</tr>
					<c:forEach var="board" items="${boardList}">
					<tr>
						<td>${board.bid}</td>
						<td>
							<a href="/jw/bbs/board/detail?bid=${board.bid}">${board.title}</a>
							<c:if test="${board.replyCount ge 1}">
								<span class="text-danger">[${board.replyCount}]</span>
							</c:if>
						</td>
						<td>${board.uname}</td>
						<td>${fn:substring(fn:replace(board.modTime,"T"," "), 2, 16)}</td>
						<td>${board.viewCount}</td>
					</tr>
					</c:forEach>
				</table>
				<%-- pagination --%>
				<ul class="pagination justify-content-center mt-4">
					<li class="page-item"><a class="page-link" href="#"><i class="fa-solid fa-less-than"></i></a></li>
				<c:forEach var="page" items="${pageList}">
					<li class="page-item ${currentBoardPage eq page ? 'active' : ''}">
						<a class="page-link" href="/jw/bbs/board/list?p=${page}&f=${field}&q=${query}">${page}</a>
					</li>
				</c:forEach>
					<li class="page-item"><a class="page-link" href="#"><i class="fa-solid fa-greater-than"></i></a></li>
				</ul>	
					
			</div>
		</div>
	</div>
	
	<%@ include file="../common/_bottom.jspf" %>
	
</body>
</html>