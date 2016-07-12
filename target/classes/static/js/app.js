/**
 * angular intro
 */

var app = angular.module('app', [/* put other modules for the project that you need here */])

app.controller('ExampleController', function ExampleController ($scope) {
	$scope.users = [
	                { name: "Michael Boren", city: "Memphis", state: "Tennessee" },
	                { name: "Dillon Callis", city: "Memphis", state: "Tennessee" },
	                { name: "Robert Thomas Collins", city: "Washington", state: "District of Columbia" }
	]
})

app.controller('SecondController', function SecondController ($scope, $http) {

	$http.get('users')
		.then((all) => {
			$scope.users = all.data
		})
		
})