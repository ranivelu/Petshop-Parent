<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Products Page</title>


<style type="text/css" dir="<c:url value='/css/pet-webshop.css'/>"></style>
<!-- Global Url for Angular Libraries 
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js"></script> 
Filters -->
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
<!-- 
<script type="text/javascript" src="<c:url value='/resources/js-lib/angular2.js'/>"></script>-->
<script type="text/javascript" src="<c:url value='/resources/js/petshop-common.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/petshop-user.js'/>"></script>
</head>
<body>

<script type="text/javascript">

var REST_GET_PRODUCTS = "http://localhost:8080/petuser/rest/products"; 
	//"http://localhost:8080/petuser/rest/products";

var prdApp = angular.module('prdApp', []);
prdApp.controller('productList', function($scope, $http) {
	$http.get(REST_GET_PRODUCTS).success(
			function(response) {
				$scope.products = response;
			});
	//alert($scope.products);
}); 

</script>

	<div ng-app="prdApp" ng-controller="productList">
		<table>
			<thead>
				<tr>
					<th width="80">Product ID</th>
					<th width="120">Product Name</th>
					<th width="120">Product Description</th>
					<th width="60">Product Price</th>
					<th width="60">Product Details</th>
					<th width="60">Add to Cart</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th width="80"><label><input ng-model="search.prdCode"></label></th>
					<th width="120"><label> <input
							ng-model="search.prdName"></label></th>
					<th width="120"><label> <input
							ng-model="search.prdDesc"></label></th>
					<th width="60"><label><input
							ng-model="search.prdPrice"></label></th>
					<th width="60"></th>
					<th width="60"></th>
				</tr>
				<tr
					ng-repeat="product in products |filter:search:strict |orderBy:'prdCode'">
					<!-- | filter:test | orderBy:'country' -->
					<td>{{product.prdCode}}</td>
					<td>{{product.prdName}}</td>
					<td>{{product.prdDesc}}</td>
					<td>{{product.prdPrice}}</td>
					<td><a href="<c:url value='/pdetails/{{product.prdCode}}' />">
							View Details</a></td>
					<td><a href="<c:url value='/paddcart/{{product.prdCode}}' />">
							Add to Cart</a></td>					
				</tr>
			</tbody>
		</table>

	</div>





</body>
</html>