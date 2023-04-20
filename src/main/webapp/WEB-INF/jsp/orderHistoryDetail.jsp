<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link href="<c:url value="/resources/css/custom.css"/>" rel="stylesheet"/>

<script>
</script>
<div class="container mainArea">
	<!-- 大標題1：過去訂單記錄 -->
	<div class="bigBox">
		<h3 class="" style="margin-left: 10px;">訂單 #${orderNo} </h3>
		<h6 style="margin-left: 20px;margin-right:20px;color:gray"><i class="fa-sharp fa-solid fa-location-dot" style="color:orange"></i> 訂購於 T&YOU café</h6>
		<h6 style="margin-left: 20px;margin-right:20px;color:gray"><i class="fa-solid fa-calendar-days" style="color:orange"></i> 訂單時間 ${orderTime}</h6>
		<c:forEach items="${detailList}" var="data" varStatus="loop">
		<div class="littleBox" style="background-color:#FFFAF2">
			<div class="row align-items-center">
				<!-- bg-info bg-warning bg-primary-->
				<div class="col-3 ">
					<div><img class="boxImg" src="<c:url value="/resources/assets/img/banner.jpg"/>"/></div>
				</div>
				<div class="col-6 fontBox" >
					<div><span class="fs-6">${data.remark}</span></div>
					<div><span class="fs-6">數量 ${data.num}</span></div>
					<div><span class="fs-6">$ ${data.sum}</span></div>
				</div>
				<div class="col-3 text-center">
				</div>
			</div>
		</div>
		</c:forEach>
	</div>
	<hr>
	<div class="bigBox" style="margin-top:30px">
		<div>
			<div class="align-items-center" style="margin-left: 20px;margin-right:20px">
					<div class=""><span style="font-size:10px;color:gray">小計:</span><span style="font-size:10px;float:right;height:20px;color:gray">$ ${totalPrice}</span></div>
					<div class=""><span style="font-size:10px;color:gray">優惠卷:</span><span style="font-size:10px;float:right;color:gray"></span></div>
					<div class=""><span style="font-size:10px;color:gray">總計:</span><span style="font-size:10px;float:right;color:gray">$ ${totalPrice}</span></div>
			</div>
		</div> 
	</div>
	<hr>
	<div class="bigBox">
					<h5 class="" style="font-family: monospace; margin-top: 10px;margin-left: 20px;">付款方式</h5>
					<div class="align-items-center" style="margin-left: 20px;margin-right:20px">
					<div class=""><span><img src="<c:url value="/resources/assets/img/LINE-Pay.png"/>" ></span><span style="font-size:10px;float:right;height:20px;color:gray">$ ${totalPrice}</span></div>
			</div>
		</div>
</div>
<script>
</script>

	
