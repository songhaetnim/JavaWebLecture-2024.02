<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>회원 가입</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
	<style>
		* { font-family: 'Noto Sans KR', sans-serif; }
		a { text-decoration: none; }
    td { text-align: center; }
	</style>	
</head>
<body class="bg-light">
  <nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
    <div class="container-fluid">
      <img src="/jw/img/ck-logo.png" height="60">
      <div class="p-2 bg-dard justify-content-center">
        <img src="https://picsum.photos/1500/180" width="100%">
      </div>
    </div>
  </nav>
  <div class="container" style="margin-top: 220px;">
    <div class="row">
      <div class="col-4"></div>
      <div class="col-4">
        <div class="card">
          <div class="card-body">
            <div class="card-title"><h3><strong>회원 가입</strong></h3></div>
            <hr>
            <form action="/jw/ch06/register" method="post">
              <table class="table table-borderless">
                <tr>
                  <td style="width: 30%;"><label class="col-form-label">사용자 ID</label></td>
                  <td style="width: 70%;"><input type="text" name="uid" class="form-control"></td>
                </tr>
                <tr>
                  <td><label class="col-form-label">패스워드</label></td>
                  <td><input type="password" name="pwd" class="form-control"></td>
                </tr>
                <tr>
                  <td><label class="col-form-label">패스워드 확인</label></td>
                  <td><input type="password" name="pwd2" class="form-control"></td>
                </tr>
                <tr>
                  <td><label class="col-form-label">사용자 이름</label></td>
                  <td><input type="text" name="name" class="form-control"></td>
                </tr>
                <tr>
                  <td><label class="col-form-label">이메일</label></td>
                  <td><input type="text" name="email" class="form-control"></td>
                </tr>
                <tr>
                  <td colspan="2">
                    <button class="btn btn-primary" type="submit">확인</button>
                    <button class="btn btn-secondary" type="reset">취소</button>
                  </td>
                </tr>
              </table>
            </form>
            <p class="mt-3">
              <span class="me-3">이미 사용자 계정이 있으신가요?</span>
              <a href="/jw/ch06/login">로그인</a>
            </p>
            <div class="mt-3 mb-3">
              <span class="me-3">소셜 계정으로 가입</span>
              <span>
                <a class="ms-2" href="#"><img src="/jw/img/google-logo.png" height="32"></a>
                <a class="ms-2" href="#"><img src="/jw/img/github-logo.png" height="32"></a>
                <a class="ms-2" href="#"><img src="/jw/img/naver-logo.jpg" height="32"></a>
                <a class="ms-2" href="#"><img src="/jw/img/kakao-logo.png" height="32"></a>
              </span>
            </div>
          </div>
        </div>
      </div>
      <div class="col-4"></div>
    </div>
  </div>
</body>
</html>