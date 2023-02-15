<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<!-- Content section 1-->
	<div class="card product-card">
		<p>
		  Your location is <span id="latitude">0.00</span>° latitude by
		  <span id="longitude">0.00</span>° longitude.
		</p>
	</div>
		
	<script>
	
	document.addEventListener("DOMContentLoaded", () => {
		  console.log("Hello World!");
		  getLocation();
		});
	
	var getLocation = () => {
		let latText = document.getElementById("latitude");
		let longText = document.getElementById("longitude");
		
		navigator.geolocation.getCurrentPosition((position) => {
		    let lat = position.coords.latitude;
		    let long = position.coords.longitude;

		    latText.innerText = lat.toFixed(2);
		    longText.innerText = long.toFixed(2);
		    
		  });
	}
	
	
	
	</script>

