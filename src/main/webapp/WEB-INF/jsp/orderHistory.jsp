<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link href="<c:url value="/resources/css/custom.css"/>" rel="stylesheet"/>

<script>
</script>
<div class="container mainArea">
	<form id="historyDetailForm" method="post" action="<c:url value="/orderHistoryDetail"/>">
	<!-- 大標題1：過去訂單記錄 -->
	<div class="bigBox">
		<h1 class=""><a href="<c:url value="/order" />" style="width:150px"><i class="fa-solid fa-xmark" style="color:orange"></i></a>  過去訂單紀錄</h1>
		<c:forEach items="${dataList}" var="data" varStatus="loop">
		<div class="littleBox" style="background-color:#FFFAF2">
			<div class="row align-items-center" onclick="showHistory(${data.orderNo},${data.totalPrice},'${data.orderTime}');">
				<!-- bg-info bg-warning bg-primary-->
				<div class="col-3 ">
					<div><img class="boxImg" src="<c:url value="/resources/assets/img/banner.jpg"/>"/></div>
				</div>
				<div class="col-6 fontBox" >
					<div><span class="fs-6">${data.storeName}</span></div>
					<div><span class="fs-6">$ ${data.totalPrice}</span></div>
					<div><span class="fs-6">${data.orderTime}</span></div>
					<div><span class="fs-6">${data.remark}</span></div>
				</div>
				<div class="col-3 text-center">
				</div>
			</div>
		</div>
		</c:forEach>
	</div>
	<input type="hidden" id="orderN" name="orderN" value="">
	<input type="hidden" id="totalPrice" name="totalPrice" value="">
	<input type="hidden" id="orderTime" name="orderTime" value="">
	</form>
</div>
<script>
	<!-- 轉跳至商品明細頁面 -->
	function showHistory(orderNo,totalPrice,orderTime){
		$('#orderN').val(orderNo);
		$('#totalPrice').val(totalPrice);
		$('#orderTime').val(orderTime);
		$('#historyDetailForm').submit();
	}
</script>

	
