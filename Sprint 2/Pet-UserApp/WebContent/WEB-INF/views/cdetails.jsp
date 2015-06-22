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
	 	
		var catCode = urlPathArray[3];
		var REST_CAT_DETAILS = "http://localhost:8080/petuser/rest/category/" +catCode;
			//"http://localhost:8080/petuser/rest/product" + productCode;
		//"http://localhost:8080/petuser/rest/products";

		var prdApp = angular.module('catApp', []);
		prdApp.controller('cdetails', function($scope, $http) {
			$http.get(REST_CAT_DETAILS).success(function(response) {
				$scope.category = response;
			});
			//alert($scope.product);
		});
	</script>

	<div ng-app="catApp" ng-controller="cdetails">
		<table>
			<tbody>
				<tr>
					<td>Category Image</td>
					<td><img alt="" src=""></td>
				</tr>
				<tr>
					<td>Category Code</td>
					<td>{{category.catCode}}</td>
				</tr>
				<tr>
					<td>Category Name</td>
					<td>{{category.catName}}</td>
				</tr>
				<tr>
					<td>Category Description</td>
					<td>{{category.catDesc}}</td>
				</tr>				
			</tbody>
		</table>
		<div><button>Add to Cart</button></div>
	</div>
	
</body>
</html>