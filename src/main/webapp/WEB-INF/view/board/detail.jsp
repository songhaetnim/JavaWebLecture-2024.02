<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% pageContext.setAttribute("newline", "\n"); %>

<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/_head.jspf" %>
	<style>
		td, th { text-align: center; }
	</style>
	<script>
		function deleteFunc(bid) {
			$('#deleteBid').val(bid);
			$('#deleteModal').modal('show');
		}
	</script>
</head>
<body>
	<%@ include file="../common/_top.jspf" %>
	
	<div class="container" style="margin-top:80px">
		<div class="row">
			<%@ include file="../common/_aside.jspf" %>
			
			<!-- ===================== 본문 영역 ===================== -->
			<div class="col-9">
				<h3><strong class="me-5">게시글 보기</strong>
					<span style="font-size:16px">
						<a href="/jw/bbs/board/list?p=${currentBoardPage}&f=${field}&q=${query}"><i class="fa-solid fa-table-list"></i> 목록</a>
					<c:if test="${sessUid eq board.uid}">	<!-- 본인만 수정/삭제 가능 -->
						<a href="/jw/bbs/board/update?bid=${board.bid}"><i class="fa-solid fa-file-pen ms-3"></i> 수정</a>
						<a href="javascript:deleteFunc('${board.bid}')"><i class="fa-solid fa-trash ms-3"></i> 삭제</a>
					</c:if>
					<c:if test="${sessUid ne board.uid}">	
						<a href="#" class="disabled-link"><i class="fa-solid fa-file-pen ms-3"></i> 수정</a>
						<a href="#" class="disabled-link"><i class="fa-solid fa-trash ms-3"></i> 삭제</a>
					</c:if>
					</span>
				</h3>
				<hr>
				<div class="row">
					<div class="col-8">
						<h5>${board.title}</h5>
						<h6>글번호: ${board.bid} | ${fn:replace(board.modTime, "T", " ")}</h6>
					</div>
					<div class="col-4 text-end">
						<h5>${board.uname}</h5>
						<h6>조회 ${board.viewCount} &nbsp;&nbsp; 댓글 ${board.replyCount}</h6>
					</div>
					<hr>
					<div class="col-12">
						${fn:replace(board.content, newline, '<br>')}
					</div>
				</div>
			</div>
			<!-- ===================== 본문 영역 ===================== -->
		</div>
	</div>
	
	<%@ include file="../common/_bottom.jspf" %>

	<div class="modal" id="deleteModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">게시글 삭제</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				</div>
			
				<!-- Modal body -->
				<div class="modal-body">
					<strong>정말로 삭제하시겠습니까?</strong>
					<div class="text-center mt-5">
						<form action="/jw/bbs/board/delete" method="post">
							<input type="hidden" id="deleteBid" name="bid">
							<button class="btn btn-danger" type="submit">삭제</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>	
</body>
</html>