<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="../common/_head.jspf" %>
    <style>
        td, th { text-align: center; }
        .top-section {
            /* 위쪽 영역 스타일 */
        }
        .bottom-section {
            /* 아래쪽 영역 스타일 */
            border: 1px solid #ccc; /* 테두리 스타일 */
            padding: 20px; /* 내부 여백 */
        }
    </style>
    <script>
        function deleteFunc(user_id) {
            $('#deleteuser_id').val(user_id);
            $('#deleteModal').modal('show');
        }
    </script>
</head>
<body>
    <%@ include file="../common/_top.jspf" %>

<div class="container mt-3">
        <div class="row">
            <div class="col-12">
                <div id="demo" class="carousel slide" data-bs-ride="carousel">
                    <!-- Indicators/dots -->
                    <div class="carousel-indicators">
                        <button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
                        <button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
                        <button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
                    </div>

                    <!-- The slideshow/carousel -->
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img src="/jw/img2/스키1.png" alt="Los Angeles" class="d-block" style="width:100% ">
                            <div class="carousel-caption text-dark">
                                <h3>Los Angeles</h3>
                                <p>We had such a great time in LA!</p>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img src="/jw/img2/스키2.jpg" alt="Chicago" class="d-block" style="width:100%">
                            <div class="carousel-caption text-dark">
                                <h3>Chicago</h3>
                                <p>Thank you, Chicago!</p>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img src="/jw/img2/스키3.jpg" alt="New York" class="d-block" style="width:100%">
                            <div class="carousel-caption text-dark">
                                <h3>New York</h3>
                                <p>We love the Big Apple!</p>
                            </div>
                        </div>
                    </div>

                    <!-- Left and right controls/icons -->
                    <button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
                        <span class="carousel-control-prev-icon">

                        </span>
                    </button>
                    <button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
                        <span class="carousel-control-next-icon"></span>
                    </button>
                </div>
                <div class="row mt-5" style="text-align: center;">
                	<h1> BEST ITEMS </h1>
                </div>
                	<hr>
                <div class="row mt-5">              
					<div class="col-lg-4 menu-item">
						<a href="#"><img src="/jw/img2/보드5.jpg" class="menu-img img-fluid" alt="" style="width:100%"></a>
					</div>
					<div class="col-lg-4 menu-item">
					    <a href="#"><img src="/jw/img2/스키장비2.jpg" class="menu-img img-fluid" alt="" style="width:100%"></a>
					</div>
					<div class="col-lg-4 menu-item">
					    <a href="#"><img src="/jw/img2/스키장비3.jpg" class="menu-img img-fluid" alt="" style="width:100%"></a>
					</div>
                </div>     
					<hr>
            </div>
        </div>
    </div>

    <%@ include file="../common/_bottom.jspf" %>
    <div style="margin-bottom:100px;"></div>
</body>
</html>