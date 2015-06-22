<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>

<!-- <script
	src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.19/angular-resource.js"></script> -->
<!-- <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script> -->

<link rel="stylesheet" type="text/css" href="resources/css/login.css" />
<script type="text/javascript"
	src="<c:url value='/resources/js-lib/angular.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/resources/js-lib/angular-resource.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/resources/js/petshop-common.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/resources/js/petshop-user.js'/>"></script>

</head>
<body>
	<script type="text/javascript">
		var helloApp = angular.module('loginApp', [ "ngResource" ]);
		helloApp.controller("usersCtrl",
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
								//alert("authenticate >> " + $scope.username+ ";" + $scope.password);
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
										.post('http://localhost:8080/petuser/rest/authenticate',
												dataToPost)
										//, queryParams 
										.success(
												function(response, status,
														headers, config) {
													$scope.postresponse = response;

													var name = $scope.postresponse.usrName;
													var usrCode = $scope.postresponse.usrCode;
													$window.sessionStorage.name = name;
													if(name) {
													$window.location.href = "welcome?name="+name+"&id="+usrCode;
													} else {
														alert("User Authentication Failed ! Re-try with valid Credentials");
													}

												})
										.error(
												function(serverResponse,
														status, headers, config) {
													alert("Error Occurred during User Authentication");
												});
							};
						});
	</script>
	
	
	<div class="container">
		<section id="content">
			<div ng-app="loginApp" ng-controller="usersCtrl">
				<h2>Login</h2>
				<div>
					<br /> <label>Username</label> <input type="text"
						ng-model="username" /> <br /> <label for="password">Password</label>
					<input type="password" ng-model="password" /><br />

					<div>
						<button ng-click="postData()">Login</button>
						<a href="#">Lost your password?</a> <a href="/register">Register</a>
					</div>

					<br />
				</div>
			</div>
		</section>
	</div>	
</body>



</html>