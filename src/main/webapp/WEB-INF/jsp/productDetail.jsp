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


<div class="container mainArea">
	<!-- 商品資訊 -->
	<div class="card">
	  <img src="resources/assets/img/06.jpg" class="card-img-top" alt="...">
	  <div class="card-body">
	  	<h5 class="card-title">帶我走-提拉米蘇拿鐵</h5>	
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
          <div class="col-auto"><span class="fs-2">$ 75</span></div>
        </div>
    	<p class="card-text">藍山咖啡香味略淡，但喝起來的口感卻是非常香醇可口，略帶點果香的香純，而其滑順入喉的口感，擁有絲絨般細膩醇厚的香氣，細緻的芳香中帶著難以捉摸迷人氣質。</p>
	  </div>
	</div>
	<!-- 份量 -->
	<div class="card">
	  <div class="card-body">
	    <h5 class="card-title">份量</h5>
		<div class="form-check">
		  <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1">
		  <label class="form-check-label" for="flexRadioDefault1">
		    M
		  </label>
		</div>
		<div class="form-check">
		  <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2" checked>
		  <label class="form-check-label" for="flexRadioDefault2">
		    L
		  </label>
		</div>
	  </div>
	</div>
	<!-- 甜度 -->
	<div class="card">
	  <div class="card-body">
	    <h5 class="card-title">甜度</h5>
		<div class="form-check">
		  <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1">
		  <label class="form-check-label" for="flexRadioDefault1">
		    全糖
		  </label>
		</div>
		<div class="form-check">
		  <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2" checked>
		  <label class="form-check-label" for="flexRadioDefault2">
		    半糖
		  </label>
		</div>
		<div class="form-check">
		  <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2" checked>
		  <label class="form-check-label" for="flexRadioDefault2">
		    微糖
		  </label>
		</div>
		<div class="form-check">
		  <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2" checked>
		  <label class="form-check-label" for="flexRadioDefault2">
		    無糖
		  </label>
		</div>
	  </div>
	</div>
	<!-- 冰塊 -->
	<div class="card">
	  <div class="card-body">
	    <h5 class="card-title">冰塊</h5>
		<div class="form-check">
		  <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1">
		  <label class="form-check-label" for="flexRadioDefault1">
		    去冰
		  </label>
		</div>
		<div class="form-check">
		  <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2" checked>
		  <label class="form-check-label" for="flexRadioDefault2">
		    微冰
		  </label>
		</div>
		<div class="form-check">
		  <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2" checked>
		  <label class="form-check-label" for="flexRadioDefault2">
		    少冰
		  </label>
		</div>
		<div class="form-check">
		  <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2" checked>
		  <label class="form-check-label" for="flexRadioDefault2">
		    正常冰
		  </label>
		</div>
		<div class="form-check">
		  <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2" checked>
		  <label class="form-check-label" for="flexRadioDefault2">
		    熱
		  </label>
		</div>
	  </div>
	</div>
</div>

<!-- 按鈕(固定在最下面) -->
<div class="container-fluid bg-info fixed-bottom" style="height:200px">
	<div class="row justify-content-center align-items-center" style="height:100%">
		<div class="row bg-warning justify-content-center d-flex align-items-center" id="btnArea" >
			<div class="col-auto"><span class="fs-3">加入購物車</span></div>
		</div>
	</div>
</div>
