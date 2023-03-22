<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="<c:url value="/resources/css/custom.css"/>" rel="stylesheet"/>

<style>
.circle {
  border: 1px solid #333;
  width: 30px;
  height: 30px;
  display: inline-block;
  border-radius: 50%;
  margin: 0px 5px;
  text-align: center;
  cursor: pointer;
}
.square {
  display: inline-block;
  border: 1px solid #333;
  width: 80px;
  height: 30px;
  text-align: center;
}

</style>

<form id="toShopCar" action="<c:url value="checkToShopCar"/>" method="POST">
<div class="container mainArea">
	<!-- 商品資訊 -->
	<div class="card">
	  <img src="resources/assets/img/06.jpg" class="card-img-top" alt="...">
	  <div class="card-body">
	  	<h5 class="card-title">${detail.productName}</h5>
	  	<input type="hidden" id="productId" name="productId" value="${detail.productId}">
        <div class="row align-items-center" id="chooseNum">
          <div class="col-7 ">
	          <div class="circle">
	            <i class="fa-solid fa-minus"></i>
	          </div>
	          <div class="square">1</div>
	          <div class="circle">
	            <i class="fa-solid fa-plus"></i>
	          </div>
          </div>
          <div class="col-auto"><span class="fs-2">${priceM}</span></div>
          <input type="hidden" id="finalSize" name="finalPrice">
        </div>
    	<p class="card-text">${detail.productDesc}</p>
	  </div>
	</div>
	<!-- 份量 -->
	<div class="card">
	  <div class="card-body">
	    <h5 class="card-title">份量</h5>
		<div class="form-check">
		  <input class="form-check-input" type="radio" name="radioSize" id="radioSizeM" value="M">
		  <label class="form-check-label" for="radioSizeM">
		  ${sizeM}
		  </label>
		</div>
		<c:if test="${sizeL != null}">
			<div class="form-check">
			  <input class="form-check-input" type="radio" name="radioSize" id="radioSizeL" value="L" checked>
			  <label class="form-check-label" for="radioSizeL">
			    ${sizeL} (+${priceL - priceM}元)
			  </label>
			</div>
		</c:if>
	  </div>
	</div>
	<!-- 甜度 -->
	<div class="card">
	  <div class="card-body">
	    <h5 class="card-title">甜度</h5>
	    <input type="hidden" id="finalSweet" name="finalSweet">
		<div class="form-check">
		  <input class="form-check-input" type="radio" name="radioSweet" id="radioSweet1" value="全糖">
		  <label class="form-check-label" for="radioSweet1">
		    全糖
		  </label>
		</div>
		<div class="form-check">
		  <input class="form-check-input" type="radio" name="radioSweet" id="radioSweet2" value="半糖" checked>
		  <label class="form-check-label" for="radioSweet2">
		    半糖
		  </label>
		</div>
		<div class="form-check">
		  <input class="form-check-input" type="radio" name="radioSweet" id="radioSweet3" value="微糖" checked>
		  <label class="form-check-label" for="radioSweet3">
		    微糖
		  </label>
		</div>
		<div class="form-check">
		  <input class="form-check-input" type="radio" name="radioSweet" id="radioSweet4" value="無糖" checked>
		  <label class="form-check-label" for="radioSweet4">
		    無糖
		  </label>
		</div>
	  </div>
	</div>
	<!-- 冰塊 -->
	<div class="card">
	  <div class="card-body">
	    <h5 class="card-title">冰塊</h5>
	    <input type="hidden" id="finalIce" name="finalIce">
		<div class="form-check">
		  <input class="form-check-input" type="radio" name="radioIce" id="radioIce1" value="去冰">
		  <label class="form-check-label" for="radioIce1">
		    去冰
		  </label>
		</div>
		<div class="form-check">
		  <input class="form-check-input" type="radio" name="radioIce" id="radioIce2"  value="微冰" checked>
		  <label class="form-check-label" for="radioIce2">
		    微冰
		  </label>
		</div>
		<div class="form-check">
		  <input class="form-check-input" type="radio" name="radioIce" id="radioIce3"  value="少冰" checked>
		  <label class="form-check-label" for="radioIce3">
		    少冰
		  </label>
		</div>
		<div class="form-check">
		  <input class="form-check-input" type="radio" name="radioIce" id="radioIce4"  value="正常冰" checked>
		  <label class="form-check-label" for="radioIce4">
		    正常冰
		  </label>
		</div>
		<div class="form-check">
		  <input class="form-check-input" type="radio" name="radioIce" id="radioHot1"  value="熱" checked>
		  <label class="form-check-label" for="radioHot1">
		    熱
		  </label>
		</div>
	  </div>
	</div>
</div>

<!-- 按鈕(固定在最下面) -->
<div class="container-fluid bg-info fixed-bottom" style="height:200px">
	<div class="row justify-content-center align-items-center" style="height:100%">
		<div class="row bg-warning justify-content-center d-flex align-items-center" id="btnArea">
			<div class="col-auto"><span class="fs-3">加入購物車</span></div>
		</div>
	</div>
</div>
</form>
<script>
	$('#btnArea').on('click',function(){
		var size=$('#radioPriceL:checked').val();
		$('#finalSize').val($('input:radio[name="radioSize"]:checked').val());
		$('#finalSweet').val($('input:radio[name="radioSweet"]:checked').val());
		$('#finalIce').val($('input:radio[name="radioIce"]:checked').val());
        $('#toShopCar').submit();
	})
</script>