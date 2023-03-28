<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link href="<c:url value="/resources/css/custom.css"/>" rel="stylesheet"/>

<script>
</script>
<c:choose>
<c:when test="${!empty dataList}">
<div class="container mainArea">
	
	<!-- 大標題1：購物車 -->
	<div class="bigBox">
		<h1 class=""><a href="<c:url value="/order" />" style="width:150px"><i class="fa-solid fa-arrow-left" ></i></a>  購物車</h1>
		<c:forEach items="${dataList}" var="data" varStatus="loop">
<%-- 		onclick="edit(${loop.index});" --%>
		<div class="bg-secondary littleBox" >
			<div class="row align-items-center" >
				<!-- bg-info bg-warning bg-primary-->
				<div class="col-3 ">
					<div><img class="boxImg" src="<c:url value="resources/assets/img/06.jpg"/>"/></div>
				</div>
				<div class="col-6 fontBox" >
					<div><span class="fs-6">${data.productName}</span></div>
					<div><span class="fs-6">${data.size}/${data.ice}/${data.sweet}</span></div>
					<div><a style="padding:5px" onclick="numMinus(${loop.index});"><i class="fa-solid fa-minus"></i></a><input type="text" id="${loop.index}" style="width:40px;text-align:center" value="${data.num}" readonly><a style="padding:5px" onclick="numPlus(${loop.index});"><i class="fa-solid fa-plus"></i></a></div>
	            
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
		<div class="row bg-warning justify-content-center d-flex align-items-center" id="btnArea" >
			<div class="col-auto"><a href="<c:url value="/orderCheck" />" class="text-dark" style="font-size:20px">結帳</a></div>
		</div>
	</div>
</div>
</c:when>
<c:otherwise>
<div class="container mainArea">
	
	<!-- 大標題1：購物車 -->
	<div class="bigBox">
		<h1 class="">購物車為空</h1>
		<a href="<c:url value="/order"/>">回菜單</a>
	</div>
</div>
</c:otherwise>
</c:choose>
<script>
	function edit(index){
		 $.ajax({
	            type:"POST",
	            url: '<c:url value="/shopCar/remove"/>',
	            data: {index:index},
	            success:function(result){
	            	location.reload();
	            }
	        });
	}
	
	function numMinus(index){
		var minusNum = $('#'+index).val();
		if(minusNum - 1 == 0){
			edit(index);
		}else{
// 		$('#'+index).val(minusNum - 1);
			$.ajax({
	            type:"POST",
	            url: '<c:url value="/shopCar/edit"/>',
	            data: {index:index,num:minusNum,mt:"minus"},
	            success:function(result){
	            	location.reload();
	            }
	        });
		}
	}
	
	function numPlus(index){
		var plusNum = $('#'+index).val();
		$.ajax({
            type:"POST",
            url: '<c:url value="/shopCar/edit"/>',
            data: {index:index,num:plusNum,mt:"plus"},
            success:function(result){
            	location.reload();
            }
        });
	}
</script>

	
