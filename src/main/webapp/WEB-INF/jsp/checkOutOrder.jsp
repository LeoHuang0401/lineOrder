<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link href="<c:url value="/resources/css/custom.css"/>" rel="stylesheet"/>

<div class="container mainArea">
	<ul class="wizard-steps" style="max-width: 100%;">
		<li class="current"><span class="step">1</span> <span class="title" style="color: #ffc107">確認明細</span></li>
		<li class=""><span class="step">2</span> <span class="title" style="color:gray">確認結帳</span></li>
	</ul>
	<!-- 大標題1：預計取餐時間 -->
	<form id="requestForm" method="post" action="<c:url value="/orderCheckPay"/>">
		<div class="bigBox">
			<div class="bg-light littleBox">
				<div class="row align-items-center">
					<h5 style="font-family: monospace; margin-top: 20px;margin-left: 20px;">預計取餐時間</h5>
					<div class="" align="center" style="margin-bottom:10px">
						<input class="form-control form-control-lg" type="time" id="takeTime" name="takeTime" value="${takeTime}" onchange="checkTime();" style="border-radius:10px;width:80%;">
					</div>
				</div>
			</div>
		</div>
	</form>
	<!-- 大標題2：訂單明細 -->
	<div class="bigBox">
		<h5 class="" style="font-family: monospace; margin-top: 10px;margin-left: 20px;"> 訂單明細</h5>
		<c:forEach items="${dataList}" var="data" varStatus="loop">
		<div class=" littleBox" style="width:90%;margin-left: 10px;background-color:#FFFAF2">
			<div class="row align-items-center" >
				<!-- bg-info bg-warning bg-primary-->
				<div class="col-3 ">
					<div><img class="boxImg" src="<c:url value="/resources/assets/img/06.jpg"/>"/></div>
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
	<div class="bigBox">
			<div class="bg-light littleBox">
				<div class="row align-items-center">
					<h5 class="" style="font-family: monospace; margin-top: 10px;margin-left: 20px;">付款方式</h5>
					<div class="form-check" style="margin-bottom:10px">
					  <input class="form-check-input" type="radio" name="linePayCheck" id="linePayCheck" style="margin-left:20px;background-color:#ffc107;border: 1px solid #ffc107;" checked>
					  <label class="form-check-label" for="linePayCheck" style="margin-left:5px">
					    <img src="<c:url value="/resources/assets/img/LINE-Pay.png"/>" >
					  </label>
					</div>
				</div>
			</div>
		</div>
	<!-- 按鈕(固定在最下面) -->
	<div class="fixed-bottom" style="height: 70px;margin-bottom:3px;bottom: 50px !important;">
			<div class="row" style="height: 100%;">
				<div class="btn-group" role="group" aria-label="Basic example">
					<button type="button" class="btn" style="background: #FFFAF2;font-weight:bold;" onclick="location.href='<c:url value="/shopCar"/>'">上一步</button>
					<button type="button" class="btn" style="background: orange;font-weight:bold;color:white" onclick="next();">下一步</button>
				</div>
			</div>
		</div>
	</div>
<script>
	function checkTime(){
		if ($('#takeTime').val() < '${pickUpTime}'){
			alert('取餐時間不可早於即時起15分鐘');
		}
	}
	
	function next(){
		if($('#takeTime').val() == null || $('#takeTime').val() == ''){
			alert('取餐時間不得為空');
		}else if ($('#takeTime').val() < '${pickUpTime}'){
			alert('取餐時間不可早於即時起15分鐘');
		}else{
			$('#requestForm').submit();
		}
	}
</script>

	


	
