angular.module('clientModule').
controller('ClientListCtrl', function($scope, clients) {
	$scope.clients = clients; 
});