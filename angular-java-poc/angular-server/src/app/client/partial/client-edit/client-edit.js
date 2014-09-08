angular.module('clientModule').controller('ClientEditCtrl',function($scope, client, $state, $http){

	$scope.client = client;

	$scope.submit = function() {
		$http.post('http://localhost:8080/api/client/save', $scope.client).success(function() {
			$state.go('client-list');		
		});
		
	};
});