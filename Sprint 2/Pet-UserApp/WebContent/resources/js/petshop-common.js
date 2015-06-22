/*
 * @author : ravelu
 * @date   : 2015-06-11
 * This is an common script library across pet shop applications. 
 */
//System/Env details

// gives the hostname and port number, if available
httpColn = "http://"
lhost = window.document.location.host;
appContext = "/petuser";
 
 


//Rest API's

var REST_GET_PRODUCTS = httpColn + lhost + appContext "/rest/products";

var REST_PRODUCT_DETAILS = "";

var REST_GET_CATEGORIES ="";
var REST_PRODUCTS_BY_CAT = "";


var app = angular.module('petCommon', []);
app.controller('petCommonCtrl', function($scope) { // 'petCommonCtrl'    
	
    $scope.myVar = false;
    
    //toggling 
    $scope.toggle = function() {
        $scope.myVar = !$scope.myVar;
    };
  
});

var prdApp = angular.module('prdApp', []);
prdApp.controller('productList', function($scope, $http) {
	$http.get(REST_GET_PRODUCTS).success(
			function(response) {
				$scope.products = response;
			});
	alert($scope.products);
}); 


/*var prdApp = angular.module('loginApp', []);
prdApp.controller('authenticate', function($scope, $http) {
	$http.get(REST_GET_PRODUCTS).success(
			function(response) {
				$scope.products = response
			});
	alert($scope.products);
}); 
*/
/**
 * Login Application Module
 * 
 */
var helloApp = angular.module('loginApp', [ "ngResource" ]);
helloApp
		.controller(
				"usersCtrl",
				function($scope, $http, $window) {

					$scope.authenticate = function() {
						// Create a resource class object
						alert("authenticate >>");
						var data = {
							usrCode : 0,
							usrName : '',
							usrPwd : $scope.username,
							usrAlias : $scope.password,
							usrType : '',
							usrMobile : 0,
							usrEmail : '',
							usrAddress : ''
						};
						$http
								.post('/rest/authenticate', data)
								.success(
										function(data, status, headers) {
											alert("User authenticated !");
											$http
													.get(
															headers("location"))
													.success(
															function(
																	data) {
																$scope.tasks
																		.push(data);
															});
										});
					}

					// Sample method to post data to server.
					$scope.postData = function() {
						// Posting the firstName and lastName to the server
						alert("authenticate >> " + $scope.username
								+ ";" + $scope.password);
						var dataToPost = {
							usrCode : 0,
							usrName : '',
							usrPwd : $scope.password,
							usrAlias : $scope.username,
							usrType : '',
							usrMobile : 0,
							usrEmail : '',
							usrAddress : ''
						};
						// Configuring the query parameters.
						var queryParams = {
							params : {}
						};/* Query Parameters*/

						// Posting the data to the Servlet.
						$http
								.post(
										'http://localhost:8080/petuser/rest/authenticate',
										dataToPost)
								//, queryParams 
								.success(
										function(response, status,
												headers, config) {
											$scope.postresponse = response;

											var name = $scope.postresponse.usrName;
											$window.location.href = 'welcome?name='+name;

										})
								.error(
										function(serverResponse,
												status, headers, config) {
											alert("User Authentication Failed ! Re-try with valid Credentials");
										});
					};
				});

/*var helloApp = angular.module("loginApp", [ 'ngResource' ]);
helloApp.controller("usersCtrl", [ '$scope', '$resource', 	function($scope, $resource) {
		
		$scope.saveUser = function(){							
			// Create a resource class object
			//
			var User = $resource('/rest/user/create');
			// Call action method (save) on the class 
			//
			User.save({firstname:$scope.firstname,lastname:$scope.lastname,address:$scope.address,email:$scope.email}, function(response){
				$scope.message = response.message;
			});
 
		};
		
		$scope.authenticate = function(){							
			// Create a resource class object
			alert("authenticate >>");
			var User = $resource('/rest/authenticate');
			// Call action method (save) on the class 
			//
			User.save({usrCode:1, usrName:'', usrPwd: $scope.username, usrAlias: $scope.password, usrType:'', usrMobile:0, usrEmail:'',usrAddress: ''}, function(response){
				$scope.message = response.message;
			});
			alert("authenticate >> message " + $scope.message);
		};
 
	} ]);*/