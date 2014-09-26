angular.module('auth')
	.controller('LoginFormCtrl',
		function($http, $scope, $state){
			
	//for the directive.
	$scope.submitted = false;

	// method called from shakeForm directive 
	$scope.submit = function() {
		$http.defaults.headers.common['Authorization'] = ('Basic ' + btoa($scope.email + ":" + $scope.password));
		$state.go('base');
	};
}); 