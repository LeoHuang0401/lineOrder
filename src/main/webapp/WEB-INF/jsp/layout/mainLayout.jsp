<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>One Page Wonder - Start Bootstrap Template</title>
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js"
	crossorigin="anonymous"></script>
<!-- Google fonts-->
<link
	href="https://fonts.googleapis.com/css?family=Catamaran:100,200,300,400,500,600,700,800,900"
	rel="stylesheet" />
<link
	href="https://fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400,400i,700,700i,900,900i"
	rel="stylesheet" />
	
<!-- Bootstrap V5.0.2-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	
<!-- Core theme CSS (includes Bootstrap)-->
<link href="<c:url value="/resources/css/styles.css"/>" rel="stylesheet" />
<link href="<c:url value="/resources/css/common.css"/>" rel="stylesheet" />
<script src="<c:out value="/onlineOrder/resources/jquery/jquery.min.js" />"></script>
</head>
<body id="page-top">
	<!-- Navigation-->
	<nav
		class="navbar navbar-expand-lg navbar-dark navbar-custom fixed-top">
		<div class="container px-5">
			<a class="navbar-brand" href="#page-top"> <img
				class="img-fluid rounded-circle width-40 margin-r-10"
				src="<c:url value="/resources/assets/img/02.jpg"/>" alt="..." />
				點餐平台
			</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ms-auto">
					<li class="nav-item"><a class="nav-link" href="<c:url value="/store" />">附近店家</a></li>
					<li class="nav-item"><a class="nav-link" href="<c:url value="/order" />">點餐</a></li>
					<li class="nav-item"><a class="nav-link" href="<c:url value="/confirmOrder" />">訂單</a></li>
					<li class="nav-item"><img
						class="img-fluid rounded-circle width-40"
						src="<c:url value="/resources/assets/img/02.jpg"/>" alt="..." /></li>
					<li class="nav-item"><a class="nav-link" href="#!">oyang</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- Content section 1-->
	
	<sitemesh:write property="body"/>

	<!-- Footer-->
	<footer class="py-5 bg-black">
		<div class="container px-5">
			<p class="m-0 text-center text-white small">Copyright &copy; Your
				Website 2022</p>
		</div>
	</footer>
	<!-- Bootstrap core JS-->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	
	<!-- Line LIFF SDK v2 版 -->
<!-- 	<script src="https://static.line-scdn.net/liff/edge/2/sdk.js"></script> -->
	<!-- Core theme JS-->
<%-- 	<script src="<c:url value="/resources/js/scripts.js"/>"></script> --%>
<%-- 	<script src="<c:url value="/resources/js/line-liff.js"/>"></script>  --%>
</body>
</html>
