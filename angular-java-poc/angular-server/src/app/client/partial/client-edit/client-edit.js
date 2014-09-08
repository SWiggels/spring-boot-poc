angular.module('clientModule').controller('ClientEditCtrl',function($scope, client, $state, $http){

	$scope.client = client;

	$scope.submit = function() {
		console.log("Submitting: " + JSON.stringify($scope.client));
		$http.post('http://localhost:8080/api/client/save', $scope.client).success(function() {
			$state.go('client-list');		
		});
		
	};
});