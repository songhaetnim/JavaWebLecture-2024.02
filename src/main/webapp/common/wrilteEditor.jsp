<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<%@ include file="_head.jspf" %>
	<!-- _gead.jspf에 없는 내용 포함시킴-->
	<style>
		td { text-align: center; }
	</style>
	<script>
		window.onload = function() {
			CKEDITOR.replace('content', { height: 450 });
		}
	</script>
</head>
<body>
	<%@ include file="_top.jspf" %>
	
	<div class="container" style="margin-top:80px">
		<div class="row">
		<%@ include file="_aside.jspf" %>

		<%--본문 영역 - 매 페이지마다 바뀌는 부분 --%>
			<div class="col-9">
				<h3><strong>글 쓰기</strong></h3>
				<hr>
				<div class="row">
					<div class="col-1"></div>
					<div class="col-10">
						<form action="/board/write" method="post" enctype="multipart/form-data">
							<table class="table table-borderless">
								<tr>
									<td><label class="col-form-label">제목</label></td>
									<td><input type="text" name="title" class="form-control"></td>
								</tr>
								<tr>
									<td><label class="col-form-label">본문</label></td>
									<td><textarea name="content" id="content" rows="10" class="form-control">
										이 영역이 CK Editor가 작동하는 영역입니다.
									</textarea></td>
								</tr>
								<tr>
									<td><label class="col-form-label">첨부</label></td>
									<td><input type="file" name="file" class="form-control" multiple></td>
								</tr>
								<tr>
									<td colspan="2">
										<button type="submit" class="btn btn-primary">제출</button>
										<button type="reset" class="btn btn-secondary">취소</button>
									</td>
								</tr>
							</table>
						</form>						
					</div>
					<div class="col-1"></div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="_bottom.jspf" %>
</body>
</html>