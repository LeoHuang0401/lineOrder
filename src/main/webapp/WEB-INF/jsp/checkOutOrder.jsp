<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link href="<c:url value="/resources/css/custom.css"/>" rel="stylesheet"/>

<div class="container mainArea">

	<!-- 大標題1：預計取餐時間 -->
	<form id="requestForm" method="post" action="<c:url value="/confirmOrder/checkLinePay"/>">
	<div class="bigBox">
		<h1 class="">預計取餐時間</h1>
		<div class="bg-secondary">
			<input class="form-control form-control-lg" type="time" id="takeTime" name="takeTime" onchange="checkTime();">
		</div>
	</div>
	</form>
	<!-- 大標題2：訂單明細 -->
	<div class="bigBox">
		<h1 class=""><a href="<c:url value="shopCar" />" style="width:150px"><i class="fa-solid fa-arrow-left" ></i></a>  訂單明細</h1>
		<c:forEach items="${dataList}" var="data" varStatus="loop">
		<div class="bg-secondary littleBox" >
			<div class="row align-items-center" >
				<!-- bg-info bg-warning bg-primary-->
				<div class="col-3 ">
					<div><img class="boxImg" src="resources/assets/img/06.jpg"/></div>
				</div>
				<div class="col-6 fontBox" >
					<div><span class="fs-6">${data.productName}</span></div>
					<div><span class="fs-6">${data.size}/${data.ice}/${data.sweet}</span></div>
					<div><span class="fs-6">數量 ${data.num}</span></div>
	            
				</div>
				<div class="col-3 text-center">
					<div><span class="fs-2">$${data.price * data.num}</span></div>
				</div>
			</div>
		</div>
		</c:forEach>
	</div>
</div>
<!-- 按鈕(固定在最下面) -->
<div class="container-fluid bg-info fixed-bottom" style="height:200px">
	<div class="row justify-content-center" style="height:100%">
		<div class="row align-items-center" style="height:50%">
			<div class="col-sm-7" ></div>
			<div class="col-sm-5">
				<div class=""><span class="fs-5">數量： ${total.totalNum}</span></div>
				<div class=""><span class="fs-5">應付金額： ${total.totalPrice}</span></div>
			</div>
		</div>
		<div class="row bg-warning justify-content-center d-flex align-items-center" id="btnArea">
			<div class="col-auto" ><span class="fs-3">確認付款</span></div>
		</div>
	</div>
</div>

<script>
	function checkTime(){
		if ($('#takeTime').val() < '${pickUpTime}'){
			alert('取餐時間不可早於即時起15分鐘');
		}
	}
	
	$('#btnArea').click(function requestForm(){
		if($('#takeTime').val() == null || $('#takeTime').val() == ''){
			alert('取餐時間不得為空');
		}else if ($('#takeTime').val() < '${pickUpTime}'){
			alert('取餐時間不可早於即時起15分鐘');
		}else{
			$('#requestForm').submit();
		}
	})
</script>

	


	
