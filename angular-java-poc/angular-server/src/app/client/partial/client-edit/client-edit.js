angular.module('clientModule').
controller('ClientEditCtrl', 
	function($scope, client, $state, clientService, $http) {

		//get the new token for post requests.
		$http.get('http://localhost:8080/api/token').
			success(function(data) {
				console.log("RESPONSE: " + data.response);
				$http.defaults.headers.common['X-CSRF-HEADER'] = data.response;
				console.log("HEADER: " + $http.defaults.headers.common['X-CSRF-HEADER']);
		});

		$scope.client = client; 
		$scope.submit = function() {
			clientService.save($scope.client, function() {
				$http.defaults.headers.common['X-CSRF-HEADER'] = null;
				$state.go('base.clients');  
			});
		};
});