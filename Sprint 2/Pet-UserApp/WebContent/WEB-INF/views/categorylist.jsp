<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Categories Page</title>


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

var REST_GET_CAT = "http://localhost:8080/petuser/rest/categories"; 
	//"http://localhost:8080/petuser/rest/products";

var prdApp = angular.module('catApp', []);
prdApp.controller('categoryList', function($scope, $http) {
	$http.get(REST_GET_CAT).success(
			function(response) {
				$scope.categories = response;
			});
	//alert($scope.products);
}); 

</script>

	<div ng-app="catApp" ng-controller="categoryList">
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
					<th width="80"><label><input ng-model="search.catCode"></label></th>
					<th width="120"><label> <input
							ng-model="search.catName"></label></th>
					<th width="120"><label> <input
							ng-model="search.catDesc"></label></th>
					
					<th width="60"></th>
					<th width="60"></th>
				</tr>
				<tr
					ng-repeat="category in categories |filter:search:strict |orderBy:'catCode'">
					<!-- | filter:test | orderBy:'country' -->
					<td>{{category.catCode}}</td>
					<td>{{category.catName}}</td>
					<td>{{category.catDesc}}</td>
					
					<td><a href="<c:url value='/cdetails/{{category.catCode}}' />">
							View Details</a></td>
									
				</tr>
			</tbody>
		</table>

	</div>





</body>
</html>