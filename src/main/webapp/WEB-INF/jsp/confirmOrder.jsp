<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Tempus Dominus Styles -->
</head>
<body>
<!-- Header-->
	<header class="back text-center text-white"> 
		<span style="font-size:20px;letter-spacing:40px">確認訂單</span>
	</header>
	
	
<%-- 	method="POST" name="form1" action="<c:url value="/confirmOrder/checkLinePay" />" --%>
	<form id="form1" method="POST" name="form1" action="<c:url value="/confirmOrder/checkLinePay" />">
	<div class="card product-card">
		<div class="card-header">
			<h4 class="category-title col-5">預計取餐時間</h4> 
			<span class="col-6">
					
			</span> 
		</div>
		<!-- body -->
		<ul class="list-group list-group-flush">
			<li class="list-group-item">
				<input type="time" id="pickUpTime" name="pickUpTime" class="form-control search-control" placeholder="請選擇">
			</li>
		</ul>
	</div>
	<div class="card product-card">
		<div class="card-header">
			<h4 class="category-title col-5">訂單明細</h4> 
			<span class="col-6">
			</span> 
		</div>
		<!-- body -->
		<ul class="list-group list-group-flush">
			<li class="list-group-item">
				<span class="col-7">美式咖啡</span> 
				<span class="col-2">$55</span> 
				<span class="col-2">$60</span> 
			</li>
		</ul>
	</div>
	</form>
	<div align="center">
	<a id="btnConfirm" class="btn btn-primary" onclick="checkData();"> 結帳</a>
	</div>
	
<script>

function checkData(){
	if($('#pickUpTime').val() == null || $('#pickUpTime').val() == ''){
		alert('取餐時間不得為空');
		return ;
	}else if ($('#pickUpTime').val() < '${nowTime}'){
		alert('取餐時間不可早於現在時間');
	}else{
 	$('#form1').submit();
	}
}

</script>
</body>
</html>