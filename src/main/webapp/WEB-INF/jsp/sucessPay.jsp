<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link href="<c:url value="/resources/css/custom.css"/>" rel="stylesheet"/>

<div class="container mainArea">

	<!-- 大標題1 訂單已送出 -->
	<h1 class="" ><a href="<c:url value="/order" />" style="width:150px"><i class="fa-solid fa-xmark" style="color:orange"></i></a>  訂單已送出</h1>
	<div class="bigBox" align="center">
		 <div >
			<div class="align-items-center" >
				<!-- bg-info bg-warning bg-primary-->
				<div class=" fontBox" align="center">
					<span style="color:orange;width:300px">預計取餐時間</span>
					<div><span class="fs-6">${takeTime}</span></div>
				</div>
				<div class="col-6" style="margin-top:10px">
					<div><i class="fa-sharp fa-solid fa-circle-check" style="font-size: 5em;color:orange"></i></div>
				</div>
			</div>
		</div> 
	</div>
	<div align="center">
		<span>${uLineName}，我們已收到您的訂單，正在處理中....<br/>可至歷史訂單查看訂單詳細資訊</span>
	</div>
	<hr>
	<div class="bigBox" style="margin-top:30px">
		<div>
			<div class="align-items-center" >
				<div class=" fontBox">
					<span style="font-size:15px">訂單詳情</span>
					<div class=""><span style="font-size:10px;color:gray">您的訂單:</span><span class="input-group-text" id="basic-addon2" style="font-size:10px;float:right;height:20px;color:#1C1CFF"># ${orderNo}</span></div>
					<div class=""><span style="font-size:10px;color:gray">餐點店家:</span><span style="font-size:10px;float:right;color:gray">T&YOU</span></div>
					<div class=""><span style="font-size:10px;color:gray">金額:</span><span style="font-size:10px;float:right;color:gray">$ ${totalPrice}</span></div>
				</div>
				<div class="col-6">
				</div>
			</div>
		</div> 
	</div>
</div>
<script>
</script>

	


	
