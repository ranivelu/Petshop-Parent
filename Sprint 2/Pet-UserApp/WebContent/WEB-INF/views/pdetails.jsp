<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Details</title>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
</head>
<body>
	<script type="text/javascript">

		urlPath=window.location.pathname;
		urlPathArray = urlPath.split('/');
	 	
		var productCode = urlPathArray[3];
		var REST_PRODUCT_DETAILS = "http://localhost:8080/petuser/rest/product/" +productCode;
			//"http://localhost:8080/petuser/rest/product" + productCode;
		//"http://localhost:8080/petuser/rest/products";

		var prdApp = angular.module('prdApp', []);
		prdApp.controller('pdetails', function($scope, $http) {
			$http.get(REST_PRODUCT_DETAILS).success(function(response) {
				$scope.product = response;
			});
			//alert($scope.product);
		});
	</script>

	<div ng-app="prdApp" ng-controller="pdetails">
		<table>
			<tbody>
				<tr>
					<td>Product Image</td>
					<td><img alt="" src=""></td>
				</tr>
				<tr>
					<td>Product Code</td>
					<td>{{product.prdCode}}</td>
				</tr>
				<tr>
					<td>Product Name</td>
					<td>{{product.prdName}}</td>
				</tr>
				<tr>
					<td>Category Code</td>
					<td>{{product.catCode}}</td>
				</tr>
				<tr>
					<td>Product Code</td>
					<td>{{product.prdDesc}}</td>
				</tr>
				<tr>
					<td>Product Code</td>
					<td>{{product.prdPrice}}</td>
				</tr>
			</tbody>
		</table>
		<div><td><a href="<c:url value='/paddcart/{{product.prdCode}}' />">
							Add to Cart</a></td></div>
	</div>
	
</body>
</html>