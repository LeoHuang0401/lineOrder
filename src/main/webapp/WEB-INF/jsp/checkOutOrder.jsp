<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
	#space {
		height: 100px
		
	}
	
	.mainOrder {
/* 		height: 200px; */
/* 		border: 10px solid black; */
 		border-radius: 10px;
		margin-bottom: 2%;

		
	}
	img {
 		padding:5px; 
		height:100%;
		width:100%
	}
	#btnArea {
		width: 200PX;
		height: 50PX;
		border-radius: 10px;
		margin-bottom: 10px;
	}
</style>
<script>
	
</script>
	<!-- 訂單明細 -->
	<div id="space"></div>

	<div class="container">
		<!-- 預計取餐時間 -->
		<div>
			<h1 class="">預計取餐時間</h1>
			<div class="bg-secondary mainOrder">
				<input class="form-control form-control-lg" type="time">
			</div>
		</div>
		
		<!-- 訂單明細 -->
		<div>
			<h1 class="">訂單明細</h1>
			<div class="bg-secondary mainOrder">
				<div class="row justify-content-center d-flex align-items-center" >
	<!-- 				bg-info bg-warning bg-primary-->
					<div class="col-3">
						<div><img src="resources/assets/img/06.jpg"/></div>
					</div>
					<div class="col-6 align-items-center" >
						<div class=""><span class="fs-6">帶我走-提拉米蘇拿鐵</span></div>
						<div class=""><span class="fs-6">M/微冰</span></div>
						<div><span class="fs-6">數量 1</span></div>
					</div>
					<div class="col-3 text-center">
						<div><span class="fs-2">$ 85</span></div>
					</div>
				</div>
			</div>
			<div class="bg-secondary mainOrder">
				<div class="row justify-content-center d-flex align-items-center" style="height: 100%">
					<div class="col-3">
						<div><img src="resources/assets/img/07.jpg"/></div>
					</div>
					<div class="col-6 align-items-center">
						<div class=""><span class="fs-6">花生醬炙燒培根</span></div>
						<div class=""><span class="fs-6">x</span></div>
						<div><span class="fs-6">數量 1</span></div>
					</div>
					<div class="col-3 text-center">
						<div><span class="fs-2">$ 105</span></div>
					</div>
				</div>
			</div>
			<div class="bg-secondary mainOrder">
				<div class="row justify-content-center d-flex align-items-center" style="height: 100%">
					<div class="col-3">
						<div><img src="resources/assets/img/07.jpg"/></div>
					</div>
					<div class="col-6 align-items-center">
						<div class=""><span class="fs-6">花生醬炙燒培根</span></div>
						<div class=""><span class="fs-6">x</span></div>
						<div><span class="fs-6">數量 1</span></div>
					</div>
					<div class="col-3 text-center">
						<div><span class="fs-2">$ 105</span></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container-fluid bg-info" style="height:200px">
		<div class="row justify-content-center" style="height:100%">
			<div class="row align-items-center" id="checkArea" style="height:50%">
				<div class="col-sm-7" ></div>
				<div class="col-sm-5">
					<div class=""><span class="fs-5">數量： 4</span></div>
					<div class=""><span class="fs-5">應付金額： 300</span></div>
				</div>
			</div>
			<div class="row bg-warning justify-content-center d-flex align-items-center" style="height:30%" id="btnArea" >
				<div class="col-auto"><span class="fs-3">結帳</span></div>
			</div>
		</div>
	</div>

	
