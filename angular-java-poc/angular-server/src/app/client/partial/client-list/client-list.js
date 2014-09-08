angular.module('clientModule').controller('ClientListCtrl',function($scope, clients){
 
 	console.log('Made it to the controlller!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!' + JSON.stringify(clients))
	$scope.clients = clients;
});