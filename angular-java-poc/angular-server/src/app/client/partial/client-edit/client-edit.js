angular.module('clientModule').controller('ClientEditCtrl', function($scope, client, $state, clientService) {

	$scope.client = client; 

	$scope.submit = function() {
		clientService.save($scope.client, function() {
			$state.go('base.clients');
		});
	};
});