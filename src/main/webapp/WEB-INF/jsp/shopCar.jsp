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
		<h5 class="" style="margin-left:20px"> 購物車</h5>
		<c:forEach items="${dataList}" var="data" varStatus="loop">
<%-- 		onclick="edit(${loop.index});" --%>
		<div class=" littleBox" style="background-color:#FFFAF2">
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
	<!-- 按鈕(固定在最下面) -->
	<div class="fixed-bottom" style="height: 120px;margin-bottom:3px;bottom: 50px !important;">
		<div class="row" style="height: 100%;">
			<div style="background: #FFF3DE">
				<span class="fs-5" style="float:right;margin-right:10px">應付金額： ${total.totalPrice}</span><span class="fs-5" style="float:right;margin-right:20px">數量： ${total.totalNum}</span>
			</div>
			<div class="btn-group" role="group" aria-label="Basic example" >
				<button type="button" class="btn" style="background: #FFFAF2;font-weight:bold;" onclick="location.href='<c:url value="order"/>'">上一步</button>
				<button type="button" class="btn" style="background: orange;font-weight:bold;color:white" onclick="location.href='<c:url value="/orderCheck" />'">結帳</button>
			</div>
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

	
