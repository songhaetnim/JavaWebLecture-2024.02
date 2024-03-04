<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	

<!DOCTYPE html>
<html lang="ko">

<head>
<%@ include file="../common/_head.jspf" %>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>역경매 게시글</title>
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
            	const modTime = document.getElementById('modTime').value;
            	const targetDateTime_ = modTime.replace("T", " ");
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

                document.getElementById('time').innerHTML = timeStr;

            }, 1000);
        }
        
        function openAuctionsModal() {
            const current_price = "${auctions.current_price}";
            const aPrice = document.getElementById('aPrice').value;
            if (parseInt(current_price) <= parseInt(aPrice)) {
                $('#notAuctionsModal').modal('show');
            } else {
                $('#auctionsModal').modal('show');
                $('#current_price').val(aPrice);
            }
        }
    </script>
    <style>
	    .itemImg {
			    width: 350px;
			    height: auto;
			}
    </style>
</head>

<body style="margin: 50px;">
<%@ include file="../common/_top.jspf" %>
	<div class="container">
		<div class="row">
			<div class="col-3">
				<a href="/jw/mini/aList" class="btn btn-secondary">
					<i class="fa-solid fa-table-list me-1"></i> 목록
				</a>
			</div>
			<div class="col-9"></div>
		</div>
		<div class="row">
			<div class="col-1"></div>
			<div class="col-5">
				<img class="itemImg" src="/jw/mini/view?filename=${auctions.pimage}">
			</div>
			<div class="col-5">
			    <input type="hidden" id="modTime" value="${auctions.end_time}">
			    <table class="table table-borderless">
			    	<tr>
				    	<td colspan="2"><h3 id="time"></h3></td>
				    </tr>
				    <tr>
				    	<td colspan="2"><h3><strong>${auctions.title}</strong></h3></td>
				    </tr>
				    <tr>
				    	<td>${auctions.user_id}</td>
				    </tr>
	                <tr>
						<td style="width: 30%;"><label class="col-form-label">시작가</label></td>
						<td style="width: 70%;"><fmt:formatNumber value="${auctions.start_price}" type="number" pattern="#,##0"></fmt:formatNumber></td>
	                </tr>
	                <tr>
						<td><label class="col-form-label">현재가</label></td>
						<td><fmt:formatNumber value="${auctions.current_price}" type="number" pattern="#,##0"></fmt:formatNumber></td>
	                </tr>
	                <tr>
						<td><label class="col-form-label">할인된 금액</label></td>
						<td><fmt:formatNumber value="${discount}" type="number" pattern="#,##0"></fmt:formatNumber></td>
	                </tr>
	                <c:if test="${secondsInt > 0}">
		                <tr>
							<td><label class="col-form-label">제시 금액</label></td>
							<td><input type="text" class="form-control" id="aPrice"></td>
		                </tr>
		                <tr>
		                	<td>
		                <%--	<input type="text" name="seller_id" value="${sessuser_id}">  --%>
		                <%--	<input type="text" name="seller_id" value="maria">  --%>
		                	</td>
			                <td colspan="1">
			              	<c:if test="${sessuser_id eq auctions.user_id or sessuser_id eq 'admin'}">
			              		<a class="btn btn-primary" href="#">경매</a>
			              	</c:if>
			                <c:if test="${sessuser_id ne auctions.user_id}">
			                	<c:if test="${sessuser_id ne 'admin'}">			                	
			              			<a class="btn btn-primary" href="javascript:openAuctionsModal()">경매</a>
			                	</c:if>
			              	</c:if>
			                </td>
		                </tr>
					</c:if>
					<c:if test="${secondsInt < 0}">
						<tr>
							<td colspan="2"><h2>경매가 종료 되었습니다</h2></td>
						</tr>
					</c:if>
            	</table>
			</div>
			<div class="col-1"></div>
		</div>
    	<div class="row mt-5">
    		<div class="col-2"></div>
    		<div class="col-8 card" style="height: 500px">
    			${auctions.content}
    		</div>    		
    		<div class="col-2"></div>
    	</div>
    </div>
    
    <%-- 밑으로는 모달 --%>
    
    <div class="modal" id="auctionsModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">경매</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				</div>
			
				<!-- Modal body -->
				<div class="modal-body">
					<strong>경매에 참여하시겠습니까?</strong>
					<div class="text-center mt-5">
						<form action="/jw/mini/auctions" method="post">
				<%-- 		<input type="text" name="seller_id" value="${sessuser_id}">  --%>
				<%-- 		<input type="text" name="seller_id" value="maria">   --%>
							<input type="hidden" id="current_price" name="current_price">
							<input type="hidden" name="auction_id" value="${auctions.auction_id}">
							<button class="btn btn-primary" type="submit">확인</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal" id="notAuctionsModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">경매</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				</div>
			
				<!-- Modal body -->
				<div class="modal-body">
					<strong>현재가보다 금액이 높습니다.</strong>
					<div class="text-center mt-5">
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
					</div>
				</div>
			</div>
		</div>
	</div>	
	<%@ include file="../common/_bottom.jspf" %>
</body>
</html>