<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<%@ include file="../common/_head.jspf" %>
	<meta charset="UTF-8">
	<title>역경매 리스트</title>
	
	<script>
	function twoDigit(num) {
        return (num < 10) ? '0' + num : String(num);          
    }                                                       

    function myDateTime(date) {
        return '' + date.getFullYear() + '-' + twoDigit(date.getMonth() + 1) + '-' + twoDigit(date.getDate()) + ' ' +
            twoDigit(date.getHours()) + ':' + twoDigit(date.getMinutes()) + ':' + twoDigit(date.getSeconds());
    }
 
    window.onload = function () {
        setInterval(function () {
            const modTimes = document.querySelectorAll('.time_display');
            modTimes.forEach(function (modTime, index) {
                const targetDateTime_ = modTime.previousElementSibling.value.replace("T", " ");
                const targetDateTime = targetDateTime_.replace("-", "/");
                const now = new Date();
    
                const timeDifference = new Date(targetDateTime).getTime() - now.getTime();
                let timeStr = '';
                    
                const days = Math.floor(timeDifference / (1000 * 60 * 60 * 24));
                const hours = Math.floor((timeDifference % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
                const minutes = Math.floor((timeDifference % (1000 * 60 * 60)) / (1000 * 60));
                const seconds = Math.floor((timeDifference % (1000 * 60)) / 1000);
                
                if (days == 0 && timeDifference > 0) {
                	timeStr = twoDigit(hours) + ':' + twoDigit(minutes) + ':' + twoDigit(seconds);
                } else if(timeDifference > 0){
                    timeStr = days + '일' + twoDigit(hours) + ':' + twoDigit(minutes) + ':' + twoDigit(seconds);
                } else {
                	timeStr = '경매 종료';
                }
    
                modTime.innerHTML = timeStr;
            });
        }, 1000);
    }; 
    </script>
</head>
<body>
<%@ include file="../common/_top.jspf" %>
	<div class="container">
		<div class="row">
			<div class="col-1"></div>
			<div class="col-10">
				<%-- 로그인 안되어있으면 로그인화면으로 --%>
				<span style="font-size: 16px;">
					<a href="/jw/mini/aInsert" class="btn btn-primary">
						<i class="fa-solid fa-pen-to-square me-1"></i> 경매 등록
					</a>
				</span>
				<table class="table mt-2" border="1" style="width: 800px">
					<tr class="table-secondary">
						<th style="width: 8%">번호</th>
						<th style="width: 18%">경매기간</th>
						<th style="width: 41%">제목</th>
						<th style="width: 18%">현재가</th>
						<th style="width: 15%">유저명</th>
					</tr>
					<c:forEach var="auctions" items="${auctionsList}" varStatus="loop">
					<tr>
						<td>${auctions.auction_id}</td>
						<input type="hidden" id="modTime_${loop.index}" value="${auctions.end_time}">
						<td class="time_display" id="time_${loop.index}"></td>
						<td>
							<a href="/jw/mini/aDetail?auction_id=${auctions.auction_id}">${auctions.title}</a>
						</td>
						<td>
							<fmt:formatNumber value="${auctions.current_price}" type="number" pattern="#,##0"></fmt:formatNumber>
						</td>
						<td>${auctions.user_id}</td>
					</tr>
					</c:forEach>
				</table>
					<%-- pagination --%>
				<ul class="pagination justify-content-center mt-4">
					<li class="page-item"><a class="page-link" href="#"><i class="fa-solid fa-less-than"></i></a></li>
					<c:forEach var="page" items="${pageList}">
					<li class="page-item ${currentBoardPage eq page ? 'active' : ''}">
						<a class="page-link" href="/jw/mini/aList?p=${page}">${page}</a>
					</li>
					</c:forEach>
					<li class="page-item"><a class="page-link" href="#"><i class="fa-solid fa-greater-than"></i></a></li>
				</ul> 
			</div>
			<div class="col-1"></div>
		</div>
	</div>
	<%@ include file="../common/_bottom.jspf" %>
</body>
</html>