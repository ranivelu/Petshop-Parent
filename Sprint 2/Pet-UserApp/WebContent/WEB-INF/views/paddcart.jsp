 <script type="text/javascript">
 /* 
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
	}); */
    
    var headerApp = angular.module('headerApp', []);
    headerApp.controller('headerAppCtrl', function($scope, $http, $window) {
		if($window.sessionStorage.name) {
			$scope.name = $window.sessionStorage.name;
			alert($scope.name);
		}
	});	
 
</script>
<div align="right">Customer Name : {{name}} </div>