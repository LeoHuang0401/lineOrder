<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link href="<c:url value="/resources/css/custom.css"/>" rel="stylesheet"/>

<div class="container mainArea">
	<ul class="wizard-steps" style="max-width: 100%;">
		<li class="current"><span class="step">1</span> <span class="title" style="color: #ffc107">確認明細</span></li>
		<li class="current"><span class="step">2</span> <span class="title" style="color: #ffc107">確認結帳</span></li>
	</ul>
	<div class="alert alert-danger" role="alert" style="width:80%;margin-left:40px;margin-right:50px" align="center">
	  <i class="fa-sharp fa-solid fa-circle-exclamation" style="width:5%"></i>     預計取餐時間會依門市狀況調整
	</div>
	<!-- 大標題1：預計取餐時間 -->
	<form id="requestForm" method="post" action="<c:url value="/confirmOrder/checkLinePay"/>">
		<div class="bigBox" >
			<div class="list-group" style="margin-right:20px;width:100%;display:inline;">
				<ul class="list-group-flush" style="width:45%;float:left;">
					<li class="list-group-item" style="font-family:Impact;">訂購門市</li>
					<li class="list-group-item" style="font-family:Impact;">訂購人</li>
					<li class="list-group-item" style="font-family:Impact;">取餐方式</li>
					<li class="list-group-item" style="font-family:Impact;">預計取餐時間</li>
					<li class="list-group-item" style="font-family:Impact;">付款方式</li>
					<li class="list-group-item" style="font-family:Impact;">應付金額</li>
					<li class="list-group-item"></li>
				</ul>
				<ul class="list-group-flush" style="width:40%;float:left">
					<li class="list-group-item" style="font-family:Impact;">T&YOU café</li>
					<li class="list-group-item" style="font-family:Impact;">${uLineName}</li>
					<li class="list-group-item" style="font-family:Impact;font-weight:bold;">自取</li>
					<li class="list-group-item" style="font-family:Impact;">${takeTime}</li>
					<li class="list-group-item" style="font-family:Impact;">LINE PAY</li>
					<li class="list-group-item" style="font-family:Impact;">${totalPrice }</li>
					<li class="list-group-item"></li>
				</ul>
			</div>
		</div>
	</form>
	<!-- 按鈕(固定在最下面) -->
	<div class="fixed-bottom" style="height: 70px;margin-bottom:3px;bottom: 50px !important;">
		<div class="row" style="height: 100%;">
			<div class="btn-group" role="group" aria-label="Basic example">
				<button type="button" class="btn" style="background: #FFFAF2;font-weight:bold;" onclick="location.href='<c:url value="/orderCheck"/>'">上一步</button>
				<button type="button" class="btn" style="background: orange;font-weight:bold;color:white" onclick="checkOk();">送出訂單</button>
			</div>
		</div>
	</div>
</div>
<script>
	function checkOk(){
		$('#requestForm').submit();
	}
</script>

	


	
