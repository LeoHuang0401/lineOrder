<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<!-- Header-->
	<header class="masthead text-center text-white"> 
		<img class="img-fluid rounded-circle" src="<c:url value="/resources/assets/img/banner.jpg"/>" alt="..." />
	</header>
	<!-- Content section 1-->
	<a id="gotop" style="display: none;position: fixed;right: 20px;bottom: 20px;padding: 10px 15px;
	font-size: 18px;background: white;border-radius:10px;color: pink;z-index:3" href="<c:url value="/shopCar" />">
	<c:if test="${shopCarNum != null}">
		${shopCarNum}
	</c:if>
	<i class="fa-solid fa-cart-shopping"></i></a>
	 <c:forEach items="${data}" var="list">
			<div class="card product-card">
				<div class="card-header">
					<h4 class="category-title col-7"><c:out value="${list.productCategoryName}"></c:out></h4> 
					<span class="col-2">M</span> 
					<span class="col-2">L</span> 
				</div>
				<c:forEach items="${list.dataList}" var="map">
				<ul class="list-group list-group-flush">
					<li class="list-group-item" onclick="productDetail(${map.PRODUCT_ID});">
						<span class="col-7">${map.PRODUCT_NAME}</span> 
						<span class="col-2">${map.price1}</span> 
						<c:if test="${map.price2 != null}">
						<span class="col-2">${map.price2}</span> 
						</c:if>
					</li>
				</ul>
				</c:forEach>
			</div>
	</c:forEach>
<script>
	$(function(){
    $(window).scroll(function() {
        if ( $(this).scrollTop() > 0){
            $('#gotop').fadeIn("fast");
        }
	    });
	});

	function productDetail(id){
		window.location.href='<c:url value="/order/orderData?id="/>'+id;
	}
</script>
